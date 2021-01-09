package MySQL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Dao.MyConnection;
import java.sql.*;

public class dl extends JFrame implements ActionListener {
	private JFrame app;
	private JButton 登录, 清除, 注册, 重新输入, 退出;
	private JLabel 用户名, 密码;
	private JTextField 用户名输入;
	private JPasswordField 用户密码;
	private JDialog 提示;
	private int massage = 0;

	public dl() {
		app = new JFrame("项目经费管理系统");
		app.setSize(200, 200);// 设置窗口的大小
		app.setLocation(800, 350);// 设置窗口位置
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);// 设置能关闭窗口
		Container c = app.getContentPane();// 初始化容器
		c.setLayout(new FlowLayout());// 设置流式布局
		// 声明姓名和密码的标签、输入框和按钮
		用户名 = new JLabel("用户名");
		用户名输入 = new JTextField(10);
		密码 = new JLabel("密码");
		用户密码 = new JPasswordField(10);
		登录 = new JButton("登录");
		登录.addActionListener(this);
		清除 = new JButton("清除");
		// 加入容器
		c.add(用户名);
		c.add(用户名输入);
		c.add(密码);
		c.add(用户密码);
		c.add(登录);
		c.add(清除);
		清除.addActionListener(this);// 给清除加监听器
		提示 = new JDialog();// 弹出新的提示对话框
		提示.setSize(340, 80);// 提示框设置大小
		提示.setLocation(app.getX() - 60, app.getY() + 60);// 提示框设置位置（登录框中央）
		提示.setLayout(new FlowLayout());// 提示框布局
		提示.add(new Label("重新输入还是退出?"));
		重新输入 = new JButton("重新输入");// 重新输入按钮
		退出 = new JButton("退出");// 退出按钮
		// 加入对话框
		提示.add(重新输入);
		提示.add(退出);
		重新输入.addActionListener(this); // 重新输入监听器
		退出.addActionListener(this); // 退出监听器
		c.add(new JLabel("如果你还没有注册，请注册"));
		注册 = new JButton("注册");// 注册按钮
		c.add(注册);
		注册.addActionListener(this);// 注册监听器
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == 登录) {
			Connection con;
			Statement stmt;
			ResultSet rs;
			try {
				con = MyConnection.getConnection();
				stmt = con.createStatement();
				String sqlstr="select * from admin";
				rs = stmt.executeQuery(sqlstr);
				while (rs.next()) {
					String st1 = rs.getString(1);
					String st2 = rs.getString(2);
					String st3 = "";
					char[] ps = 用户密码.getPassword();
					for (int i = 0; i < ps.length; i++) {
						st3 += ps[i];
					}
					if ((用户名输入.getText().equals(st1)) && (st3.equals(st2))) {
						massage = 1;
						new xmjfglxt();
						app.setVisible(false);
						rs.close();
						stmt.close();
						con.close();
						break;
					}
				}
				if (massage == 0) {
					JOptionPane.showMessageDialog(this, "您输入的帐号或密码有误,请重新输入！", "系统提示", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException f) {
				System.out.println(f);
			}
		}
		if (e.getSource() == 清除) {
			提示.setVisible(true);
		}
		if (e.getSource() == 退出)
			System.exit(0);
		if (e.getSource() == 重新输入) {
			用户名输入.setText("");
			用户密码.setText("");
			提示.setVisible(false);
		}
		if (e.getSource() == 注册) {
			new zc();
			app.setVisible(false);
		}
	}

	public static void main(String args[]) {
		new dl();
	}
}
