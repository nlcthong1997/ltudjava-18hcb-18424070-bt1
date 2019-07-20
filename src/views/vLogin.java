package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class vLogin {

	private JFrame frame;
	private JTextField textTaikhoan;
	private JTextField textMatkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vLogin window = new vLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDangnhap = new JLabel("Đăng nhập");
		lblDangnhap.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDangnhap.setBounds(158, 36, 134, 31);
		frame.getContentPane().add(lblDangnhap);
		
		JLabel lblT = new JLabel("Tài khoản");
		lblT.setBounds(65, 79, 66, 15);
		frame.getContentPane().add(lblT);
		
		textTaikhoan = new JTextField();
		textTaikhoan.setBounds(149, 74, 196, 25);
		frame.getContentPane().add(textTaikhoan);
		textTaikhoan.setColumns(10);
		
		JLabel lblMt = new JLabel("Mật khẩu");
		lblMt.setBounds(65, 116, 66, 15);
		frame.getContentPane().add(lblMt);
		
		textMatkhau = new JTextField();
		textMatkhau.setBounds(149, 111, 196, 25);
		frame.getContentPane().add(textMatkhau);
		textMatkhau.setColumns(10);
		
		JButton btnDangnhap = new JButton("Đăng nhập");
		btnDangnhap.setBounds(231, 148, 114, 25);
		frame.getContentPane().add(btnDangnhap);
	}
}
