package models;

public class mSinhvien {
	private String ten;
	private String mssv;
	private String gioitinh;
	private String cmnd;
	private String nienkhoa;
	
	public mSinhvien(String ten, String mssv, String gioitinh, String cmnd, String nienkhoa) {
		super();
		this.ten = ten;
		this.mssv = mssv;
		this.gioitinh = gioitinh;
		this.cmnd = cmnd;
		this.nienkhoa = nienkhoa;
	}
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getMssv() {
		return mssv;
	}
	
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	
	public String getGioitinh() {
		return gioitinh;
	}
	
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	
	public String getCmnd() {
		return cmnd;
	}
	
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	public String getNienkhoa() {
		return nienkhoa;
	}
	
	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	
	
}
