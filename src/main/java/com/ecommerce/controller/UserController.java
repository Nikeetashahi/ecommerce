package com.ecommerce.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.model.UserCredential;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.UserCredentialService;
import com.ecommerce.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService us;
	
	@Autowired
	UserCredentialService ucs;
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView adduser(User u){
		boolean registerationstatus;
		ModelAndView mvc=new ModelAndView("index", "user", new User());
		UserCredential uc=new UserCredential();
		try{
			
			us.addUser(u);
			uc.setUsername(u.getUsername());
			uc.setPassword(u.getPassword());
//			uc.setEnable(true);
			uc.setRole("ROLE_USER");
			ucs.addUserCredential(uc);
			System.out.println(u.getPassword());
			registerationstatus=true;
			
		}
		catch(Exception e)
		{
			System.out.println("something went wong with signin");
			registerationstatus=false;
			
		}
		mvc.addObject("successmessage", registerationstatus );
		return mvc;
	}
	
	@RequestMapping(value="login")
	public ModelAndView login(){
		ModelAndView mvc=new ModelAndView("login" ,"user", new User());
		return mvc;
		
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView admin(){
		ModelAndView mvc =new ModelAndView("admin");
		return mvc;
	}
	
	@RequestMapping(value="/validatelogin", method=RequestMethod.POST)
	public ModelAndView loginChecker(ModelAndView mvc, HttpSession session)
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role = "ROLE_USER";
		System.out.println("person is"+ username);
		for(GrantedAuthority authority : authorities)
		{
			if(authority.getAuthority().equals(role))
			{
			mvc = new ModelAndView("index", "user", new User());
			session.setAttribute("loggedinuser", username);
			session.setAttribute("userloggedin", true);
			
		}
		else
		{
			mvc = new ModelAndView("admin");
			session.setAttribute("loggedinuser", username);

		}
		}
		return mvc;
		
	}
	
	@RequestMapping(value="/perform_logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
	{
		session=request.getSession();
		session.invalidate();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		ModelAndView mvc = new ModelAndView("index", "user", new User());
		return mvc;


		
	}
	}


