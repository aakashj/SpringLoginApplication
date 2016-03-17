package com.learning.spring.controller;

import com.learning.spring.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/")
public class LoginController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String goLogin(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "login";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("loginModel") LoginModel loginModel) {
        System.out.println("in submit" + loginModel);
        String password = loginModel.getPassword();
        if (password != null && password.equals("password")) {
            modelMap.put("userInfo", loginModel.getUserName());
            return "home";
        } else {
            modelMap.put("error", "Invalid UserName / Password");
            return "login";
        }
 
    }
}