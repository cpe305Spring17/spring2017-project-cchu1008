package lib.jars;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Pieces.Piece;

public class End extends BasicGameState {
	
	public static int ID = 2;
	
	private GameDriver game;
	private Piece[][] board;
	private Player p1;
	private Player p2;
	
	public End(){
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.game = (GameDriver)game;
		this.board = this.game.board;
		this.p1 = this.game.p1;
		this.p2 = this.game.p2;

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawString("This is the End State", 220, 50);
		g.setColor(Color.white);
		g.drawString("State Based Game Test", 205, 100);
		g.drawString("Numbers 0-2 will switch between states.", 125, 200);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return End.ID;
	}
	
	public void keyReleased(int key, char c){
		if(key == Input.KEY_LEFT || key == Input.KEY_1){
			game.getState(Play.ID);
			game.enterState(Play.ID);
		}
		if(key == Input.KEY_0){
			game.getState(Menu.ID);
			game.enterState(Menu.ID);
		}
	}

}