package main.helper;

public class Position extends Object{
	private int x;
	private int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setPos(Position p){
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	@Override
	public boolean equals(Object p){
		Position point = (Position)p;
		return (this.x == point.getX() && this.y == point.getY());
	}
}
