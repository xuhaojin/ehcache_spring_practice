package com.xhj.practice.ehcache.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xhj.practice.ehcache.domain.Customer;
import com.xhj.practice.ehcache.service.CustomerCacheService;

@Controller
public class CustomerController
{
    Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    private CustomerCacheService customerCacheService;
    
    @RequestMapping(value="/")
    public String toIndex(@RequestParam(value="name",required=false) String name,ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("customers", customerCacheService.getAllCustomerCaches());
        return "index";
    }
    
    @RequestMapping(value="clearCache",method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String clearCache() {
        customerCacheService.removeAllCaches();
        return "all customer cache removed successfully!";
    }
    
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(final Model model) {
        final Customer customer = new Customer();
        model.addAttribute("premierFormulaire", customer);
        return "add";
    }
    
    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String save(@ModelAttribute("premierFormulaire") final Customer customer,final Model model) {
        model.addAttribute("retour:"+customer.toString());
        try {
            boolean result = customerCacheService.saveCustomerCache(customer);
            if(result) {
                return "success";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return "fail";
    }
}
