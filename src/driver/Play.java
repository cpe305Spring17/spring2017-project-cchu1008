package driver;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import helper.*;
import piece.*;
import org.newdawn.slick.Image;
public class Play extends BasicGameState {
	
	public static final int ID = 2;

	private GameDriver game;
	private Piece[][] board;
	private Player p1;
	private Player p2;
	
	private int turn;
	
	private Button tiles[][] = new Button[8][8];
	private ButtonListener bListen = new ButtonListener();
	
	public Play(){
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
		this.game = (GameDriver)game;
		this.board = this.game.board;
		this.p1 = this.game.p1;
		this.p2 = this.game.p2;
		this.turn = this.game.turn;

		generateWhite();
		generateBlack();
		generateTiles(container);
		
		//Get player name..?
		p1 = new HumanPlayer("Player Seven", true, this.game);
		p2 = new HumanPlayer("Player Eight", false, this.game);
		
		this.game.update(board, p1, p2);

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		// TODO Auto-generated method stub		
		g.setColor(Color.red);
		g.drawString("This is the Play State", GameDriver.X_SIZE*0.360f, GameDriver.Y_SIZE/8);
		g.setColor(Color.white);
		g.drawString("State Based Game Test", GameDriver.X_SIZE*0.365f, GameDriver.Y_SIZE/6);
		g.drawString("Numbers 0-3 will switch between states.", GameDriver.X_SIZE*0.255f, GameDriver.Y_SIZE/4);

		g.drawString("Player 1: ", GameDriver.X_SIZE/3, GameDriver.Y_SIZE/3);
		g.drawString(this.game.p1.getName(), GameDriver.X_SIZE/3 + 100, GameDriver.Y_SIZE/3);
		g.drawString("Player 2: ", GameDriver.X_SIZE/3, GameDriver.Y_SIZE/2);
		g.drawString(this.game.p2.getName(), GameDriver.X_SIZE/3 + 100, GameDriver.Y_SIZE/2);
		
		drawBoard(container, g);
		board[4][0].getImage().draw(10, 10, 0.4f);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int i) throws SlickException {
		// TODO Auto-generated method stub
		this.board = this.game.board;
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Play.ID;
	}
	
	public void keyReleased(int key, char c){
		if(key == Input.KEY_RIGHT || key == Input.KEY_3){
			game.getState(End.ID);
			game.enterState(End.ID);
		}
		if(key == Input.KEY_LEFT || key == Input.KEY_1){
			game.getState(Setup.ID);
			game.enterState(Setup.ID);
		}
		if(key == Input.KEY_0){
			game.getState(Menu.ID);
			game.enterState(Menu.ID);
		}
	}
	
	public void drawBoard(GameContainer container, Graphics g) throws SlickException{
		Image hBorder = new Image("resources/border.jpg");
		Image vBorder = new Image("resources/borderVerticle.jpg");
		
		for(int i = 1; i < 13; i++){
			hBorder.draw(50 * i, 15, 0.055f);
			hBorder.draw(50 * i, 603, 0.055f);
		}
		
		for(int i = 0; i < 12; i++){
			vBorder.draw(50, 15 + (50 * i), 0.055f);
			vBorder.draw(638, 15 + (50 * i), 0.055f);
		}
		
		drawTiles(container, g);
	}
	
	public void generateTiles(GameContainer container) throws SlickException{
		for(int j = 0; j < 8; j += 2){
			for(int i = 0; i < 8; i += 2){
				this.tiles[i][j] = new Button(i, j, container, new Image("resources/darkTile.jpg"), 65 + (143 * (i/2)), 30 + (143 * (j/2)), 72, 72, bListen);
				this.tiles[i + 1][j] = new Button(i + 1, j, container, new Image("resources/lightTile.jpg"), 137 + (143 * (i/2)), 30 + (143 * (j/2)), 72, 72, bListen);
				this.tiles[i][j + 1] = new Button(i, j + 1, container, new Image("resources/lightTile.jpg"), 65 + (143 * (i/2)), 102 + (143 * (j/2)), 72, 72, bListen);
				this.tiles[i + 1][j + 1] = new Button(i + 1, j + 1, container, new Image("resources/darkTile.jpg"), 137 + (143 * (i/2)), 102 + (143 * (j/2)), 72, 72, bListen);
			}
		}
	}
	
	public void drawTiles(GameContainer container, Graphics g) throws SlickException{
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.tiles[i][j].render(container, g);
			}
		}
	}
	
	
	public void generateWhite() throws SlickException{
		for(int i = 0; i < 8; i++){
			board[i][1] = new Pawn(new Position(i, 1), true, new Image("resources/whitePawn.png"), this.game.board);
		}
		board[0][0] = new Rook(new Position(0, 0), true, new Image("resources/whiteRook.png"), this.game.board);
		board[7][0] = new Rook(new Position(7, 0), true, new Image("resources/whiteRook.png"), this.game.board);
		board[1][0] = new Knight(new Position(1, 0), true, new Image("resources/whiteKnight.png"), this.game.board);
		board[6][0] = new Knight(new Position(6, 0), true, new Image("resources/whiteKnight.png"), this.game.board);
		board[2][0] = new Bishop(new Position(2, 0), true, new Image("resources/whiteBishop.png"), this.game.board);
		board[5][0] = new Bishop(new Position(5, 0), true, new Image("resources/whiteBishop.png"), this.game.board);
		board[3][0] = new Queen(new Position(3, 0), true, new Image("resources/whiteQueen.png"), this.game.board);
		board[4][0] = new King(new Position(4, 0), true, new Image("resources/whiteKing.png"), this.game.board);
	}
	
	public void generateBlack() throws SlickException{
		for(int i = 0; i < 8; i++){
			board[i][6] = new Pawn(new Position(i, 6), false, new Image("resources/blackPawn.png"), this.game.board);
		}
		board[0][7] = new Rook(new Position(0, 7), false, new Image("resources/blackRook.png"), this.game.board);
		board[7][7] = new Rook(new Position(7, 7), false, new Image("resources/blackRook.png"), this.game.board);
		board[1][7] = new Knight(new Position(1, 7), false, new Image("resources/blackKnight.png"), this.game.board);
		board[6][7] = new Knight(new Position(6, 7), false, new Image("resources/blackKnight.png"), this.game.board);
		board[2][7] = new Bishop(new Position(2, 7), false, new Image("resources/blackBishop.png"), this.game.board);
		board[5][7] = new Bishop(new Position(5, 7), false, new Image("resources/blackBishop.png"), this.game.board);
		board[3][7] = new Queen(new Position(3, 7), false, new Image("resources/blackQueen.png"), this.game.board);
		board[4][7] = new King(new Position(4, 7), false, new Image("resources/blackKing.png"), this.game.board);
		
	}

}
