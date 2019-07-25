package models;

public class mDiem {
	private String stt;
	private String nienKhoa;
	private String maMon;
	private String mssv;
	private String hoTen;
	private String diemGk;
	private String diemCk;
	private String diemKhac;
	private String diemTong;
	public mDiem(String stt, String nienKhoa, String maMon, String mssv, String hoTen, String diemGk, String diemCk,
			String diemKhac, String diemTong) {
		super();
		this.stt = stt;
		this.nienKhoa = nienKhoa;
		this.maMon = maMon;
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemGk = diemGk;
		this.diemCk = diemCk;
		this.diemKhac = diemKhac;
		this.diemTong = diemTong;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public String getNienKhoa() {
		return nienKhoa;
	}
	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiemGk() {
		return diemGk;
	}
	public void setDiemGk(String diemGk) {
		this.diemGk = diemGk;
	}
	public String getDiemCk() {
		return diemCk;
	}
	public void setDiemCk(String diemCk) {
		this.diemCk = diemCk;
	}
	public String getDiemKhac() {
		return diemKhac;
	}
	public void setDiemKhac(String diemKhac) {
		this.diemKhac = diemKhac;
	}
	public String getDiemTong() {
		return diemTong;
	}
	public void setDiemTong(String diemTong) {
		this.diemTong = diemTong;
	}
}
