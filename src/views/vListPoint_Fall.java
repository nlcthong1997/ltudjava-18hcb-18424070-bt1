package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controllers.cPoint;
import models.mPoint;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class vListPoint_Fall {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vBangDiemRot window = new vBangDiemRot();
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
	 */
	public vListPoint_Fall(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
		frame = new JFrame("Danh sach rot - " + cLass);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addGap(6))
		);
		
		ArrayList<mPoint> listFallPoint = cPoint.getListFallPoint(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem Tong" };
		String[][] data = new String[listFallPoint.size()][7];
		int i = 0;
		for (mPoint point : listFallPoint) {
			data[i][0] = point.getId();
			data[i][1] = point.getIdStudent();
			data[i][2] = point.getNameStudent();
			data[i][3] = point.getMidtermPoint();
			data[i][4] = point.getEndPoint();
			data[i][5] = point.getOrtherPoint();
			data[i][6] = point.getTotalPoint();
			i++;
		}
		table = new JTable(data, titles);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
