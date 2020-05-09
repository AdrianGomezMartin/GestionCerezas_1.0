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
 *         Ventana que gestiona el menú de Consultas
 *
 */
public class VentanaConsulta {
	private JFrame ventanaConsulta;
	private JButton btnConsultaPrecios, btnConsultaEscandallo, btnConsultaDineroEscandallo, btnVolver;

	public VentanaConsulta() {
		ventanaConsulta = new JFrame("Ventana Consulta");
		ventanaConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaConsulta.setBounds(600, 300, 500, 400);
	}

	/**
	 * Método que inicializa la Ventana
	 */
	public void Inicializar() {
		ventanaConsulta.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		ventanaConsulta.setResizable(false);
	}

	/**
	 * Método que inicializa los Listeners de todos los botones
	 */
	private void inicializarListeners() {
		btnConsultaPrecios.addActionListener((e) -> {
			VentanaConsultaPrecios ventanaConsultaPrecios = new VentanaConsultaPrecios();
			ventanaConsultaPrecios.Inicializar();
			ventanaConsulta.dispose();
		});
		btnConsultaEscandallo.addActionListener((e) -> {
			VentanaConsultarEscandallo ventanaConsultarEscandallo = new VentanaConsultarEscandallo();
			ventanaConsultarEscandallo.Inicializar();
			ventanaConsulta.dispose();
		});
		btnConsultaDineroEscandallo.addActionListener((e) -> {
			VentanaCalcularPrecioEscandallo ventanaCalcularPrecioEscandallo = new VentanaCalcularPrecioEscandallo();
			ventanaCalcularPrecioEscandallo.Inicializar();
			ventanaConsulta.dispose();
		});
		btnVolver.addActionListener((e) -> {
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.Inicializar();
			ventanaConsulta.dispose();
		});
	}

	/**
	 * Metodo que inicializa los componentes de la ventana
	 */
	private void inicializarComponentes() {
		ventanaConsulta.setLayout(new GridBagLayout());
		Insets espacios = new Insets(20, 20, 20, 20);
		GridBagConstraints opc = new GridBagConstraints();
		btnConsultaPrecios = new JButton("Consultar Precios");
		opc.gridx = 0;
		opc.gridy = 0;
		opc.insets = espacios;
		ventanaConsulta.add(btnConsultaPrecios, opc);

		opc = new GridBagConstraints();
		btnConsultaEscandallo = new JButton("Consultar Escandallos");
		opc.gridx = 0;
		opc.gridy = 1;
		opc.insets = espacios;
		ventanaConsulta.add(btnConsultaEscandallo, opc);

		opc = new GridBagConstraints();
		btnConsultaDineroEscandallo = new JButton("Calcular Escandallo");
		opc.gridx = 0;
		opc.gridy = 2;
		opc.insets = espacios;
		ventanaConsulta.add(btnConsultaDineroEscandallo, opc);

		opc = new GridBagConstraints();
		btnVolver = new JButton("Volver");
		opc.gridx = 0;
		opc.gridy = 3;
		opc.insets = espacios;
		ventanaConsulta.add(btnVolver, opc);
	}
}
