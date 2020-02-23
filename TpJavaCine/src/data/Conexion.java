package data;
import java.sql.*;


public class Conexion {
	private static Conexion instancia;
	
	
/*
	public String driver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="root";
	private String password="lalo123";
	private String db="cine";*/
	
	public String driver="com.mysql.jdbc.Driver";
	private String host="127.0.0.1";
	private String port="3306";
	private String user="root";
	private String password="lalo123";
	private String db="cine";
	private int conectados=0;
	private Connection conn=null;
	
	public Conexion() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
		
	}

	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}