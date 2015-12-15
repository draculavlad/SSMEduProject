package jacob.su.edu.service;

import java.util.List;

import jacob.su.edu.domain.Student;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public interface StudentService {

    Student getStudentById(int studentId);

    List<Student> getStudents();

    Student addStudent(String name, String gender) throws Exception;

    Student updateStudent(int studentId, String name, String gender) throws Exception;

    void removeStudent(int studentId) throws Exception;
}
