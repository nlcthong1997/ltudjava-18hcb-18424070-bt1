package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cListClass_Subject;
import controllers.cListClass_ClassName;
import models.mStudent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class vListClass_ClassName {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vDanhSachLopTheoKhoa window = new vDanhSachLopTheoKhoa();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @wbp.parser.entryPoint
	 */
	public vListClass_ClassName(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
		frame = new JFrame("Danh sach lop - " + cLass);
		frame.setBounds(100, 100, 660, 406);
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnQuayLai = new JButton("Quay lai");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vMinistry window = new vMinistry(id, userName, type);
				window.frame.setVisible(true);
			}
		});
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				vListClass_ClassName_Add window = new vListClass_ClassName_Add(id, userName, type, cLass);
				window.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnQuayLai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnThem)
							.addPreferredGap(ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
							.addComponent(btnQuayLai))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		// handles table list student
		ArrayList<mStudent> listStudentClassName = cListClass_ClassName.getListStudentFollowClassName(cLass);
		String[] titles = new String[] { "STT", "MSSV", "Ho ten", "Gioi Tinh", "CMND" };
		String[][] data = new String[listStudentClassName.size()][5];
		int i = 0;
		for (mStudent student : listStudentClassName) {
			data[i][0] = student.getId();
			data[i][1] = student.getIdStudent();
			data[i][2] = student.getNameStudent();
			data[i][3] = student.getSex();
			data[i][4] = student.getIdentityCard();
			i++;
		}
		table = new JTable(data, titles);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
