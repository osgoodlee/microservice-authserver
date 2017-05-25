package framework.lisi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lisix
 * @since 2017年4月18日
 */
@Controller
public class PortalController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/user/index")
	public String userIndex() {
		return "user/index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

}
