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
	private JTextField 科技成果,专利管理, 软件著作权;
	private JButton 确认, 重新填写, 返回,ok;
	private JDialog 提示;
	
	public xmcggl() {
		app=new JFrame("项目成果管理");
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
		p1.add(new JLabel("科技成果"));
		科技成果=new JTextField(10);
		p2.add(科技成果);
		
		p1.add(new JLabel("专利管理"));
		专利管理=new JTextField(10);
		p2.add(专利管理);
		
		p1.add(new JLabel("软件著作权"));
		软件著作权=new JTextField(10);
		p2.add(软件著作权);
		重新填写= new JButton("重新填写");
		p1.add(重新填写);
		重新填写.addActionListener(this);
		确认=new JButton("确认");
		p2.add(确认);
		提示 = new JDialog();// 弹出新的提示对话框
		提示.setSize(340, 80);// 提示框设置大小
		提示.setLocation(800,450);// 提示框设置位置（登录框中央）
		提示.setLayout(new FlowLayout());// 提示框布局
		提示.add(new Label("输入成功！"));
		ok = new JButton("确认");
		提示.add(ok);
		ok.addActionListener(this);
		确认.addActionListener(this);
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
				String sqlstr = "INSERT INTO res" +"(ach,mana,soft) " + "values(" + "?,?,?)";
				PreparedStatement psmt = con.prepareStatement(sqlstr);
				psmt.setString(1, 科技成果.getText());
		        psmt.setString(2, 专利管理.getText());
		        psmt.setString(3, 软件著作权.getText());
		        psmt.execute();
				stmt.close();
				con.close();
				提示.setVisible(true);
			}catch (SQLException f) {
				System.out.println("SQLException:" + f.getMessage());
			}
		}
		if(e.getSource()==重新填写) {
			科技成果.setText("");
			专利管理.setText("");
			软件著作权.setText("");
		}
		if(e.getSource()==返回) {
			new xmjfglxt();
			app.setVisible(false);
		}
		if(e.getSource()==ok) {
			科技成果.setText("");
			专利管理.setText("");
			软件著作权.setText("");
			提示.setVisible(false);
		}	
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
