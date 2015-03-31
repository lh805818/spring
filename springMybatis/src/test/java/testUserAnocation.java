import model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Johnson on 2015/3/30.
 */
public class testUserAnocation {

    private static ApplicationContext context=null;
    private static SqlSessionFactory sqlSessionFactory =null;

    private final static String config_file_name="bean.xml";
    static{
        context=new ClassPathXmlApplicationContext(config_file_name);
         sqlSessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
    }





    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User u=new User();
            u.setUserName("oo");
            u.setPassword("123456");
            sqlSession.insert("addUser", u);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
