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
 *         Ventana que gestiona el menú para eliminar datos
 *
 */
public class VentanaEliminar {
	private JFrame ventanaEliminar;
	private JButton btnEliminarEscandallo, btnEliminarPrecios, btnEliminarPreciosEscandallo, btnVolver;

	public VentanaEliminar() {
		ventanaEliminar = new JFrame("Ventana Eliminar");
		ventanaEliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaEliminar.setBounds(600, 300, 500, 500);
	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventanaEliminar.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaEliminar.setResizable(false);
	}

	/**
	 * Metodo que inicializa los Listeners de todos los botones
	 */
	private void inicializarListeners() {
		btnEliminarEscandallo.addActionListener((e) -> {
			VentanaEliminarEscandallo ventanaEliminarEscandallo = new VentanaEliminarEscandallo();
			ventanaEliminarEscandallo.Inicializar();
			ventanaEliminar.dispose();
		});
		btnEliminarPrecios.addActionListener((e) -> {
			VentanaEliminarPrecios ventanaEliminarPrecios = new VentanaEliminarPrecios();
			ventanaEliminarPrecios.Inicializar();
			ventanaEliminar.dispose();
		});
		btnEliminarPreciosEscandallo.addActionListener((e) -> {
			VentanaEliminarPreciosEscandallos ventanaEliminarPreciosEscandallos = new VentanaEliminarPreciosEscandallos();
			ventanaEliminarPreciosEscandallos.Inicializar();
			ventanaEliminar.dispose();
		});
		btnVolver.addActionListener((e) -> {
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.Inicializar();
			ventanaEliminar.dispose();
		});

	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventanaEliminar.setLayout(new GridBagLayout());
		Insets espacios = new Insets(20, 20, 20, 20);

		btnEliminarEscandallo = new JButton("Eliminar Escandallo");
		GridBagConstraints opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaEliminar.add(btnEliminarEscandallo);

		btnEliminarPrecios = new JButton("Eliminar Precios");
		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaEliminar.add(btnEliminarPrecios, opc);

		btnEliminarPreciosEscandallo = new JButton("Eliminar Precios y Escandallo");
		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 2;
		// opc.insets = espacios;
		ventanaEliminar.add(btnEliminarPreciosEscandallo, opc);

		btnVolver = new JButton("Volver");
		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaEliminar.add(btnVolver, opc);
	}
}
