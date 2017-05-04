package main.driver;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class End extends BasicGameState {
	
	public static final int ID = 3;
	
	private GameDriver game;
	private Player[] players = new Player[2];
	
	public End(){
		//Not sure why we need this.
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = (GameDriver)game;
		this.players = this.game.players;

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.drawString("This is the End State", GameDriver.X_SIZE*0.360f, GameDriver.Y_SIZE/8);
		g.setColor(Color.white);
		g.drawString("State Based Game Test", GameDriver.X_SIZE*0.365f, GameDriver.Y_SIZE/6);
		g.drawString("Numbers 0-3 will switch between states.", GameDriver.X_SIZE*0.255f, GameDriver.Y_SIZE/4);


	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return End.ID;
	}
	
	public void keyReleased(int key, char c){
		if(key == Input.KEY_LEFT || key == Input.KEY_2){
			game.getState(Play.ID);
			game.enterState(Play.ID);
		}
		if(key == Input.KEY_0){
			game.getState(Menu.ID);
			game.enterState(Menu.ID);
		}
		if(key == Input.KEY_1){
			game.getState(Setup.ID);
			game.enterState(Setup.ID);
		}
	}

}
