package ventanas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Adrián Gómez
 *
 *         Ventana que gestiona el menú principal
 */
public class VentanaPrincipal {
	private JFrame ventana;
	private JButton[] botones = new JButton[3];
	int i;

	public VentanaPrincipal() {
		ventana = new JFrame("Menu Principal");
		ventana.setBounds(600, 300, 500, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo que inicializa la ventana
	 */
	public void Inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}

	/**
	 * Metodo que inicializa los componentes de la Ventana
	 */
	private void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		GridBagConstraints opc = new GridBagConstraints();
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new JButton(i == 0 ? "Añadir Datos" : i == 1 ? "Eliminar Datos" : "Consultar Datos");
			opc.gridx = 0;
			opc.gridy = i;
			opc.fill = GridBagConstraints.BOTH;
			opc.insets = new Insets(40, 10, 10, 10);
			ventana.getContentPane().add(botones[i], opc);
		}
		ventana.setResizable(false);
	}

	/**
	 * Metodo que inicializa los listeners de todos los botones
	 */
	private void inicializarListeners() {
		for (i = 0; i < botones.length; i++) {
			botones[i].addActionListener(new ActionListener() {
				private int i_anonima = i;

				@Override
				public void actionPerformed(ActionEvent e) {
					switch (i_anonima) {
					case 0:
						VentanaMenuInsercion ventanaMenuInsercion = new VentanaMenuInsercion();
						ventanaMenuInsercion.Inicializar();
						ventana.dispose();
						break;
					case 1:
						VentanaEliminar ventanaEliminar = new VentanaEliminar();
						ventanaEliminar.Inicializar();
						ventana.dispose();
						break;
					case 2:
						VentanaConsulta ventanaConsulta = new VentanaConsulta();
						ventanaConsulta.Inicializar();
						ventana.dispose();
						break;
					}

				}
			});
		}

	}
}
