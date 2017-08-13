package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Supplier;
import com.ecommerce.service.SupplierService;
import com.sun.jmx.mbeanserver.ModifiableClassLoaderRepository;

@Controller
public class SupplierController {
	@Autowired
	SupplierService supservice;
	
	
	@RequestMapping("/supper")
	public ModelAndView supplier()
	{
		ModelAndView mvc = new ModelAndView("Suppliers", "s", new Supplier());
		String suplist = supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
		
	}
	@RequestMapping(value="/addsuplier", method=RequestMethod.POST )
	public ModelAndView addSupplier(Supplier sobj){
		supservice.addSupplier(sobj);
		ModelAndView mvc=new ModelAndView("Suppliers", "s", new Supplier());
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
		
	}
	@RequestMapping(value="/delsuplier", method=RequestMethod.GET)
	public ModelAndView deleteSupplier(@RequestParam("id")int id)		//the requestparam(id) should b same as the href of thr Suppliers delete?id

	{
	supservice.deleteSupplier(id);//("sid") int id should match with deleteSupplier(sid)
	ModelAndView mvc=new ModelAndView("Suppliers","s", new Supplier());
	String suplist=supservice.retrieveSupplier();
	mvc.addObject("Suplierlist", suplist);
	return mvc;
		
	}
	
	@RequestMapping(value="/fetchbyid", method=RequestMethod.GET)
	public ModelAndView fetchproductbyid(@RequestParam("id")int id){
		Supplier sobj=supservice.fetchproductbyid(id);
		ModelAndView mvc=new ModelAndView("Suppliers","s", new Supplier());
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		mvc.addObject("ClickedUpdateSuplier", "true");

		return mvc;
		
		
	}
	@RequestMapping(value="/updatesuplier", method=RequestMethod.POST)
	public ModelAndView updateSupplier(Supplier sopobj)
	{
		supservice.updateSupplier(sopobj);
		ModelAndView mvc=new ModelAndView("Suppliers", "s", new Supplier());
		String suplist=supservice.retrieveSupplier();
		mvc.addObject("Suplierlist", suplist);
		return mvc;
		
		
	}
	
	
	

}
