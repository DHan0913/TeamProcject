package himedia.dvd.repositories.vo;

import java.util.Date;

public class NoticeVo {
	private Long id;
	private String title;
	private String content;
	private Date createdDate;
	
	public NoticeVo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "NoticeVo [id=" + id + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getContent()=" + getContent()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
