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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import engine.Game;
import engine.Player;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

public class Grid implements ActionListener , MouseListener
{
	JFrame frame;
	JPanel team1; //team 1 info
	JPanel team2; //team 2 info
	JPanel board; //grid 5x5
	JPanel current; //current champion inf
	JPanel move;
	JPanel Abuttons;
	JPanel TOQ;
	
	JLabel t1;
	JLabel t2;
	JLabel turnordQ;
	
	JButton place1;
	
	
	JButton k11;
	JButton k13;
	JButton k22;
	JButton k31;
	JButton k33;	
	
	JButton Attack;
	JButton Ability; // pop up window with ability options
	JButton endTurn;
	
	JButton UP;
	JButton DOWN;
	JButton RIGHT;
	JButton LEFT;
	
	JButton useLA1;
	JButton useLA2;
	
	ChooseChamps cc ; 
	Game game;
	ChooseLeaders cl;
	EnterPlayerName pp;
	
	JButton [][] b;
	
	boolean f;
	boolean ff;
	
	Grid(ChooseChamps cc , ChooseLeaders cl)
	{
		
		try{
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		this.cc=cc;
		this.pp = pp;
		game=new Game(cc.p1,cc.p2);
		this.cl = cl;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1000, 1000);
		frame.setTitle("Game Started");
		
		team1 = new JPanel();
		team1.setPreferredSize(new Dimension(200, 800));
		team1.setBackground(Color.WHITE);
		
		team2 = new JPanel();
		team2.setPreferredSize(new Dimension(200, 800));
		team2.setBackground(Color.WHITE);
		
		board = new JPanel();
		board.setLayout(new GridLayout(5,5));
		board.setPreferredSize(new Dimension(200, 200));
		board.setLayout(new GridLayout(5,5));
		board.setBackground(Color.DARK_GRAY);
		
		current = new JPanel();
		current.setLayout(new BorderLayout());
		current.setPreferredSize(new Dimension(200, 200));
		current.setBackground(Color.BLACK);
		
		move= new JPanel();
		move.setLayout(new GridLayout(3,3));
		move.setPreferredSize(new Dimension(200,200));
		move.setBackground(Color.RED);
		
			k11= new JButton();
			UP =new JButton();
			k13=new JButton();
			LEFT=new JButton();
			k22=new JButton();
			RIGHT= new JButton();
			k31=new JButton();
			DOWN= new JButton();
			k33= new JButton();
			
		
		Abuttons= new JPanel();
		Abuttons.setLayout(new GridLayout(3,0));
		Abuttons.setPreferredSize(new Dimension(200,200));
		Abuttons.setBackground(Color.RED);
		
			Attack=new JButton("Attack!");
			Ability= new JButton("Abilities");
			endTurn= new JButton("End Turn");
		
		TOQ= new JPanel();
		TOQ.setLayout(new BorderLayout());
		TOQ.setPreferredSize(new Dimension(100,30));
		TOQ.setBackground(Color.BLUE);
		
		useLA1= new JButton("Use Leader Ability");
		useLA1.setBounds(40,20, 5,5);
		useLA1.addActionListener(this);
		useLA2= new JButton("Use Leader Ability");
		useLA2.setBounds(40,20,5,5);
		useLA2.addActionListener(this);
		
		t1=new JLabel("        TEAM 1");
		t1.setPreferredSize(new Dimension(90,20));
		
		t2=new JLabel("TEAM 2");
		t2.setPreferredSize(new Dimension(80,20));
		
		turnordQ=new JLabel("abcdefghijklmnopqrstuvwxyz");
		turnordQ.setPreferredSize(new Dimension(50,20));
		
		b = new JButton [5][5];
		for( int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.println("hello");
				JButton x= new JButton();
				b[i][j]=x;
				x.setFont(new Font("serif",Font.PLAIN,11));
				x.addActionListener(this);
				board.add(b[i][j]);
		}
		}
		
		
		move.add(k11);
		move.add(UP);
		move.add(k13);
		move.add(LEFT);
		move.add(k22);
		move.add(RIGHT);
		move.add(k31);
		move.add(DOWN);
		move.add(k33);
		
