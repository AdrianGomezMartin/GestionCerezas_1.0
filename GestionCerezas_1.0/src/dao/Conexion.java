package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Adrián Gómez
 * 
 *         Esta clase se utiliza para conectar con la BBDD Recuerde importar la
 *         libreria (mysql-connector-java-5.1.36-bin.jar) para su correcto
 *         funcionamiento
 */

public class Conexion {
	/**
	 * Método que devuelve una conexión con la BBDD
	 * 
	 * @return conexión configurada
	 */
	public static Connection getConexion() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/CEREZAS", "root", "");
			if (!conexion.isValid(5000))
				System.err.println("Error al conectar en la BBDD");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}
