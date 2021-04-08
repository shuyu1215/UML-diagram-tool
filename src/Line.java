import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;

public abstract class Line extends Shape{
	public Port beginPort = new Port();
	public Port endPort = new Port();
	public int update_x;
	public int update_y;
	
	public void draw(Graphics g) {
			g.setColor(Color.white);
		};
	
	protected void newLinePorts() {
		beginPort.setPort(x1, y1,5);
		endPort.setPort(x2, y2, 5);
	}
	
	public void show(Graphics g) {
		g.setColor(new Color(255, 240, 135));
		this.draw(g);
	}
	
	public void resetPoint(int begin_x, int begin_y, int end_x, int end_y) {
		x1 = begin_x;
		y1 = begin_y;
		x2 = end_x;
		y2 = end_y;
	}
	//for group
	public void setPosition(int diff_X, int diff_Y) {
		x1 = x1 + diff_X;
		y1 = y1 + diff_Y;
		x2 = x2 + diff_X;
		y2 = y2 + diff_Y;
	}
	
	public void setPosition(int diff_X, int diff_Y, String flag) {
		if(flag == "begin") {
			update_x = x1 + diff_X;
			update_y = y1 + diff_Y;
			x1 = update_x;
			y1 = update_y;
		}
		else if(flag == "end") {
			update_x = x2 + diff_X;
			update_y = y2 + diff_Y;
			x2 = update_x;
			y2 = update_y;
		}
	}
	
	
	public String contain(Port port, Point p) {
		Polygon check_port = new Polygon();
		check_port.addPoint(port.x-port.width*4, port.y-port.height*4);
		check_port.addPoint(port.x-port.width*4, port.y+port.height*4);
		check_port.addPoint(port.x+port.width*4, port.y-port.height*4);
		check_port.addPoint(port.x+port.width*4, port.y+port.height*4);
		if (check_port.contains(p)) {
			return "true";
		}
		return null;
	}
	
	public void resetPort(Port port, Line line, String flag) {
		port.addLine(line);
		if(flag == "begin"){
			this.beginPort.removeLine(line);
			this.beginPort = port;
		}
		else if(flag == "end"){
			this.endPort.removeLine(line);
			this.endPort = port;
		}
		
	}
	
	private double distance(Point p) {
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		return line.ptLineDist(p.getX(), p.getY());
	}
}
 