package himedia.dvd.repositories.vo;

import java.util.Date;

public class CommentVo {
    private Long id;
    private Long noticeId;
    private Long userId = 0L;
    private String content;
    private Date createdDate;
    private String username;
    private String secret;

    public CommentVo() {
    }

    public CommentVo(Long id, Long noticeId, Long userId, String content, Date createdDate, String secret, String username) {
        this.id = id;
        this.noticeId = noticeId;
        this.userId = userId;
        this.content = content;
        this.createdDate = createdDate;
        this.secret = secret;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "CommentVo [id=" + id + ", noticeId=" + noticeId + ", userId=" + userId + ", content=" + content
                + ", createdDate=" + createdDate + ", username=" + username + ", secret=" + secret + ", getId()="
                + getId() + ", getNoticeId()=" + getNoticeId() + ", getUserId()=" + getUserId() + ", getContent()="
                + getContent() + ", getCreatedDate()=" + getCreatedDate() + ", getUsername()=" + getUsername()
                + ", getSecret()=" + getSecret() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
}
