package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import engine.Game;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

public class GamePlay extends JFrame implements ActionListener{
	JPanel left;
	JPanel center;
	JPanel right; 
	JButton [][] listbuttons;

	JButton moveRight;
	JButton moveLeft;
	JButton moveUp;
	JButton moveDown;
	JButton attackup;
	JButton attackdown;
	JButton attackleft;
	JButton attackright;
	JButton leaderability;
	JButton endturn;
	JButton cast1;
	JButton cast2;
	JButton cast3;
//	JButton cast4;
//	JButton cast5;
	
	
	
	
	Game game;
	Direction d;
	JPanel leftt; 
	
	GamePlay() throws IOException{
		listbuttons = new JButton [5][5];
		left = new JPanel();
		right = new JPanel();
		center = new JPanel();
	
		moveDown = new JButton();
		moveLeft = new JButton();
		moveRight = new JButton();
		moveRight = new JButton();
		moveUp = new JButton();
		this.attackup=new JButton();
		this.attackdown=new JButton();
		this.attackleft=new JButton();
		this.attackright=new JButton();
		this.leaderability=new JButton();
		this.endturn=new JButton();
		game = new Game(ChampionSelectWindow.getP1(), ChampionSelectWindow.getP2());
		d = Direction.LEFT;
		
//		game.loadAbilities("Abilities.csv");
//		game.loadChampions("Champions.csv");
		
		game.placeChampions();
		//game.placeCovers();
		
	    //game.prepareChampionTurns();
		
//		for
		
		center.setLayout(new GridLayout(5,5));
		center.setSize(500, 500);
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				JButton  x= new JButton();
				center.add(x);
				x.setOpaque(true);
				x.setVisible(true);
				x.setBackground(Color.black);
				x.addActionListener(this);
				listbuttons[i][j]=x;
			}
		}
		
		this.add(right, BorderLayout.WEST);
		
		 cast1 = new JButton(game.getCurrentChampion().getAbilities().get(0).getName());
	     cast2 = new JButton(game.getCurrentChampion().getAbilities().get(1).getName());
	     cast3 = new JButton(game.getCurrentChampion().getAbilities().get(2).getName());
	     Point p = game.getCurrentChampion().getLocation();
	     (listbuttons[p.x][p.y]).setForeground(Color.red);
	    moveDown.setText("Down");
		moveDown.addActionListener(this);
		moveDown.setFocusable(false);
		
		moveLeft.setText("Left");
		moveLeft.addActionListener(this);
		moveLeft.setFocusable(false);
		
		moveRight.setText("Right");
		moveRight.addActionListener(this);
		moveRight.setFocusable(false);
		
		moveUp.setText("Up");
		moveUp.addActionListener(this);
		moveUp.setFocusable(false);
		
		
		attackup.setText("Attack up ");
		attackup.addActionListener(this);
		attackup.setFocusable(false);
		attackdown.setText("Attack down");
		attackdown.addActionListener(this);
		attackdown.setFocusable(false);
		attackleft.setText("Attack left");
		attackleft.addActionListener(this);
		attackleft.setFocusable(false);
		attackright.setText("Attack right");
		attackright.addActionListener(this);
		attackright.setFocusable(false);
		leaderability.setText("leader ability");
		leaderability.addActionListener(this);
		leaderability.setFocusable(false);
		endturn.setText("end turn");
		endturn.addActionListener(this);
		endturn.setFocusable(false);
		
		
		right.setSize(400, 400);
		right.setLayout(new FlowLayout());
		right.setVisible(true);
		right.setPreferredSize(new Dimension(100,this.getHeight()));
		right.add(moveUp);
		right.add(moveDown);
		right.add(moveLeft);
		right.add(moveRight);
		right.add(attackup);
		right.add(attackdown);
		right.add(attackleft);
		right.add(attackright);
		right.add(leaderability);
		
		createboardgrid(game);
		leftt = new JPanel();
		this.add(leftt,BorderLayout.EAST);
		leftt.setPreferredSize(new Dimension(200,this.getHeight()));
		//right.setSize(400, 400);
		right.setLayout(new FlowLayout());
		right.setVisible(true);
		right.setPreferredSize(new Dimension(100,this.getHeight()));
		
		leftt.add(cast1);
		leftt.add(cast2);
		leftt.add(cast3);
