package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import models.result;
import controllers.cGiaoVu;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;

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
		frame.setBounds(100, 100, 428, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblLop = new JLabel("Lop theo mon");
		JComboBox<String> comboBox = new JComboBox<String>();
		
		JLabel lblLop_1 = new JLabel("Lop");
		JComboBox<String> comboBoxLop = new JComboBox<String>();
		
		// handle auto load data
		loadCombobox(comboBox);
		loadComboboxLop(comboBoxLop);

		JButton btnXemDsLop = new JButton("Xem DS lop");
		btnXemDsLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cbbSelected = (String) comboBox.getSelectedItem();
				frame.dispose();
				try {
					vDanhSachLop window = new vDanhSachLop(id, userName, type, cbbSelected);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				;
			}
		});
		
		JButton btnXemDsLopTheoKhoa = new JButton("Xem DS lop");
		btnXemDsLopTheoKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cbbLopSelected = (String) comboBoxLop.getSelectedItem();
				frame.dispose();
				try {
					vDanhSachLopTheoKhoa window = new vDanhSachLopTheoKhoa(id, userName, type, cbbLopSelected);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});

		JButton btnThoikhoaabieu = new JButton("Xem Tkb");
		btnThoikhoaabieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cbbLopSelected = (String) comboBoxLop.getSelectedItem();
				frame.dispose();
				try {
					vTkbTheoKhoa window = new vTkbTheoKhoa(id, userName, type, cbbLopSelected);
					window.frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});

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
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
					// handle auto load data
					loadCombobox(comboBox);
					loadComboboxLop(comboBoxLop);
					
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
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
					// handle auto load data
					loadCombobox(comboBox);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDoiMatKhau, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblLop, Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(comboBox, 0, 256, Short.MAX_VALUE)
									.addComponent(comboBoxLop, 0, 256, Short.MAX_VALUE)
									.addComponent(lblLop_1)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnDangxuat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDoimatkhau, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
									.addComponent(lblCanhan))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblImport)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnImpTkb, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnImpBangDiem, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnXemDsLopTheoKhoa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnBangDiem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnXemDsLop, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
										.addComponent(btnThoikhoaabieu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addGap(13))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLop)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXemDsLop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBangDiem)
					.addGap(17)
					.addComponent(lblLop_1)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxLop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXemDsLopTheoKhoa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThoikhoaabieu)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImport)
						.addComponent(lblCanhan))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDoiMatKhau)
						.addComponent(btnDoimatkhau))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnImpBangDiem)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(btnDangxuat)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnImpTkb)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	private void loadCombobox(JComboBox<String> comboBox) {
		// handles set value for combobox
		try {
			comboBox.removeAllItems();
			for (String cLass : cGiaoVu.getListClassWithSubjects()) {
				comboBox.addItem(cLass);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadComboboxLop(JComboBox<String> comboBoxLop) {
		// handles set value for combobox
		try {
			comboBoxLop.removeAllItems();
			for (String cLass : cGiaoVu.getListClass()) {
				comboBoxLop.addItem(cLass);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
