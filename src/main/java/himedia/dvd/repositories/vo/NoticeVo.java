package himedia.dvd.repositories.vo;

import java.util.Date;

public class NoticeVo {
	private Long id;
	private String title;
	private String content;
	private Date createdDate;
	private String Status;
	
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "NoticeVo [id=" + id + ", title=" + title + ", content=" + content + ", createdDate=" + createdDate
				+ ", Status=" + Status + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getContent()="
				+ getContent() + ", getCreatedDate()=" + getCreatedDate() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
