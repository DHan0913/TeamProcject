package himedia.dvd.repositories.vo;

import java.time.LocalDateTime;

public class AccessAttemptVo {
	private Long id;
	private String ipAddress;
	private int attempts;
	private LocalDateTime lastAttempt;

	public AccessAttemptVo() {
	}

	public AccessAttemptVo(Long id, String ipAddress, int attempts, LocalDateTime lastAttempt) {
		this.id = id;
		this.ipAddress = ipAddress;
		this.attempts = attempts;
		this.lastAttempt = lastAttempt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public LocalDateTime getLastAttempt() {
		return lastAttempt;
	}

	public void setLastAttempt(LocalDateTime lastAttempt) {
		this.lastAttempt = lastAttempt;
	}

}
