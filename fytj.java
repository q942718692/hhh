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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.MyConnection;

public  class fytj extends JFrame implements ActionListener , ItemListener {
	private JFrame app;
	private JTextField ��Ŀ����,�˹�����,��Ʒ���,ֱ��Ͷ��,�ܷ���,ί�п�����,��������;
	private JButton ������д,ok,����,ȷ��;
	private JDialog ��ʾ;
	
	public fytj() {
		app=new JFrame("��Ŀ����");
		app.setSize(550,350);
		app.setLocation(700, 350);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = app.getContentPane();
		c.setLayout(new GridLayout(1,2));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		c.add(p1);
		c.add(p2);
		p1.setLayout(new GridLayout(10,1,0,10));
		p2.setLayout(new GridLayout(10,1,0,10));
		p1.add(new JLabel("��Ŀ����"));
		��Ŀ����=new JTextField(10);
		p2.add(��Ŀ����);
		p1.add(new JLabel("�˹�����"));
		�˹�����=new JTextField(10);
		p2.add(�˹�����);
		p1.add(new JLabel("��Ʒ���"));
		��Ʒ���=new JTextField(10);
		p2.add(��Ʒ���);
		p1.add(new JLabel("ֱ��Ͷ��"));
		ֱ��Ͷ��=new JTextField(10);
		p2.add(ֱ��Ͷ��);
		p1.add(new JLabel("ί�п�����"));
		ί�п�����=new JTextField(10);
		p2.add(ί�п�����);
		p1.add(new JLabel("��������"));
		��������=new JTextField(10);
		p2.add(��������);
		p1.add(new JLabel("�ܷ���"));
		�ܷ���=new JTextField(10);
		p2.add(�ܷ���);
		������д= new JButton("������д");
		p1.add(������д);
		������д.addActionListener(this);
		ȷ��=new JButton("ȷ��");
		p2.add(ȷ��);
		ȷ��.addActionListener(this);
		��ʾ = new JDialog();
		��ʾ.setSize(340, 80);
		��ʾ.setLocation(800,450);
		��ʾ.setLayout(new FlowLayout());
		��ʾ.add(new Label("����ɹ���"));
		ok = new JButton("ȷ��");
		��ʾ.add(ok);
		ok.addActionListener(this);
		����=new JButton("����");
		p2.add(����);
		����.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ȷ��) {
			Connection con;
			Statement stmt;
			try {
				con=MyConnection.getConnection();
				stmt = con.createStatement();
				String sqlstr = "INSERT INTO feiyong" +"(pn,rf,sf,zjf,wtf,qita,total) " + "values(" + "?,?,?,?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(sqlstr);
				psmt.setString(1, ��Ŀ����.getText());
		        psmt.setString(2,�˹�����.getText());
		        psmt.setString(3,��Ʒ���.getText());
		        psmt.setString(4,ֱ��Ͷ��.getText());	
		        psmt.setString(5, ί�п�����.getText());
		        psmt.setString(6,��������.getText());
		        psmt.setString(7, �ܷ���.getText());
		        psmt.execute();
				stmt.close();
				con.close();
				��ʾ.setVisible(true);
			}catch (SQLException f) {
				System.out.println("SQLException:" + f.getMessage());
			}
		}
		if(e.getSource()==������д) {
			��Ŀ����.setText("");
			�˹�����.setText("");
			��Ʒ���.setText("");
			ֱ��Ͷ��.setText("");
			ί�п�����.setText("");
			��������.setText("");
			�ܷ���.setText("");
		}
		if(e.getSource()==����) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==ok) {
			��Ŀ����.setText("");
			�˹�����.setText("");
			��Ʒ���.setText("");
			ֱ��Ͷ��.setText("");
			ί�п�����.setText("");
			��������.setText("");
			�ܷ���.setText("");
			��ʾ.setVisible(false);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
