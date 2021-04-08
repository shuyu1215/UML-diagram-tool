import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	public Port upPort = new Port();
	public Port downPort = new Port();
	public Port leftPort = new Port();
	public Port rightPort = new Port();
	public boolean check_group = false;
	public List<Shape> Lines = new ArrayList<Shape>();
	public List<Shape> shapes = new ArrayList<Shape>();
	public abstract void draw(Graphics g);
	public void show(Graphics g){
	}
	
	public int getX1(){
		return x1;
	}
	public int getY1(){
		return y1;
	}
	public int getX2(){
		return x2;
	}
	public int getY2(){
		return y2;
	}
	
	public String contain(Point p){
		return null;
	}
	
	public void addLines(Shape line) {
		Lines.add(line);
	}
	
	public List<Shape> getLineList() {
		return Lines;
	}
	
	public void setPosition(){}
	public void setPosition(int diff_X, int diff_Y) {}
	public void setPosition(int diff_X, int diff_Y, String flag){
	}
	
	public void resetSelectedShape() {}
	public Shape getSelectedShape() {
		return null;
	}
	
	public void Rename(String newName) {}
	
}