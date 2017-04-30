package piece;
import java.util.ArrayList;

import helper.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import driver.GameDriver;

public abstract class Piece {
	private Position location;
	private ArrayList<Position> valid;
	private boolean white;
	private Image myImage;
	private String name;
	public GameDriver game;
	
	public Piece(Position p, boolean white, Image image, StateBasedGame game){
		this.location = p;
		this.white = white;
		this.myImage = image;
		this.game = (GameDriver)game;
	}
	
	public Piece(){
		this.location = new Position(0, 0);
	}
	
	public void move(Position p){
		if(isValid(p)) this.location = p;
	}
	public ArrayList<Position> validMoves(){
		return new ArrayList<Position>();
	}
	public boolean isValid(Position point){
		boolean valid = false;
		for(Position p : this.valid){
			if(p.equals(point)){
				valid = true;
				break;
			}
		}
		return valid;
	}
	public void setValid(ArrayList<Position> valid){
		this.valid = valid;
	}
	public ArrayList<Position> getValid(){
		return this.valid;
	}
	public Position getLocation(){
		return this.location;
	}
	public boolean onBoard(Position p){
		return (p.getX() >= 0 && p.getX() < 8 && p.getY() >= 0 && p.getY() < 8);
	}
	public boolean isWhite(){
		return this.white;
	}
	public Image getImage(){
		return this.myImage;
	}
	public void printValid(){
		for(Position p: this.valid){
			System.out.println("Valid: (" + p.getX() + ", " + p.getY() + ")");
		}
	}
	public String getName(){
		return this.name;
	}
	public void setName(String s){
		this.name = s;
	}
}
