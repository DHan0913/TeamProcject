package himedia.dvd.repositories.vo;

import java.sql.Date;

public class CashVo {
    private Long id;
    private String requestId;
    private Double amount;
    private String status;
    private Date requestDate;
    private Date approveDate;

    public CashVo() {
    }

    public CashVo(String requestId, Double amount, Date requestDate) {
        this.requestId = requestId;
        this.amount = amount;
        this.requestDate = requestDate;
    }
    
    public CashVo(Double amount) {
		super();
		this.amount = amount;
	}
    
   
    
    
    // 예성씌 캐시 차감에 필요한 생성자
   

    public CashVo(String requestId) {
		super();
		this.requestId = requestId;
	}
    
    
    

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    @Override
    public String toString() {
        return "CashVo [id=" + id + ", requestId=" + requestId + ", amount=" + amount
                + ", status=" + status + ", requestDate=" + requestDate + ", approveDate=" + approveDate + "]";
    }
}
