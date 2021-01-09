package MySQL;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.MyConnection;

public class xmgl extends JFrame implements ActionListener {
	private JFrame app,cz,xg,sc;
	private JButton 删除,查找,修改;
	private JTextField 项目名称,项目负责人,申请预算,预期支出;
	
	public xmgl() {
		app = new JFrame("项目管理");
		app.setSize(400, 100);
		app.setLocation(800, 350);
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);
		Container c = app.getContentPane();
		c.setLayout(new FlowLayout());
		删除=new JButton("删除");
		查找=new JButton("查找");
		修改=new JButton("修改");
		c.add(查找);
		c.add(修改);
		c.add(删除);
		查找.addActionListener(this);
		修改.addActionListener(this);
		删除.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == 查找) {
			new find();
			app.setVisible(false);
		}
		if(e.getSource() == 修改) {
			new change();
			app.setVisible(false);
		}
		if(e.getSource() == 删除) {
			new delete();
			app.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
