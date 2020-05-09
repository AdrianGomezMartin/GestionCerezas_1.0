package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.GestionBBDD;

public class VentanaCalcularPrecioEscandallo {
	private JFrame ventanaCalcularEscandallo;
	private JTextField txtFecha, txt32, txt30, txt28, txt26, txt24, txtTotal;
	private JButton btnConsultar, btnLimpiarCampos, btnVolver;

	public VentanaCalcularPrecioEscandallo() {
		ventanaCalcularEscandallo = new JFrame("Ventana CalcularEscandallo");
		ventanaCalcularEscandallo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCalcularEscandallo.setBounds(600, 300, 600, 600);
	}

	public void Inicializar() {
		ventanaCalcularEscandallo.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaCalcularEscandallo.setResizable(false);
	}

	private void inicializarListeners() {
		btnConsultar.addActionListener((e) -> {
			float total = 0;
			float[] valores = GestionBBDD.calcularValorEscandallo(txtFecha.getText().toString());
			for (int i = 0; i < valores.length; i++) {
				valores[i] = formatearDecimales(Double.parseDouble(Float.toString(valores[i])), 2);
				total += valores[i];
			}
			txt32.setText(Float.toString(valores[0]) + " €");
			txt30.setText(Float.toString(valores[1]) + " €");
			txt28.setText(Float.toString(valores[2]) + " €");
			txt26.setText(Float.toString(valores[3]) + " €");
			txt24.setText(Float.toString(valores[4]) + " €");
			txtTotal.setText(Float.toString(total) + " €");

		});
		btnLimpiarCampos.addActionListener((e) -> {
			txt32.setText(null);
			txt30.setText(null);
			txt28.setText(null);
			txt26.setText(null);
			txt24.setText(null);
			txtTotal.setText(null);
			txtFecha.setText(null);
		});
		btnVolver.addActionListener((e) -> {
			VentanaConsulta ventanaConsulta = new VentanaConsulta();
			ventanaConsulta.Inicializar();
			ventanaCalcularEscandallo.dispose();
		});

	}

	private void inicializarComponentes() {
		ventanaCalcularEscandallo.setLayout(new GridBagLayout());
		GridBagConstraints opc = new GridBagConstraints();
		Insets espacios = new Insets(10, 10, 10, 10);
		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("Inserte la fecha del escandallo (yyyy-mm-dd)"));

		opc = new GridBagConstraints();
		txtFecha = new JTextField("", 10);
		opc.gridx = 1;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txtFecha, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("Valor 32 : "), opc);

		opc = new GridBagConstraints();
		txt32 = new JTextField("", 6);
		txt32.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txt32, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("Valor 30 : "), opc);

		opc = new GridBagConstraints();
		txt30 = new JTextField("", 6);
		txt30.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txt30, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("Valor 28 : "), opc);

		opc = new GridBagConstraints();
		txt28 = new JTextField("", 6);
		txt28.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txt28, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 4;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("Valor 26 : "), opc);

		opc = new GridBagConstraints();
		txt26 = new JTextField("", 6);
		txt26.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 4;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txt26, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 5;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("Valor 24 : "), opc);

		opc = new GridBagConstraints();
		txt24 = new JTextField("", 6);
		txt24.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 5;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txt24, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(new JLabel("TOTAL : "), opc);

		opc = new GridBagConstraints();
		txtTotal = new JTextField("", 8);
		txtTotal.setEditable(false);
		opc.gridx = 1;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(txtTotal, opc);

		opc = new GridBagConstraints();
		btnConsultar = new JButton("Calcular Escandallo");
		opc.gridx = 0;
		opc.gridy = 7;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(btnConsultar, opc);

		opc = new GridBagConstraints();
		btnLimpiarCampos = new JButton("Limpiar Campos");
		opc.gridx = 1;
		opc.gridy = 7;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(btnLimpiarCampos, opc);

		opc = new GridBagConstraints();
		btnVolver = new JButton("Volver");
		opc.gridx = 2;
		opc.gridy = 7;
		opc.insets = espacios;
		ventanaCalcularEscandallo.add(btnVolver, opc);

	}

	private float formatearDecimales(Double numero, Integer numeroDecimales) {
		return Float.parseFloat(
				Double.toString(Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales)));
	}
}
