package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.world.Champion;
import engine.Game;
import engine.Player;

public class ChooseLeaders implements ActionListener
{
	JFrame frame ;
	JLabel Lp1;
	JLabel Lp2;
	JPanel Pp1;
	JPanel Pp2;
	ChooseChamps cc ; 
	EnterPlayerName pp ; 
	JButton c11;
	JButton c12;
	JButton c13;
	JButton c21;
	JButton c22;
	JButton c23;
	JPanel x;
	JPanel y;
	Game game;
	Player f;
	Player s;
	ImageIcon ironman;
	ImageIcon cap;
	ImageIcon dead;
	ImageIcon electro1;
	ImageIcon ghost;
	ImageIcon hela1;
	ImageIcon iceman;
	ImageIcon loki1;
	ImageIcon quicksilver;
	ImageIcon spiderman;
	ImageIcon wizard;
	ImageIcon thor1;
	ImageIcon venom1;
	ImageIcon hulk1;
	ImageIcon yellowjacket;
	int count = 0;
	ChooseLeaders(ChooseChamps cc)
	{
		this.cc=cc; //MOHEMA AWY W WAS MISSING
		this.pp = pp;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.setTitle("Choose Players' Leaders");
		frame.setLayout(new GridLayout(2,0));
		Lp1 = new JLabel(pp.n1 + " Choose a Team Leader!");
		Lp2 = new JLabel(pp.n2+  " Choose a Team Leader!");
		Lp1.setFont(new Font("Georgia Pro Cond Black", Font.PLAIN, 25));
		Lp2.setFont(new Font("Georgia Pro Cond Black", Font.PLAIN, 25));
		Pp1 = new JPanel ();
		Pp1.setPreferredSize(new Dimension(750,1500));
		Pp1.setBackground(Color.BLACK);
		game=new Game(cc.p1,cc.p2);     //MOHEMA 
		Pp2 = new JPanel ();
		Pp2.setPreferredSize(new Dimension(750,1500));
		Pp2.setBackground(Color.BLACK);
		x= new JPanel();
		x.setBackground(Color.WHITE);
		x.setLayout(new GridLayout(0,3,10,10));
		x.setPreferredSize(new Dimension(800,300));
		x.setAlignmentY(100);
		y= new JPanel();
		y.setBackground(Color.WHITE);
		y.setLayout(new GridLayout(0,3,10,10));
		y.setPreferredSize(new Dimension(800,300));
		y.setAlignmentY(100);
		Lp1.setBounds(90, 90, 0,0);
		Lp1.setForeground(Color.RED);
		Lp2.setBounds(90, 90, 0,0);
		Lp2.setForeground(Color.RED);
		
		
		ironman= new ImageIcon("ironmAN.png");
		cap= new ImageIcon("cap2.png");
		dead= new ImageIcon("DeadPool2.png");
		electro1= new ImageIcon("electro2.png");
		ghost= new ImageIcon("gr2.png");
		hela1= new ImageIcon("hela2.png");
		iceman= new ImageIcon("iceman_2.png");
		loki1= new ImageIcon("loki 2.png");
		quicksilver= new ImageIcon("quicksilver2.png");
		spiderman= new ImageIcon("spiderman2.png");
		wizard= new ImageIcon("strange.png");
		thor1= new ImageIcon("thor2.png");
		venom1= new ImageIcon("venom2.png");
		hulk1= new ImageIcon("hulk2.png");
		yellowjacket= new ImageIcon("yellowJacket2.png");
		
		
		
		Pp1.add(Lp1);
		Pp1.add(x);
		Pp2.add(Lp2);
		Pp2.add(y);
		f = cc.p1;
		s = cc.p2;
		c11 = new JButton(f.getTeam().get(0).getName());
		c12 = new JButton(f.getTeam().get(1).getName());
		c13 = new JButton(f.getTeam().get(2).getName());
		c21 = new JButton(s.getTeam().get(0).getName());
		c22 = new JButton(s.getTeam().get(1).getName());
		c23 = new JButton(s.getTeam().get(2).getName());
		
		if(f.getTeam().get(0).getName().equals("Captain America"))
			c11.setIcon(cap);
		else if(f.getTeam().get(1).getName().equals("Captain America"))
			c12.setIcon(cap);
		else if(f.getTeam().get(2).getName().equals("Captain America"))
			c13.setIcon(cap);
		else if(s.getTeam().get(0).getName().equals("Captain America"))
			c21.setIcon(cap);
		else if(s.getTeam().get(1).getName().equals("Captain America"))
			c22.setIcon(cap);
		else if(s.getTeam().get(2).getName().equals("Captain America"))
			c23.setIcon(cap);
		
		 if(f.getTeam().get(0).getName().equals("Deadpool"))
			c11.setIcon(dead);
		else if(f.getTeam().get(1).getName().equals("Deadpool"))
			c12.setIcon(dead);
		else if(f.getTeam().get(2).getName().equals("Deadpool"))
			c13.setIcon(dead);
		else if(s.getTeam().get(0).getName().equals("Deadpool"))
			c21.setIcon(dead);
		else if(s.getTeam().get(1).getName().equals("Deadpool"))
			c22.setIcon(dead);
		else if(s.getTeam().get(2).getName().equals("Deadpool"))
			c23.setIcon(dead);
		 
		 if(f.getTeam().get(0).getName().equals("Dr Strange"))
				c11.setIcon(wizard);
			else if(f.getTeam().get(1).getName().equals("Dr Strange"))
				c12.setIcon(wizard);
			else if(f.getTeam().get(2).getName().equals("Dr Strange"))
				c13.setIcon(wizard);
			else if(s.getTeam().get(0).getName().equals("Dr Strange"))
				c21.setIcon(wizard);
			else if(s.getTeam().get(1).getName().equals("Dr Strange"))
				c22.setIcon(wizard);
			else if(s.getTeam().get(2).getName().equals("Dr Strange "))
				c23.setIcon(wizard);
		
		if(f.getTeam().get(0).getName().equals("Ironman"))
			c11.setIcon(ironman);
		else if(f.getTeam().get(1).getName().equals("Ironman"))
			c12.setIcon(ironman);
		else if(f.getTeam().get(2).getName().equals("Ironman"))
			c13.setIcon(ironman);
		else if(s.getTeam().get(0).getName().equals("Ironman"))
			c21.setIcon(ironman);
		else if(s.getTeam().get(1).getName().equals("Ironman"))
			c22.setIcon(ironman);
		else if(s.getTeam().get(2).getName().equals("Ironman"))
			c23.setIcon(ironman);
		
		if(f.getTeam().get(0).getName().equals("Electro"))
			c11.setIcon(electro1);
		else if(f.getTeam().get(1).getName().equals("Electro"))
			c12.setIcon(electro1);
		else if(f.getTeam().get(2).getName().equals("Electro"))
			c13.setIcon(electro1);
		else if(s.getTeam().get(0).getName().equals("Electro"))
			c21.setIcon(electro1);
		else if(s.getTeam().get(1).getName().equals("Electro"))
			c22.setIcon(electro1);
		else if(s.getTeam().get(2).getName().equals("Electro"))
			c23.setIcon(electro1);
		
		if(f.getTeam().get(0).getName().equals("Ghost Rider"))
			c11.setIcon(ghost);
		else if(f.getTeam().get(1).getName().equals("Ghost Rider"))
			c12.setIcon(ghost);
		else if(f.getTeam().get(2).getName().equals("Ghost Rider"))
			c13.setIcon(ghost);
		else if(s.getTeam().get(0).getName().equals("Ghost Rider"))
			c21.setIcon(ghost);
		else if(s.getTeam().get(1).getName().equals("Ghost Rider"))
			c22.setIcon(ghost);
		else if(s.getTeam().get(2).getName().equals("Ghost Rider"))
			c23.setIcon(ghost);
		
		if(f.getTeam().get(0).getName().equals("Hela"))
			c11.setIcon(hela1);
		else if(f.getTeam().get(1).getName().equals("Hela"))
			c12.setIcon(hela1);
		else if(f.getTeam().get(2).getName().equals("Hela"))
			c13.setIcon(hela1);
		else if(s.getTeam().get(0).getName().equals("Hela"))
			c21.setIcon(hela1);
		else if(s.getTeam().get(1).getName().equals("Hela"))
			c22.setIcon(hela1);
		else if(s.getTeam().get(2).getName().equals("Hela"))
			c23.setIcon(hela1);
		
		if(f.getTeam().get(0).getName().equals("Iceman"))
			c11.setIcon(iceman);
		else if(f.getTeam().get(1).getName().equals("Iceman"))
			c12.setIcon(iceman);
		else if(f.getTeam().get(2).getName().equals("Iceman"))
			c13.setIcon(iceman);
		else if(s.getTeam().get(0).getName().equals("Iceman"))
			c21.setIcon(iceman);
		else if(s.getTeam().get(1).getName().equals("Iceman"))
			c22.setIcon(iceman);
		else if(s.getTeam().get(2).getName().equals("Iceman"))
			c23.setIcon(iceman);
		
		if(f.getTeam().get(0).getName().equals("Loki"))
			c11.setIcon(loki1);
		else if(f.getTeam().get(1).getName().equals("Loki"))
			c12.setIcon(loki1);
		else if(f.getTeam().get(2).getName().equals("Loki"))
			c13.setIcon(loki1);
		else if(s.getTeam().get(0).getName().equals("Loki"))
			c21.setIcon(loki1);
		else if(s.getTeam().get(1).getName().equals("Loki"))
			c22.setIcon(loki1);
		else if(s.getTeam().get(2).getName().equals("Loki"))
			c23.setIcon(loki1);
		
		if(f.getTeam().get(0).getName().equals("Quicksilver"))
			c11.setIcon(quicksilver);
		else if(f.getTeam().get(1).getName().equals("Quicksilver"))
			c12.setIcon(quicksilver);
		else if(f.getTeam().get(2).getName().equals("Quicksilver"))
			c13.setIcon(quicksilver);
		else if(s.getTeam().get(0).getName().equals("Quicksilver"))
			c21.setIcon(quicksilver);
		else if(s.getTeam().get(1).getName().equals("Quicksilver"))
			c22.setIcon(quicksilver);
		else if(s.getTeam().get(2).getName().equals("Quicksilver"))
			c23.setIcon(quicksilver);
		
		if(f.getTeam().get(0).getName().equals("Spiderman"))
			c11.setIcon(spiderman);
		else if(f.getTeam().get(1).getName().equals("Spiderman"))
			c12.setIcon(spiderman);
		else if(f.getTeam().get(2).getName().equals("Spiderman"))
			c13.setIcon(spiderman);
		else if(s.getTeam().get(0).getName().equals("Spiderman"))
			c21.setIcon(spiderman);
		else if(s.getTeam().get(1).getName().equals("Spiderman"))
			c22.setIcon(spiderman);
		else if(s.getTeam().get(2).getName().equals("Spiderman"))
			c23.setIcon(spiderman);
		
		
		if(f.getTeam().get(0).getName().equals("Thor"))
			c11.setIcon(thor1);
		else if(f.getTeam().get(1).getName().equals("Thor"))
			c12.setIcon(thor1);
		else if(f.getTeam().get(2).getName().equals("Thor"))
			c13.setIcon(thor1);
		else if(s.getTeam().get(0).getName().equals("Thor"))
			c21.setIcon(thor1);
		else if(s.getTeam().get(1).getName().equals("Thor"))
			c22.setIcon(thor1);
		else if(s.getTeam().get(2).getName().equals("Thor"))
			c23.setIcon(thor1);
		
		if(f.getTeam().get(0).getName().equals("Venom"))
			c11.setIcon(venom1);
		else if(f.getTeam().get(1).getName().equals("Venom"))
			c12.setIcon(venom1);
		else if(f.getTeam().get(2).getName().equals("Venom"))
			c13.setIcon(venom1);
		else if(s.getTeam().get(0).getName().equals("Venom"))
			c21.setIcon(venom1);
		else if(s.getTeam().get(1).getName().equals("Venom"))
			c22.setIcon(venom1);
		else if(s.getTeam().get(2).getName().equals("Venom"))
			c23.setIcon(venom1);
		
		if(f.getTeam().get(0).getName().equals("Hulk"))
			c11.setIcon(hulk1);
		else if(f.getTeam().get(1).getName().equals("Hulk"))
			c12.setIcon(hulk1);
		else if(f.getTeam().get(2).getName().equals("Hulk"))
			c13.setIcon(hulk1);
		else if(s.getTeam().get(0).getName().equals("Hulk"))
			c21.setIcon(hulk1);
		else if(s.getTeam().get(1).getName().equals("Hulk"))
			c22.setIcon(hulk1);
		else if(s.getTeam().get(2).getName().equals("Hulk"))
			c23.setIcon(hulk1);	
		
		if(f.getTeam().get(0).getName().equals("Yellow Jacket"))
			c11.setIcon(yellowjacket);
		else if(f.getTeam().get(1).getName().equals("Yellow Jacket"))
			c12.setIcon(yellowjacket);
		else if(f.getTeam().get(2).getName().equals("Yellow Jacket"))
			c13.setIcon(yellowjacket);
		else if(s.getTeam().get(0).getName().equals("Yellow Jacket"))
			c21.setIcon(yellowjacket);
		else if(s.getTeam().get(1).getName().equals("Yellow Jacket"))
			c22.setIcon(yellowjacket);
		else if(s.getTeam().get(2).getName().equals("Yellow Jacket"))
			c23.setIcon(yellowjacket);	
		
		
		x.add(c11);
		x.add(c12);
		x.add(c13);
		y.add(c21);
		y.add(c22);
		y.add(c23);
		frame.add(Pp1);
		frame.add(Pp2);
		frame.setVisible(true);
		c11.addActionListener(this);
		c12.addActionListener(this);
		c13.addActionListener(this);
		c21.addActionListener(this);
		c22.addActionListener(this);
		c23.addActionListener(this);
		
		
	}
	
