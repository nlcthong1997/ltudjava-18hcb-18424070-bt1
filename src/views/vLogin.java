package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controllers.cGiaoVu;
import controllers.cLogin;
import models.result;

import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class vLogin {

	public JFrame frame;
	private JTextField textTaikhoan;
	private JPasswordField textMatkhau;

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
		
		JLabel lblDangnhap = new JLabel("Dang nhap");
		lblDangnhap.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDangnhap.setBounds(158, 36, 134, 31);
		frame.getContentPane().add(lblDangnhap);
		
		JLabel lblT = new JLabel("Tai khoan");
		lblT.setBounds(65, 79, 66, 15);
		frame.getContentPane().add(lblT);
		
		textTaikhoan = new JTextField();
		textTaikhoan.setBounds(149, 74, 196, 25);
		frame.getContentPane().add(textTaikhoan);
		textTaikhoan.setColumns(10);
		
		JLabel lblMt = new JLabel("Mat khau");
		lblMt.setBounds(65, 116, 66, 15);
		frame.getContentPane().add(lblMt);
		
		textMatkhau = new JPasswordField();
		textMatkhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					result rs = cLogin.dangNhap(textTaikhoan.getText(), textMatkhau.getText());
					// function dangNhap
					if(rs.isStatus()) {
						if (rs.getTypeUser().equals("gv")) {
							frame.dispose();
							vGiaoVu window = new vGiaoVu(rs.getIdUser(), rs.getNameUser(), rs.getTypeUser());
							window.frame.setVisible(true);
						} else {
							//sinh vien
						}
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					}
				}
			}
		});
		textMatkhau.setBounds(149, 111, 196, 25);
		frame.getContentPane().add(textMatkhau);
		
		JButton btnDangnhap = new JButton("Dang nhap");
		btnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result rs = cLogin.dangNhap(textTaikhoan.getText(), textMatkhau.getText());
				// function dangNhap
				if(rs.isStatus()) {
					if (rs.getTypeUser().equals("gv")) {
						frame.dispose();
						vGiaoVu window = new vGiaoVu(rs.getIdUser(), rs.getNameUser(), rs.getTypeUser());
						window.frame.setVisible(true);
					} else {
						//sinh vien
					}
				} else {
					JOptionPane.showMessageDialog(frame, rs.getMessage());
				}
			}
		});
		btnDangnhap.setBounds(231, 148, 114, 25);
		frame.getContentPane().add(btnDangnhap);
	}
}
