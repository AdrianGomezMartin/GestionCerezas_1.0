 package main;

import java.awt.EventQueue;

import ventanas.VentanaPrincipal;

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
