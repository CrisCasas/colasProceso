package colasProcesador;

import java.awt.Color; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import java.awt.Color;
import javax.swing.GroupLayout;

/**
 *
 * @author dracored
 */
public class Ventana extends javax.swing.JFrame {

	interfaz dibujar = new interfaz();
	ColaProcesos colaProcesos;
	Procesador procesador;

	public Ventana() {
		initComponents();
		this.setSize(1000, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("colaProcesador");
		pnlPintar.setSize(1000, 400);
		pnlPintar.setAlignmentX(320);
		colaProcesos = new ColaProcesos();
		procesador = new Procesador();

		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				final SwingWorker worker = new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {

						if (e.getSource() == btnFilaInicial) {
							btnFilaInicial.setEnabled(false);
							colaProcesos.colaNodos();
							dibujar.pintarCola(pnlPintar.getGraphics(), colaProcesos.getcolaNodos());
						}
						if (e.getSource() == btnNuevoCliente) {
							colaProcesos.rellenarNodo();
							dibujar.pintarCola(pnlPintar.getGraphics(), colaProcesos.getcolaNodos());
						}
						if (e.getSource() == btnServicio) {
							while (colaProcesos.colaNodos.size() != 0) {
								dibujar.pintarCola(pnlPintar.getGraphics(), colaProcesos.getcolaNodos());
								procesador.ejecutarProceso(colaProcesos.colaNodos.get(0));
								if (colaProcesos.colaNodos.get(0).getnumProcesadores() == 0) {
									colaProcesos.colaNodos.remove(0);
								} else {
									System.out.println("..............");
									Thread.sleep(100);
									colaProcesos.regresarACola(colaProcesos.colaNodos);
								}
								dibujar.limpiar(pnlPintar.getGraphics());
							}
						}
						return null;
					}
				};
				worker.execute();

			}
		};

		btnFilaInicial.addActionListener(evento);
		btnNuevoCliente.addActionListener(evento);
		btnServicio.addActionListener(evento);

	}


	@SuppressWarnings("unchecked")

	private void initComponents() {

		pnlPintar = new JPanel();
		btnFilaInicial = new JButton();
		btnServicio = new JButton();
		btnNuevoCliente = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		btnFilaInicial.setBackground(new Color(51, 204, 255));
		btnFilaInicial.setForeground(new Color(255, 255, 255));
		btnFilaInicial.setText("Procesos Iniciales");
		btnFilaInicial.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnFilaInicialMouseClicked(evt);
			}
		});

		btnFilaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnFilaInicialActionPerformed(evt);
			}
		});

		btnServicio.setBackground(new Color(51, 204, 255));
		btnServicio.setForeground(new Color(255, 255, 255));
		btnServicio.setText("Ejecutar");
		btnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnServicioActionPerformed(evt);
			}
		});

		btnNuevoCliente.setBackground(new Color(51, 204, 255));
		btnNuevoCliente.setForeground(new Color(255, 255, 255));
		btnNuevoCliente.setText("Nuevo Proceso");
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNuevoClienteActionPerformed(evt);
			}
		});

		GroupLayout pnlPintarLayout = new GroupLayout(pnlPintar);
		pnlPintar.setLayout(pnlPintarLayout);
		pnlPintarLayout.setHorizontalGroup(pnlPintarLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlPintarLayout.createSequentialGroup().addGap(19, 19, 19)
						.addComponent(btnServicio, GroupLayout.PREFERRED_SIZE, 114,GroupLayout.PREFERRED_SIZE)
						.addGap(267, 267, 267)
						.addComponent(btnFilaInicial,GroupLayout.PREFERRED_SIZE, 170,GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
						.addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145,GroupLayout.PREFERRED_SIZE)
						.addGap(19, 19, 19)));

		pnlPintarLayout.setVerticalGroup(pnlPintarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlPintarLayout.createSequentialGroup().addContainerGap(399, Short.MAX_VALUE)
						.addGroup(pnlPintarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnFilaInicial, GroupLayout.PREFERRED_SIZE, 43,GroupLayout.PREFERRED_SIZE)
								.addComponent(btnServicio,GroupLayout.PREFERRED_SIZE, 43,GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNuevoCliente, GroupLayout.PREFERRED_SIZE, 46,GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnlPintar,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnlPintar,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}

	private void btnFilaInicialMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void btnFilaInicialActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnServicioActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */

	private javax.swing.JButton btnFilaInicial;
	private javax.swing.JButton btnNuevoCliente;
	private javax.swing.JButton btnServicio;
	private javax.swing.JPanel pnlPintar;
	
}
