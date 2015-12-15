package jacob.su.edu.controller;

import jacob.su.edu.domain.Student;
import jacob.su.edu.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudent(@PathVariable(value = "studentId") int studentId) {
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object addStudent(@RequestParam("name") String name, @RequestParam("gender") String gender) throws Exception {
        return studentService.addStudent(name,gender);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object updateStudent(@RequestParam("name") String name, @RequestParam("gender") String gender,@RequestParam("studentId") int studentId) throws Exception {
        return studentService.updateStudent(studentId,name,gender);
    }

    @RequestMapping(value = "/remove/{studentId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeStudent(@PathVariable("studentId") int studentId) throws Exception {
        studentService.removeStudent(studentId);
    }
}

