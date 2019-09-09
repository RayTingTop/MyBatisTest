import dao.UserMapper;
import pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * dao中使用select注解，config中不需要引入mapper.xml(注释掉mappers)
 */
public class Test {

    public SqlSessionFactory getSqlSessionFactory1() throws IOException {
        Reader reader= Resources.getResourceAsReader("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
        return  sqlSessionFactory;
    }

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
        return new SqlSessionFactoryBuilder().build(is);
    }

    /**
     * 测试方法
     */
    @org.junit.Test
    public void test() throws IOException {
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserByID(1);//需要修改dao中方法上的的select注解
            System.out.println(user.toString());
        } finally {
            session.close();
        }
    }

}


