package models;

public class result {
	private boolean status;
	private String message;
	private String idUser;
	private String typeUser;
	private String nameUser;

	public result(boolean status, String message, String idUser, String typeUser, String nameUser) {
		super();
		this.status = status;
		this.message = message;
		this.idUser = idUser;
		this.typeUser = typeUser;
		this.nameUser = nameUser;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

}
