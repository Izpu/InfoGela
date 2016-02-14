package elementos;

public class elementoImpl implements elementoInt {
	private String nombreElemento;			//Nombre del elemento.
	private boolean statusOk=false;				//El elemento está operativo.
	private String comentario;					//Comentario sobre el elemento.
	private boolean fundamental=false;			//Si el elemento es imprescindible para el uso del equipo.
	
 public elementoImpl(String nombreElemento, boolean fundamental) {
	this.nombreElemento=nombreElemento;
	this.fundamental=fundamental;
 	}
 
	@Override
	public void setOk(boolean statusOk) {
		this.statusOk=statusOk;
	}

	@Override
	public boolean getOk() {
		return statusOk;
	}

	@Override
	public void setComentario(String comentario) {
		this.comentario=comentario;
	}

	@Override
	public String getComentario() {
		return comentario;
	}

	@Override
	public void setFundamental(boolean fundamental) {
		this.fundamental=fundamental;
	}

/*
 * Tal vez no se use para nada ya que está en el constructor.
 */
	@Override
	public void setNombre(String nombre) {
		this.nombreElemento=nombre;
	}

	@Override
	public String getNombre() {
		return nombreElemento;
	}

	@Override
	public boolean getFundamental() {
		return fundamental;
	}

}
