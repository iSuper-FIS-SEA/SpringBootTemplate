package com.seagate.controller;

import com.seagate.model.User;
import com.seagate.model.UserDao;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

  @Autowired
  private UserDao _userDao;

  @RequestMapping(value="/deleteUser")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }

  @RequestMapping(value="/getByEmailUser", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView getByEmail(String email) {
    String username = null;
    User user = null;
    try {
      user = _userDao.getByEmail(email);
    }
    catch(Exception ex) {
      System.out.print("User not found");
    }
    return new ModelAndView("userView").addObject("user", user);
  }

  @RequestMapping(value="/saveUser", method = RequestMethod.POST)
  @ResponseBody
  public String create(HttpServletRequest request, String email, String name, MultipartFile imagefile) {
    try {
      // Save image avatar
      String rootPath = request.getServletContext().getRealPath("/");
      String dest = rootPath + "static/img/avatar/";
      if(!imagefile.isEmpty()) {
        imagefile.transferTo(new File(dest + name + ".png"));
        System.out.println("Save file success!");
      }

      User user = new User(email, name);
      _userDao.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

} // class UserController
