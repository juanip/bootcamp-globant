package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import services.IUserServices;
import services.UserServices;
import entities.User;

@Controller
@RequestMapping("users")
public class UserServicesController {

	private IUserServices userServices = new UserServices();

	// get all users
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		return userServices.getUsers();
	}

	// create
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user) {
		return userServices.addUser(user);
	}

	// update
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody() User user) {
		return userServices.updateUser(user);
	}

	// remove
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<User> removeUser(@PathVariable() long id) {
		return userServices.removeUser(id);
	}

	// read
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable() long id) {
		return userServices.getUser(id);
	}
}
