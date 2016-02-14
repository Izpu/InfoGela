package procesos.auxiliares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SistemaOperativo {
	private String sO;					//Sistema operativo.
	private boolean linux=false;		//SO Linux.
	private boolean windows=false;		//SO Windows.
	private String version="";			//Versión del S.O.
	private String arquitectura="";		//Arquitectura del S.O.
	
	public SistemaOperativo()
	{
		procesar();
	}
	public String getSO()
	{
		//getHostName();
		return sO;
	}
	public String getArquitectura()
	{
		return arquitectura;
	}
/**
 * Devuelve la información de la distribución de linux que se está ejecutando.
 * @return Cadena con el nombre y versión de la distribución.
 */
	public String getDistro()
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
				    	if (line.indexOf("DISTRIB_ID")>=0) 
				    	{
						      rdo=rdo+line.substring("DISTRIB_ID".length()); 
				    	}
				    	if(line.indexOf("DISTRIB_RELEASE")>=0) 
				    	{
				    		rdo=rdo+" "+line.substring("DISTRIB_RELEASE".length()+1);
				    	}
				    }
				} catch (IOException e) {

				    e.printStackTrace();
				} 
	return rdo;
	}

	private String getHostName() throws IOException
	{
	String rdo="No identificable";
	//String OS = System.getProperty("os.name").toLowerCase();
	String OSVersion = System.getProperty("os.version").toLowerCase();
	//String OSArch = System.getProperty("os.arch").toLowerCase();
	sO=OSVersion+" "+this.arquitectura+" +"+getDistro();

        if (this.windows) {	//Sistemas Windows.
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
	            if (this.linux) {
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
	
	   private static String execReadToString(String execCommand) throws IOException {
	        Process proc = Runtime.getRuntime().exec(execCommand);
	        try (InputStream stream = proc.getInputStream()) {
	            try (Scanner s = new Scanner(stream).useDelimiter("\\A")) {
	                return s.hasNext() ? s.next() : "";
	            }
	        }

	}
	
	   public void procesar()
	   {
		   String OS = System.getProperty("os.name").toLowerCase();
		   if (OS.indexOf("win")>=0) this.windows=true;
		   if(OS.indexOf("nix")>=0 || OS.indexOf("nux") >= 0) this.linux=true;
		   this.arquitectura = System.getProperty("os.arch").toLowerCase(); //Arquitectura
	   }
}
