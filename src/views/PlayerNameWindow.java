package views;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;







import engine.Game;
import engine.Game;
import engine.Player;

public class PlayerNameWindow extends JFrame implements MouseListener{
	
	private JButton button;
	private JLabel labelp1;
	private JLabel labelp2;
	private JLabel labelMessage;
	private JTextField field1;
	private JTextField field2;
	private String n1;
	private String n2;
	private Game game;
	private static Player p1;
	private static Player p2;
	ChampionSelectWindow championSelectWindow;
	
	PlayerNameWindow() {
		button = new JButton();
		labelp1 = new JLabel();
		labelp2 = new JLabel();
		labelMessage = new JLabel();
		field1 = new JTextField();
		field2 = new JTextField();
		
		button.setText("Done");
		button.setBounds(350,300,80,30);
		button.setFocusable(false);
		button.addMouseListener(this);
		
		labelMessage.setText("Please Type Your Names");
		labelMessage.setBounds(300, 20, 300, 30);
		labelMessage.setFont(new Font("MV Boli",Font.PLAIN,20));
		
		labelp1.setText("Player 1 :");
		labelp1.setBounds(50,90,100,40);
		
		labelp2.setText("Player 2 :");
		labelp2.setBounds(50,180,100,40);
		
		field1.setBounds(120,90,200,40);
		field2.setBounds(120,180,200,40);
		
		this.setSize(800,400);
		this.setLayout(null);
		this.add(button);
		this.add(labelMessage);
		this.add(labelp1);
		this.add(labelp2);
		this.add(field1);
		this.add(field2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==button)
		{
			if(field1.getText().equals("") || field2.getText().equals("") )
			{
				JOptionPane.showMessageDialog(this, "Both players must have a name" , "Error" , JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.dispose();
			p1 = new Player(field1.getText());
			p2 = new Player(field2.getText());
			
			try {
				game.loadAbilities("Abilities.csv");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				game.loadChampions("Champions.csv");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				new ChampionSelectWindow();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

	public JButton getButton() {
		return button;
	}

	public static Player getP1() {
		return p1;
	}

	public static Player getP2() {
		return p2;
	}

	public JTextField getField1() {
		return field1;
	}

	public JTextField getField2() {
		return field2;
	}

	public Game getGame() {
		return game;
	}
	
	
	
	
}
