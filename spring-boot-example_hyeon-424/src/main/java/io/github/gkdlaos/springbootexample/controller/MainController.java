package io.github.gkdlaos.springbootexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.gkdlaos.springbootexample.model.User;
import io.github.gkdlaos.springbootexample.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String main(HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "redirect:user_list";
		} else {
			return "login";
		}
	}

	@RequestMapping("/register_page")
	public String registerPage() {
		return "register_page";
	}

	@RequestMapping("/register")
	public String register(String userId, String password, String name) {
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		user.setName(name);
		userService.register(user);
		return "redirect:/";
	}

	@RequestMapping("/login")
	public String login(String userId, String password, HttpSession session, Model model) {
		User user = userService.logIn(userId, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:./user_list";
		} else {
			model.addAttribute("message", "잘못된 ID혹은 패스워드입니다.");
			return "error_message";
		}
	}

	@RequestMapping("/user_list")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getAllUsers());
		return "user_list";
	}
}
