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
 *         Ventana que gestiona la inserción de precios
 *
 */
public class VentanaInsertarPrecios {
	private JFrame ventanaInsercion;
	private JTextField txt24, txt26, txt28, txt30, txt32, txtFecha;
	private JButton btnAceptar, btnLimpiar, btnVolver;

	public VentanaInsertarPrecios() {
		ventanaInsercion = new JFrame("Insercion Precios");
		ventanaInsercion.setBounds(600, 300, 800, 600);
		ventanaInsercion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventanaInsercion.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}

	/**
	 * Metodo que inicializa los Listeners de todos los botones
	 */
	private void inicializarListeners() {
		btnAceptar.addActionListener((e) -> {
			GestionBBDD.insertarPrecios(txtFecha.getText().toString(),
					new float[] { Float.parseFloat(txt32.getText().toString()),
							Float.parseFloat(txt30.getText().toString()), Float.parseFloat(txt28.getText().toString()),
							Float.parseFloat(txt26.getText().toString()),
							Float.parseFloat(txt24.getText().toString()) });
			btnLimpiar.doClick();

		});
		btnLimpiar.addActionListener((e) -> {
			txt32.setText(null);
			txt30.setText(null);
			txt28.setText(null);
			txt26.setText(null);
			txt24.setText(null);
			txtFecha.setText(null);
		});
		btnVolver.addActionListener((e) -> {
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.Inicializar();
			ventanaInsercion.dispose();
		});
	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventanaInsercion.setLayout(new GridBagLayout());
		Insets espacios = new Insets(10, 10, 10, 10);
		GridBagConstraints opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		opc.gridwidth = 3;
		ventanaInsercion.add(new JLabel("Inserte los precios referentes a la fecha "), opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaInsercion.add(new JLabel("Precio 32 : "), opc);

		txt32 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 1;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsercion.add(txt32, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaInsercion.add(new JLabel("Precio 30 : "), opc);

		txt30 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 2;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsercion.add(txt30, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaInsercion.add(new JLabel("Precio 28 : "), opc);

		txt28 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 3;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsercion.add(txt28, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 4;
		opc.insets = espacios;
		ventanaInsercion.add(new JLabel("Precio 26 : "), opc);

		txt26 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 4;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsercion.add(txt26, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 5;
		opc.insets = espacios;
		ventanaInsercion.add(new JLabel("Precio 24 : "), opc);

		txt24 = new JTextField("", 4);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 5;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsercion.add(txt24, opc);

		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 6;
		opc.insets = espacios;
		ventanaInsercion.add(new JLabel("Inserte la fecha del precio (yyyy-mm-dd) : "), opc);

		txtFecha = new JTextField("", 10);
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 6;
		opc.insets = espacios;
		opc.fill = GridBagConstraints.HORIZONTAL;
		ventanaInsercion.add(txtFecha, opc);

		espacios = new Insets(20, 20, 20, 20);
		btnAceptar = new JButton("Aceptar");
		opc = new GridBagConstraints();
		opc.gridx = 0;
		opc.gridy = 7;
		opc.insets = espacios;
		ventanaInsercion.add(btnAceptar, opc);

		btnLimpiar = new JButton("Limpiar Campos");
		opc = new GridBagConstraints();
		opc.gridx = 1;
		opc.gridy = 7;
		opc.insets = espacios;
		ventanaInsercion.add(btnLimpiar, opc);

		btnVolver = new JButton("Volver");
		opc = new GridBagConstraints();
		opc.gridx = 2;
		opc.gridy = 7;
		opc.insets = espacios;
		ventanaInsercion.add(btnVolver, opc);
		ventanaInsercion.setResizable(false);
	}
}
