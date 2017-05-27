package main.piece;
import java.util.List;

import main.driver.GameDriver;
import main.helper.ImageType;
import main.helper.Position;

import java.util.ArrayList;

public class Pawn extends Piece{
	public Position start;
	
	public Pawn(Position p, boolean white, ImageType image){
		super(p, white, image);
		this.start = p;
		this.setValid(validMoves());
		this.setName(" Pawn ");
	}
	
	@Override
	public List<Position> validMoves(){
		List<Position> moves = new ArrayList<>();
		
		if(!this.isWhite()){
			//First Move
			if(this.start.equals(this.getLocation()) && (GameDriver.getBoard()[this.start.getX()][this.start.getY() + 1] == null) && (GameDriver.getBoard()[this.start.getX()][this.start.getY() + 2] == null))
				moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + 2));
			
			//Straight ahead
			if(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() + 1)) && GameDriver.isEmpty(new Position(this.getLocation().getX(), this.getLocation().getY() + 1)))
				moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() + 1));
			
			//Diagonal to the Right
			if(onBoard(new Position(this.getLocation().getX() + 1, this.getLocation().getY() + 1)) && (!GameDriver.isEmpty(new Position(this.getLocation().getX() + 1, this.getLocation().getY() + 1)) && (GameDriver.getBoard()[this.getLocation().getX() + 1][this.getLocation().getY() + 1].isWhite() != this.isWhite())))
				moves.add(new Position(this.getLocation().getX() + 1, this.getLocation().getY() + 1));
			
			//Diagonal to the Left
			if(onBoard(new Position(this.getLocation().getX() - 1, this.getLocation().getY() + 1)) && (!GameDriver.isEmpty(new Position(this.getLocation().getX() - 1, this.getLocation().getY() + 1)) && (GameDriver.getBoard()[this.getLocation().getX() - 1][this.getLocation().getY() + 1].isWhite() != this.isWhite())))
				moves.add(new Position(this.getLocation().getX() - 1, this.getLocation().getY() + 1));
		}
		else{
			if(this.start.equals(this.getLocation()) && (GameDriver.getBoard()[this.start.getX()][this.start.getY() - 1] == null) && (GameDriver.getBoard()[this.start.getX()][this.start.getY() - 2] == null))
				moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() - 2));
			
			//Straight ahead
			if(onBoard(new Position(this.getLocation().getX(), this.getLocation().getY() - 1)) && GameDriver.isEmpty(new Position(this.getLocation().getX(), this.getLocation().getY() - 1)))
				moves.add(new Position(this.getLocation().getX(), this.getLocation().getY() - 1));
			
			//Diagonal to the Right
			if(onBoard(new Position(this.getLocation().getX() + 1, this.getLocation().getY() - 1)) && (!GameDriver.isEmpty(new Position(this.getLocation().getX() + 1, this.getLocation().getY() - 1)) && (GameDriver.getBoard()[this.getLocation().getX() + 1][this.getLocation().getY() - 1].isWhite() != this.isWhite())))
				moves.add(new Position(this.getLocation().getX() + 1, this.getLocation().getY() - 1));
			
			//Diagonal to the Left
			if(onBoard(new Position(this.getLocation().getX() - 1, this.getLocation().getY() - 1)) && (!GameDriver.isEmpty(new Position(this.getLocation().getX() - 1, this.getLocation().getY() - 1)) && (GameDriver.getBoard()[this.getLocation().getX() - 1][this.getLocation().getY() - 1].isWhite() != this.isWhite())))
				moves.add(new Position(this.getLocation().getX() - 1, this.getLocation().getY() - 1));
		}
		
		this.setValid(moves);
		return moves;
	}
}
