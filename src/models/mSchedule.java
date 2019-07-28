package models;

public class mSchedule {
	private String id;
	private String className;
	private String subjectCode;
	private String subjectName;
	private String classRoom;

	public mSchedule(String id, String className, String subjectCode, String subjectName, String classRoom) {
		super();
		this.id = id;
		this.className = className;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.classRoom = classRoom;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

}
