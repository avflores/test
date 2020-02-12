package full;

public class Reglas {
	
	private Integer numeroDia;
	private String dia;
	private String horaInicioMatutino;
	private String horaFinMatutino;
	private String horaInicioVes;
	private String horaFinVes;
	private String numeroPlaca;
	
	
	
	
	
	public Reglas(Integer numeroDia, String dia, String horaInicioMatutino, String horaFinMatutino, String horaInicioVes,
			String horaFinVes, String numeroPlaca) {
		super();
		this.numeroDia = numeroDia;
		this.dia = dia;
		this.horaInicioMatutino = horaInicioMatutino;
		this.horaFinMatutino = horaFinMatutino;
		this.horaInicioVes = horaInicioVes;
		this.horaFinVes = horaFinVes;
		this.numeroPlaca = numeroPlaca;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraInicioMatutino() {
		return horaInicioMatutino;
	}
	public void setHoraInicioMatutino(String horaInicioMatutino) {
		this.horaInicioMatutino = horaInicioMatutino;
	}
	public String getHoraFinMatutino() {
		return horaFinMatutino;
	}
	public void setHoraFinMatutino(String horaFinMatutino) {
		this.horaFinMatutino = horaFinMatutino;
	}
	public String getHoraInicioVes() {
		return horaInicioVes;
	}
	public void setHoraInicioVes(String horaInicioVes) {
		this.horaInicioVes = horaInicioVes;
	}
	public String getHoraFinVes() {
		return horaFinVes;
	}
	public void setHoraFinVes(String horaFinVes) {
		this.horaFinVes = horaFinVes;
	}
	public String getNumeroPlaca() {
		return numeroPlaca;
	}
	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}
	public Integer getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}
	
	

}
