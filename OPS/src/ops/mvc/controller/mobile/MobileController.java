package ops.mvc.controller.mobile;

import ops.mvc.controller.base.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobile")
public class MobileController extends BaseController {

	@RequestMapping("/index")
	public String index() {
		return "/mobile/index";
	}

}
