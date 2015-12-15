package jacob.su.edu.dao;

import java.util.List;

import jacob.su.edu.domain.Signin;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public interface SigninDao extends BaseDao<Signin> {

    public List<Signin> gueryListByStudent(int studentId);

    public List<Signin> queryListBySubject(int subjectId);

}
