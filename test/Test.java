import dao.UserMapper;
import pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * dao中使用select注解，config中不需要引入mapper.xml(注释掉mappers)
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("mybatis_config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserByID(1);//需要修改dao中方法上的的select注解
            System.out.println(user.toString());
        } finally {
            session.close();
        }
    }
}


