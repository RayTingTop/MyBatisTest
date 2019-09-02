package pojo;

/**
 * 评论
 */
public class Post {
    private int id;
    private int userId;
    private String content;
    private User user;

    public Post() {
    }

    public Post(int userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }
}
