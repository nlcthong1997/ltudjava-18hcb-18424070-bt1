package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import controllers.cUser;
import models.result;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class vDoiMatKhau {

	public JFrame frame;
	private JPasswordField txtMatKhauMoi;
	private JPasswordField txtXacNhanMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vDoiMatKhau window = new vDoiMatKhau();
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
//	public vDoiMatKhau() {
//		initialize();
//	}
	public vDoiMatKhau(String id, String userName, String type) {
		initialize(id, userName, type);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String userName, String type) {
		frame = new JFrame("Doi mat khau");
		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JLabel lblMatKhauMoi = new JLabel("Mat khau moi");

		txtMatKhauMoi = new JPasswordField();

		JLabel lblXacNhanMat = new JLabel("Xac nhan mat khau");

		txtXacNhanMatKhau = new JPasswordField();

		JButton btnDoiMatKhau = new JButton("Doi mat khau");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String matKhauMoi = txtMatKhauMoi.getText();
				String xacNhanMatKhau = txtXacNhanMatKhau.getText();
				if (matKhauMoi.equals(xacNhanMatKhau)) {
					try {
						result rs = cUser.doiMatKhau(id, userName, type, xacNhanMatKhau);
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
						txtMatKhauMoi.setText(null);
						txtXacNhanMatKhau.setText(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Mat khau xac nhan khong dung", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JLabel lblDoiMatKhau = new JLabel("Doi mat khau");
		lblDoiMatKhau.setFont(new Font("Dialog", Font.BOLD, 20));

		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vGiaoVu window = new vGiaoVu(id, userName, type);
				window.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblMatKhauMoi)
								.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE).addComponent(
										txtMatKhauMoi, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblXacNhanMat)
								.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE).addComponent(
										txtXacNhanMatKhau, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnDoiMatKhau))
				.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(144).addComponent(lblDoiMatKhau)
						.addContainerGap(144, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(314, Short.MAX_VALUE)
						.addComponent(btnQuayLai).addContainerGap()));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(lblDoiMatKhau)
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtMatKhauMoi, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMatKhauMoi))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtXacNhanMatKhau, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblXacNhanMat))
										.addGap(27).addComponent(btnDoiMatKhau)
										.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
										.addComponent(btnQuayLai).addContainerGap()));
		frame.getContentPane().setLayout(groupLayout);
	}
}
