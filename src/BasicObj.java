import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

public abstract class BasicObj extends Shape{
	protected int width, height; 
	protected String objectName = "Object Name";
	protected Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
	public int update_x;
	public int update_y;
	
	public BasicObj() {
	}
	
	public abstract void draw(Graphics g);
	
	public void show(Graphics g) {
		//set selected color
		g.setColor(new Color(255, 240, 135));
		//draw the object
		this.draw(g);
		//draw the ports
		g.fillRect(upPort.x, upPort.y, upPort.width, upPort.height);
		g.fillRect(downPort.x, downPort.y, downPort.width, downPort.height);
		g.fillRect(leftPort.x, leftPort.y, leftPort.width, leftPort.height);
		g.fillRect(rightPort.x, rightPort.y, rightPort.width, rightPort.height);
	
		for(int i = Lines.size()-1; i>=0;i--) {
			Shape Line = Lines.get(i);
			Line.show(g);
		}
	}
	
	public String contain(Point p) {
		Polygon check_area = new Polygon();
		check_area.addPoint(x1, y1);
		check_area.addPoint(x1, y2);
		check_area.addPoint(x2, y1);
		check_area.addPoint(x2, y2);
		if (check_area.contains(p)) {
			return "true";
		}
		return null;
	}
	
	protected void newObjPorts() {
		upPort.setPort((x1+x2)/2, y1 - 5, 5);
		downPort.setPort((x1+x2)/2, y2+5, 5);
		leftPort.setPort(x1 - 5, (y1+y2)/2, 5);
		rightPort.setPort(x2 + 5, (y1+y2)/2, 5);
	}
	
	public void setPosition(int diff_X, int diff_Y) {
		update_x = x1 + diff_X;
		update_y = y1 + diff_Y;
		x1 = update_x;
		y1 = update_y;
		x2 = update_x + width;
		y2 = update_y + height;
		newObjPorts();
	}
	
	public void Rename(String newName) {
		objectName = newName;
	}
	
	
}