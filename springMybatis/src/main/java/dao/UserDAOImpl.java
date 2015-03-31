package dao;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by Johnson on 2015/3/30.
 */
public class UserDAOImpl implements  IUserDAO{

    private SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public boolean addUser(User user) {
        SqlSession session=this.getSqlSessionFactory().openSession();
        int i1 = session.insert( "addUser", user);
        session.close();
        return i1!=0;
    }

    @Override
    public boolean checkUser(User user) {
        SqlSession session=this.getSqlSessionFactory().openSession();
        int i = session.update( "updateUser", user );
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        SqlSession session=this.getSqlSessionFactory().openSession();
        return false;
    }
}
