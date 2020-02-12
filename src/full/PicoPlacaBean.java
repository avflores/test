package full;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import javafx.scene.control.Alert;

@ViewScoped
@Named("picoPlaca")
public class PicoPlacaBean implements Serializable {

	private String placa;
	private String mensaje;
	private String inFecha;
	private String inHora;
	

	@Inject
	private SesionBean sesionBean;

	public String validarPicoPlaca() {
		// Obtengo el Día y la Hora ingresados
		String[] tmpInFecha = inFecha.split("/");
		String[] tmpInHora  = inHora.split(":");

		Calendar cal1 = GregorianCalendar.getInstance();		
		cal1.set(Integer.parseInt(tmpInFecha[2]), Integer.parseInt(tmpInFecha[1]), Integer.parseInt(tmpInFecha[0]), Integer.parseInt(tmpInHora[0]), Integer.parseInt(tmpInHora[1]));
		
		Integer numeroDia = cal1.get(Calendar.DAY_OF_WEEK);
		
		Calendar horaActual = Calendar.getInstance();
		horaActual.set(Calendar.HOUR_OF_DAY, cal1.get(Calendar.HOUR_OF_DAY));
		horaActual.set(Calendar.MINUTE, Integer.parseInt(cal1.get(Calendar.MINUTE) > 9 ? Integer.toString(cal1.get(Calendar.MINUTE))
				: "0" + Integer.toString(cal1.get(Calendar.MINUTE))));

		mensaje = procesar(numeroDia, horaActual);
		
		return mensaje;

	}
	
	
	private String procesar(Integer numeroDia, Calendar horaActual) {
		
		String ultimoDigito = getPlaca().substring(getPlaca().length() - 1);
		
		mensaje = "USTED PUEDE CIRCULAR";
		
		String[] tmpHora;
		
		for (Iterator iterator = sesionBean.getLstReglas().iterator(); iterator.hasNext();) {
			Reglas rlg = (Reglas) iterator.next();

			// Comparo el día
			if (numeroDia == rlg.getNumeroDia()) {

				// Comparo el digito de la placa
				String[] digitoNoCircula = rlg.getNumeroPlaca().split(",");
				for (int i = 0; i < digitoNoCircula.length; i++) {
					if (digitoNoCircula[i].equalsIgnoreCase(ultimoDigito)) {

						// Comparo las horas de circulación
						tmpHora = rlg.getHoraInicioMatutino().split(":");
						Calendar horaInicioM = Calendar.getInstance();
						horaInicioM.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmpHora[0]));
						horaInicioM.set(Calendar.MINUTE, Integer.parseInt(tmpHora[1]));

						tmpHora = rlg.getHoraFinMatutino().split(":");
						Calendar horaFinM = Calendar.getInstance();
						horaFinM.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmpHora[0]));
						horaFinM.set(Calendar.MINUTE, Integer.parseInt(tmpHora[1]));

						tmpHora = rlg.getHoraInicioVes().split(":");
						Calendar horaInicioV = Calendar.getInstance();
						horaInicioV.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmpHora[0]));
						horaInicioV.set(Calendar.MINUTE, Integer.parseInt(tmpHora[1]));

						tmpHora = rlg.getHoraFinVes().split(":");
						Calendar horaFinV = Calendar.getInstance();
						horaFinV.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmpHora[0]));
						horaFinV.set(Calendar.MINUTE, Integer.parseInt(tmpHora[1]));

						if ((horaActual.before(horaFinM) && horaActual.after(horaInicioM))
								|| (horaActual.before(horaFinV) && horaActual.after(horaInicioV))) {

							mensaje = "HOY NO CIRCULA SU PLACA TERMINA EN "+ ultimoDigito + " Y NO PUEDE CIRCULAR EL DÍA " + rlg.getDia() + " EN EL HORARIO "+ rlg.getHoraInicioMatutino() + " A " + rlg.getHoraFinMatutino() + " Y DE " + rlg.getHoraInicioVes() +" A "+ rlg.getHoraFinVes();
							break;

						}
					}

				}

			}

		}
		return mensaje;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getInFecha() {
		return inFecha;
	}

	public void setInFecha(String inFecha) {
		this.inFecha = inFecha;
	}

	public String getInHora() {
		return inHora;
	}

	public void setInHora(String inHora) {
		this.inHora = inHora;
	}
	
	
	

}
