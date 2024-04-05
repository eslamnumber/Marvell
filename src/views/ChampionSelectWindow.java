package views;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.text.Position;
import javax.sound.sampled.*;

import engine.Game;
import engine.Player;
import model.world.Champion;
import model.abilities.Ability;

public class ChampionSelectWindow extends JFrame implements MouseListener, ActionListener{
	JButton play;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton button10;
	JButton button11;
	JButton button12;
	JButton button13;
	JButton button14;
	JButton button15;
	JRadioButton r1;
	JRadioButton r2;
	JRadioButton r3;
	JRadioButton r4;
	JRadioButton r5;
	JRadioButton r6;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon icon3;
	ImageIcon icon4;
	ImageIcon icon5;
	ImageIcon icon6;
	ImageIcon icon7;
	ImageIcon icon8;
	ImageIcon icon9;
	ImageIcon icon10;
	ImageIcon icon11;
	ImageIcon icon12;
	ImageIcon icon13;
	ImageIcon icon14;
	ImageIcon icon15;
	JPanel panel;
//	PlayerNameWindow pnw;
	static Player p1;
	static Player p2;
	private static Game game;
//	ArrayList<Champion> c;
	JLabel label1;
	JLabel label2;

	JLabel labelc;
	JTextArea info;
	
	ChampionSelectWindow() throws IOException{
	
		play = new JButton();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		button10 = new JButton();
		button11 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		button14 = new JButton();
		button15 = new JButton();
		r1 = new JRadioButton();
		r2 = new JRadioButton();
		r3 = new JRadioButton();
		r4 = new JRadioButton();
		r5 = new JRadioButton();
		r6 = new JRadioButton();
		icon = new ImageIcon("2.PNG");
		icon2 = new ImageIcon("3.PNG");
		icon3 = new ImageIcon("10.PNG");
		icon4 = new ImageIcon("11.PNG");
		icon5 = new ImageIcon("12.PNG");
		icon6 = new ImageIcon("13.PNG");
		icon7 = new ImageIcon("14.PNG");
		icon8 = new ImageIcon("15.PNG");
		icon9 = new ImageIcon("16.PNG");
		icon10 = new ImageIcon("4.PNG");
		icon11 = new ImageIcon("5.PNG");
		icon12 = new ImageIcon("6.PNG");
		icon13 = new ImageIcon("7.PNG");
		icon14 = new ImageIcon("9.PNG");
		icon15 = new ImageIcon("Capture.PNG");		
		panel = new JPanel();
		labelc = new JLabel();
		info = new JTextArea();
		label1 = new JLabel();
		label2 = new JLabel();

		p1 = new Player(PlayerNameWindow.getP1().getName());
	    p2 = new Player(PlayerNameWindow.getP2().getName());
		game = new Game(p1,p2);
		
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");
		
		label1.setText(p1.getName() + "->");
		label1.setBounds(400, 450, 300, 30);
		label1.setFont(new Font("MV Boli",Font.PLAIN,20));
		
		label2.setText(p2.getName() + "->");
		label2.setBounds(400, 600, 300, 30);
		label2.setFont(new Font("MV Boli",Font.PLAIN,20));
		
		info.setBounds(20, 450, 360, 400);
		info.setEditable(false);
		
		labelc.setText("Choose Your Champions");
		labelc.setBounds(300, 20, 300, 30);
		labelc.setFont(new Font("MV Boli",Font.PLAIN,20));
		
		panel.setLayout(new GridLayout(3,5));
		panel.setBounds(50, 60, 600, 350);
		
		
		play.setText("Start Playing");
		play.setBounds(700, 700, 150, 30);
		play.setFocusable(false);
		play.addActionListener(this);

		button1.addMouseListener(this);
		button1.addActionListener(this);
		button1.setIcon(icon);
		button1.setFocusable(false);
		
		button2.addActionListener(this);
		button2.addMouseListener(this);		
		button2.setIcon(icon2);
		button2.setFocusable(false);
 
		button3.addActionListener(this);
		button3.addMouseListener(this);
		button3.setFocusable(false);
		button3.setIcon(icon3);
		
		button4.addActionListener(this);
		button4.addMouseListener(this);
		button4.setFocusable(false);
		button4.setIcon(icon4);
		
		button5.addActionListener(this);
		button5.addMouseListener(this);
		button5.setFocusable(false);
		button5.setIcon(icon5);
		
		button6.addActionListener(this);
		button6.addMouseListener(this);
		button6.setFocusable(false);
		button6.setIcon(icon6);
		
		button7.addActionListener(this);
		button7.addMouseListener(this);
		button7.setFocusable(false);
		button7.setIcon(icon7);
		
		button8.addActionListener(this);
		button8.addMouseListener(this);
		button8.setFocusable(false);
		button8.setIcon(icon8);

		button9.addActionListener(this);
		button9.addMouseListener(this);
		button9.setFocusable(false);
		button9.setIcon(icon9);
		
		button10.addActionListener(this);
		button10.addMouseListener(this);
		button10.setFocusable(false);
		button10.setIcon(icon10);
		
		button11.addActionListener(this);
		button11.addMouseListener(this);
		button11.setFocusable(false);
		button11.setIcon(icon11);
		
		button12.addActionListener(this);
		button12.addMouseListener(this);
		button12.setFocusable(false);
		button12.setIcon(icon12);
		
		button13.addActionListener(this);
		button13.addMouseListener(this);
		button13.setFocusable(false);
		button13.setIcon(icon13);
		
		button14.addActionListener(this);
		button14.addMouseListener(this);
		button14.setFocusable(false);
		button14.setIcon(icon14);
		
		button15.addActionListener(this);
		button15.addMouseListener(this);
		button15.setFocusable(false);
		button15.setIcon(icon15);
		
		this.setBounds(0, 0, 1000, 850);
		this.setLayout(null);
		this.add(play);
		this.add(panel);
		this.add(labelc);
		this.add(info);
		this.add(label1);
		this.add(label2);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button10);
		panel.add(button11);
		panel.add(button12);
		panel.add(button13);
		panel.add(button14);
		panel.add(button15);
		this.add(r1);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==play){
			System.out.println("sdfsdgf");
			try {
				new GamePlay();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.dispose();	
		}
	}
	int i=0;

	public void mouseClicked(MouseEvent e) {
		if(this.p1.getTeam().size()!=3 || this.p2.getTeam().size()!=3){
			if(e.getSource()==button1){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(0));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(0));
				}
				i++;
				button1.setEnabled(false);
			}
			if(e.getSource()==button2){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(1));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(1));
				}
				i++;
				button2.setEnabled(false);
			}
			if(e.getSource()==button3){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(2));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(2));
				}
				i++;
				button3.setEnabled(false);
			}
			if(e.getSource()==button4){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(3));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(3));
				}
				i++;
				button4.setEnabled(false);
			}
			if(e.getSource()==button5){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(4));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(4));
				}
				i++;
				button5.setEnabled(false);
			}
			if(e.getSource()==button6){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(5));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(5));
				}
				i++;
				button6.setEnabled(false);
			}
			if(e.getSource()==button7){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(6));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(6));
				}
				i++;
				button7.setEnabled(false);
			}
			if(e.getSource()==button8){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(7));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(7));
				}
				i++;
				button8.setEnabled(false);
			}
			if(e.getSource()==button9){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(8));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(8));
				}
				i++;
				button9.setEnabled(false);
			}
			if(e.getSource()==button10){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(9));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(9));
				}
				i++;
				button10.setEnabled(false);
			}
			if(e.getSource()==button11){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(10));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(10));
				}
				i++;
				button11.setEnabled(false);
			}
			if(e.getSource()==button12){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(11));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(11));
				}
				i++;
				button12.setEnabled(false);
			}
			if(e.getSource()==button13){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(12));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(12));
				}
				i++;
				button13.setEnabled(false);
			}
			if(e.getSource()==button14){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(13));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(13));
				}
				i++;
				button14.setEnabled(false);
			}
			if(e.getSource()==button15){
				if(i<3){
					this.game.getFirstPlayer().getTeam().add(game.getAvailableChampions().get(14));
				}
				else{
					this.game.getSecondPlayer().getTeam().add(game.getAvailableChampions().get(14));
				}
				i++;
				button15.setEnabled(false);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		for(int i = 0;i<game.getAvailableChampions().size();i++){
			Champion c;
			if(e.getSource()==button1){
				c = game.getAvailableChampions().get(11);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button2){
				c = game.getAvailableChampions().get(2);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button3){
				c = game.getAvailableChampions().get(1);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button4){
				c = game.getAvailableChampions().get(7);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button5){
				c = game.getAvailableChampions().get(5);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button6){
				c = game.getAvailableChampions().get(4);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button7){
				c = game.getAvailableChampions().get(8);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button8){
				c = game.getAvailableChampions().get(9);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button9){
				c = game.getAvailableChampions().get(13);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button10){
				c = game.getAvailableChampions().get(10);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button11){
				c = game.getAvailableChampions().get(12);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button12){
				c = game.getAvailableChampions().get(14);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button13){
				c = game.getAvailableChampions().get(6);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button14){
				c = game.getAvailableChampions().get(3);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			if(e.getSource()==button15){
				c = game.getAvailableChampions().get(0);
				info.setText("Name: " + c.getName() + '\n' + "Attack Damage: " + c.getAttackDamage() + '\n' + "Attack Range: " +
						c.getAttackRange() + '\n' + "Speed: " + c.getSpeed() + '\n' + "Action Points: " + 
						c.getMaxActionPointsPerTurn() + '\n' + "HP: " + c.getMaxHP() + '\n' + "Mana:" + c.getMana() + '\n' + 
						"Condition: " + c.getCondition() + '\n' + "Abilities: " + c.getAbilities().get(0).getName() + ", " +
						c.getAbilities().get(1).getName() + ", " + c.getAbilities().get(2).getName());
			}
			
		}
	}

	public void mouseExited(MouseEvent e) {
		if(e.getSource()==button1){
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
	}

	public static Game getGame() {
		return game;
	}

	public static Player getP1() {
		return p1;
	}

	public static Player getP2() {
		return p2;
	}
	
	
	
	
}
