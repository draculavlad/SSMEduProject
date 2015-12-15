package jacob.su.edu.service;

import java.util.List;

import jacob.su.edu.domain.Subject;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public interface SubjectService {

    Subject getSubjectById(int subjectId);

    List<Subject> getSubjects();

    Subject addSubject(String name) throws Exception;

    Subject updateSubject(int subjectId, String name) throws Exception;

    void removeSubject(int subjectId) throws Exception;
}
