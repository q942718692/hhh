package MySQL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Dao.MyConnection;
import java.sql.*;    
public class zc extends JFrame implements ActionListener, ItemListener {
	private JFrame app;
	private JTextField 用户名, 密码, 确认密码, 姓名, 联系电话, e_mail地址;
	private JRadioButton 男, 女;
	private JButton 下一步, 重新填写;
	private Dialog dialog;

	public zc() {
		app = new JFrame("现在注册");
		app.setSize(600, 500);
		app.setLocation(600, 240);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = app.getContentPane();
		c.setLayout(new GridLayout(1, 3));//一列文字  一列信息  一列输入框
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		p1.setLayout(new GridLayout(10, 1, 0, 10));//网格布局（水平间距、垂直间距）
		p2.setLayout(new GridLayout(10, 1, 0, 10));
		p3.setLayout(new GridLayout(10, 1, 0, 10));
		
		p1.add(new JLabel("注册步骤"));
		p1.add(new JLabel("一、阅读并同意协议"));
		p1.add(new JLabel("二，填写表单"));
		p1.add(new JLabel("三、完成注册"));
		
		c.add(p1);
		c.add(p2);
		c.add(p3);
		
		p2.add(new JLabel("用户名"));
		用户名 = new JTextField(10);
		p3.add(用户名);
		p2.add(new JLabel("性 别"));
		ButtonGroup 性别 = new ButtonGroup();
		男 = new JRadioButton("男", true);
		性别.add(男);
		女 = new JRadioButton("女", false);
		性别.add(女);
		JPanel p31 = new JPanel();
		p31.setLayout(new GridLayout(1, 2));
		p31.add(男);
		p31.add(女);
		p3.add(p31);
		p2.add(new JLabel("密 码"));
		密码 = new JPasswordField(10);
		p3.add(密码);
		p2.add(new JLabel("确认密码"));
		确认密码 = new JPasswordField(10);
		p3.add(确认密码);
		p2.add(new JLabel("姓名："));
		姓名 = new JTextField(10);
		p3.add(姓名);
		p2.add(new JLabel("联系电话："));
		联系电话 = new JTextField(10);
		p3.add(联系电话);
		p2.add(new JLabel("E-mail地址"));
		e_mail地址 = new JTextField(10);
		p3.add(e_mail地址);
		下一步 = new JButton("下一步");
		p2.add(下一步);
		下一步.addActionListener(this);
		重新填写 = new JButton("重新填写");
		p3.add(重新填写);
		重新填写.addActionListener(this);
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (密码.getText().equals(确认密码.getText())) {
			if (e.getSource() == 下一步) {
				Connection con;
				Statement stmt;
				try {
					con = MyConnection.getConnection();
					stmt = con.createStatement();
					String xb = "";
					if (男.isSelected())
						xb = 男.getText();
					if (女.isSelected())
						xb = 女.getText();
					String sqlstr = "INSERT INTO admin" + " (id,password,name,telephone,mail) " + "values(" + "?,?,?,?,?)";
			        PreparedStatement psmt = con.prepareStatement(sqlstr);
			        psmt.setString(1, 用户名.getText());
			        psmt.setString(2, 密码.getText());
			        psmt.setString(3, 姓名.getText());
			        psmt.setString(4, 联系电话.getText());	
			        psmt.setString(5, e_mail地址.getText());
			        psmt.execute();
					stmt.close();
					con.close();
					new dl();
					app.setVisible(false);
				} catch (SQLException f) {
					System.out.println("SQLException:" + f.getMessage());
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "对不起!两次密码输入不同， 请重新输入！", "系统提示", JOptionPane.INFORMATION_MESSAGE);
			用户名.setText("");
			密码.setText("");
			确认密码.setText("");
			姓名.setText("");
			联系电话.setText("");
			e_mail地址.setText("");
			this.setVisible(false);
		}
		if (e.getSource() == 重新填写) {
			用户名.setText("");
			密码.setText("");
			确认密码.setText("");
			姓名.setText("");
			联系电话.setText("");
			e_mail地址.setText("");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}