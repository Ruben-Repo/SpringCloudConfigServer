package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {

	@Value("${user.role}")
	private String role;

	@Value("${user.password}")
	private String password;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping(value = "/whoami/{username}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String whoami(@PathVariable("username") String username) {
		return String.format("Hello %s! You are a(n) %s and your password is '%s'.\n", username, role, password);
	}

}
