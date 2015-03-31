package dao;

import model.User;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Johnson on 2015/3/30.
 */
public interface IUserDAO {
    @Insert("insert into user(username,password)  values(#{userName},#{password})")
    public  boolean addUser(User user);

    public  boolean checkUser(User user);
    public  boolean updateUser(User user);
}
