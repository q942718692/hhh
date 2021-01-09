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

public  class find extends JFrame implements ActionListener , ItemListener {
	private JFrame app;
	private JTextField ��Ŀ����,��Ŀ������,����Ԥ��,Ԥ��֧��;
	private JButton ����,��������,����,ȷ��,ok;
	private JDialog ��ʾ;
	private int massage = 0;
	
	public find() {
		app=new JFrame("��Ŀ����");
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
		p1.add(new JLabel("��Ŀ����"));
		��Ŀ���� = new JTextField(10);
		p2.add(��Ŀ����);
		p1.add(new JLabel("��Ŀ������"));
		��Ŀ������ = new JTextField(10);
		p2.add(��Ŀ������);
		p1.add(new JLabel("����Ԥ��"));
		����Ԥ�� = new JTextField(10);
		p2.add(����Ԥ��);
		p1.add(new JLabel("Ԥ��֧��"));
		Ԥ��֧�� = new JTextField(10);
		p2.add(Ԥ��֧��);
		��������= new JButton("��������");
		p1.add(��������);
		��������.addActionListener(this);
		����=new JButton("����");
		p2.add(����);
		����.addActionListener(this);
		����=new JButton("����");
		p2.add(����);
		����.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==����) {
			Connection con;
			Statement stmt;
			ResultSet rs;
			String sqlstr;
			try {
				con=MyConnection.getConnection();	
				stmt = con.createStatement();
				sqlstr="SELECT pn,pl,money,zhichu FROM project";
				rs=stmt.executeQuery(sqlstr);
				while(rs.next()){
					String st1 = rs.getString(1);
					String st2 = rs.getString(2);
					String st3 = rs.getString(3);
					String st4 = rs.getString(4);
					if(��Ŀ����.getText().equals(st1)) {
						massage=1;
						��Ŀ������.setText(st2);
						����Ԥ��.setText(st3);
						Ԥ��֧��.setText(st4);
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
			��Ŀ������.setText("");
			����Ԥ��.setText("");
			Ԥ��֧��.setText("");
		}
		if(e.getSource()==����) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==ok) {
			��Ŀ����.setText("");
			��Ŀ������.setText("");
			����Ԥ��.setText("");
			Ԥ��֧��.setText("");
			��ʾ.setVisible(false);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}


}
