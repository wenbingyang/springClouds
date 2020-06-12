package com.smd.employee.controller;

import com.smd.employee.model.User;
//import com.smd.employee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
* Title: UserRestController
* Description: 
* 用户控制层
* Version:1.0.0  
* @author pancm
* @date 2018年3月19日
 */
@Controller
public class UserRestController {
    //@Autowired
    //private UserService userService;
 
		@RequestMapping("/")
	    public String index() {
	        return "redirect:/list";
	    }





//		@RequestMapping("/toLogin")
//		public String toLogin() {
//		return "user/login";
//	}

	    @RequestMapping("/add")
	    public String add(User user) {
	        //userService.addUser(user);
	        return "redirect:/list";
	    }

	    @RequestMapping("/toEdit")
	    public String toEdit(Model model,int id) {
	        //User user=userService.findUserById(id);
	        //model.addAttribute("user", user);
	        return "user/userEdit";
	    }

	    @RequestMapping("/edit")
	    public String edit(User user) {
	        //userService.updateUser(user);
	        return "redirect:/list";
	    }


	    @RequestMapping("/toDelete")
	    public String delete(int id) {
	        //userService.deleteUser(id);
	        return "redirect:/list";
	    }
}
