package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;

import models.result;
import controllers.cGiaoVu;
import controllers.cUser;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class vGiaoVu {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vGiaoVu window = new vGiaoVu();
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
//	public vGiaoVu() {
//		initialize();
//	}

	public vGiaoVu(String id, String userName, String type) {
		initialize(id, userName, type);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String userName, String type) {
		frame = new JFrame("Giao vu - " + userName);
		frame.setBounds(100, 100, 438, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblLop = new JLabel("Lop");

		JComboBox<String> comboBox = new JComboBox<String>();
		//handles set value for combobox
		try {
			for(String lop: cGiaoVu.getListClass()) {
				comboBox.addItem(lop);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JButton btnXemDsLop = new JButton("Xem DS lop");
		btnXemDsLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cbbSelected = (String) comboBox.getSelectedItem();
				frame.dispose();
				vDanhSachLop window;
				try {
					window = new vDanhSachLop(id, userName, type, cbbSelected);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				};
			}
		});

		JButton btnThoikhoaabieu = new JButton("Xem Tkb");

		JButton btnBangDiem = new JButton("Xem bang diem");

		JLabel lblCanhan = new JLabel("Ca nhan");

		JButton btnDoimatkhau = new JButton("Doi mat khau");
		btnDoimatkhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vDoiMatKhau window = new vDoiMatKhau(id, userName, type);
				window.frame.setVisible(true);
			}
		});

		JButton btnDangxuat = new JButton("Dang xuat");
		btnDangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vLogin window = new vLogin();
				window.frame.setVisible(true);
			}
		});

		JButton btnImpBangDiem = new JButton("Imp bang diem");
		btnImpBangDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result rs = cGiaoVu.importCsv("bangdiem");
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		JLabel lblImport = new JLabel("Import");

		JButton btnDoiMatKhau = new JButton("Imp Ds lop");
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result rs = cGiaoVu.importCsv("dslop");
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnImpTkb = new JButton("Imp Tkb");
		btnImpTkb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result rs = cGiaoVu.importCsv("tkb");
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblLop)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblCanhan, Alignment.LEADING)
												.addComponent(comboBox, Alignment.LEADING, 0, 237, Short.MAX_VALUE))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnDangxuat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnDoimatkhau, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnImpTkb, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblImport)
												.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
										.addComponent(btnThoikhoaabieu, 0, 147, Short.MAX_VALUE)
										.addComponent(btnBangDiem, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addComponent(btnXemDsLop, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addComponent(btnDoiMatKhau, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
										.addComponent(btnImpBangDiem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147,
												Short.MAX_VALUE))))
				.addGap(24)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblLop)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXemDsLop))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnThoikhoaabieu)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBangDiem).addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCanhan)
								.addComponent(lblImport))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnDoimatkhau)
								.addComponent(btnDoiMatKhau))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnDangxuat)
								.addComponent(btnImpTkb))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnImpBangDiem)
						.addContainerGap(31, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
