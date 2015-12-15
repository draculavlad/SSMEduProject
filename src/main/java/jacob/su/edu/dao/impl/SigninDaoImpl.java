package jacob.su.edu.dao.impl;

import java.util.List;

import jacob.su.edu.dao.SigninDao;
import jacob.su.edu.domain.Signin;
import org.springframework.stereotype.Repository;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Repository
public class SigninDaoImpl extends BaseDaoImpl<Signin> implements SigninDao {

    private static final String selectListByStudentId="selectListByStudentId";
    private static final String selectListBySubjectId="selectListBySubjectId";

    @Override
    public List<Signin> gueryListByStudent(int studentId) {
        return getSession().selectList(this.clazz.getName()+selectListByStudentId, studentId);
    }

    @Override
    public List<Signin> queryListBySubject(int subjectId) {
        return getSession().selectList(this.clazz.getName()+selectListBySubjectId, subjectId);
    }
}
