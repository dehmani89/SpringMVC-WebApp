package com.springmvc.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nameParam")
public class LoginController {
	
	//variable to hold the APP view home directory for request mapping
	private static String appView = "loginview";
		
	
	// Set the login Service using dependency injection as an Auto-Wired
	@Autowired
	LoginService loginService;

	/**
	 * using the request mapping of"/showmessage" the servlet finds and executes the sayHi() method using the controller "LoginController"
	 * this method does not take a parameter, it only returns a string message
	 * @return the message printed on the screen
	 */
	@RequestMapping(value = "/showmessage") 
	@ResponseBody	//@ResponseBody returns a message to the view
	public String sayHi() {
		return "You have actvated the showmessage mapping";
	}
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET) //using the request mapping of"/login" the servlet finds and executes the say hello method using the controller "LoginController"
	public String showLoginPage() {
		//the returned page name
		return appView+"/login";
	}
	
	
	/**
	 * the method below will return the name of the file to show when called
	 * value 	-> this is the mapping value to be used
	 * method 	-> this is the type of acceptable method to be used
	 * @return view named welcome
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	// to pass parameters from the view to the backend use @RequestParam annotation
	// the @RequestParam allows you to define and variable and the name of the param passed from the view
	// make sure the param name on the view matches the variable name defined in the @RequestParam 
	// to add a model that can communicate between the view and the controller you simply add a ModelMap
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if(loginService.validateUser(name, password)){
			// to put a value in the model, you simply add the key/value pair
			// this model now will be available to the view to use as "nameParam"
			model.put("nameParam", name);
			model.put("passParam", password);
			
			//the returned page name
			return appView+"/welcome";
		}else{
			model.put("errorMessage", "username or password is incorrect!");
			//the returned page name
			return appView+"/login";
		}
	}
	
	
	
	
}
