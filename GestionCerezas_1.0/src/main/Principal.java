package main;

import java.awt.EventQueue;

import ventanas.VentanaPrincipal;

/**
 * 
 * @author Adrián Gómez
 * 
 *         Esta clase lanza la primera ventana del programa
 */
public class Principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.Inicializar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
