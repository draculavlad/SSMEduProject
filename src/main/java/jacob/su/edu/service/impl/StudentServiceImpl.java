package jacob.su.edu.service.impl;

import java.util.List;

import jacob.su.edu.dao.StudentDao;
import jacob.su.edu.domain.Student;
import jacob.su.edu.service.StudentService;
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
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;


    @Autowired
    private TransactionService transactionService;


    @Override
    public Student getStudentById(int studentId) {
        return studentDao.queryOne(studentId);
    }


    @Override
    public List<Student> getStudents() {
        return studentDao.queryAll();
    }

    @Override
    public Student addStudent(String name, String gender) throws Exception {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(gender)) {
            throw new RuntimeException();
        }
        Student student = new Student();
        student.setGender(gender);
        student.setStudentName(name);
        TransactionStatus ts = transactionService.getTransation();
        try {
            studentDao.addOne(student);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        return student;
    }


    @Override
    public Student updateStudent(int studentId, String name, String gender) throws Exception {
        Student student = studentDao.queryOne(studentId);
        if (student == null) {
            throw new RuntimeException();
        }
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(gender)) {
            throw new RuntimeException();
        }
        student.setGender(gender);
        student.setStudentName(name);
        TransactionStatus ts = transactionService.getTransation();
        try {
            studentDao.updateOne(student);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        return student;
    }


    @Override
    public void removeStudent(int studentId) throws Exception {
        Student student = studentDao.queryOne(studentId);
        if (student == null) {
            throw new RuntimeException();
        }
        TransactionStatus ts = transactionService.getTransation();
        try {
            studentDao.removeOne(studentId);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
    }

}
