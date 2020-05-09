package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GestionBBDD {

	public static void insertarPrecios(String fecha, float[] precios) {
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "INSERT INTO PRECIOS(FECHA ,PRECIO_32,PRECIO_30,PRECIO_28,PRECIO_26,PRECIO_24) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = conexion.prepareStatement(sql);
			st.setDate(1, Date.valueOf(fecha));
			st.setFloat(2, precios[0]);
			st.setFloat(3, precios[1]);
			st.setFloat(4, precios[2]);
			st.setFloat(5, precios[3]);
			st.setFloat(6, precios[4]);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Precio insertado con exito");
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarEscandallo(String fecha, float[] kilos) {
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "INSERT INTO ESCANDALLOS(FECHA,KG_32,KG_30,KG_28,KG_26,KG_24) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = conexion.prepareStatement(sql);
			st.setDate(1, Date.valueOf(fecha));
			st.setFloat(2, kilos[0]);
			st.setFloat(3, kilos[1]);
			st.setFloat(4, kilos[2]);
			st.setFloat(5, kilos[3]);
			st.setFloat(6, kilos[4]);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Escandallo insertado con exito");
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarPrecios(String fecha) {
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "DELETE FROM PRECIOS WHERE FECHA = ?";
			PreparedStatement st = conexion.prepareStatement(sql);
			st.setDate(1, Date.valueOf(fecha));
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Precio eliminado con Exito");
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarEscandallo(String fecha) {
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "DELETE FROM ESCANDALLOS WHERE FECHA = ?";
			PreparedStatement st = conexion.prepareStatement(sql);
			st.setDate(1, Date.valueOf(fecha));
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Escandallo eliminado con éxito");
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static float[] obtenerEscandallo(String fecha) {
		float[] kilos = new float[5];
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "SELECT KG_32, KG_30, KG_28, KG_26, KG_24 FROM ESCANDALLOS WHERE FECHA = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(fecha));
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				kilos[0] = rs.getFloat("KG_32");
				kilos[1] = rs.getFloat("KG_30");
				kilos[2] = rs.getFloat("KG_28");
				kilos[3] = rs.getFloat("KG_26");
				kilos[4] = rs.getFloat("KG_24");
			}
			rs.close();
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kilos;
	}

	public static float[] obtenerPrecios(String fecha) {
		float[] precios = new float[5];
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "SELECT PRECIO_32, PRECIO_30, PRECIO_28, PRECIO_26, PRECIO_24 FROM PRECIOS WHERE FECHA = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(fecha));
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				precios[0] = rs.getFloat(1);
				precios[1] = rs.getFloat(2);
				precios[2] = rs.getFloat(3);
				precios[3] = rs.getFloat(4);
				precios[4] = rs.getFloat(5);
			}
			rs.close();
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precios;
	}

	public static float[] calcularValorEscandallo(String fecha) {
		float[] valores = new float[5];
		try {
			Connection conexion = Conexion.getConexion();
			String sql = "SELECT E.KG_32 * P.PRECIO_32 AS VALOR_32 , E.KG_30 * P.PRECIO_30 AS VALOR_30,"
					+ " E.KG_28 * P.PRECIO_28 AS VALOR_28, E.KG_26 * P.PRECIO_26 AS VALOR_26, E.KG_24 * P.PRECIO_24 AS VALOR_24"
					+ " FROM ESCANDALLOS AS E , PRECIOS AS P WHERE E.FECHA = P.FECHA AND E.FECHA = ?;";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(fecha));
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				valores[0] = rs.getFloat("VALOR_32");
				valores[1] = rs.getFloat("VALOR_30");
				valores[2] = rs.getFloat("VALOR_28");
				valores[3] = rs.getFloat("VALOR_26");
				valores[4] = rs.getFloat("VALOR_24");
			}
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valores;
	}
}
