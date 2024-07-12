package himedia.dvd.repositories.vo;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserVo {
	private Long userNo; // 고유 번호
	
	@NotEmpty
	private String username; // 이름
	
	@NotEmpty
	private String birth; // 생일
	
	@NotEmpty
	private String email; // 이메일
	
	@NotEmpty
	private String password; // 비번
	
	@NotEmpty
	private String passwordConfirm;	// 비번 확인
	
	
	private Date regdate; // 가입날짜
	
	private int role; // 회원구분
	
	@NotNull
	private Boolean agree; // 약관 동의 여부

	// 기본생성자
	public UserVo() {

	}

	public UserVo(Long userNo, String username, String birth, String email, String password, String passwordConfirm, Date regdate, int role, Boolean agree) {
		super();
		this.userNo = userNo;
		this.username = username;
		this.birth = birth;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.regdate = regdate;
		this.role = role;
		this.agree = agree;
	}

	// 회원가입에 필요한 생성자
	public UserVo(String username, String email, String birth, String password, String passwordConfirm, Boolean agree) {
		this.username = username;
		this.email = email;
		this.birth = birth;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.agree = agree;
	}
	
	// 회원정보수정에 필요한 생성자
	public UserVo(String birth, String email) {
		super();
		this.birth = birth;
		this.email = email;
	}
	
	// 회원 삭제에 필요한 생성자
	public UserVo(String password) {
		super();
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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

	public Boolean getAgree() {
		return agree;
	}

	public void setAgree(Boolean agree) {
		this.agree = agree;
	}
	
	

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", username=" + username + ", birth=" + birth + ", email=" + email
				+ ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", regdate=" + regdate + ", role="
				+ role + ", agree=" + agree + "]";
	}
}
