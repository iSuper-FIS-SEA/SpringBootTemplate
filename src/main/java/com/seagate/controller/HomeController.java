package com.seagate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.seagate.model.User;

@Controller
public class HomeController {

 @RequestMapping(value = "/home", method = RequestMethod.GET)
 public ModelAndView home() {
  return new ModelAndView("home").addObject("name", "Jirapin");
 }

 @RequestMapping(value = "/homeUser", method = RequestMethod.GET)
 public String homeUser() {
  return "createUser";
 }

 @RequestMapping(value = "/userV", method = RequestMethod.GET)
 public ModelAndView userview() {
  return new ModelAndView("userView").addObject("user", new User());
 }

}
