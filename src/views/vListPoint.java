package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cListClass_Subject;
import controllers.cPoint;
import models.mPoint;
import models.mStudent;
import models.result;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class vListPoint {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vBangDiem window = new vBangDiem();
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
	public vListPoint(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
		frame = new JFrame("Bang diem lop - " + cLass);
		frame.setBounds(100, 100, 682, 404);
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
		
		JButton btnSua = new JButton("Sua diem");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					String stt = table.getModel().getValueAt(row, 0).toString();
					String mssv = table.getModel().getValueAt(row, 1).toString();
					String hoTen = table.getModel().getValueAt(row, 2).toString();
					String diemGK = table.getModel().getValueAt(row, 3).toString();
					String diemCK = table.getModel().getValueAt(row, 4).toString();
					String diemKhac = table.getModel().getValueAt(row, 5).toString();
					String diemTong = table.getModel().getValueAt(row, 6).toString();
					String info[] = { stt, mssv, hoTen, diemGK, diemCK, diemKhac, diemTong, cLass };
					frame.dispose();
					vListPoint_Edit window = new vListPoint_Edit(id, userName, type, info);
					window.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua chon dong de xoa.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		JButton btnDsDau = new JButton("DS dau");
		btnDsDau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					vListPoint_Pass window = new vListPoint_Pass(id, userName, type, cLass);
					window.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnDsRot = new JButton("DS rot");
		btnDsRot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vListPoint_Fall window = new vListPoint_Fall(id, userName, type, cLass);
					window.frame.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		String diemPerCent[] = cPoint.getPointPercent(cLass);
		JLabel lblTileDau = new JLabel("Ti le dau: " + diemPerCent[0] + "%");
		lblTileDau.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblTileRot = new JLabel("Ti le rot: " + diemPerCent[1] + "%");
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vMinistry window = new vMinistry(id, userName, type);
				window.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnDsDau, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnQuayLai, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTileDau)
								.addComponent(btnDsRot, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTileRot))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSua)
							.addGap(12)
							.addComponent(btnDsDau)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDsRot)
							.addGap(44)
							.addComponent(lblTileDau)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTileRot)
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
							.addComponent(btnQuayLai))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		// handles table
		ArrayList<mPoint> listPointClass = cPoint.getListPointWithSubjects(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem Tong" };
		String[][] data = new String[listPointClass.size()][7];
		int i = 0;
		for (mPoint point : listPointClass) {
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
