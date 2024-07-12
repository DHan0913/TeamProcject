package himedia.dvd.repositories.vo;

import java.time.LocalDateTime;

public class BlockedIpVo {
	private Long id;
	private String ipAddress;
	private LocalDateTime blockedAt;
	private String blockedBy;

	
	
	public BlockedIpVo(Long id, String ipAddress, LocalDateTime blockedAt, String blockedBy) {

		this.id = id;
		this.ipAddress = ipAddress;
		this.blockedAt = blockedAt;
		this.blockedBy = blockedBy;
	}

	public BlockedIpVo() {

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

	public LocalDateTime getBlockedAt() {
		return blockedAt;
	}

	public void setBlockedAt(LocalDateTime blockedAt) {
		this.blockedAt = blockedAt;
	}

	public String getBlockedBy() {
		return blockedBy;
	}

	public void setBlockedBy(String blockedBy) {
		this.blockedBy = blockedBy;
	}

}
