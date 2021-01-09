package MySQL;
 
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Dao.MyConnection;

public class xmcggl extends JFrame implements ActionListener, ItemListener {
	private JFrame app;
	private JTextField �Ƽ��ɹ�,ר������, �������Ȩ;
	private JButton ȷ��, ������д, ����,ok;
	private JDialog ��ʾ;
	
	public xmcggl() {
		app=new JFrame("��Ŀ�ɹ�����");
		app.setSize(550,350);
		app.setLocation(750, 350);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = app.getContentPane();
		c.setLayout(new GridLayout(1,2));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		c.add(p1);
		c.add(p2);
		p1.setLayout(new GridLayout(6,1,0,10));
		p2.setLayout(new GridLayout(6,1,0,10));
		p1.add(new JLabel("�Ƽ��ɹ�"));
		�Ƽ��ɹ�=new JTextField(10);
		p2.add(�Ƽ��ɹ�);
		
		p1.add(new JLabel("ר������"));
		ר������=new JTextField(10);
		p2.add(ר������);
		
		p1.add(new JLabel("�������Ȩ"));
		�������Ȩ=new JTextField(10);
		p2.add(�������Ȩ);
		������д= new JButton("������д");
		p1.add(������д);
		������д.addActionListener(this);
		ȷ��=new JButton("ȷ��");
		p2.add(ȷ��);
		��ʾ = new JDialog();// �����µ���ʾ�Ի���
		��ʾ.setSize(340, 80);// ��ʾ�����ô�С
		��ʾ.setLocation(800,450);// ��ʾ������λ�ã���¼�����룩
		��ʾ.setLayout(new FlowLayout());// ��ʾ�򲼾�
		��ʾ.add(new Label("����ɹ���"));
		ok = new JButton("ȷ��");
		��ʾ.add(ok);
		ok.addActionListener(this);
		ȷ��.addActionListener(this);
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
				String sqlstr = "INSERT INTO res" +"(ach,mana,soft) " + "values(" + "?,?,?)";
				PreparedStatement psmt = con.prepareStatement(sqlstr);
				psmt.setString(1, �Ƽ��ɹ�.getText());
		        psmt.setString(2, ר������.getText());
		        psmt.setString(3, �������Ȩ.getText());
		        psmt.execute();
				stmt.close();
				con.close();
				��ʾ.setVisible(true);
			}catch (SQLException f) {
				System.out.println("SQLException:" + f.getMessage());
			}
		}
		if(e.getSource()==������д) {
			�Ƽ��ɹ�.setText("");
			ר������.setText("");
			�������Ȩ.setText("");
		}
		if(e.getSource()==����) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==ok) {
			�Ƽ��ɹ�.setText("");
			ר������.setText("");
			�������Ȩ.setText("");
			��ʾ.setVisible(false);
		}	
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
