package jacob.su.edu.service.impl;

import java.util.List;

import jacob.su.edu.dao.*;
import jacob.su.edu.domain.*;
import jacob.su.edu.service.SigninService;
import jacob.su.edu.component.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Service
public class SigninServiceImpl implements SigninService {

    @Autowired
    private SigninDao signinDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private TransactionService transactionService;

    @Override
    public List<Signin> getSigninByStudentId(int studentId) {
        Student student = studentDao.queryOne(studentId);
        if(student==null) {
            throw new RuntimeException();
        }
        return signinDao.gueryListByStudent(student.getStudentId());
    }

    @Override
    public List<Signin> getSigninBySubjectId(int subjectId) {
        Subject subject = subjectDao.queryOne(subjectId);
        if(subject==null){
            throw new RuntimeException();
        }
        return signinDao.queryListBySubject(subject.getSubjectId());
    }

    @Override
    public void addSignin(int studentId, int subjectId) throws Exception {
        Student student = studentDao.queryOne(studentId);
        if(student==null) {
            throw new RuntimeException();
        }
        Subject subject = subjectDao.queryOne(subjectId);
        if(subject==null){
            throw new RuntimeException();
        }
        Signin signin = new Signin();
        signin.setStudentId(student.getStudentId());
        signin.setSubjectId(subject.getSubjectId());
        TransactionStatus ts = transactionService.getTransation();
        try {
            signinDao.addOne(signin);
        } catch (Exception ex) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        System.out.println(signin);
    }

    @Override
    public void removeSignin(int signinId) throws Exception {
        Signin signin = signinDao.queryOne(signinId);

        if(signin==null){
            throw new RuntimeException();
        }

        TransactionStatus ts = transactionService.getTransation();
        try {
            signinDao.removeOne(signin.getSiginId());
        } catch (Exception ex) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        System.out.println(signin);
    }

    @Override
    public void updateSignin(int signinId, int studentId, int subjectId) throws Exception {
        Signin signin = signinDao.queryOne(signinId);
        if(signin==null){
            throw new RuntimeException();
        }
        Student student = studentDao.queryOne(studentId);
        if(student==null) {
            throw new RuntimeException();
        }
        Subject subject = subjectDao.queryOne(subjectId);
        if(subject==null){
            throw new RuntimeException();
        }
        signin.setStudentId(student.getStudentId());
        signin.setSubjectId(subject.getSubjectId());
        TransactionStatus ts = transactionService.getTransation();
        try {
            signinDao.updateOne(signin);
        } catch (Exception ex) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        System.out.println(signin);
    }

}
