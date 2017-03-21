package kr.or.dgit.post;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.post.dto.Post;
import kr.or.dgit.post.service.PostService;

@SuppressWarnings("serial")
public class PostFind extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
	private JTable table;
	private JTextField tFdoro;
	private JButton btnFin;
	private List<Post> lists;
	private JComboBox comboBox;
	private int size;
	
	public PostFind() {
		setTitle("우편번호 검색");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblSido = new JLabel("시도");
		panel.add(lblSido);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"강원도", "경기도", "경상남도", "경상북도", "광주광역시", "대구광역시", "대전광역시", "부산광역시", "서울특별시", "세종특별자치시", "울산광역시", "인천광역시", "전라남도", "전라북도", "제주특별자치도", "충청남도", "충청북도"}));
		panel.add(comboBox);
		
		JLabel lblDoro = new JLabel("도로명");
		panel.add(lblDoro);
		
		tFdoro = new JTextField();
		panel.add(tFdoro);
		tFdoro.setColumns(10);
		
		btnFin = new JButton("검색");
		btnFin.addActionListener(this);
		panel.add(btnFin);
		
		table = new JTable();
		table.addMouseListener(this);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(table);
			
	}
	
	public void loadTable(){
		table.setModel(new DefaultTableModel(getObject(),getColumn()));
	}

	public void setListSize(int size){
		this.size = size;
	}
	
	public void setLists(List<Post> lists){
		this.lists = lists;
	}
	
	public Object[][] getObject(){
		Object[][] datas = new Object[size][];
		for(int i=0 ; i<size ; i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}
	
	public Object[] getColumn(){
		return new String[] {"우편번호","주소"};
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFin) {
			actionPerformedBtnFin(e);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	
	protected void actionPerformedBtnFin(ActionEvent e) {
		PostService postService = new PostService();
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("sido", comboBox.getSelectedItem());
		post.put("doro", tFdoro.getText());
		
		List<Post> Lists = postService.findPostByObj(post);
		setListSize(Lists.size());
		setLists(Lists);
		loadTable();
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	protected void mouseClickedTable(MouseEvent e) {
		Object[] mainObj = new Object[]{table.getValueAt(table.getSelectedRow(), 0), 
				table.getValueAt(table.getSelectedRow(), 1)};
		PostMain.getText(mainObj);
	
	}
}
