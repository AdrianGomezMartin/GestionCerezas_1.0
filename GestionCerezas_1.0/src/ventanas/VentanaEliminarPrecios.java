package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.GestionBBDD;

public class VentanaEliminarPrecios {
	private JFrame ventanaEliminarPrecios;
	private JButton btnEliminar, btnVolver;
	private JTextField txtFecha;

	public VentanaEliminarPrecios() {
		ventanaEliminarPrecios = new JFrame("Ventana Eliminar Precios");
		ventanaEliminarPrecios.setBounds(600, 300, 500, 500);
		ventanaEliminarPrecios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Inicializar() {
		ventanaEliminarPrecios.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaEliminarPrecios.setResizable(false);
	}

	private void inicializarListeners() {
		btnEliminar.addActionListener((e) -> {
			GestionBBDD.eliminarPrecios(txtFecha.getText().toString());
		});
		btnVolver.addActionListener((e) -> {
			VentanaEliminar ventanaEliminar = new VentanaEliminar();
			ventanaEliminar.Inicializar();
			ventanaEliminarPrecios.dispose();
		});

	}

	private void inicializarComponentes() {
		ventanaEliminarPrecios.setLayout(new GridBagLayout());
		GridBagConstraints opc = new GridBagConstraints();
		Insets espacios = new Insets(10, 10, 10, 10);
		opc.gridx = 0;
		opc.gridy = 0;
		ventanaEliminarPrecios.add(new JLabel("Inserte la fecha de los precios (yyyy-mm-dd)"), opc);

		opc = new GridBagConstraints();
		txtFecha = new JTextField("", 10);
		opc.gridx = 1;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaEliminarPrecios.add(txtFecha, opc);

		opc = new GridBagConstraints();
		btnEliminar = new JButton("Eliminar Precios");
		opc.gridx = 0;
		opc.gridy = 2;
		ventanaEliminarPrecios.add(btnEliminar, opc);

		opc = new GridBagConstraints();
		btnVolver = new JButton("Volver");
		opc.gridx = 1;
		opc.gridy = 2;
		ventanaEliminarPrecios.add(btnVolver, opc);
	}
}
