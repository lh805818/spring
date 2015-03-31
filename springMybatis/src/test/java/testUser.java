import dao.IUserDAO;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Johnson on 2015/3/30.
 */
public class testUser {

    private static ApplicationContext context=null;

    private final static String config_file_name="bean.xml";
    static{
        context=new ClassPathXmlApplicationContext(config_file_name);
    }

    public  static IUserDAO getUserDao(){
        try {
            return (IUserDAO)context.getBean("userDAO");
        }catch (Exception e){
            return null;
        }
    }
    public static void main(String[] args) {
        IUserDAO dao=getUserDao();
        User u=new User();
        u.setUserName("hehe");
        u.setPassword("123456");
        dao.addUser(u);
    }
}
