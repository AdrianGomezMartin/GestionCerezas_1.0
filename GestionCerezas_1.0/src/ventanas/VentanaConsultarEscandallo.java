package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.GestionBBDD;

public class VentanaConsultarEscandallo {
	private JFrame ventanaConsultaEscandallo;
	private JTextField txtFecha, txt32, txt30, txt28, txt26, txt24;
	private JButton btnConsultar, btnLimpiarCampos, btnVolver;

	public VentanaConsultarEscandallo() {
		ventanaConsultaEscandallo = new JFrame("Ventana Consultar Escandallos");
		ventanaConsultaEscandallo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaConsultaEscandallo.setBounds(600, 300, 600, 600);
	}

	public void Inicializar() {
		ventanaConsultaEscandallo.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaConsultaEscandallo.setResizable(false);
	}

	private void inicializarListeners() {
		btnConsultar.addActionListener((e) -> {
			float precios[] = GestionBBDD.obtenerEscandallo(txtFecha.getText().toString());
			txt32.setText(Float.toString(precios[0]));
			txt30.setText(Float.toString(precios[1]));
			txt28.setText(Float.toString(precios[2]));
			txt26.setText(Float.toString(precios[3]));
			txt24.setText(Float.toString(precios[4]));
		});
		btnLimpiarCampos.addActionListener((e) -> {
			txt32.setText(null);
			txt30.setText(null);
			txt28.setText(null);
			txt26.setText(null);
			txt24.setText(null);
			txtFecha.setText(null);
		});
		btnVolver.addActionListener((e) -> {
			VentanaConsulta ventanaConsulta = new VentanaConsulta();
			ventanaConsulta.Inicializar();
			ventanaConsultaEscandallo.dispose();
		});

	}

	private void inicializarComponentes() {
		ventanaConsultaEscandallo.setLayout(new GridBagLayout());
		GridBagConstraints opc = new GridBagConstraints();
		Insets espacios = new Insets(10, 10, 10, 10);
		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(new JLabel("Inserte la fecha del escandallo (yyyy-mm-dd)"));

		opc = new GridBagConstraints();
		txtFecha = new JTextField("", 10);
		opc.gridx = 1;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(txtFecha, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(new JLabel("Kg 32 : "), opc);

		opc = new GridBagConstraints();
		txt32 = new JTextField("", 4);
		txt32.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(txt32, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(new JLabel("Kg 30 : "), opc);

		opc = new GridBagConstraints();
		txt30 = new JTextField("", 4);
		txt30.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(txt30, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(new JLabel("Kg 28 : "), opc);

		opc = new GridBagConstraints();
		txt28 = new JTextField("", 4);
		txt28.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(txt28, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 4;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(new JLabel("Kg 26 : "), opc);

		opc = new GridBagConstraints();
		txt26 = new JTextField("", 4);
		txt26.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 4;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(txt26, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 5;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(new JLabel("Kg 24 : "), opc);

		opc = new GridBagConstraints();
		txt24 = new JTextField("", 4);
		txt24.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 5;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(txt24, opc);

		opc = new GridBagConstraints();
		btnConsultar = new JButton("Consultar Escandallo");
		opc.gridx = 0;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(btnConsultar, opc);

		opc = new GridBagConstraints();
		btnLimpiarCampos = new JButton("Limpiar Campos");
		opc.gridx = 1;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(btnLimpiarCampos, opc);

		opc = new GridBagConstraints();
		btnVolver = new JButton("Volver");
		opc.gridx = 2;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaConsultaEscandallo.add(btnVolver, opc);

	}
}
