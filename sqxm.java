package MySQL;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import Dao.MyConnection;
import java.sql.*;

public  class sqxm extends JFrame implements ActionListener , ItemListener {
	private JFrame app;
	private JTextField ��Ŀ����,��Ŀ������,����Ԥ��,Ԥ��֧��;
	private JButton ������д,����,����,ȷ��;
	private JDialog ��ʾ;
	
	public sqxm() {
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

		p1.setLayout(new GridLayout(6,1,0,10));
		p2.setLayout(new GridLayout(6,1,0,10));
		
		p1.add(new JLabel("��Ŀ����"));
		��Ŀ����=new JTextField(10);
		p2.add(��Ŀ����);
		
		p1.add(new JLabel("��Ŀ������"));
		��Ŀ������=new JTextField(10);
		p2.add(��Ŀ������);
		
		p1.add(new JLabel("����Ԥ��"));
		����Ԥ��=new JTextField(10);
		p2.add(����Ԥ��);
		
		p1.add(new JLabel("Ԥ��֧��"));
		Ԥ��֧��=new JTextField(10);
		p2.add(Ԥ��֧��);
		
		������д= new JButton("������д");
		p1.add(������д);
		������д.addActionListener(this);
		����=new JButton("����");
		p2.add(����);
		����.addActionListener(this);
		��ʾ = new JDialog();// �����µ���ʾ�Ի���
		��ʾ.setSize(340, 80);// ��ʾ�����ô�С
		��ʾ.setLocation(800,450);// ��ʾ������λ�ã���¼�����룩
		��ʾ.setLayout(new FlowLayout());// ��ʾ�򲼾�
		��ʾ.add(new Label("����ɹ���"));
		ȷ�� = new JButton("ȷ��");
		��ʾ.add(ȷ��);
		ȷ��.addActionListener(this);
		����=new JButton("����");
		p2.add(����);
		����.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ����) {
			Connection con;
			Statement stmt;
			try {
				con=MyConnection.getConnection();
				stmt = con.createStatement();
				String sqlstr = "INSERT INTO project" +"(pn,pl,money,zhichu) " + "values(" + "?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(sqlstr);
				psmt.setString(1, ��Ŀ����.getText());
		        psmt.setString(2, ��Ŀ������.getText());
		        psmt.setString(3, ����Ԥ��.getText());
		        psmt.setString(4, Ԥ��֧��.getText());	
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
			��Ŀ������.setText("");
			����Ԥ��.setText("");
			Ԥ��֧��.setText("");
		}
		if(e.getSource()==����) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==ȷ��) {
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