		k11.setEnabled(false);
		k13.setEnabled(false);
		k22.setEnabled(false);
		k31.setEnabled(false);
		k33.setEnabled(false);
		
		current.add(move, BorderLayout.EAST);
		current.add(Abuttons, BorderLayout.WEST);
		
		Abuttons.add(Attack);
		Abuttons.add(Ability);
		Abuttons.add(endTurn);
		
		frame.add(TOQ, BorderLayout.NORTH);
		frame.add(board , BorderLayout.CENTER);
		frame.add(team1 , BorderLayout.WEST);
		frame.add(team2 , BorderLayout.EAST);
		frame.add(current , BorderLayout.SOUTH);
		
		team1.add(useLA1);
		team2.add(useLA2);
		
		TOQ.add(t1, BorderLayout.WEST);
		TOQ.add(t2, BorderLayout.EAST);
		TOQ.add(turnordQ, BorderLayout.CENTER); // not centeralized
		
		f = game.isFirstLeaderAbilityUsed();
		ff = game.isSecondLeaderAbilityUsed();
		
		frame.setVisible(true);
		
		board();
		
		}
	
	
	public void board()
	{
		for (int i=0 ; i < 5 ; i++)
		{
			for (int j = 0 ; j < 5 ; i++)
			{
				if(game.getBoard()[i][j] instanceof Cover)
				{
					Cover c=(Cover)game.getBoard()[i][j];
					b[i][j].setBackground(Color.BLACK);
					b[i][j].setForeground(Color.WHITE);
					b[i][j].setText(c.getCurrentHP()+" ");
					
				}
				else if(game.getBoard()[i][j] instanceof Champion)
				{
					Champion c=(Champion)game.getBoard()[i][j];
					if(c==cc.game.getCurrentChampion())
					{
						b[i][j].setBackground(Color.BLACK);
						b[i][j].setBackground(Color.WHITE);
					}
					else if(cc.p1.getTeam().contains(c))
					{
						b[i][j].setBackground(Color.DARK_GRAY);
						b[i][j].setBackground(Color.YELLOW);
					}
					else
					{
						b[i][j].setBackground(Color.LIGHT_GRAY);
						b[i][j].setBackground(Color.BLUE);
					}
					b[i][j].setText(c.getName()+" / "+c.getCurrentHP()+"");
				}
				else 
				{
					b[i][j].setText("");
					b[i][j].setBackground(Color.WHITE);	
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == UP)
		{
			try {
				game.move(Direction.RIGHT);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		if (e.getSource() == RIGHT)
		{
			try {
				game.move(Direction.UP);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		if (e.getSource() == DOWN)
		{
			try {
				game.move(Direction.LEFT);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		if (e.getSource() == LEFT)
		{
			try {
				game.move(Direction.DOWN);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		if (e.getSource() == Attack)
		{
			JOptionPane.showMessageDialog(null , "Please Choos A Direction", "ATTACK'S DIRECTION", JOptionPane.INFORMATION_MESSAGE);
			{
				if (e.getSource() == UP)
				{
					try {
						game.attack(Direction.RIGHT);
					} catch (NotEnoughResourcesException
							| ChampionDisarmedException
							| InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if (e.getSource() == RIGHT)
				{
					try {
						game.attack(Direction.UP);
					} catch (NotEnoughResourcesException
							| ChampionDisarmedException
							| InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if (e.getSource() == DOWN)
				{
					try {
						game.attack(Direction.LEFT);
					} catch (NotEnoughResourcesException
							| ChampionDisarmedException
							| InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if (e.getSource() == LEFT)
				{
					try {
						game.attack(Direction.DOWN);
					} catch (NotEnoughResourcesException
							| ChampionDisarmedException
							| InvalidTargetException e1) {
						JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		}
		if(e.getSource() == useLA1)
		{
			f = true;
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException
					| LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			useLA1.setEnabled(false);
		}
		else if(e.getSource() == useLA2)
		{
			ff = true;
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException
					| LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(null , e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			useLA1.setEnabled(false);
		}
		
	
		
	}


	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}

