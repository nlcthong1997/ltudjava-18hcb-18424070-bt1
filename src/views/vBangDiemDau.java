package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.cDiem;
import models.mDiem;

public class vBangDiemDau {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vBangDiemDau window = new vBangDiemDau();
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
	public vBangDiemDau(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
		frame = new JFrame("Danh sach dau - " + cLass);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addGap(13))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(10))
		);
		
		ArrayList<mDiem> listDiemDau = cDiem.getListDiemDau(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem Tong" };
		String[][] data = new String[listDiemDau.size()][7];
		int i = 0;
		for (mDiem diem : listDiemDau) {
			data[i][0] = diem.getStt();
			data[i][1] = diem.getMssv();
			data[i][2] = diem.getHoTen();
			data[i][3] = diem.getDiemGk();
			data[i][4] = diem.getDiemCk();
			data[i][5] = diem.getDiemKhac();
			data[i][6] = diem.getDiemTong();
			i++;
		}
		table = new JTable(data, titles);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