//		leftt.add(cast4);
//		leftt.add(cast5);
		
		
		this.add(center, BorderLayout.CENTER);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 850);
		this.setVisible(true);
	}
	public void createboardgrid(Game game) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(this.game.getBoard()[i][j]!=null) {
					if(this.game.getBoard()[i][j] instanceof Cover)
					this.listbuttons[i][j].setText("Cover"+((Cover)this.game.getBoard()[i][j]).getCurrentHP());
					if(this.game.getBoard()[i][j] instanceof Champion) {
						this.listbuttons[i][j].setText(((Champion)this.game.getBoard()[i][j]).getName()+((Champion)this.game.getBoard()[i][j]).getCurrentHP());
					}
				}
				else {
					this.listbuttons[i][j].setText(" ");
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==moveUp){
			Point old = this.game.getCurrentChampion().getLocation();
			try {
				game.move(Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.listbuttons[old.x][old.y].setText(" ");
			createboardgrid(game);
			
		}
		
		
		
		if(e.getSource()==moveDown){
			Point old = this.game.getCurrentChampion().getLocation();
			try {
				game.move(Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.listbuttons[old.x][old.y].setText(" ");
			createboardgrid(game);
		}
		
		if(e.getSource()==moveLeft){
			Point old = this.game.getCurrentChampion().getLocation();
			try {
				game.move(Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.listbuttons[old.x][old.y].setText(" ");
			createboardgrid(game);
					
		}
		
		if(e.getSource()==moveRight){
			Point old = this.game.getCurrentChampion().getLocation();
			try {
				game.move(Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.listbuttons[old.x][old.y].setText(" ");
			createboardgrid(game);
			
		}
		
		if(e.getSource()==attackup){
			try {
				game.attack(Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			createboardgrid(game);
			
		}
		if(e.getSource()==attackdown){
			try {
				game.attack(Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			createboardgrid(game);
			
		}
		if(e.getSource()==attackleft){
			try {
				game.attack(Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			createboardgrid(game);
			
		}
		if(e.getSource()==attackright){
			//Point old = this.game.getCurrentChampion().getLocation();
			try {
				game.attack(Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			createboardgrid(game);
			
		}
		if(e.getSource()==leaderability) {
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			createboardgrid(game);
		}
		


	}
	public void Casting(Ability a) throws AbilityUseException, CloneNotSupportedException {
		if(a.getCastArea()==AreaOfEffect.SURROUND||a.getCastArea()==AreaOfEffect.TEAMTARGET||a.getCastArea()==AreaOfEffect.SELFTARGET) {
			try {
				game.castAbility(a);
			}
			catch(NotEnoughResourcesException e1 ) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
				e1.printStackTrace();	
			}
			catch(AbilityUseException e2) {
				JOptionPane.showMessageDialog(null,e2.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
				e2.printStackTrace();	
			}
			}
		else if(a.getCastArea()==AreaOfEffect.DIRECTIONAL) {
			JFrame y = new JFrame();
			y.setLayout(new GridLayout(2,2));
			y.setSize(100,100);
			y.setVisible(true);
			JButton button1 = new JButton("Up");
			JButton button2 = new JButton("Down");
			JButton button3 = new JButton("Right");
			JButton button4 = new JButton("left");
			
			button1.addActionListener(e->
			{
				try {
					game.castAbility(a, Direction.UP);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e1.printStackTrace();
				} catch (AbilityUseException e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e2.printStackTrace();
				} catch (CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null,e3.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e3.printStackTrace();
				}
			});

			button2.addActionListener(e->
			{
				try {
					game.castAbility(a, Direction.DOWN);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e1.printStackTrace();
				} catch (AbilityUseException e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e2.printStackTrace();
				} catch (CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null,e3.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e3.printStackTrace();
				}
			});
			button3.addActionListener(e->
			{
				try {
					game.castAbility(a, Direction.RIGHT);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e1.printStackTrace();
				} catch (AbilityUseException e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e2.printStackTrace();
				} catch (CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null,e3.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e3.printStackTrace();
				}
			});
			button4.addActionListener(e->
			{
				try {
					game.castAbility(a, Direction.LEFT);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e1.printStackTrace();
				} catch (AbilityUseException e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage(),"You cannot use the Ability",JOptionPane.ERROR_MESSAGE );
					e2.printStackTrace();
				} catch (CloneNotSupportedException e3) {
					JOptionPane.showMessageDialog(null,e3.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
					e3.printStackTrace();
				}
			});
		}
		else if(a.getCastArea()==AreaOfEffect.SINGLETARGET) {	
			for(int i = 0; i<5 ;i++) {
				for(int j =0;j<5;j++) {
					int x = i ;
					int y =j;
					(listbuttons[i][j]).addActionListener(e->{
					  try {
						game.castAbility(a, x, y);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
						e1.printStackTrace();
					} catch (AbilityUseException e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage(),"You cannot use the Ability",JOptionPane.ERROR_MESSAGE );
						e2.printStackTrace();
					} catch (InvalidTargetException e3) {
						JOptionPane.showMessageDialog(null,e3.getMessage(),"Invalid target",JOptionPane.ERROR_MESSAGE );
						e3.printStackTrace();
					} catch (CloneNotSupportedException e4) {
						JOptionPane.showMessageDialog(null,e4.getMessage(),"Not Enough Resources",JOptionPane.ERROR_MESSAGE );
						e4.printStackTrace();
					}
					  
					});
					
				}
			  }
			}
		createboardgrid(game);
		for(int i =0 ;i<5 ;i++) 
			for(int j =0;j<5;j++) 
				(listbuttons[i][j]).addActionListener(null);
			
		}
	public void endTurn() {
		game.endTurn();
		Point p = game.getCurrentChampion().getLocation();
	   // (listbuttons[p.x][p.y]).setForeground(Color.red);
        cast1 = new JButton(game.getCurrentChampion().getAbilities().get(0).getName());
        cast2 = new JButton(game.getCurrentChampion().getAbilities().get(1).getName());
        cast3 = new JButton(game.getCurrentChampion().getAbilities().get(2).getName());
        cast1.addActionListener(e->{
        	try {
				Casting(game.getCurrentChampion().getAbilities().get(0));
			} catch (AbilityUseException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        cast2.addActionListener(e->{
        	try {
				Casting( game.getCurrentChampion().getAbilities().get(1));
			} catch (AbilityUseException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }); cast3.addActionListener(e->{
        	try {
				Casting( game.getCurrentChampion().getAbilities().get(2));
			} catch (AbilityUseException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
	}
}
