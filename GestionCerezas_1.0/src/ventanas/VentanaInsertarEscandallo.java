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
 *         Ventana que gestiona la insercion de escandallos
 *
 */
public class VentanaInsertarEscandallo {
	private JFrame ventanaInsertarEscandallo;
	private JTextField kg32, kg30, kg28, kg26, kg24, txtFecha;
	private JButton btnAceptar, btnCancelar, btnLimpiar;

	public VentanaInsertarEscandallo() {
		ventanaInsertarEscandallo = new JFrame("Ventana Insertar Escandallo");
		ventanaInsertarEscandallo.setBounds(600, 300, 800, 600);
		ventanaInsertarEscandallo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventanaInsertarEscandallo.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaInsertarEscandallo.setResizable(false);
	}

	/**
	 * Metodo que inicializa los Listeners de todos los botones
	 */
	private void inicializarListeners() {
		btnAceptar.addActionListener((e) -> {
			GestionBBDD.insertarEscandallo(txtFecha.getText().toString(),
					new float[] { Float.parseFloat(kg32.getText().toString()),
							Float.parseFloat(kg30.getText().toString()), Float.parseFloat(kg28.getText().toString()),
							Float.parseFloat(kg26.getText().toString()), Float.parseFloat(kg24.getText().toString()) });
			btnLimpiar.doClick();
		});
		btnLimpiar.addActionListener((e) -> {
			kg32.setText(null);
			kg30.setText(null);
			kg28.setText(null);
			kg26.setText(null);
			kg24.setText(null);
			txtFecha.setText(null);
		});
		btnCancelar.addActionListener((e) -> {
			VentanaMenuInsercion ventanaMenuInsercion = new VentanaMenuInsercion();
			ventanaMenuInsercion.Inicializar();
			ventanaInsertarEscandallo.dispose();
		});

	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventanaInsertarEscandallo.setLayout(new GridBagLayout());
		Insets espacios = new Insets(10, 10, 10, 10);
		GridBagConstraints opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		opc.gridwidth = 3;
		ventanaInsertarEscandallo.add(new JLabel("Introduce los kg por calibre"));

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaInsertarEscandallo.add(new JLabel("Kg 32 : "), opc);

		kg32 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 1;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(kg32, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaInsertarEscandallo.add(new JLabel("Kg 30 : "), opc);

		kg30 = new JTextField("", 4);
		opc.gridx = 1;
		opc.gridy = 2;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(kg30, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaInsertarEscandallo.add(new JLabel("Kg 28 : "), opc);

		kg28 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 3;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(kg28, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 4;
		opc.insets = espacios;
		ventanaInsertarEscandallo.add(new JLabel("Kg 26 : "), opc);

		kg26 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 4;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(kg26, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 5;
		opc.insets = espacios;
		ventanaInsertarEscandallo.add(new JLabel("Kg 24 : "), opc);

		kg24 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 5;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(kg24, opc);

		txtFecha = new JTextField("", 10);
		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaInsertarEscandallo.add(new JLabel("Inserte la fecha del escandallo (yyyy-mm-dd)"), opc);

		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 6;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(txtFecha, opc);

		espacios = new Insets(20, 20, 20, 20);
		btnAceptar = new JButton("Aceptar");
		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 7;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(btnAceptar, opc);

		btnLimpiar = new JButton("Limpiar Campos");
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 7;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(btnLimpiar, opc);

		btnCancelar = new JButton("Volver");
		opc = new GridBagConstraints();
		opc.gridx = 2;
		opc.gridy = 7;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsertarEscandallo.add(btnCancelar, opc);
	}
}
