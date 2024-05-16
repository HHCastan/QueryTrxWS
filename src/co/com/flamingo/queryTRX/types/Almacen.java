package co.com.flamingo.queryTRX.types;

public class Almacen {
	private String codigo;
	private String nombre;
	private String IP;
	private String tomcatServer;
	private String userData1;
	private String userData2;
	private String userData3;
	private String userData4;
	private String userData5;

	public String getCodigo() {
		return this.codigo;
	}

	public Almacen(String codigo) {
		super();
		this.codigo = codigo;
	}

	public Almacen() {
		super();
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return getCodigo() + " - " + getNombre();
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getTomcatServer() {
		return tomcatServer;
	}

	public void setTomcatServer(String tomcatServer) {
		this.tomcatServer = tomcatServer;
	}

	public String getUserData1() {
		return userData1;
	}

	public void setUserData1(String userData1) {
		this.userData1 = userData1;
	}

	public String getUserData2() {
		return userData2;
	}

	public void setUserData2(String userData2) {
		this.userData2 = userData2;
	}

	public String getUserData3() {
		return userData3;
	}

	public void setUserData3(String userData3) {
		this.userData3 = userData3;
	}

	public String getUserData4() {
		return userData4;
	}

	public void setUserData4(String userData4) {
		this.userData4 = userData4;
	}

	public String getUserData5() {
		return userData5;
	}

	public void setUserData5(String userData5) {
		this.userData5 = userData5;
	}

}
