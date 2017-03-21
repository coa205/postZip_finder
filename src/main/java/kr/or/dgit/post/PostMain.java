package kr.or.dgit.post;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PostMain extends JFrame implements ActionListener {
	private JPanel contentPane;
	private static JTextField tFpos;
	private static JTextField tFadd;
	private JTextField tFdeAdd;
	private JButton btnPosFin;
	private JButton btnSub;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostMain frame = new PostMain();
					frame.setVisible(true);
					
					/*InitSettingService init = new InitSettingService();
					init.initSetting();*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PostMain() {
		setTitle("우편번호");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 5, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel lblPos = new JLabel("우편 번호");
		lblPos.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblPos);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		tFpos = new JTextField();
		panel_4.add(tFpos);
		tFpos.setColumns(10);
		
		btnPosFin = new JButton("우편번호 검색");
		btnPosFin.addActionListener(this);
		panel_4.add(btnPosFin);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel lblAdd = new JLabel("주소");
		lblAdd.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblAdd);
		
		tFadd = new JTextField();
		panel_1.add(tFadd);
		tFadd.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel lbldeAdd = new JLabel("세부 주소");
		lbldeAdd.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_2.add(lbldeAdd);
		
		tFdeAdd = new JTextField();
		panel_2.add(tFdeAdd);
		tFdeAdd.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		btnSub = new JButton("등록");
		btnSub.addActionListener(this);
		panel_3.add(btnSub);
	}
	
	public static void getText(Object[] obj){
		tFpos.setText(String.valueOf(obj[0]));
		tFadd.setText(String.valueOf(obj[1]));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSub) {
			actionPerformedBtnSub(e);
		}
		if (e.getSource() == btnPosFin) {
			actionPerformedBtnPosFin(e);
		}
	}
	
	protected void actionPerformedBtnPosFin(ActionEvent e) {
		PostFind postfind = new PostFind();
		postfind.setVisible(true);
		
	}
	protected void actionPerformedBtnSub(ActionEvent e) {
		JOptionPane.showMessageDialog(null, tFpos.getText()+" "+tFadd.getText()+","+tFdeAdd.getText());
	}
}
