package MySQL;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
    
public class xmjfglxt extends JFrame implements ActionListener {
	private JButton ������Ŀ,��Ŀ����,��Ŀ�ɹ�,���ù���, �˳�ϵͳ;
	private JPanel p3;
	private Container label1;
	private JFrame app;

	public xmjfglxt() {
		app = new JFrame("�������");
		Container c = app.getContentPane();
		c.setLayout(new BorderLayout());/**
		*
		�߽粼��*/
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		c.add(p1, "West");
		p1.setLayout(new GridLayout(2, 1));//2��һ�У�һ�а�ť��һ�����֣�
		JPanel p2 = new JPanel(new GridLayout(7, 1));//7�а�ť
		p1.add(p2);
		
		JPanel p_1 = new JPanel(new GridLayout(1, 1));
		p1.add(p_1);
		JLabel tel = new JLabel("��ϵ�绰:1213132123123");
		tel.setFont(new Font("����", 1, 12));
		tel.setForeground(Color.GRAY);
		p_1.add(tel, JLabel.CENTER);

		������Ŀ = new JButton("������Ŀ");
		p2.add(������Ŀ);
		������Ŀ.addActionListener(this);
		��Ŀ���� = new JButton("��Ŀ����");
		p2.add(��Ŀ����);
		��Ŀ����.addActionListener(this);
		��Ŀ�ɹ� = new JButton("��Ŀ�ɹ�");
		p2.add(��Ŀ�ɹ�);
		��Ŀ�ɹ�.addActionListener(this);
		���ù��� = new JButton("���ù���");
		p2.add(���ù���);
		���ù���.addActionListener(this);
		�˳�ϵͳ = new JButton("�˳�ϵͳ");
		p2.add(�˳�ϵͳ);
		�˳�ϵͳ.addActionListener(this);
		
		p3 = new JPanel();
		ImageIcon icon1 = new ImageIcon("C:\\1\\��Ŀ���ѹ���ϵͳ\\src\\u.jpg");
		JLabel cp1 = new JLabel(icon1);
		cp1.setSize(500, 300);
		p3.add(cp1);
		c.add(p3);
		
		JPanel p5 = new JPanel(new GridLayout(1, 1));//�·�ʱ��
		p5.setBackground(Color.WHITE);
		c.add(p5, "South");
		/**
		 * ��ȡ��¼ʱ��
		 */
	    Date date = new Date();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		p5.add(new JLabel("��¼ʱ��: " + df.format(date), JLabel.CENTER));
		
		JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		/**
		 * ���ⱳ��
		 */
		p6.setBackground(Color.WHITE);
		c.add(p6, "North");
		JLabel huanying = new JLabel("��ӭʹ����Ŀ���ѹ���ϵͳ");
		/**
		 * ��ӭ����
		 */
		huanying.setFont(new Font("�����п�", 1, 30));
		huanying.setForeground(Color.RED);
		p6.add(huanying, JLabel.CENTER);
		app.setSize(700, 640);
		app.setLocation(650, 200);
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ������Ŀ) {
			new sqxm();
			app.setVisible(false);
		}
		if(e.getSource() == ��Ŀ����) {
			new xmgl();
			app.setVisible(false);
		}
		if (e.getSource() == ��Ŀ�ɹ�) {
			new xmcggl();
			app.setVisible(false);
		}
		if(e.getSource()==���ù���) {
			new fytj();
			app.setVisible(false);
		}
		if (e.getSource() == �˳�ϵͳ)
			System.exit(10);
	}
	public static void main(String[] args) {
		xmjfglxt h=new xmjfglxt();
	}
}
