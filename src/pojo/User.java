package pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 用户
 */
public class User implements Serializable {//使用ehCache缓存到本地磁盘，需要将对象序列化，否则无法保存
    private int id;
    private String name;
    private List<Post> postList;

    public User() {
    }
    public User( String name) {
        this.name = name;
    }
    public User(String name, List<Post> postList) {
        this.name = name;
        this.postList = postList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postList=" + postList +
                '}';
    }
}
