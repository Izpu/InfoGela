package elementos;

import java.util.Date;

public interface EquipoInt {

	public String getID();
	public void setID();
	public String getSO();
	public void setSO();
	public Date getFechaHora();
	public void setFechaHora(Date fechaHora);
	public boolean getOperativo();
	public void setOperativo();
	public String getIP();
	public boolean getMonitorOk();
	public void setMointorStatus();
	public boolean getTecladoOk();
	public void setTecladoStatus();
	public boolean getRatonOk();
	public void setRatonOk();
	public String getInfoIncidencia();
	public void setInfoIncidencia(String infoIncidencia);
}
