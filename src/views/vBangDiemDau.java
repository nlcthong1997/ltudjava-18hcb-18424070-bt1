package views;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class vBangDiemDau {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					vBangDiemDau window = new vBangDiemDau();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public vBangDiemDau(String id, String userName, String type, String cLass) {
		initialize(id, userName, type, cLass);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String id, String userName, String type, String cLass) {
		frame = new JFrame("Danh sach dau - " + cLass);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
