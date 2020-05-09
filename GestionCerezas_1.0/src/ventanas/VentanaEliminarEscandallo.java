package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.GestionBBDD;

/**
 * 
 * @author Adrián Gómez
 *
 *         Ventana que gestiona la eliminación de escandallos
 */
public class VentanaEliminarEscandallo {
	private JFrame ventanaEliminarEscandallo;
	private JTextField txtFecha;
	private JButton btnEliminar, btnVolver;

	public VentanaEliminarEscandallo() {
		ventanaEliminarEscandallo = new JFrame("Eliminar Escandallo");
		ventanaEliminarEscandallo.setBounds(600, 300, 500, 500);
		ventanaEliminarEscandallo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventanaEliminarEscandallo.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaEliminarEscandallo.setResizable(false);
	}

	/**
	 * Metodo que inicializa los Listeners de todos los botones
	 */
	private void inicializarListeners() {
		btnVolver.addActionListener((e) -> {
			VentanaEliminar ventanaEliminar = new VentanaEliminar();
			ventanaEliminar.Inicializar();
			ventanaEliminarEscandallo.dispose();
		});
		btnEliminar.addActionListener((e) -> {
			GestionBBDD.eliminarEscandallo(txtFecha.getText().toString());
		});

	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventanaEliminarEscandallo.setLayout(new GridBagLayout());
		Insets espacios = new Insets(10, 10, 10, 10);
		GridBagConstraints opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 0;
		// opc.insets = espacios;
		ventanaEliminarEscandallo.add(new JLabel("Inserte la fecha del escandallo (yyyy-mm-dd)"), opc);

		opc = new GridBagConstraints();
		txtFecha = new JTextField("", 10);
		opc.gridx = 1;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaEliminarEscandallo.add(txtFecha, opc);

		opc = new GridBagConstraints();
		btnEliminar = new JButton("Eliminar Escandallo");
		opc.gridx = 0;
		opc.gridy = 2;
		ventanaEliminarEscandallo.add(btnEliminar, opc);

		opc = new GridBagConstraints();
		btnVolver = new JButton("Volver");
		opc.gridx = 1;
		opc.gridy = 2;
		ventanaEliminarEscandallo.add(btnVolver, opc);
	}
}
