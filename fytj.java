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
	private JTextField 项目名称,人工费用,设计费用,直接投入,总费用,委托开发费,其他费用;
	private JButton 重新填写,ok,返回,确认;
	private JDialog 提示;
	
	public fytj() {
		app=new JFrame("项目申请");
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
		p1.add(new JLabel("项目名称"));
		项目名称=new JTextField(10);
		p2.add(项目名称);
		p1.add(new JLabel("人工费用"));
		人工费用=new JTextField(10);
		p2.add(人工费用);
		p1.add(new JLabel("设计费用"));
		设计费用=new JTextField(10);
		p2.add(设计费用);
		p1.add(new JLabel("直接投入"));
		直接投入=new JTextField(10);
		p2.add(直接投入);
		p1.add(new JLabel("委托开发费"));
		委托开发费=new JTextField(10);
		p2.add(委托开发费);
		p1.add(new JLabel("其他费用"));
		其他费用=new JTextField(10);
		p2.add(其他费用);
		p1.add(new JLabel("总费用"));
		总费用=new JTextField(10);
		p2.add(总费用);
		重新填写= new JButton("重新填写");
		p1.add(重新填写);
		重新填写.addActionListener(this);
		确认=new JButton("确认");
		p2.add(确认);
		确认.addActionListener(this);
		提示 = new JDialog();
		提示.setSize(340, 80);
		提示.setLocation(800,450);
		提示.setLayout(new FlowLayout());
		提示.add(new Label("输入成功！"));
		ok = new JButton("确认");
		提示.add(ok);
		ok.addActionListener(this);
		返回=new JButton("返回");
		p2.add(返回);
		返回.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == 确认) {
			Connection con;
			Statement stmt;
			try {
				con=MyConnection.getConnection();
				stmt = con.createStatement();
				String sqlstr = "INSERT INTO feiyong" +"(pn,rf,sf,zjf,wtf,qita,total) " + "values(" + "?,?,?,?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(sqlstr);
				psmt.setString(1, 项目名称.getText());
		        psmt.setString(2,人工费用.getText());
		        psmt.setString(3,设计费用.getText());
		        psmt.setString(4,直接投入.getText());	
		        psmt.setString(5, 委托开发费.getText());
		        psmt.setString(6,其他费用.getText());
		        psmt.setString(7, 总费用.getText());
		        psmt.execute();
				stmt.close();
				con.close();
				提示.setVisible(true);
			}catch (SQLException f) {
				System.out.println("SQLException:" + f.getMessage());
			}
		}
		if(e.getSource()==重新填写) {
			项目名称.setText("");
			人工费用.setText("");
			设计费用.setText("");
			直接投入.setText("");
			委托开发费.setText("");
			其他费用.setText("");
			总费用.setText("");
		}
		if(e.getSource()==返回) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==ok) {
			项目名称.setText("");
			人工费用.setText("");
			设计费用.setText("");
			直接投入.setText("");
			委托开发费.setText("");
			其他费用.setText("");
			总费用.setText("");
			提示.setVisible(false);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
