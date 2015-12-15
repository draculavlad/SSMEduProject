package jacob.su.edu.service;

import java.util.List;

import jacob.su.edu.domain.Signin;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public interface SigninService {


    List<Signin> getSigninByStudentId(int studentId);

    List<Signin> getSigninBySubjectId(int subjectId);

    void addSignin(int studentId, int subjectId) throws Exception;

    void removeSignin(int signinId) throws Exception;

    void updateSignin(int signinId, int studentId, int subjectId) throws Exception;
}
