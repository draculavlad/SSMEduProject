package jacob.su.edu.component.impl;


import jacob.su.edu.component.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private DataSourceTransactionManager transactionManager;


    public TransactionStatus getTransation() {
        return transactionManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW));
    }


    public TransactionStatus getDefaultTransaction(int propagationBehavior) {
        return transactionManager.getTransaction(new DefaultTransactionDefinition(propagationBehavior));
    }


    public void rollback(TransactionStatus status) {
        if (status != null) {
            transactionManager.rollback(status);
        }
    }


    public void commit(TransactionStatus status) {
        if (status != null) {
            transactionManager.commit(status);
        }
    }


}
