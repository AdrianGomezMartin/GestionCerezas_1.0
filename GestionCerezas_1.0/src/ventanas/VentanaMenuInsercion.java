package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Adrián Gómez
 *
 *         Ventana que gestiona el menu de insercion
 */
public class VentanaMenuInsercion {
	private JFrame ventanaMenuInsercion;
	private JButton btnInsertarPrecios, btnInsertarEscandallo, btnVolver;

	public VentanaMenuInsercion() {
		ventanaMenuInsercion = new JFrame("Menu Insercion");
		ventanaMenuInsercion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaMenuInsercion.setBounds(600, 300, 500, 500);
	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventanaMenuInsercion.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaMenuInsercion.setResizable(false);
	}

	/**
	 * Metodo que inicializa los Listeners de todos los botones
	 */
	private void inicializarListeners() {
		btnInsertarEscandallo.addActionListener((e) -> {
			VentanaInsertarEscandallo ventanaInsertarEscandallo = new VentanaInsertarEscandallo();
			ventanaInsertarEscandallo.Inicializar();
			ventanaMenuInsercion.dispose();
		});
		btnInsertarPrecios.addActionListener((e) -> {
			VentanaInsertarPrecios ventanaInsertarPrecios = new VentanaInsertarPrecios();
			ventanaInsertarPrecios.Inicializar();
			ventanaMenuInsercion.dispose();
		});
		btnVolver.addActionListener((e) -> {
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.Inicializar();
			ventanaMenuInsercion.dispose();
		});
	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventanaMenuInsercion.setLayout(new GridBagLayout());
		GridBagConstraints opc = new GridBagConstraints();
		Insets espacios = new Insets(10, 10, 10, 10);
		btnInsertarPrecios = new JButton("Insertar Precios");
		btnInsertarEscandallo = new JButton("Insertar Escandallos");
		btnVolver = new JButton("Volver");

		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaMenuInsercion.add(btnInsertarPrecios, opc);

		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaMenuInsercion.add(btnInsertarEscandallo, opc);

		opc.gridx = 0;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaMenuInsercion.add(btnVolver, opc);

	}
}
