package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cDanhSachLop;
import models.mStudent;
import models.result;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
		frame.setBounds(100, 100, 660, 406);
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

		// handles table list student
		ArrayList<mStudent> listStudentClassSubject = cDanhSachLop.getListStudentFollowSubject(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Gioi Tinh", "CMND" };
		String[][] data = new String[listStudentClassSubject.size()][5];
		int i = 0;
		for (mStudent student : listStudentClassSubject) {
			data[i][0] = student.getId();
			data[i][1] = student.getIdStudent();
			data[i][2] = student.getNameStudent();
			data[i][3] = student.getSex();
			data[i][4] = student.getIdentityCard();
			i++;
		}
		table = new JTable(data, titles);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vDanhSachLop_Them window = new vDanhSachLop_Them(id, userName, type, cLass);
				window.frame.setVisible(true);
			}
		});

		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					String mssv = table.getModel().getValueAt(row, 1).toString();
					String hoTen = table.getModel().getValueAt(row, 2).toString();
					String gioiTinh = table.getModel().getValueAt(row, 3).toString();
					String cmnd = table.getModel().getValueAt(row, 4).toString();
					String info[] = { mssv, hoTen, gioiTinh, cmnd, cLass };
					try {
						result rs = cDanhSachLop.deleteStudentOfClassSubject(info);
						if (rs.isStatus()) {
							JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua chon dong de xoa.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
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
												.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
												.addComponent(btnQuayLai).addGap(15)))));
		frame.getContentPane().setLayout(groupLayout);
	}
}
