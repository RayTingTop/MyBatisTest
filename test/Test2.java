import dao.PostMapper;
import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Post;
import pojo.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试一对多多对一
 */
public class Test2 {



    public static void main(String[] args){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = factory.openSession(true);
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> users = userMapper.getUserList();
            for (User user: users) {
                System.out.println(user.toString());
            }
            System.out.println();
            System.out.println(userMapper.getUserByID(1).toString());//用了动态sql
            System.out.println();

            PostMapper postMapper = session.getMapper(PostMapper.class);
            List<Post> posts = postMapper.getPostList();
            for (Post post: posts) {
                System.out.println(post.toString());
            }

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] test= new String[]{};
        if (test == null) {
            
        }
        if (test != null) {
            
        }
        if (args == null) {

        }
        if (args != null) {

        }

    }





}
