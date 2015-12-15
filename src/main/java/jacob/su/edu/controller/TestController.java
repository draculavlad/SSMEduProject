package jacob.su.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object getHello() {
        return "hello";
    }

}
