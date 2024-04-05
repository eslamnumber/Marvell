package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;
import engine.Game;
import engine.Player;


public class ChooseChamps implements ActionListener, MouseListener
{
	Game game;
	Champion c;
	int count = 0;
	JFrame frame;
	JPanel champs; //el feeh buttouns
	JPanel panel; //hanhot feh panel w button
	JLabel info; //de bta3t el information
	JButton captainAmerica ;
	JButton deadPool;
	JButton doctorStrange;
	JButton electro;
	JButton ghostRider;
	JButton hela;
	JButton hulk;
	JButton iceMan;
	JButton ironMan;
	JButton loki;
	JButton quickSilver;
	JButton spiderMan;
	JButton thor;
	JButton venom;
	JButton yellowJacket;
	String type;
	String special;
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
	Player p1;
	Player p2;
	private static ArrayList <JButton> all = new ArrayList <JButton> ();
	
	
	ChooseChamps()
	{
		frame = new JFrame();
		champs = new JPanel();
		champs.setLayout(new GridLayout (3,5,10,10));
		champs.setPreferredSize(new Dimension(700,815));
		champs.setBackground(Color.BLACK);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1500,100));
		info = new JLabel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1500);
		frame.setTitle("Choose Players' Champions");
		p1 = new Player(EnterPlayerName.getN1()); //MOHEM
		p2 = new Player(EnterPlayerName.getN2()); //MOHEM
		game = new Game(p1, p2); //MOHEM
		try{
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");

		}catch(IOException e){
			e.printStackTrace();
		}
		captainAmerica = new JButton(Game.getAvailableChampions().get(0).getName());
		captainAmerica.addActionListener(this);
		captainAmerica.addMouseListener(this);
		deadPool = new JButton(Game.getAvailableChampions().get(1).getName());
		deadPool.addActionListener(this);
		deadPool.addMouseListener(this);
		doctorStrange = new JButton(Game.getAvailableChampions().get(2).getName());
		doctorStrange.addActionListener(this);
		doctorStrange.addMouseListener(this);
		electro = new JButton(Game.getAvailableChampions().get(3).getName());
		electro.addActionListener(this);
		electro.addMouseListener(this);
		ghostRider = new JButton(Game.getAvailableChampions().get(4).getName());
		ghostRider.addActionListener(this);
		ghostRider.addMouseListener(this);
		hela = new JButton(Game.getAvailableChampions().get(5).getName());
		hela.addActionListener(this);
		hela.addMouseListener(this);
		hulk = new JButton(Game.getAvailableChampions().get(6).getName());
		hulk.addActionListener(this);
		hulk.addMouseListener(this);
		iceMan = new JButton(Game.getAvailableChampions().get(7).getName());
		iceMan.addActionListener(this);
		iceMan.addMouseListener(this);
		ironMan = new JButton(Game.getAvailableChampions().get(8).getName());
		ironMan.addActionListener(this);
		ironMan.addMouseListener(this);
		loki = new JButton(Game.getAvailableChampions().get(9).getName());
		loki.addActionListener(this);
		loki.addMouseListener(this);
		quickSilver = new JButton(Game.getAvailableChampions().get(10).getName());
		quickSilver.addActionListener(this);
		quickSilver.addMouseListener(this);
		spiderMan = new JButton(Game.getAvailableChampions().get(11).getName());
		spiderMan.addActionListener(this);
		spiderMan.addMouseListener(this);
		thor = new JButton(Game.getAvailableChampions().get(12).getName());
		thor.addActionListener(this);
		thor.addMouseListener(this);
		venom = new JButton(Game.getAvailableChampions().get(13).getName());
		venom.addActionListener(this);
		venom.addMouseListener(this);
		yellowJacket = new JButton(Game	.getAvailableChampions().get(14).getName());
		yellowJacket.addActionListener(this);
		yellowJacket.addMouseListener(this);
		
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
		
		ironMan.setIcon(ironman);
		captainAmerica.setIcon(cap);
		deadPool.setIcon(dead);
		electro.setIcon(electro1);
		ghostRider.setIcon(ghost);
		hela.setIcon(hela1);
		iceMan.setIcon(iceman);
		loki.setIcon(loki1);
		quickSilver.setIcon(quicksilver);
		spiderMan.setIcon(spiderman);
		doctorStrange.setIcon(wizard);
		thor.setIcon(thor1);
		venom.setIcon(venom1);
		hulk.setIcon(hulk1);
		yellowJacket.setIcon(yellowjacket);
		
		champs.add(captainAmerica);
		champs.add(deadPool);
		champs.add(doctorStrange);
		champs.add(electro);
		champs.add(ghostRider);
		champs.add(hela);
		champs.add(hulk);
		champs.add(iceMan);
		champs.add(ironMan);
		champs.add(loki);
		champs.add(quickSilver);
		champs.add(spiderMan);
		champs.add(thor);
		champs.add(venom);
		champs.add(yellowJacket);
		info.setFont(new Font("Comic San",Font.PLAIN, 16));
		panel.add(info , BorderLayout.CENTER);
		frame.add(panel , BorderLayout.SOUTH);
		frame.add(champs, BorderLayout.NORTH);
		frame.setVisible(true);
	}	
	

	public void placeinTeams(String champName){

		if(game.getFirstPlayer().getTeam().size()<3)
		{
			for(int i = 0; i<Game.getAvailableChampions().size() ;i++)
				if(game.getAvailableChampions().get(i).getName().equals(champName))
					p1.getTeam().add(game.getAvailableChampions().get(i));
		}
		else if(game.getSecondPlayer().getTeam().size()<3)
		{
			for(int i = 0; i<Game.getAvailableChampions().size() ;i++)
				if(game.getAvailableChampions().get(i).getName().equals(champName))
					p2.getTeam().add(game.getAvailableChampions().get(i));
		}
	}

	public void placeDetails(Champion c) 
	{
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		panel2.setLayout(new GridLayout(2,5));
		
		((JLabel) panel2.add(new JLabel(( " Mana :" + c.getMana()) ))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		((JLabel) panel2.add(new JLabel((" Action points per turn :" +c.getMaxActionPointsPerTurn())))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		((JLabel) panel2.add(new JLabel(( " Attack Damage :"+ c.getAttackDamage())))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		((JLabel) panel2.add(new JLabel((" Attack Range :"+ c.getAttackRange())))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		((JLabel) panel2.add(new JLabel(( " Speed :" +c.getSpeed())))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		((JLabel) panel2.add(new JLabel("Abilities: "))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		
		for(int i1 = 0; i1<c.getAbilities().size() ;i1++)
		{
			String type;
			String special;
			if(c.getAbilities().get(i1) instanceof CrowdControlAbility)
			{
				type = "Crowd Control Ability.";
				special = ((CrowdControlAbility) c.getAbilities().get(i1)).getEffect().getName() + " Effect.";
				
			}
			else if(c.getAbilities().get(i1) instanceof DamagingAbility)
			{
				type = "Damaging Ability.";
				special = Integer.toString(((DamagingAbility) c.getAbilities().get(i1)).getDamageAmount()) + " Damage amount.";
			}
			else
			{
				type = "Healing Ability.";
				special = Integer.toString(((HealingAbility) c.getAbilities().get(i1)).getHealAmount()) + " Heal amount.";
				
			}
			
			((JLabel) panel2.add(new JLabel("<html>" + Integer.toString(i1+1)
					+ "- " 
					+ c.getAbilities().get(i1).getName() + ", " 
					+ type + "<br>" 
					+ c.getAbilities().get(i1).getCastArea() + " Cast area, " 
					+ c.getAbilities().get(i1).getCastRange() + " Cast range." + "<br>"
					+ c.getAbilities().get(i1).getManaCost() + " Mana, "
					+ c.getAbilities().get(i1).getRequiredActionPoints() + " Required action points." + "<br>"
					+ c.getAbilities().get(i1).getCurrentCooldown() + " Current cooldown, "
					+ c.getAbilities().get(i1).getBaseCooldown() + " Base cooldown." + "<br>"
					+ special
					+ "</html>"))).setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		}
		panel2.setPreferredSize(new Dimension(0,160));
		frame.add(panel2, BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
			if (e.getSource() == captainAmerica )
			{
				count++;
				captainAmerica.setEnabled(false);
				placeinTeams("Captain America");
				
			}
			
			else if (e.getSource() == deadPool)
			{
				count++;
				deadPool.setEnabled(false);
				placeinTeams("Deadpool");
				
			}
			else if (e.getSource() == doctorStrange)
			{
				count++;
				doctorStrange.setEnabled(false);
				placeinTeams("Dr Strange");
				
			}
			else if (e.getSource() == electro)
			{
				count++;
				electro.setEnabled(false);
				placeinTeams("Electro");
				
			}
			else if (e.getSource() == ghostRider)
			{
				count++;
				ghostRider.setEnabled(false);
				placeinTeams("Ghost Rider");
				
			}
			else if (e.getSource() == hela)
			{
				count++;
				hela.setEnabled(false);
				placeinTeams("Hela");
				
			}
			else if (e.getSource() == hulk)
			{
				count++;
				hulk.setEnabled(false);
				placeinTeams("Hulk");
				
			}
			else if (e.getSource() == iceMan)
			{
				count++;
				iceMan.setEnabled(false);
				placeinTeams("Iceman");
				
					
			}
			else if (e.getSource() == ironMan)
			{
				count++;
				ironMan.setEnabled(false);
				placeinTeams("Ironman");
				
					
			}
			else if (e.getSource() == loki)
			{
				count++;
				loki.setEnabled(false);
				placeinTeams("Loki");
				
			}
			else if (e.getSource() == quickSilver)
			{
				count++;
				quickSilver.setEnabled(false);
				placeinTeams("Quicksilver");
				
			}
			else if (e.getSource() == spiderMan)
			{
				count++;
				spiderMan.setEnabled(false);
				placeinTeams("Spiderman");
				
			}
			else if (e.getSource() == thor)
			{
				count++;
				thor.setEnabled(false);
				placeinTeams("Thor");
				
			}
			else if (e.getSource() == venom)
			{
				count++;
				venom.setEnabled(false);
				placeinTeams("Venom");
				
			}
			else if (e.getSource() == yellowJacket)
			{
				count++;
				yellowJacket.setEnabled(false);
				placeinTeams("Yellow Jacket");
				
			}

			if (count == 3)
			{
				JOptionPane.showMessageDialog(null, "2nd Player's Turn ", "You Finished" , JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if (count == 6)
			{
				JOptionPane.showMessageDialog(null, "Thank You", "Next" , JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				ChooseLeaders cl = new ChooseLeaders(this);
			}
//			System.out.println();
//			System.out.println(p1.getTeam().get(0).getName());
//			System.out.println(p1.getTeam().get(1).getName());
//			System.out.println(p1.getTeam().get(2).getName());
//			System.out.println(p2.getTeam().get(0).getName());
//			System.out.println(p2.getTeam().get(1).getName());
//			System.out.println(p2.getTeam().get(2).getName());
		}
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==captainAmerica)
		{
			c = Game.getAvailableChampions().get(0);
			placeDetails(c);
		}
		else if(e.getSource()==deadPool)
		{
			c = Game.getAvailableChampions().get(1);
			placeDetails(c);
		}
		else if(e.getSource()==doctorStrange)
		{
			c = Game.getAvailableChampions().get(2);
			placeDetails(c);
		}
		else if(e.getSource()==electro)
		{
			c = Game.getAvailableChampions().get(3);
			placeDetails(c);
		}
		else if(e.getSource()==ghostRider)
		{
			c = Game.getAvailableChampions().get(4);
			placeDetails(c);
		}
		else if(e.getSource()==hela)
		{
			c = Game.getAvailableChampions().get(5);
			placeDetails(c);
		}
		else if(e.getSource()==hulk)
		{
			c = Game.getAvailableChampions().get(6);
			placeDetails(c);
		}
		else if(e.getSource()==iceMan)
		{
			c = Game.getAvailableChampions().get(7);
			placeDetails(c);
		}
		else if(e.getSource()==ironMan)
		{
			c = Game.getAvailableChampions().get(8);
			placeDetails(c);
		}
		else if(e.getSource()==loki)
		{
			c = Game.getAvailableChampions().get(9);
			placeDetails(c);
		}
		else if(e.getSource()==quickSilver)
		{
			c = Game.getAvailableChampions().get(10);
			placeDetails(c);
		}
		else if(e.getSource()==spiderMan)
		{
			c = Game.getAvailableChampions().get(11);
			placeDetails(c);
		}
		else if(e.getSource()==thor)
		{
			c = Game.getAvailableChampions().get(12);
			placeDetails(c);
		}
		else if(e.getSource()==venom)
		{
			c = Game.getAvailableChampions().get(13);
			placeDetails(c);
		}
		else if(e.getSource()==yellowJacket)
		{
			c = Game.getAvailableChampions().get(14);
			placeDetails(c);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}



