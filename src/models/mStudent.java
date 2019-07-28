package models;

public class mStudent {
	private String id;
	private String className;
	private String subjects;
	private String idStudent;
	private String nameStudent;
	private String sex;
	private String identityCard;

	public mStudent(String id, String className, String subjects, String idStudent, String nameStudent, String sex,
			String identityCard) {
		super();
		this.id = id;
		this.className = className;
		this.subjects = subjects;
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.sex = sex;
		this.identityCard = identityCard;
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

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

}
