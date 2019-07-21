package models;

public class mTkb {
	private String stt;
	private String nienKhoa;
	private String maMon;
	private String tenMon;
	private String phongHoc;

	public mTkb(String stt, String nienKhoa, String maMon, String tenMon, String phongHoc) {
		super();
		this.stt = stt;
		this.nienKhoa = nienKhoa;
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.phongHoc = phongHoc;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getStt() {
		return stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public String getPhongHoc() {
		return phongHoc;
	}

	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}

}
