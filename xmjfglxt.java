package MySQL;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
    
public class xmjfglxt extends JFrame implements ActionListener {
	private JButton 申请项目,项目管理,项目成果,费用管理, 退出系统;
	private JPanel p3;
	private Container label1;
	private JFrame app;

	public xmjfglxt() {
		app = new JFrame("管理界面");
		Container c = app.getContentPane();
		c.setLayout(new BorderLayout());/**
		*
		边界布局*/
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		c.add(p1, "West");
		p1.setLayout(new GridLayout(2, 1));//2行一列（一行按钮，一行文字）
		JPanel p2 = new JPanel(new GridLayout(7, 1));//7行按钮
		p1.add(p2);
		
		JPanel p_1 = new JPanel(new GridLayout(1, 1));
		p1.add(p_1);
		JLabel tel = new JLabel("联系电话:1213132123123");
		tel.setFont(new Font("隶书", 1, 12));
		tel.setForeground(Color.GRAY);
		p_1.add(tel, JLabel.CENTER);

		申请项目 = new JButton("申请项目");
		p2.add(申请项目);
		申请项目.addActionListener(this);
		项目管理 = new JButton("项目管理");
		p2.add(项目管理);
		项目管理.addActionListener(this);
		项目成果 = new JButton("项目成果");
		p2.add(项目成果);
		项目成果.addActionListener(this);
		费用管理 = new JButton("费用管理");
		p2.add(费用管理);
		费用管理.addActionListener(this);
		退出系统 = new JButton("退出系统");
		p2.add(退出系统);
		退出系统.addActionListener(this);
		
		p3 = new JPanel();
		ImageIcon icon1 = new ImageIcon("C:\\1\\项目经费管理系统\\src\\u.jpg");
		JLabel cp1 = new JLabel(icon1);
		cp1.setSize(500, 300);
		p3.add(cp1);
		c.add(p3);
		
		JPanel p5 = new JPanel(new GridLayout(1, 1));//下方时间
		p5.setBackground(Color.WHITE);
		c.add(p5, "South");
		/**
		 * 获取登录时间
		 */
	    Date date = new Date();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		p5.add(new JLabel("登录时间: " + df.format(date), JLabel.CENTER));
		
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		/**
		 * 标题背景
		 */
		p6.setBackground(Color.WHITE);
		c.add(p6, "North");
		JLabel huanying = new JLabel("欢迎使用项目经费管理系统");
		/**
		 * 欢迎标题
		 */
		huanying.setFont(new Font("华文行楷", 1, 30));
		huanying.setForeground(Color.RED);
		p6.add(huanying, JLabel.CENTER);
		app.setSize(700, 640);
		app.setLocation(650, 200);
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == 申请项目) {
			new sqxm();
			app.setVisible(false);
		}
		if(e.getSource() == 项目管理) {
			new xmgl();
			app.setVisible(false);
		}
		if (e.getSource() == 项目成果) {
			new xmcggl();
			app.setVisible(false);
		}
		if(e.getSource()==费用管理) {
			new fytj();
			app.setVisible(false);
		}
		if (e.getSource() == 退出系统)
			System.exit(10);
	}
	public static void main(String[] args) {
		xmjfglxt h=new xmjfglxt();
	}
}
