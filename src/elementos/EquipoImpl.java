package elementos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class EquipoImpl implements EquipoInt {
	private String equipoID;		//Id del equipo, su nombre.
	private String sO;				//Sistema operativo.
	private Date fechaHora;			//Fecha y hora del registro.
	private boolean monitorOK;		//Monitor correcto.
	private elementoImpl monitor;
	private elementoImpl teclado;
	private elementoImpl raton;
	private elementoImpl red;
	
public EquipoImpl()
{
	monitor=new elementoImpl("monitor", true);
	teclado=new elementoImpl("teclado", true);
	raton=new elementoImpl("raton", false);
	red=new elementoImpl("red", true);
	setID();
}
	@Override
	public String getID() {
		return equipoID;
	}

	@Override
	public void setID() {
		//Obtener el nombre del equipo.
		try {
			equipoID=getHostName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Date getFechaHora() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaHora(Date fechaHora) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOperativo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOperativo() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getMonitorOk() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMointorStatus() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getTecladoOk() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTecladoStatus() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getRatonOk() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRatonOk() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInfoIncidencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInfoIncidencia(String infoIncidencia) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSO() {
		// TODO Auto-generated method stub
		return sO;
	}

	@Override
	public void setSO() {
		// TODO Auto-generated method stub
		
	}

	
    private static String execReadToString(String execCommand) throws IOException {
        Process proc = Runtime.getRuntime().exec(execCommand);
        try (InputStream stream = proc.getInputStream()) {
            try (Scanner s = new Scanner(stream).useDelimiter("\\A")) {
                return s.hasNext() ? s.next() : "";
            }
        }

}

	
	private String getHostName() throws IOException
	{
	String rdo="No identificable";
	String OS = System.getProperty("os.name").toLowerCase();
	String OSVersion = System.getProperty("os.version").toLowerCase();
	String OSArch = System.getProperty("os.arch").toLowerCase();
	sO=OS+" "+OSVersion+" "+OSArch+" +"+getDistro();

        if (OS.indexOf("win") >= 0) {	//Sistemas Windows.
        	if  (System.getenv("COMPUTERNAME")!=null)
        		{
        		rdo=System.getenv("COMPUTERNAME");
        		return rdo;
        		}
        	if (execReadToString("hostname")!=null)
        		{
        		rdo=execReadToString("hostname");
        		return rdo;
        		}
	        } else {					//Sistemas UNIX
	            if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0) {
	            	if (System.getenv("HOSTNAME")!=null)
	            	{
	            		rdo=System.getenv("HOSTNAME");
	            		return rdo;
	            	}
	            	if (execReadToString("hostname")!=null)
	            	{
	            		rdo=execReadToString("hostname");
	            		return rdo;
	            	}
	            	if(execReadToString("cat /etc/hostname")!=null)
	            	{
	            		rdo=execReadToString("cat /etc/hostname");
	            		return rdo;
	            	}
	            }
	        }
		return rdo;
	}
		private String getDistro()
		{
			String rdo="";
			String[] cmd = {
					"/bin/sh", "-c", "cat /etc/*-release" };

					try {
					    Process p = Runtime.getRuntime().exec(cmd);
					    BufferedReader bri = new BufferedReader(new InputStreamReader(
					            p.getInputStream()));

					    String line = "";
					    while ((line = bri.readLine()) != null) {
					        System.out.println(line);
					      rdo=rdo+line;  
					    }
					} catch (IOException e) {

					    e.printStackTrace();
					} 
		return rdo;
		}
		
	
	
}
