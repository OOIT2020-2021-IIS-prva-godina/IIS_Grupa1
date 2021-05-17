package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<String> dlmBoje = new DefaultListModel<String>();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	private JTextField txtDodajBoju;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// centralni panel
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlCenter.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlCenter.setLayout(gbl_pnlCenter);

		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.setPreferredSize(new Dimension(80, 25));
		tglbtnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmBoje.addElement(lblCrvena.getText());

				if (tglbtnCrvena.isSelected()) {
					lblPlava.setForeground(Color.black);
					lblZuta.setForeground(Color.black);
					lblCrvena.setForeground(Color.red);
				}
			}
		});
		
				JLabel lblDodatneBoje = new JLabel("Izaberi dodatne boje:");
				GridBagConstraints gbc_lblDodatneBoje = new GridBagConstraints();
				gbc_lblDodatneBoje.anchor = GridBagConstraints.EAST;
				gbc_lblDodatneBoje.insets = new Insets(0, 0, 5, 5);
				gbc_lblDodatneBoje.gridx = 5;
				gbc_lblDodatneBoje.gridy = 0;
				pnlCenter.add(lblDodatneBoje, gbc_lblDodatneBoje);
		
				JComboBox<String> cbxDodatneBoje = new JComboBox<String>();
				cbxDodatneBoje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dlmBoje.addElement(cbxDodatneBoje.getSelectedItem().toString());

						switch (cbxDodatneBoje.getSelectedItem().toString()) {
						case "zelena":
							lblDodatneBoje.setForeground(Color.green);
							break;
						case "narandzasta":
							lblDodatneBoje.setForeground(Color.orange);
							break;
						case "ljubicasta":
							lblDodatneBoje.setForeground(Color.magenta);
							break;
							
						}
					}
				});
				cbxDodatneBoje
						.setModel(new DefaultComboBoxModel<String>(new String[] { "zelena", "narandzasta", "ljubicasta" }));
				GridBagConstraints gbc_cbxDodatneBoje = new GridBagConstraints();
				gbc_cbxDodatneBoje.insets = new Insets(0, 0, 5, 0);
				gbc_cbxDodatneBoje.fill = GridBagConstraints.HORIZONTAL;
				gbc_cbxDodatneBoje.gridx = 6;
				gbc_cbxDodatneBoje.gridy = 0;
				pnlCenter.add(cbxDodatneBoje, gbc_cbxDodatneBoje);
		
		JLabel lblUnesiBoju = new JLabel("Unesi boju:");
		GridBagConstraints gbc_lblUnesiBoju = new GridBagConstraints();
		gbc_lblUnesiBoju.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnesiBoju.anchor = GridBagConstraints.EAST;
		gbc_lblUnesiBoju.gridx = 5;
		gbc_lblUnesiBoju.gridy = 1;
		pnlCenter.add(lblUnesiBoju, gbc_lblUnesiBoju);
		
		txtDodajBoju = new JTextField();
		txtDodajBoju.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlmBoje.addElement(txtDodajBoju.getText());
					txtDodajBoju.setText("");
				}
			}
		});
		GridBagConstraints gbc_txtDodajBoju = new GridBagConstraints();
		gbc_txtDodajBoju.insets = new Insets(0, 0, 5, 0);
		gbc_txtDodajBoju.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDodajBoju.gridx = 6;
		gbc_txtDodajBoju.gridy = 1;
		pnlCenter.add(txtDodajBoju, gbc_txtDodajBoju);
		txtDodajBoju.setColumns(10);
		buttonGroup.add(tglbtnCrvena);
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 3;
		gbc_tglbtnCrvena.gridy = 2;
		pnlCenter.add(tglbtnCrvena, gbc_tglbtnCrvena);

		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 4;
		gbc_lblCrvena.gridy = 2;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);

		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.setPreferredSize(new Dimension(80, 25));
		tglbtnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmBoje.addElement(lblPlava.getText());

				if (tglbtnPlava.isSelected()) {
					lblCrvena.setForeground(Color.black);
					lblZuta.setForeground(Color.black);
					lblPlava.setForeground(Color.red);
				}
			}
		});
		buttonGroup.add(tglbtnPlava);
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 3;
		gbc_tglbtnPlava.gridy = 3;
		pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);

		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 4;
		gbc_lblPlava.gridy = 3;
		pnlCenter.add(lblPlava, gbc_lblPlava);

		JToggleButton tglbtnZuta = new JToggleButton("Zuta");
		tglbtnZuta.setPreferredSize(new Dimension(80, 25));
		tglbtnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmBoje.addElement(lblZuta.getText());

				if (tglbtnZuta.isSelected()) {
					lblCrvena.setForeground(Color.black);
					lblZuta.setForeground(Color.red);
					lblPlava.setForeground(Color.black);
				}

			}
		});
		buttonGroup.add(tglbtnZuta);
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZuta.gridx = 3;
		gbc_tglbtnZuta.gridy = 4;
		pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);

		lblZuta = new JLabel("Zuta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.gridx = 4;
		gbc_lblZuta.gridy = 4;
		pnlCenter.add(lblZuta, gbc_lblZuta);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 5;
		pnlCenter.add(scrollPane, gbc_scrollPane);

		JList listBoje = new JList();
		scrollPane.setViewportView(listBoje);
		listBoje.setModel(dlmBoje);

		// juzni panel
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton btnIspis = new JButton("Klikni me");
		btnIspis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)", "Ispis poruke klikom na dugme",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOtvoriDijalog = new JButton("Dodaj boju");
		btnOtvoriDijalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTestBoja dlgTest = new DlgTestBoja();
				dlgTest.setVisible(true);
				
				if(dlgTest.isOk) {
					dlmBoje.addElement(dlgTest.txtCrvena.getText()+" "+dlgTest.txtZelena.getText()+" "+dlgTest.txtPlava.getText());
					pnlCenter.setBackground(new Color(Integer.parseInt(dlgTest.txtCrvena.getText()),
							Integer.parseInt(dlgTest.txtZelena.getText()),Integer.parseInt(dlgTest.txtPlava.getText())));
				}
			}
		});
		pnlSouth.add(btnOtvoriDijalog);
		pnlSouth.add(btnIspis);

		// severni panel
		JPanel pnl_North = new JPanel();
		contentPane.add(pnl_North, BorderLayout.NORTH);
		pnl_North.setBackground(Color.green);
		pnl_North.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNaslov = new JLabel("Zadatak 1");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_North.add(lblNaslov);

	}

}
