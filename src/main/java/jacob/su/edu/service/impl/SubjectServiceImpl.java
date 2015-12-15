package jacob.su.edu.service.impl;

import java.util.Date;
import java.util.List;

import jacob.su.edu.dao.SubjectDao;
import jacob.su.edu.domain.Subject;
import jacob.su.edu.service.SubjectService;
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
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private TransactionService transactionService;


    @Override
    public Subject getSubjectById(int subjectId) {
        return subjectDao.queryOne(subjectId);
    }


    @Override
    public List<Subject> getSubjects() {
        return subjectDao.queryAll();
    }

    @Override
    public Subject addSubject(String name) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }
        Subject subject = new Subject();
        subject.setSubjectName(name);
        subject.setCreated(new Date());
        TransactionStatus ts = transactionService.getTransation();
        try {
            subjectDao.addOne(subject);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        return subject;
    }


    @Override
    public Subject updateSubject(int subjectId, String name) throws Exception {
        Subject subject = subjectDao.queryOne(subjectId);
        if (subject == null) {
            throw new RuntimeException();
        }
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }
        subject.setSubjectName(name);
        TransactionStatus ts = transactionService.getTransation();
        try {
            subjectDao.updateOne(subject);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
        return subject;
    }


    @Override
    public void removeSubject(int subjectId) throws Exception {
        Subject subject = subjectDao.queryOne(subjectId);
        if (subject == null) {
            throw new RuntimeException();
        }
        TransactionStatus ts = transactionService.getTransation();
        try {
            subjectDao.removeOne(subjectId);
        } catch (Exception ex ) {
            transactionService.rollback(ts);
            throw ex;
        } finally {
            transactionService.commit(ts);
        }
    }
}
