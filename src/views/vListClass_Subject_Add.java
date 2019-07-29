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

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.cListClass_Subject;
import models.result;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class vListClass_Subject_Add {

	public JFrame frame;
	private JTextField textHoten;
	private JTextField textMssv;
	private JTextField textCmnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vDanhSachLop_Them window = new vDanhSachLop_Them();
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
	public vListClass_Subject_Add(String id, String userName, String type, String cLass) {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String userName, String type, String cLass) {
		frame = new JFrame("Them sinh vien cho lop - " + cLass);
		frame.setBounds(100, 100, 446, 386);
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

		JLabel lblThemSinhVien = new JLabel("Them sinh vien");
		lblThemSinhVien.setFont(new Font("Dialog", Font.BOLD, 20));

		JLabel lblMssv = new JLabel("Mssv");

		JLabel lblHoTen = new JLabel("Ho ten");

		JLabel lblGioiTinh = new JLabel("Gioi tinh");

		JLabel lblCmnd = new JLabel("Cmnd");

		textHoten = new JTextField();
		textHoten.setColumns(10);

		textMssv = new JTextField();
		textMssv.setColumns(10);

		textCmnd = new JTextField();
		textCmnd.setColumns(10);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nu");
		buttonGroup.add(rdbtnNu);

		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// format : ["mssv", "ho ten", "gioi tinh", "cmmd", "nienkhoa_maMon"]
				String gioiTinh = "";
				if (rdbtnNam.isSelected()) {
					gioiTinh = "Nam";
				} else if (rdbtnNu.isSelected()) {
					gioiTinh = "Nu";
				} else {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
				String mssv = textMssv.getText();
				String hoTen = textHoten.getText();
				String cmnd = textCmnd.getText();
				
				if (mssv.equals("") || hoTen.equals("") || cmnd.equals("")) {
					JOptionPane.showMessageDialog(frame, "Ban chua nhap du thong tin.", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String[] info = new String[] { mssv, hoTen, gioiTinh, cmnd, cLass };
					try {
						result rs = cListClass_Subject.insertStudentOfClassSubject(info);
						if (rs.isStatus()) {
							JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
									JOptionPane.INFORMATION_MESSAGE);
							textMssv.setText(null);
							textHoten.setText(null);
							textCmnd.setText(null);
						}
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
					vListClass_Subject window = new vListClass_Subject(id, userName, type, cLass);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(lblThemSinhVien)
					.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(345, Short.MAX_VALUE)
					.addComponent(btnQuayLai)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGioiTinh)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNam)
							.addGap(18)
							.addComponent(rdbtnNu)
							.addGap(120))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnThem)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHoTen)
										.addComponent(lblMssv)
										.addComponent(lblCmnd))
									.addGap(25)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textHoten, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
										.addComponent(textMssv, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
										.addComponent(textCmnd, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))))
							.addGap(77))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblThemSinhVien)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMssv)
						.addComponent(textMssv, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoTen)
						.addComponent(textHoten, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCmnd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCmnd))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGioiTinh)
						.addComponent(rdbtnNam)
						.addComponent(rdbtnNu))
					.addGap(18)
					.addComponent(btnThem)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnQuayLai)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
