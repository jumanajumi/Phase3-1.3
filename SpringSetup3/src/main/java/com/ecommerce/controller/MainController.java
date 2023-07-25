package com.ecommerce.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecommerce.entity.Eproduct;
import com.ecommerce.dao.EProductDAO;

import java.util.List; // Import the List class from java.util

@Controller
public class MainController {

    @Autowired
    EProductDAO EProductDAO;

    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public String listProducts(ModelMap map) {
        List<Eproduct> list = EProductDAO.getProducts();
        map.addAttribute("list", list);
        return "listProducts";
    }
}
