package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.cListClass_ClassName;
import controllers.cSchedule_ClassName;
import models.mSchedule;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class vSchedule_ClassName {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vTkbTheoKhoa window = new vTkbTheoKhoa();
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
	public vSchedule_ClassName(String id, String userName, String type, String cLass) throws IOException {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(String id, String userName, String type, String cLass) throws IOException {
		frame = new JFrame("Thoi khoa bieu lop - " + cLass);
		frame.setBounds(100, 100, 605, 379);
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnQuayLai)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addComponent(btnQuayLai))
					.addGap(15))
		);
		
		// handles table list student
		ArrayList<mSchedule> listSchedules = cSchedule_ClassName.getListScheduleFollowClassName(cLass);
		String[] titles = new String[] { "STT", "Ma mon", "Ten mon", "Phong hoc" };
		String[][] data = new String[listSchedules.size()][4];
		int i = 0;
		for (mSchedule schedule : listSchedules) {
			data[i][0] = schedule.getId();
			data[i][1] = schedule.getSubjectCode();
			data[i][2] = schedule.getSubjectName();
			data[i][3] = schedule.getClassRoom();
			i++;
		}
		table = new JTable(data, titles);
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}

}
