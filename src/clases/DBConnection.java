package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class DBConnection {

	protected ResourceBundle configFile;
	protected String url;
	protected String user;
	protected String pass;
	protected Connection con;
	protected PreparedStatement stmt;
	
	public DBConnection() 
	{
		
		/*File file = new File("the path of the folder containing the bundles");
		URL[] urls = new URL[]{file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle rb = ResourceBundle.getBundle("the bundle name", your_locale, loader);*/
		
		
		configFile = ResourceBundle.getBundle("clases.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
	}
	
	
	
	public Connection openConnection() throws Exception{
		con = DriverManager.getConnection(url, user, pass);
		//String url = "jdbc:mysql://localhost/nombreBaseDatos";
		//String url ="jdbc:mysql://localhost:3306/agency?serverTimezone=Europe/Madrid&useSSL=false";
		//con =  DriverManager.getConnection(url+"?" +"user=____&password=_____");
		//con =  DriverManager.getConnection(url,"root" ,"abcd*1234");
                return con;
			
		}
	
	public void closeConnection(PreparedStatement stmt, Connection con) throws Exception{
		if (stmt != null) 		
			stmt.close();
		
		if(con != null)			
			con.close();
			
	}
	
}