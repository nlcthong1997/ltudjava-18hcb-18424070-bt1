package views;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controllers.cDanhSachLopTheoKhoa;
import models.result;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vDanhSachLopTheoKhoa_Them {

	public JFrame frame;
	private JTextField txtMssv;
	private JTextField txtHoTen;
	private JTextField txtCmnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vDanhSachLopTheoKhoa_Them window = new vDanhSachLopTheoKhoa_Them();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public vDanhSachLopTheoKhoa_Them(String id, String userName, String type, String cLass) {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String userName, String type, String cLass) {
		frame = new JFrame("Them sinh vien cho lop - " + cLass);
		frame.setBounds(100, 100, 450, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// handle close window
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JLabel lblThemSinhVien = new JLabel("Them sinh vien");
		lblThemSinhVien.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblMssv = new JLabel("Mssv");
		
		txtMssv = new JTextField();
		txtMssv.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Ho ten");
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		
		JLabel lblCmnd = new JLabel("Cmnd");
		
		txtCmnd = new JTextField();
		txtCmnd.setColumns(10);
		
		JLabel lblGioTinh = new JLabel("Gio tinh");
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nu");
		buttonGroup.add(rdbtnNu);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gioiTinh = "";
				if (rdbtnNam.isSelected()) {
					gioiTinh = "Nam";
				} else if (rdbtnNu.isSelected()) {
					gioiTinh = "Nu";
				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
				String hoTen = txtHoTen.getText();
				String mssv = txtMssv.getText();
				String cmnd = txtCmnd.getText();
				if (hoTen.equals("") || mssv.equals("") || cmnd.equals("")) {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String info[] = { hoTen, mssv, cmnd, gioiTinh, cLass};
					try {
						result rs = cDanhSachLopTheoKhoa.themSinhVienTheoKhoa(info);
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
						txtMssv.setText(null);
						txtHoTen.setText(null);
						txtCmnd.setText(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				try {
					vDanhSachLopTheoKhoa window = new vDanhSachLopTheoKhoa(id, userName, type, cLass);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(lblThemSinhVien))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHoTen)
										.addComponent(lblMssv))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtMssv)
										.addComponent(txtHoTen, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblGioTinh)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnNam)
									.addGap(18)
									.addComponent(rdbtnNu))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnThem)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblCmnd)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtCmnd, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(324, Short.MAX_VALUE)
					.addComponent(btnQuayLai)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThemSinhVien)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMssv)
						.addComponent(txtMssv, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoTen)
						.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCmnd)
						.addComponent(txtCmnd, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGioTinh)
						.addComponent(rdbtnNam)
						.addComponent(rdbtnNu))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnThem)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(btnQuayLai)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
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
	}
}
