package jacob.su.edu.controller;

import jacob.su.edu.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Controller
@RequestMapping("/signin")
public class SigninController {

    @Autowired
    private SigninService signinService;

    @RequestMapping(value = "/listByStudent/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getSigninsByStudent(@PathVariable(value = "studentId") int studentId){
        return signinService.getSigninByStudentId(studentId);
    }

    @RequestMapping(value = "/listBySubject/{subjectId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getSigninsBySubject(@PathVariable(value = "subjectId") int subjectId){
        return signinService.getSigninBySubjectId(subjectId);
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addSignin(@RequestParam("studentId") int studentId, @RequestParam("subjectId") int subjectId) throws Exception {
        signinService.addSignin(studentId,subjectId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSignin(@RequestParam("signinId") int signinId ,@RequestParam("studentId") int studentId, @RequestParam("subjectId") int subjectId) throws Exception {
        signinService.updateSignin(signinId,studentId,subjectId);
    }

    @RequestMapping(value = "/remove/{signinId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeSignin(@RequestParam("signinId") int signinId) throws Exception {
        signinService.removeSignin(signinId);
    }
    
}
