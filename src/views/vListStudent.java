package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;

import handleData.dStudent;
import models.mStudent;
import models.result;
import controllers.cListStudent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class vListStudent {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vListStudent window = new vListStudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vListStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 28, 452, 297);
		frame.getContentPane().add(table);
		
		JButton btnImportCsv = new JButton("Import CSV");
		btnImportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result rs = cListStudent.importCsvListStudent();
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnImportCsv.setBounds(495, 294, 114, 25);
		frame.getContentPane().add(btnImportCsv);
		
		
//		JOptionPane.showMessageDialog(frame, );
	}
}
