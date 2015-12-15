package jacob.su.edu.service;

import java.util.List;

import jacob.su.edu.domain.Teacher;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public interface TeacherService {

    Teacher getTeacherById(int teacherId);

    List<Teacher> getTeachers();

    Teacher addTeacher(String name, int subjectId) throws Exception;

    Teacher updateTeacher(int teacherId, String name, int subjectId) throws Exception;

    void removeTeacher(int teacherId) throws Exception;
}
