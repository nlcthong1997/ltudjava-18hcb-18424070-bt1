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

import controllers.cDanhSachLop;
import controllers.cDiem;
import models.mDiem;
import models.mStudent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class vBangDiem {

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
	public vBangDiem(String id, String userName, String type, String cLass) throws IOException {
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
		
		JButton btnDsDau = new JButton("DS dau");
		btnDsDau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vBangDiemDau window = new vBangDiemDau(id, userName, type, cLass);
				window.frame.setVisible(true);
			}
		});
		
		JButton btnDsRot = new JButton("DS rot");
		
		JLabel lblTileDau = new JLabel("New label");
		lblTileDau.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblTileRot = new JLabel("New label");
		
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
		ArrayList<mDiem> listDiemClass = cDiem.getListDiemWithSubjects(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem Tong" };
		String[][] data = new String[listDiemClass.size()][7];
		int i = 0;
		for (mDiem diem : listDiemClass) {
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
