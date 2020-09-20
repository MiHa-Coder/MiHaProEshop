package sk.mihapro.eshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest api for user
 * @author haska
 *
 */
@RestController
public class UserController {
	
	@GetMapping(value = "/")
	public String home() {
		return "<h1>Welcome</h1>";
	}
	
	@GetMapping(value = "/user")
	public String user() {
		return "<h1>Welcome User</h1>";
	}

}
