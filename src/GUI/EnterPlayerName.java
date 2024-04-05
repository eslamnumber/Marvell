package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EnterPlayerName implements ActionListener
{
	JFrame frame = new JFrame();
	TextField name1 = new TextField("first");
	TextField name2 = new TextField("second");
	JButton b = new JButton("Start Game!");
	static String n1;
	static String n2;
	
	public static String getN1() {
		return n1;
	}
	public static String getN2() {
		return n2;
	}
	EnterPlayerName()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setTitle("Choose Player's Names");
		JLabel pname1 = new JLabel ("Enter 1st Player Name");
		pname1.setBounds(30,30,150,30);
		pname1.setForeground(Color.RED);
		JLabel pname2 = new JLabel ("Enter 2nd Player Name");
		pname2.setForeground(Color.RED);
		pname2.setBounds(30,90,150,30);
		name1.setBounds(200,30,180,30);
		name2.setBounds(200,90,180,30);
		b.setFont(new Font("Georgia Pro Cond Black",Font.BOLD,18));
		b.setBorder(BorderFactory.createEtchedBorder());
		b.setFocusable(false);
		b.setBackground(Color.RED);
		b.setBounds(220,150,140,45);
		b.addActionListener(this);
		frame.add(b);
		frame.add(name2);
		frame.add(name1);
		frame.add(pname2);
		frame.add(pname1);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		n1 = name1.getText();
		n2 = name2.getText();
		if(e.getSource()==b)
			frame.dispose();
		{
		if(name1.getText().equals("") || name2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter Player names", "Error", JOptionPane.ERROR_MESSAGE);
			}
		else if(!(name1.getText().equals("") || name2.getText().equals("")))
		{
				 ChooseChamps c = new  ChooseChamps();
				 System.out.println(n1);
				 System.out.println(n2);
		}
		
	}
	}
}


