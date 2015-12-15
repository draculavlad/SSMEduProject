package jacob.su.edu.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import jacob.su.edu.dao.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
@Repository
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {

    protected Class clazz;

   	@Autowired
   	protected SqlSessionFactory sqlSessionFactory;

   	public BaseDaoImpl() {
   		Type type = this.getClass().getGenericSuperclass();
   		ParameterizedType pt = (ParameterizedType) type;
   		this.clazz = (Class) pt.getActualTypeArguments()[0];
   	}

    @Override
    public void addOne(T t) {
        getSession().insert(this.clazz.getName() + insertOne, t);
    }

    @Override
    public void updateOne(T t) {
        getSession().update(this.clazz.getName()+updateOne,t);
    }

    @Override
    public void removeOne(int id) {
        getSession().delete(this.clazz.getName()+deleteOne,id);
    }

    @Override
    public T queryOne(int id) {
        return (T)getSession().selectOne(this.clazz.getName()+selectOneById,id);
    }

    @Override
    public List<T> queryAll() {
        return getSession().selectList(this.clazz.getName()+selectList);
    }

    protected SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
