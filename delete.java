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
	private JTextField 项目名称,项目负责人,申请预算,预期支出;
	private JButton 删除,重新输入,返回,确认,查询;
	private JDialog 提示;
	private int massage = 0;
	
	public delete() {
		app=new JFrame("项目修改");
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
		p1.add(new JLabel("要删除的项目名称"));
		项目名称 = new JTextField(10);
		p2.add(项目名称);
		重新输入= new JButton("重新输入");
		p1.add(重新输入);
		重新输入.addActionListener(this);
		删除=new JButton("删除");
		p2.add(删除);
		删除.addActionListener(this);
		查询=new JButton("查询要删除的项目名称");
		p1.add(查询);
		查询.addActionListener(this);
		返回=new JButton("返回");
		p2.add(返回);
		返回.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==删除) {
			Connection con=null;
			PreparedStatement pstmt=null;
			try {
				con=MyConnection.getConnection();
				String sql="" + "DELETE FROM project  "+  "WHERE pn = ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, 项目名称.getText());
				int n=pstmt.executeUpdate();
				if(n==1){
					JOptionPane.showMessageDialog(null,"修改成功！");
				}
				else{
					JOptionPane.showMessageDialog(this, "修改失败！", "系统提示", JOptionPane.ERROR_MESSAGE);
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
		
		if(e.getSource()==查询) {
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
					if(项目名称.getText().equals(st1)) {
						JOptionPane.showMessageDialog(null, "有该项目！");
						massage=1;
						rs.close();
						stmt.close();
						con.close();
						break;
					}
					massage=0;
				}
				if(massage==0){
					JOptionPane.showMessageDialog(this, "没有该项目！", "系统提示", JOptionPane.ERROR_MESSAGE);
				}
				
			}catch (SQLException f) {
				System.out.println("SQLException:" + f.getMessage());
				}
		}
		if(e.getSource()==重新输入) {
			项目名称.setText("");
		}
		if(e.getSource()==返回) {
			new xmjfglxt();
			app.setVisible(false);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}


}
