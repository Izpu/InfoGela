package procesos;

import procesos.auxiliares.SistemaOperativo;
import elementos.EquipoImpl;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EquipoImpl equipo=new EquipoImpl();
		System.out.println("Nombre de equipo="+equipo.getID());
		System.out.println("Sistema operativo="+equipo.getSO());
		SistemaOperativo so=new SistemaOperativo();
		System.out.println("Info so="+so.getDistro()+" arquitectura="+so.getArquitectura());
	}

}
