package jacob.su.edu.dao;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public interface BaseDao<T> {

    public static final String selectOneById = ".selectOneById";
    public static final String selectList=".selectList";
    public static final String insertOne=".insertOne";
    public static final String updateOne=".updateOne";
    public static final String deleteOne=".deleteOne";

    public void addOne(T t);

    public void updateOne(T t);

    public void removeOne(int id);

    public T queryOne(int id);

    public List<T> queryAll();

}
