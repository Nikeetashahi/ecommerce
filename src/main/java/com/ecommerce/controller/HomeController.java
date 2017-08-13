package com.ecommerce.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.SupplierService;



@Controller
public class HomeController {
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	SupplierService supservice;
	
	@Autowired
	CategoryService cservice;

	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mvc=new ModelAndView("index", "user", new User());
		String prodlist=productservice.retrieveProduct();
		mvc.addObject("plist", prodlist);
		return mvc;
		
	}
	@RequestMapping("log")
	public String admin()
	{
		return "admin";
	}
	
	@RequestMapping("/managep")//should match with ahref=""
	
	public ModelAndView managep()
	{
		ModelAndView mvc = new ModelAndView("managep","mp",new Product());
		String productlist=productservice.retrieveProduct();
		mvc.addObject("prodlist", productlist);
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
	}
	
	
	static int count = 1;
	static String prevName ="";
	static String prevDesc ="";
	
	@RequestMapping(value="addProduct" ,method=RequestMethod.POST)//should math with the action of managep
	
	public ModelAndView addproductmethod(Product prod) 
	{
		if( count == 0 && prevName.equals(prod.getPdname()) && prevDesc.equals(prod.getDescription()))
		{
			ModelAndView mvc=new ModelAndView("managep","mp",new Product());
			
		    String productlist=productservice.retrieveProduct();
			mvc.addObject("prodlist", productlist);
			String Categorylist = cservice.retrieveCategory();
			mvc.addObject("Catlist", Categorylist);
			String suplist=supservice.retrieveSupplier();
			mvc.addObject("Suplierlist", suplist);
			return mvc;	
			
		}
		
		
		productservice.addProduct(prod);//link 
		count = 0;
		prevName = prod.getPdname();
		prevDesc = prod.getDescription();
		
		String path="C:\\Users\\NIKEETA SHAHI\\workspace\\nikita\\ecommerce\\src\\main\\webapp\\res\\image\\";
		path=path+String.valueOf(prod.getPdid())+".jpg";
		File f=new File(path);
		MultipartFile multifile=prod.getProduct_image();
		if(!multifile.isEmpty())
		{
		try
		{
		byte[] bytes=multifile.getBytes();
		FileOutputStream fos=new FileOutputStream(f);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(bytes);
		bos.close();
		System.out.println("File Uploaded Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
		}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
		}	
		ModelAndView mvc=new ModelAndView("managep","mp",new Product());
	
	    String productlist=productservice.retrieveProduct();
		mvc.addObject("prodlist", productlist);
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;	
	
	}
	
	@RequestMapping(value="deleteProduct", method=RequestMethod.GET)
	public ModelAndView deleteProduct(@RequestParam("id") int id)
	{
		productservice.deleteProduct(id);
		ModelAndView mvc=new ModelAndView("managep","mp",new Product());
		String productlist=productservice.retrieveProduct();
		mvc.addObject("prodlist", productlist);
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
		
		
	}
	
	@RequestMapping(value="/fetchProduct", method=RequestMethod.GET)
	public ModelAndView fetchProduct(@RequestParam("id") int id){
		 Product p=productservice.fetchProduct(id);
		ModelAndView mvc=new ModelAndView("managep", "mp", p );
		String productlist=productservice.retrieveProduct();
		mvc.addObject("prodlist", productlist);
		mvc.addObject("updateproductform", "true");
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
		
	}
	
	@RequestMapping(value="/updatep", method=RequestMethod.POST)
	public ModelAndView updateproduct(Product pd)
	{
		productservice.updateProduct(pd);
		ModelAndView mvc=new ModelAndView("managep", "mp", new Product());
		String productlist=productservice.retrieveProduct();
		mvc.addObject("prodlist", productlist);
		String Categorylist = cservice.retrieveCategory();
		mvc.addObject("Catlist", Categorylist);
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
		
		
	}
	
	@RequestMapping(value="/tshirt")
	public ModelAndView tshirt(HttpSession session){
		ModelAndView mvc=new ModelAndView("tshirt","user",new User());
		String productlist=productservice.tshirt();
		mvc.addObject("prodlist", productlist);
		return mvc;
		
	}
	
	@RequestMapping("/shirt")
	public ModelAndView shirt(HttpSession session){
		ModelAndView mvc=new ModelAndView("shirt","user",new User());
		String productlist=productservice.shirt();
		mvc.addObject("prodlist", productlist);
		return mvc;
	}
	
	@RequestMapping("/jeans")
	public ModelAndView jeans(HttpSession session){
		ModelAndView mvc=new ModelAndView("shirt","user",new User());
		String productlist=productservice.shirt();
		mvc.addObject("prodlist", productlist);
		return mvc;
	
	
	}
	
	
	

}
