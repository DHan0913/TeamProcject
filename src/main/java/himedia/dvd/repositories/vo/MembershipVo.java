package himedia.dvd.repositories.vo;

public class MembershipVo {

	private int id;
    private String name;
    private double price;
    private int duration = 30; // 기본값 설정

    public MembershipVo() {
    }

    public MembershipVo(String name, double price) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

	@Override
	public String toString() {
		return "MembershipVo [id=" + id + ", name=" + name + ", price=" + price + ", duration=" + duration
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getDuration()=" + getDuration() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}