package colasProcesador;

import java.awt.Color; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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

						if (e.getSource() == btnProcesoInicial) {
							btnProcesoInicial.setEnabled(false);
							colaProcesos.colaNodos();
							dibujar.pintarCola(pnlPintar.getGraphics(), colaProcesos.getcolaNodos());
						}
						if (e.getSource() == btnEliminar) {
							colaProcesos.eliminar(Integer.parseInt(JOptionPane.showInputDialog(null,"id del nodo a eliminar")));
							dibujar.limpiar(pnlPintar.getGraphics());
							dibujar.pintarCola(pnlPintar.getGraphics(), colaProcesos.getcolaNodos());
						}
						if (e.getSource() == btnNuevoNodo) {
							colaProcesos.rellenarNodo();
							dibujar.pintarCola(pnlPintar.getGraphics(), colaProcesos.getcolaNodos());
						}
						if (e.getSource() == btnEjecutar) {
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

		btnProcesoInicial.addActionListener(evento);
		btnNuevoNodo.addActionListener(evento);
		btnEjecutar.addActionListener(evento);
		btnEliminar.addActionListener(evento);

	}


	@SuppressWarnings("unchecked")

	private void initComponents() {

		pnlPintar = new JPanel();
		btnProcesoInicial = new JButton();
		btnEjecutar = new JButton();
		btnNuevoNodo = new JButton();
		btnEliminar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		btnProcesoInicial.setBackground(new Color(51, 204, 255));
		btnProcesoInicial.setForeground(new Color(255, 255, 255));
		btnProcesoInicial.setText("Procesos Iniciales");
		btnProcesoInicial.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnFilaInicialMouseClicked(evt);
			}
		});

		btnProcesoInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnFilaInicialActionPerformed(evt);
			}
		});//fin botón inicial

		//botón eliminar
		btnEliminar.setBackground(new Color(51, 204, 255));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setText("Eliminar Proceso");
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnEliminarProcesoMouseClicked(evt);
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnEliminarProcesoActionPerformed(evt);
			}
		});
		
		
		btnEjecutar.setBackground(new Color(51, 204, 255));
		btnEjecutar.setForeground(new Color(255, 255, 255));
		btnEjecutar.setText("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnServicioActionPerformed(evt);
			}
		});

		btnNuevoNodo.setBackground(new Color(51, 204, 255));
		btnNuevoNodo.setForeground(new Color(255, 255, 255));
		btnNuevoNodo.setText("Nuevo Proceso");
		btnNuevoNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNuevoClienteActionPerformed(evt);
			}
		});

		GroupLayout pnlPintarLayout = new GroupLayout(pnlPintar);
		pnlPintar.setLayout(pnlPintarLayout);
		pnlPintarLayout.setHorizontalGroup(pnlPintarLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlPintarLayout.createSequentialGroup().addGap(19, 19, 19)
						.addComponent(btnEjecutar, GroupLayout.PREFERRED_SIZE, 114,GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addComponent(btnProcesoInicial,GroupLayout.PREFERRED_SIZE, 170,GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 180,GroupLayout.PREFERRED_SIZE)
						.addGap(19, 19, 19)
						.addComponent(btnNuevoNodo, GroupLayout.PREFERRED_SIZE, 145,GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0,0)));

		pnlPintarLayout.setVerticalGroup(pnlPintarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlPintarLayout.createSequentialGroup().addContainerGap(399, Short.MAX_VALUE)
						.addGroup(pnlPintarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnProcesoInicial, GroupLayout.PREFERRED_SIZE, 43,GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEjecutar,GroupLayout.PREFERRED_SIZE, 43,GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNuevoNodo, GroupLayout.PREFERRED_SIZE, 46,GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 46,GroupLayout.PREFERRED_SIZE))
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

	private void btnFilaInicialMouseClicked(MouseEvent evt) {

	}
	

	private void btnFilaInicialActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}
	
	private void btnEliminarProcesoMouseClicked(MouseEvent evt) {

	}
	
	private void btnEliminarProcesoActionPerformed(ActionEvent evt) {
		
	}
	

	private void btnServicioActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnNuevoClienteActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}


	/**
	 * @param args the command line arguments
	 */

	private JButton btnProcesoInicial;
	private JButton btnNuevoNodo;
	private JButton btnEjecutar;
	private JButton btnEliminar;
	private JPanel pnlPintar;
	
}