	public String leadName(JButton b)
	{
		return b.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==c11)
		{
			count++;
			f.setLeader(f.getTeam().get(0));
			c11.setEnabled(false);
			c12.setVisible(false);
			c13.setVisible(false);
			JOptionPane.showMessageDialog(null, "Your Team Leader is"+ "" + leadName(c11) , "1st Player", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource()==c12)
		{
			count++;
			f.setLeader(f.getTeam().get(1));
			c12.setEnabled(false);
			c11.setVisible(false);
			c13.setVisible(false);
			JOptionPane.showMessageDialog(null,"Your Team Leader is" +""+ leadName(c12) , "1st Player",  JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getSource()==c13)
		{
			count++;
			f.setLeader(f.getTeam().get(2));
			c13.setEnabled(false);
			c12.setVisible(false);
			c11.setVisible(false);
			JOptionPane.showMessageDialog(null,"Your Team Leader is" +""+ leadName(c13) , "1st Player",  JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getSource()==c21)
		{
			count++;
			s.setLeader(s.getTeam().get(0));
			c21.setEnabled(false);
			c22.setVisible(false);
			c23.setVisible(false);
			JOptionPane.showMessageDialog(null,"Your Team Leader is" +""+ leadName(c21) ,  "2nd Player", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getSource()==c22)
		{
			count++;
			s.setLeader(s.getTeam().get(1));
			c22.setEnabled(false);
			c21.setVisible(false);
			c23.setVisible(false);
			JOptionPane.showMessageDialog(null, "Your Team Leader is" +""+ leadName(c22) ,"2nd Player",  JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource()==c23)
		{
			count++;
			s.setLeader(s.getTeam().get(2));
			c23.setEnabled(false);
			c22.setVisible(false);
			c21.setVisible(false);
			JOptionPane.showMessageDialog(null,"Your Team Leader is" +""+ leadName(c23) , "2nd Player",  JOptionPane.INFORMATION_MESSAGE);
		}
		if (count == 2)
		{
			JOptionPane.showMessageDialog(null, "WOHOOO THE GAME WILL START!" , "GET READY!",  JOptionPane.PLAIN_MESSAGE);
			frame.dispose();
			Grid g = new Grid(cc , this);
			game.placeChampions();
			game.placeCovers();
		}
		
	}

	
}