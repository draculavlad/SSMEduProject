package jacob.su.edu.service.impl;

import java.util.Date;
import java.util.List;

import jacob.su.edu.dao.SubjectDao;
import jacob.su.edu.dao.TeacherDao;
import jacob.su.edu.domain.Subject;
import jacob.su.edu.domain.Teacher;
import jacob.su.edu.service.TeacherService;
import jacob.su.edu.component.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.StringUtils;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private TransactionService transactionService;


    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.queryOne(teacherId);
    }


    @Override
    public List<Teacher> getTeachers() {
        return teacherDao.queryAll();
    }

    @Override
    public Teacher addTeacher(String name,int subjectId) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }
        Subject subject = subjectDao.queryOne(subjectId);
        if (subject == null) {
            throw new RuntimeException();
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherName(name);
        teacher.setSubject(subject);
        TransactionStatus ts = transactionService.getTransation();
        try {
            teacherDao.addOne(teacher);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        return teacher;
    }


    @Override
    public Teacher updateTeacher(int teacherId, String name,int subjectId ) throws Exception {
        Subject subject = subjectDao.queryOne(subjectId);
        if (subject == null) {
            throw new RuntimeException();
        }
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }
        Teacher teacher = teacherDao.queryOne(teacherId);
        if (teacher == null) {
            throw new RuntimeException();
        }
        teacher.setTeacherName(name);
        teacher.setSubject(subject);
        TransactionStatus ts = transactionService.getTransation();
        try {
            teacherDao.updateOne(teacher);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        return teacher;
    }


    @Override
    public void removeTeacher(int teacherId) throws Exception {
        Teacher teacher = teacherDao.queryOne(teacherId);
        if (teacher == null) {
            throw new RuntimeException();
        }
        TransactionStatus ts = transactionService.getTransation();
        try {
            teacherDao.removeOne(teacher.getTeacherId());
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
    }
}
