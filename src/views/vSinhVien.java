package views;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controllers.cGiaoVu;
import controllers.cSinhVien;
import models.mPoint;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class vSinhVien {

	public JFrame frame;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vSinhVien window = new vSinhVien();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * 
	 * @wbp.parser.entryPoint
	 */
	public vSinhVien(String id, String idStudent, String type) throws IOException {
		initialize(id, idStudent, type);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String idStudent, String type) throws IOException {
		frame = new JFrame("Sinh vien - " + idStudent);
		frame.setBounds(100, 100, 606, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// handle close window
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "Ban muon thoat chuong trinh", "Thong bao!",
						JOptionPane.YES_NO_OPTION);
				if (confirm == 0) {
					frame.dispose();
				}
			}
		});

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		JLabel lblMon = new JLabel("Mon");

		JComboBox comboBoxMon = new JComboBox();
		loadComboboxSubjectOfStudent(comboBoxMon, idStudent);
		
		String cbbSelected = (String) comboBoxMon.getSelectedItem();
		renderDataTable(table, idStudent, cbbSelected);
		
		comboBoxMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String cbbSelected = (String) comboBoxMon.getSelectedItem();
					renderDataTable(table, idStudent, cbbSelected);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		JCheckBox chckbxTaCaMon = new JCheckBox("Ta ca mon");
		chckbxTaCaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (chckbxTaCaMon.isSelected()) {
						renderDataTable(table, idStudent, "");
					} else {
						renderDataTable(table, "", "");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnDoiMatKhau = new JButton("Doi mat khau");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vDoiMatKhau window = new vDoiMatKhau(id, idStudent, type);
				window.frame.setVisible(true);
			}
		});

		JButton btnDangXuat = new JButton("Dang xuat");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vLogin window = new vLogin();
				window.frame.setVisible(true);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblMon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxMon, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
					.addComponent(chckbxTaCaMon)
					.addGap(85))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnDangXuat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDoiMatKhau, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(41))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxMon, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMon)
						.addComponent(chckbxTaCaMon))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addGap(17)
					.addComponent(btnDoiMatKhau)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDangXuat)
					.addGap(24))
		);

		frame.getContentPane().setLayout(groupLayout);
	}

	private void renderDataTable (JTable table, String idStudent, String subjectName) throws IOException {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		
		model.addColumn("Mon");
		model.addColumn("Mssv");
		model.addColumn("Ho ten");
		model.addColumn("Diem GK");
		model.addColumn("Diem CK");
		model.addColumn("Diem Khac");
		model.addColumn("Diem Tong");

		if (!subjectName.equals("")) {
			for (mPoint pointStudent : cSinhVien.getDiemAllSubjectWithStudent(idStudent)) {
				Vector<String> listPoints = new Vector<String>();
				if (pointStudent.getSubjectCode().equals(subjectName)) {
					listPoints.add(pointStudent.getSubjectCode());
					listPoints.add(pointStudent.getIdStudent());
					listPoints.add(pointStudent.getNameStudent());
					listPoints.add(pointStudent.getMidtermPoint());
					listPoints.add(pointStudent.getEndPoint());
					listPoints.add(pointStudent.getOrtherPoint());
					listPoints.add(pointStudent.getTotalPoint());
					model.addRow(listPoints);
				}
			}
		} else {
			for (mPoint pointStudent : cSinhVien.getDiemAllSubjectWithStudent(idStudent)) {
				Vector<String> listPoints = new Vector<String>();
				listPoints.add(pointStudent.getSubjectCode());
				listPoints.add(pointStudent.getIdStudent());
				listPoints.add(pointStudent.getNameStudent());
				listPoints.add(pointStudent.getMidtermPoint());
				listPoints.add(pointStudent.getEndPoint());
				listPoints.add(pointStudent.getOrtherPoint());
				listPoints.add(pointStudent.getTotalPoint());
				model.addRow(listPoints);
			}
		}
	}
	
	private void loadComboboxSubjectOfStudent (JComboBox<String> comboBoxMon, String userName) {
		//userName is mssv
		try {
			comboBoxMon.removeAllItems();
			for (String cLass : cSinhVien.getListSubjectOfStudent(userName)) {
				comboBoxMon.addItem(cLass);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
