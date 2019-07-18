package models;

public class mMonhoc {
	private String ten;
	private String mamon;
	private String phonghoc;
	
	public mMonhoc(String ten, String mamon, String phonghoc) {
		super();
		this.ten = ten;
		this.mamon = mamon;
		this.phonghoc = phonghoc;
	}
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getMamon() {
		return mamon;
	}
	
	public void setMamon(String mamon) {
		this.mamon = mamon;
	}
	
	public String getPhonghoc() {
		return phonghoc;
	}

	public void setPhonghoc(String phonghoc) {
		this.phonghoc = phonghoc;
	}
	
}
