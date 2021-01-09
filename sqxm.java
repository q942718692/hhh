package MySQL;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import Dao.MyConnection;
import java.sql.*;

public  class sqxm extends JFrame implements ActionListener , ItemListener {
	private JFrame app;
	private JTextField 项目名称,项目负责人,申请预算,预期支出;
	private JButton 重新填写,申请,返回,确认;
	private JDialog 提示;
	
	public sqxm() {
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

		p1.setLayout(new GridLayout(6,1,0,10));
		p2.setLayout(new GridLayout(6,1,0,10));
		
		p1.add(new JLabel("项目名称"));
		项目名称=new JTextField(10);
		p2.add(项目名称);
		
		p1.add(new JLabel("项目负责人"));
		项目负责人=new JTextField(10);
		p2.add(项目负责人);
		
		p1.add(new JLabel("申请预算"));
		申请预算=new JTextField(10);
		p2.add(申请预算);
		
		p1.add(new JLabel("预期支出"));
		预期支出=new JTextField(10);
		p2.add(预期支出);
		
		重新填写= new JButton("重新填写");
		p1.add(重新填写);
		重新填写.addActionListener(this);
		申请=new JButton("申请");
		p2.add(申请);
		申请.addActionListener(this);
		提示 = new JDialog();// 弹出新的提示对话框
		提示.setSize(340, 80);// 提示框设置大小
		提示.setLocation(800,450);// 提示框设置位置（登录框中央）
		提示.setLayout(new FlowLayout());// 提示框布局
		提示.add(new Label("申请成功！"));
		确认 = new JButton("确认");
		提示.add(确认);
		确认.addActionListener(this);
		返回=new JButton("返回");
		p2.add(返回);
		返回.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == 申请) {
			Connection con;
			Statement stmt;
			try {
				con=MyConnection.getConnection();
				stmt = con.createStatement();
				String sqlstr = "INSERT INTO project" +"(pn,pl,money,zhichu) " + "values(" + "?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(sqlstr);
				psmt.setString(1, 项目名称.getText());
		        psmt.setString(2, 项目负责人.getText());
		        psmt.setString(3, 申请预算.getText());
		        psmt.setString(4, 预期支出.getText());	
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
			项目负责人.setText("");
			申请预算.setText("");
			预期支出.setText("");
		}
		if(e.getSource()==返回) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==确认) {
			项目名称.setText("");
			项目负责人.setText("");
			申请预算.setText("");
			预期支出.setText("");
			提示.setVisible(false);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}