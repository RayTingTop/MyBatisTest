import dao.UserMapper;
import pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * 简单方式直接测试
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory factory  = new SqlSessionFactoryBuilder().build(is);//factory应为单例模式,作用于最好Application
        SqlSession session = factory.openSession(true);//true自动提交事务,session不能共享不是线程安全,作用于在request或方法内部
        UserMapper mapper =  session.getMapper(UserMapper.class);
        User findUser = mapper.getUserByID(1);
        System.out.println("----------获取一个user："+findUser.toString());

        System.out.println("----------执行添加");
        //添加user
        mapper.insertUser(new User("ceshi"));
        System.out.println("-----------------------查询列表：");
        //查询列表
        List<User> users = mapper.getUserList();
        for (User user: users) {
            System.out.println(user.toString());
        }

        System.out.println("----------更新：");
        User user2 = users.get(2);
        user2.setName("upodate");
        mapper.updateUser(user2);

        System.out.println("-----------------------查询列表：");
        //查询列表
        users = mapper.getUserList();
        for (User user: users) {
            System.out.println(user.toString());
        }

        System.out.println("----------删除：");
        mapper.deleteUser(2);

        System.out.println("-----------------------查询列表：");
        //查询列表
        users = mapper.getUserList();
        for (User user: users) {
            System.out.println(user.toString());
        }

        session.close();//关闭连接
    }
}
