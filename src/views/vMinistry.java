package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JButton;

import models.result;
import controllers.cMinistry;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class vMinistry {

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

	public vMinistry(String id, String userName, String type) {
		initialize(id, userName, type);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String userName, String type) {
		frame = new JFrame("Giao vu - " + userName);
		frame.setBounds(100, 100, 428, 376);
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
		
		JLabel lblLop = new JLabel("Lop theo mon");
		JComboBox<String> comboBoxClassSubject = new JComboBox<String>();
		
		//lop theo khoa
		JLabel lblLop_1 = new JLabel("Lop");
		JComboBox<String> comboBoxClassName = new JComboBox<String>();
		
		// handle auto load data
		loadComboboxFollowSubject(comboBoxClassSubject);
		loadComboboxFollowClassName(comboBoxClassName);

		JButton btnXemDsLop = new JButton("Xem DS lop");
		btnXemDsLop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxClassSubject.getSelectedItem() != null) {
					String cbbSelected = (String) comboBoxClassSubject.getSelectedItem();
					try {
						frame.dispose();
						vListClass_Subject window = new vListClass_Subject(id, userName, type, cbbSelected);
						window.frame.setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu de hien thi", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnXemDsLopTheoKhoa = new JButton("Xem DS lop");
		btnXemDsLopTheoKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxClassName.getSelectedItem() != null) {
					String cbbLopSelected = (String) comboBoxClassName.getSelectedItem();
					try {
						frame.dispose();
						vListClass_ClassName window = new vListClass_ClassName(id, userName, type, cbbLopSelected);
						window.frame.setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu de hien thi", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton btnThoikhoaabieu = new JButton("Xem Tkb");
		btnThoikhoaabieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxClassName.getSelectedItem() != null) {
					String cbbLopSelected = (String) comboBoxClassName.getSelectedItem();
					try {
						frame.dispose();
						vSchedule_ClassName window = new vSchedule_ClassName(id, userName, type, cbbLopSelected);
						window.frame.setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu de hien thi", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton btnBangDiem = new JButton("Xem bang diem");
		btnBangDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxClassSubject.getSelectedItem() != null) {
					String cbbSelected = (String) comboBoxClassSubject.getSelectedItem();
					try {
						frame.dispose();
						vListPoint window = new vListPoint(id, userName, type, cbbSelected);
						window.frame.setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Khong co du lieu de hien thi", "Thong bao",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JLabel lblCanhan = new JLabel("Ca nhan");

		JButton btnDoimatkhau = new JButton("Doi mat khau");
		btnDoimatkhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vChangePassword window = new vChangePassword(id, userName, type);
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
					result rs = cMinistry.importCsv("bangdiem");
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
					result rs = cMinistry.importCsv("dslop");
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
					// handle auto load data
					loadComboboxFollowSubject(comboBoxClassSubject);
					loadComboboxFollowClassName(comboBoxClassName);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnImpTkb = new JButton("Imp Tkb");
		btnImpTkb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result rs = cMinistry.importCsv("tkb");
					if (rs.isStatus()) {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame, rs.getMessage(), "Thong bao",
								JOptionPane.INFORMATION_MESSAGE);
					}
					// handle auto load data
					loadComboboxFollowSubject(comboBoxClassSubject);
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
									.addComponent(comboBoxClassSubject, 0, 256, Short.MAX_VALUE)
									.addComponent(comboBoxClassName, 0, 256, Short.MAX_VALUE)
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
						.addComponent(comboBoxClassSubject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXemDsLop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBangDiem)
					.addGap(17)
					.addComponent(lblLop_1)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxClassName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

	private void loadComboboxFollowSubject(JComboBox<String> comboBoxClassSubject) {
		// handles set value for combobox
		try {
			comboBoxClassSubject.removeAllItems();
			for (String cLass : cMinistry.getListClassFollowSubjects()) {
				comboBoxClassSubject.addItem(cLass);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadComboboxFollowClassName(JComboBox<String> comboBoxClassName) {
		// handles set value for combobox
		try {
			comboBoxClassName.removeAllItems();
			for (String cLass : cMinistry.getListClassName()) {
				comboBoxClassName.addItem(cLass);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
