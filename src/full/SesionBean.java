package full;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import full.Reglas;

@SessionScoped
@Named("sessionBean")
public class SesionBean implements Serializable {
	
	
	private ArrayList<Reglas> lstReglas = new ArrayList<Reglas>();
	
	 @PostConstruct
	 public void inicio() {
		 
		 Reglas relgLunes = new Reglas(3,"LUNES", "07:00",  "09:30",  "16:00",  "19:30", "1,2");
		 Reglas relgMartes = new Reglas(4,"MARTES", "07:00",  "09:30",  "16:00",  "19:30", "3,4");
		 Reglas relgMiercoles = new Reglas(5,"MIERCOLES", "07:00",  "09:30",  "16:00",  "19:30", "5,6");
		 Reglas relgJueves = new Reglas(6,"JUEVES", "07:00",  "09:30",  "16:00",  "19:30", "7,8");
		 Reglas relgViernes = new Reglas(7,"VIERNES", "07:00",  "09:30",  "16:00",  "19:30", "9,0");
		
		 lstReglas.add(relgLunes);
		 lstReglas.add(relgMartes);
		 lstReglas.add(relgMiercoles);
		 lstReglas.add(relgJueves);
		 lstReglas.add(relgViernes);
		 
	 }

	public ArrayList<Reglas> getLstReglas() {
		return lstReglas;
	}

	public void setLstReglas(ArrayList<Reglas> lstReglas) {
		this.lstReglas = lstReglas;
	}
	
	 

}
