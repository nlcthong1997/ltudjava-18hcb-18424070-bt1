package models;

public class result {
	private boolean status;
	private String message;
	private String idUser;
	private String typeUser;

	public result(boolean status, String message, String idUser, String typeUser) {
		super();
		this.status = status;
		this.message = message;
		this.idUser = idUser;
		this.typeUser = typeUser;
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
}
