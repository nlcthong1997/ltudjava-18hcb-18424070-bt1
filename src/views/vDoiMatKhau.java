package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cUser;
import models.result;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Mat khau xac nhan khong dung");
				}
			}
		});

		JLabel lblDoiMatKhau = new JLabel("Doi mat khau");
		lblDoiMatKhau.setFont(new Font("Dialog", Font.BOLD, 20));
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
						.addContainerGap(144, Short.MAX_VALUE)));
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
										.addGap(27).addComponent(btnDoiMatKhau).addContainerGap(79, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
