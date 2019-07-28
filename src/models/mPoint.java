package models;

public class mPoint {
	private String id;
	private String className;
	private String subjectCode;
	private String idStudent;
	private String nameStudent;
	private String midtermPoint;
	private String endPoint;
	private String ortherPoint;
	private String totalPoint;

	public mPoint(String id, String className, String subjectCode, String idStudent, String nameStudent,
			String midtermPoint, String endPoint, String ortherPoint, String totalPoint) {
		super();
		this.id = id;
		this.className = className;
		this.subjectCode = subjectCode;
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.midtermPoint = midtermPoint;
		this.endPoint = endPoint;
		this.ortherPoint = ortherPoint;
		this.totalPoint = totalPoint;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getMidtermPoint() {
		return midtermPoint;
	}

	public void setMidtermPoint(String midtermPoint) {
		this.midtermPoint = midtermPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getOrtherPoint() {
		return ortherPoint;
	}

	public void setOrtherPoint(String ortherPoint) {
		this.ortherPoint = ortherPoint;
	}

	public String getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}
}
