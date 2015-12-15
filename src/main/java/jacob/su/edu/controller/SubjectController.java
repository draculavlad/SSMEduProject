package jacob.su.edu.controller;

import jacob.su.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private StudentService studentService;
}
