package himedia.dvd.repositories.vo;

import java.sql.Date;

public class UserVo {
	private Long userNo; // 고유 번호
	private String username; // 이름
	private String birth; // 생일
	private String email; // 이메일
	private String password; // 비번
	private Date regdate; // 가입날짜
	private int role; // 회원구분

	// 기본생성자
	public UserVo() {

	}

	public UserVo(Long userNo, String username, String birth, String email, String password, Date regdate, int role) {
		super();
		this.userNo = userNo;
		this.username = username;
		this.birth = birth;
		this.email = email;
		this.password = password;
		this.regdate = regdate;
		this.role = role;
	}

	// 회원가입에 필요한 생성자
	public UserVo(String username, String email, String birth, String password) {
		this.username = username;
		this.email = email;
		this.birth = birth;
		this.password = password;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", username=" + username + ", birth=" + birth + ", email=" + email
				+ ", password=" + password + ", regdate=" + regdate + "]";
	}

}