package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cDanhSachLop;
import models.mStudent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class vDanhSachLop {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vDanhSachLop window = new vDanhSachLop();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 * 
	 * @wbp.parser.entryPoint
	 */
//	public vDanhSachLop() {
//		initialize();
//	}
	public vDanhSachLop(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
//	private void initialize() {
		frame = new JFrame("Danh sach lop - " + cLass);
		frame.setBounds(100, 100, 654, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// handles table list student
		ArrayList<mStudent> listStudentClass;
		listStudentClass = cDanhSachLop.getListStudentWithClass(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Gioi Tinh", "CMND" };
		String[][] data = new String[listStudentClass.size()][5];
		int i = 0;
		for (mStudent student : listStudentClass) {
			data[i][0] = student.getStt();
			data[i][1] = student.getMssv();
			data[i][2] = student.getHoTen();
			data[i][3] = student.getGioiTinh();
			data[i][4] = student.getCmnd();
			i++;
		}

		table = new JTable(data, titles);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vDanhSachLop_Them window = new vDanhSachLop_Them(id, userName, type, cLass);
				window.frame.setVisible(true);
			}
		});

		JButton btnXoa = new JButton("Xoa");

		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row >= 0) {

				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua chon dong de sua.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
//				String value = table.getModel().getValueAt(row, column).toString();
				System.out.println(row);
			}
		});

		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vGiaoVu window = new vGiaoVu(id, userName, type);
				window.frame.setVisible(true);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE).addGap(21)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnQuayLai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 348,
														Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnThem)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnXoa)
												.addGap(12).addComponent(btnSua)
												.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
												.addComponent(btnQuayLai).addGap(15)))));
		frame.getContentPane().setLayout(groupLayout);
	}
}
