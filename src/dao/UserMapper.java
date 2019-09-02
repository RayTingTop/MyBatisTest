package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据id查询
     * @param id
     * @return
     */
   // @Select("select * from user where id= #{id}")
    User getUserByID(@Param("id") int id);

    /**
     * 查询
     * @return
     */
    List<User> getUserList();

    /**
     * 新增
     * @param user
     */
    void insertUser(User user);

    /**
     * 修改
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除
     * @param id
     */
    void deleteUser(@Param("id") int id);

}
