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
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private UserDao _userDao;

  @RequestMapping(value="/delete")
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

  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value="/save", method = RequestMethod.POST)
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
