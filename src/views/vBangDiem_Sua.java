package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.cDiem;
import models.result;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vBangDiem_Sua {

	public JFrame frame;
	private JTextField txtDiemGK;
	private JTextField txtDiemCK;
	private JTextField txtDiemKhac;
	private JTextField txtDiemTong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vBangDiem_Sua window = new vBangDiem_Sua();
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
	 * @wbp.parser.entryPoint
	 */
	public vBangDiem_Sua(String id, String userName, String type, String[] info) {
		initialize(id, userName, type, info);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	// Type info ['stt', 'mssv', 'hoten', 'diemGK', 'diemCK', 'diemKhac', 'diemTong', 'cLass']
	private void initialize(String id, String userName, String type, String[] info) {
		frame = new JFrame("Diem cua " + info[2]);
		frame.setBounds(100, 100, 440, 354);
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
		

		JLabel lblChinhSuaDiem = new JLabel("Chinh sua diem");
		lblChinhSuaDiem.setFont(new Font("Dialog", Font.BOLD, 20));

		JLabel lblDiemGk = new JLabel("Diem GK");

		txtDiemGK = new JTextField();
		txtDiemGK.setColumns(10);

		JLabel lblDiemCk = new JLabel("Diem CK");

		txtDiemCK = new JTextField();
		txtDiemCK.setColumns(10);

		JLabel lblDiemKhac = new JLabel("Diem Khac");

		txtDiemKhac = new JTextField();
		txtDiemKhac.setColumns(10);

		JLabel lblDiemTong = new JLabel("Diem tong");

		txtDiemTong = new JTextField();
		txtDiemTong.setColumns(10);
		
		txtDiemGK.setText(info[3]);
		txtDiemCK.setText(info[4]);
		txtDiemKhac.setText(info[5]);
		txtDiemTong.setText(info[6]);

		JButton btnChinhSua = new JButton("Chinh sua");
		btnChinhSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String diemGK = txtDiemGK.getText();
				String diemCK = txtDiemCK.getText();
				String diemKhac = txtDiemKhac.getText();
				String diemTong = txtDiemTong.getText();
				String infoEdited[] = { info[7], info[1], diemGK, diemCK, diemKhac, diemTong };
				if (!diemGK.equals("") && !diemCK.equals("") && !diemKhac.equals("") && !diemTong.equals("")) {
					try {
						result rs = cDiem.editPointStudent(infoEdited);
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Diem khong duoc de trong", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				try {
					vBangDiem window = new vBangDiem(id, userName, type, info[7]);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(133).addComponent(lblChinhSuaDiem))
						.addGroup(groupLayout.createSequentialGroup().addGap(76)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDiemGk).addComponent(lblDiemCk))
												.addGap(32)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(txtDiemGK).addComponent(txtDiemCK,
																GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDiemKhac).addComponent(lblDiemTong))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtDiemTong, GroupLayout.PREFERRED_SIZE, 179,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtDiemKhac, GroupLayout.PREFERRED_SIZE, 179,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnChinhSua, Alignment.TRAILING))))))
				.addContainerGap(101, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(339, Short.MAX_VALUE)
						.addComponent(btnQuayLai).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblChinhSuaDiem).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDiemGk)
								.addComponent(txtDiemGK, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDiemCk)
								.addComponent(txtDiemCK, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDiemKhac)
								.addComponent(txtDiemKhac, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDiemTong)
								.addComponent(txtDiemTong, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnChinhSua)
						.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE).addComponent(btnQuayLai)
						.addContainerGap()));
		frame.getContentPane().setLayout(groupLayout);

	}
}
