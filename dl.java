package MySQL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Dao.MyConnection;
import java.sql.*;

public class dl extends JFrame implements ActionListener {
	private JFrame app;
	private JButton ��¼, ���, ע��, ��������, �˳�;
	private JLabel �û���, ����;
	private JTextField �û�������;
	private JPasswordField �û�����;
	private JDialog ��ʾ;
	private int massage = 0;

	public dl() {
		app = new JFrame("��Ŀ���ѹ���ϵͳ");
		app.setSize(200, 200);// ���ô��ڵĴ�С
		app.setLocation(800, 350);// ���ô���λ��
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);// �����ܹرմ���
		Container c = app.getContentPane();// ��ʼ������
		c.setLayout(new FlowLayout());// ������ʽ����
		// ��������������ı�ǩ�������Ͱ�ť
		�û��� = new JLabel("�û���");
		�û������� = new JTextField(10);
		���� = new JLabel("����");
		�û����� = new JPasswordField(10);
		��¼ = new JButton("��¼");
		��¼.addActionListener(this);
		��� = new JButton("���");
		// ��������
		c.add(�û���);
		c.add(�û�������);
		c.add(����);
		c.add(�û�����);
		c.add(��¼);
		c.add(���);
		���.addActionListener(this);// ������Ӽ�����
		��ʾ = new JDialog();// �����µ���ʾ�Ի���
		��ʾ.setSize(340, 80);// ��ʾ�����ô�С
		��ʾ.setLocation(app.getX() - 60, app.getY() + 60);// ��ʾ������λ�ã���¼�����룩
		��ʾ.setLayout(new FlowLayout());// ��ʾ�򲼾�
		��ʾ.add(new Label("�������뻹���˳�?"));
		�������� = new JButton("��������");// �������밴ť
		�˳� = new JButton("�˳�");// �˳���ť
		// ����Ի���
		��ʾ.add(��������);
		��ʾ.add(�˳�);
		��������.addActionListener(this); // �������������
		�˳�.addActionListener(this); // �˳�������
		c.add(new JLabel("����㻹û��ע�ᣬ��ע��"));
		ע�� = new JButton("ע��");// ע�ᰴť
		c.add(ע��);
		ע��.addActionListener(this);// ע�������
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ��¼) {
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
					char[] ps = �û�����.getPassword();
					for (int i = 0; i < ps.length; i++) {
						st3 += ps[i];
					}
					if ((�û�������.getText().equals(st1)) && (st3.equals(st2))) {
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
					JOptionPane.showMessageDialog(this, "��������ʺŻ���������,���������룡", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException f) {
				System.out.println(f);
			}
		}
		if (e.getSource() == ���) {
			��ʾ.setVisible(true);
		}
		if (e.getSource() == �˳�)
			System.exit(0);
		if (e.getSource() == ��������) {
			�û�������.setText("");
			�û�����.setText("");
			��ʾ.setVisible(false);
		}
		if (e.getSource() == ע��) {
			new zc();
			app.setVisible(false);
		}
	}

	public static void main(String args[]) {
		new dl();
	}
}
