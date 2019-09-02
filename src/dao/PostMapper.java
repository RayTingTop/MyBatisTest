package dao;

import pojo.Post;
import java.util.List;

public interface PostMapper {
    /**
     * 根据id查询
     * @param id
     * @return
     */
   // @Select("select * from post where id= #{id}")
    Post getPostByID(int id);

    /**
     * 查询
     * @return
     */
    List<Post> getPostList();

    /**
     * 新增
     * @param post
     */
    void insertPost(Post post);

    /**
     * 修改
     * @param post
     */
    void updatePost(Post post);

    /**
     * 删除
     * @param id
     */
    void deletePost(int id);

}
