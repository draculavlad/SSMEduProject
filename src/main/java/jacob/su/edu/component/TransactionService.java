package jacob.su.edu.component;

import org.springframework.transaction.TransactionStatus;

public interface TransactionService {

    /**
     * 获取默认事务
     *
     * @return
     */
    public abstract TransactionStatus getTransation();

    /**
     * 获取需要的事务
     *
     * @param propagationBehavior
     *
     * @return
     */
    public abstract TransactionStatus getDefaultTransaction(
        int propagationBehavior);

    /**
     * 回滚事务
     *
     * @param status
     */
    public abstract void rollback(TransactionStatus status);

    /**
     * 提交事务
     *
     * @param status
     */
    public abstract void commit(TransactionStatus status);
}
