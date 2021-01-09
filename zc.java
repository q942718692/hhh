package MySQL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Dao.MyConnection;
import java.sql.*;    
public class zc extends JFrame implements ActionListener, ItemListener {
	private JFrame app;
	private JTextField �û���, ����, ȷ������, ����, ��ϵ�绰, e_mail��ַ;
	private JRadioButton ��, Ů;
	private JButton ��һ��, ������д;
	private Dialog dialog;

	public zc() {
		app = new JFrame("����ע��");
		app.setSize(600, 500);
		app.setLocation(600, 240);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = app.getContentPane();
		c.setLayout(new GridLayout(1, 3));//һ������  һ����Ϣ  һ�������
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		p1.setLayout(new GridLayout(10, 1, 0, 10));//���񲼾֣�ˮƽ��ࡢ��ֱ��ࣩ
		p2.setLayout(new GridLayout(10, 1, 0, 10));
		p3.setLayout(new GridLayout(10, 1, 0, 10));
		
		p1.add(new JLabel("ע�Ჽ��"));
		p1.add(new JLabel("һ���Ķ���ͬ��Э��"));
		p1.add(new JLabel("������д��"));
		p1.add(new JLabel("�������ע��"));
		
		c.add(p1);
		c.add(p2);
		c.add(p3);
		
		p2.add(new JLabel("�û���"));
		�û��� = new JTextField(10);
		p3.add(�û���);
		p2.add(new JLabel("�� ��"));
		ButtonGroup �Ա� = new ButtonGroup();
		�� = new JRadioButton("��", true);
		�Ա�.add(��);
		Ů = new JRadioButton("Ů", false);
		�Ա�.add(Ů);
		JPanel p31 = new JPanel();
		p31.setLayout(new GridLayout(1, 2));
		p31.add(��);
		p31.add(Ů);
		p3.add(p31);
		p2.add(new JLabel("�� ��"));
		���� = new JPasswordField(10);
		p3.add(����);
		p2.add(new JLabel("ȷ������"));
		ȷ������ = new JPasswordField(10);
		p3.add(ȷ������);
		p2.add(new JLabel("������"));
		���� = new JTextField(10);
		p3.add(����);
		p2.add(new JLabel("��ϵ�绰��"));
		��ϵ�绰 = new JTextField(10);
		p3.add(��ϵ�绰);
		p2.add(new JLabel("E-mail��ַ"));
		e_mail��ַ = new JTextField(10);
		p3.add(e_mail��ַ);
		��һ�� = new JButton("��һ��");
		p2.add(��һ��);
		��һ��.addActionListener(this);
		������д = new JButton("������д");
		p3.add(������д);
		������д.addActionListener(this);
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (����.getText().equals(ȷ������.getText())) {
			if (e.getSource() == ��һ��) {
				Connection con;
				Statement stmt;
				try {
					con = MyConnection.getConnection();
					stmt = con.createStatement();
					String xb = "";
					if (��.isSelected())
						xb = ��.getText();
					if (Ů.isSelected())
						xb = Ů.getText();
					String sqlstr = "INSERT INTO admin" + " (id,password,name,telephone,mail) " + "values(" + "?,?,?,?,?)";
			        PreparedStatement psmt = con.prepareStatement(sqlstr);
			        psmt.setString(1, �û���.getText());
			        psmt.setString(2, ����.getText());
			        psmt.setString(3, ����.getText());
			        psmt.setString(4, ��ϵ�绰.getText());	
			        psmt.setString(5, e_mail��ַ.getText());
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
			JOptionPane.showMessageDialog(this, "�Բ���!�����������벻ͬ�� ���������룡", "ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
			�û���.setText("");
			����.setText("");
			ȷ������.setText("");
			����.setText("");
			��ϵ�绰.setText("");
			e_mail��ַ.setText("");
			this.setVisible(false);
		}
		if (e.getSource() == ������д) {
			�û���.setText("");
			����.setText("");
			ȷ������.setText("");
			����.setText("");
			��ϵ�绰.setText("");
			e_mail��ַ.setText("");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}