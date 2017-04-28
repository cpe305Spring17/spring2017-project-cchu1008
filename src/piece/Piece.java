package piece;
import java.util.ArrayList;

import helper.*;
import org.newdawn.slick.Image;

public abstract class Piece {
	public Position location;
	public ArrayList<Position> valid;
	boolean white;
	Image myImage;
	
	public Piece(Position p, boolean white, Image image){
		this.location = p;
		this.valid = validMoves();
		this.white = white;
		this.myImage = image;
	}
	
	public Piece(){
		this.location = new Position(0, 0);
	}
	
	public void move(Position Position){
		if(isValid(Position)) this.location = Position;
	}
	public ArrayList<Position> validMoves(){
		return new ArrayList<Position>();
	}
	public boolean isValid(Position Position){
		return this.valid.contains(Position);
	}
	public void setValid(ArrayList<Position> valid){
		this.valid = valid;
	}
	public boolean onBoard(Position Position){
		return (Position.getX() >= 0 && Position.getX() < 8 && Position.getY() >= 0 && Position.getY() < 8);
	}
	public boolean isWhite(){
		return this.white;
	}
}
