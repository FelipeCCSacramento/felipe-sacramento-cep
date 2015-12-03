package addressrestapi.model;

public class ResponseObject {

	private String status;
	private String mensagem;
	
	public ResponseObject(String status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
