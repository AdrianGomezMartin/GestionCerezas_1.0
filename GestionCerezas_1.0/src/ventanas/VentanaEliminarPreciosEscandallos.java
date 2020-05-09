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
 *         Ventana que gestiona la eliminacion de precios y escandallos
 *         simultaneámente
 *
 */
public class VentanaEliminarPreciosEscandallos {
	private JFrame ventanaEliminarPreciosEscandallos;
	private JButton btnEliminar, btnVolver;
	private JTextField txtFecha;

	public VentanaEliminarPreciosEscandallos() {
		ventanaEliminarPreciosEscandallos = new JFrame("Ventana Eliminar Precios y Escandallo");
		ventanaEliminarPreciosEscandallos.setBounds(600, 300, 500, 500);
		ventanaEliminarPreciosEscandallos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventanaEliminarPreciosEscandallos.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaEliminarPreciosEscandallos.setResizable(false);
	}

	/**
	 * Metodo que inicializa todos los botones
	 */
	private void inicializarListeners() {
		btnEliminar.addActionListener((e) -> {
			GestionBBDD.eliminarEscandallo(txtFecha.getText().toString());
			GestionBBDD.eliminarPrecios(txtFecha.getText().toString());
		});
		btnVolver.addActionListener((e) -> {
			VentanaEliminar ventanaEliminar = new VentanaEliminar();
			ventanaEliminar.Inicializar();
			ventanaEliminarPreciosEscandallos.dispose();
		});
	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventanaEliminarPreciosEscandallos.setLayout(new GridBagLayout());
		GridBagConstraints opc = new GridBagConstraints();
		Insets espacios = new Insets(10, 10, 10, 10);
		opc.gridx = 0;
		opc.gridy = 0;
		ventanaEliminarPreciosEscandallos.add(new JLabel("Inserte la fecha [precios/escandallo] (yyyy-mm-dd)"), opc);

		opc = new GridBagConstraints();
		txtFecha = new JTextField("", 10);
		opc.gridx = 1;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaEliminarPreciosEscandallos.add(txtFecha, opc);

		opc = new GridBagConstraints();
		btnEliminar = new JButton("Eliminar Precios");
		opc.gridx = 0;
		opc.gridy = 2;
		ventanaEliminarPreciosEscandallos.add(btnEliminar, opc);

		opc = new GridBagConstraints();
		btnVolver = new JButton("Volver");
		opc.gridx = 1;
		opc.gridy = 2;
		ventanaEliminarPreciosEscandallos.add(btnVolver, opc);
	}
}
