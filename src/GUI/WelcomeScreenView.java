package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WelcomeScreenView implements ActionListener
{
	JFrame frame = new JFrame();
	JButton button = new JButton();
	
	WelcomeScreenView()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setTitle("Marvel: Ultimate War");
		ImageIcon image = new ImageIcon("logoo.png");
		frame.setIconImage(image.getImage());
		ImageIcon image2 = new ImageIcon("marvel.png");
		button.setIcon(image2);
		button.addActionListener(this);
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button)
		{
			frame.dispose();
			EnterPlayerName p = new EnterPlayerName();
		}
		
	}
	
	

}
