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
	private JButton ɾ��,����,�޸�;
	private JTextField ��Ŀ����,��Ŀ������,����Ԥ��,Ԥ��֧��;
	
	public xmgl() {
		app = new JFrame("��Ŀ����");
		app.setSize(400, 100);
		app.setLocation(800, 350);
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);
		Container c = app.getContentPane();
		c.setLayout(new FlowLayout());
		ɾ��=new JButton("ɾ��");
		����=new JButton("����");
		�޸�=new JButton("�޸�");
		c.add(����);
		c.add(�޸�);
		c.add(ɾ��);
		����.addActionListener(this);
		�޸�.addActionListener(this);
		ɾ��.addActionListener(this);
		app.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ����) {
			new find();
			app.setVisible(false);
		}
		if(e.getSource() == �޸�) {
			new change();
			app.setVisible(false);
		}
		if(e.getSource() == ɾ��) {
			new delete();
			app.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
