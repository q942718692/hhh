package MySQL;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.MyConnection;

public  class delete extends JFrame implements ActionListener , ItemListener {
	private JFrame app;
	private JTextField ��Ŀ����,��Ŀ������,����Ԥ��,Ԥ��֧��;
	private JButton ɾ��,��������,����,ȷ��,��ѯ;
	private JDialog ��ʾ;
	private int massage = 0;
	
	public delete() {
		app=new JFrame("��Ŀ�޸�");
		app.setSize(500,500);
		app.setLocation(800, 350);
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);
		Container a = app.getContentPane();
		a.setLayout(new GridLayout(1, 2));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(6, 1, 0, 10));
		p2.setLayout(new GridLayout(6, 1, 0, 10));
		a.add(p1);
		a.add(p2);
		p1.add(new JLabel("Ҫɾ������Ŀ����"));
		��Ŀ���� = new JTextField(10);
		p2.add(��Ŀ����);
		��������= new JButton("��������");
		p1.add(��������);
		��������.addActionListener(this);
		ɾ��=new JButton("ɾ��");
		p2.add(ɾ��);
		ɾ��.addActionListener(this);
		��ѯ=new JButton("��ѯҪɾ������Ŀ����");
		p1.add(��ѯ);
		��ѯ.addActionListener(this);
		����=new JButton("����");
		p2.add(����);
		����.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ɾ��) {
			Connection con=null;
			PreparedStatement pstmt=null;
			try {
				con=MyConnection.getConnection();
				String sql="" + "DELETE FROM project  "+  "WHERE pn = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ��Ŀ����.getText());
				int n=pstmt.executeUpdate();
				if(n==1){
					JOptionPane.showMessageDialog(null,"�޸ĳɹ���");
				}
				else{
					JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				if(pstmt!=null) {
					pstmt.close();
					}
				if(con!=null) {
					con.close();
					}
			}catch (Exception f) {
			System.out.println("SQLException:" + f.getMessage());
			}
		}
		
		if(e.getSource()==��ѯ) {
			Connection con;
			Statement stmt;
			ResultSet rs;
			String sqlstr;
			try {
				con=MyConnection.getConnection();
				stmt = con.createStatement();
				sqlstr="SELECT pn,pl,money,zhichu FROM project";
				rs=stmt.executeQuery(sqlstr);
				while(rs.next()) {
					String st1 = rs.getString(1);
					if(��Ŀ����.getText().equals(st1)) {
						JOptionPane.showMessageDialog(null, "�и���Ŀ��");
						massage=1;
						rs.close();
						stmt.close();
						con.close();
						break;
					}
					massage=0;
				}
				if(massage==0){
					JOptionPane.showMessageDialog(this, "û�и���Ŀ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				
			}catch (SQLException f) {
				System.out.println("SQLException:" + f.getMessage());
				}
		}
		if(e.getSource()==��������) {
			��Ŀ����.setText("");
		}
		if(e.getSource()==����) {
			new xmjfglxt();
			app.setVisible(false);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}


}
