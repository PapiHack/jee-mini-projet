package meissa.managers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author papihack
 * @since 07/02/19
 * @version 0.1.0
 * 
 *          Classe permettant d'établir une connection à la base de donnée. Le
 *          pattern Singleton y est implémenté !
 */
public class DbManager
{
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String URL_NAME = "jdbc:mysql://localhost/gestion_client";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "";
	private static DbManager dbManager;
	
	private DbManager()
	{
	}
	
	public static DbManager getInstance()
	{
		if (dbManager == null)
			dbManager = new DbManager();
		return dbManager;
		
	}
	
	public Connection getConnexion()
	{
		Connection con = null;
		
		try
		{
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL_NAME, DB_USER, DB_PASSWORD);
		} catch (java.sql.SQLException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			System.out.println("Driver introuvable !");
			e.printStackTrace();
		}
		
		return con;
	}
}
