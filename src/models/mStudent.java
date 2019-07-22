package models;

public class mStudent {
	private String stt;
	private String nienKhoa;
	private String cacMon;
	private String mssv;
	private String hoTen;
	private String gioiTinh;
	private String cmnd;

	public mStudent(String stt, String nienKhoa, String cacMon, String mssv, String hoTen, String gioiTinh,
			String cmnd) {
		super();
		this.stt = stt;
		this.nienKhoa = nienKhoa;
		this.cacMon = cacMon;
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
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

	public String getCacMon() {
		return cacMon;
	}

	public void setCacMon(String cacMon) {
		this.cacMon = cacMon;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
}
