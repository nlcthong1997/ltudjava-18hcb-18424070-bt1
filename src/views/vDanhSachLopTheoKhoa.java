package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cDanhSachLop;
import controllers.cDanhSachLopTheoKhoa;
import models.mStudent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class vDanhSachLopTheoKhoa {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vDanhSachLopTheoKhoa window = new vDanhSachLopTheoKhoa();
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
	 * @wbp.parser.entryPoint
	 */
	public vDanhSachLopTheoKhoa(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vGiaoVu window = new vGiaoVu(id, userName, type);
				window.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnQuayLai)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnQuayLai, Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		// handles table list student
		ArrayList<mStudent> listStudentClass = cDanhSachLopTheoKhoa.getListStudentWithClass(cLass);
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
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}

}
