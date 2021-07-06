package com.tutorial.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.tutorial.fleetapp.models.User;
import com.tutorial.fleetapp.services.UserService;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;
import com.tutorial.fleetapp.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getUsers(Model model) {
		List<User> userlist = userService.getUsers();
		model.addAttribute("users", userlist);
		return "/body/User";
	}

	@RequestMapping("users/findById")

	@ResponseBody
	public Optional<User> findById(int id) {
		return userService.findById(id);
	}

	// Modified method to Add a new user User
	@PostMapping(value = "/register/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {

		userService.save(user);

		RedirectView redirectView = new RedirectView("/login", true);

		redir.addFlashAttribute("message", "You successfully registered! You can now login");

		return redirectView;
	}

	@PostMapping(value = "users/addNew")
	public String addNew(User user) {

		userService.save(user);
		return "redirect:/users";

	}

	@RequestMapping(value = "/users/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(User user) {
		userService.save(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/users/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/users";
	}
}
