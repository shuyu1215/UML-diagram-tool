import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Group extends Shape{
	public int update_x;
	public int update_y;
	
	public void draw(Graphics g){
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.draw(g);
		}	
	}
	
	public void show(Graphics g){
		g.setColor(new Color(255, 153, 153));
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.draw(g);
			g.fillRect(shape.upPort.x, shape.upPort.y, shape.upPort.width, shape.upPort.height);
			g.fillRect(shape.downPort.x, shape.downPort.y, shape.downPort.width, shape.downPort.height);
			g.fillRect(shape.leftPort.x, shape.leftPort.y, shape.leftPort.width, shape.leftPort.height);
			g.fillRect(shape.rightPort.x, shape.rightPort.y, shape.rightPort.width, shape.rightPort.height);
		}
	}
	
	public void addToGroup(Shape shape) {
		shapes.add(shape);
		for(int i = shape.Lines.size()-1; i>=0; i--) {
			this.Lines.add(shape.Lines.get(i));
		}
	}

	public List<Shape> getShapes() {
		return shapes;
	}
	
	public String contain(Point p) {
		for (int i = 0; i < shapes.size(); i++) {
			Shape s = shapes.get(i);
			Polygon check_area = new Polygon();
			check_area.addPoint(s.x1, s.y1);
			check_area.addPoint(s.x1, s.y2);
			check_area.addPoint(s.x2, s.y1);
			check_area.addPoint(s.x2, s.y2);
			if (check_area.contains(p)) {
				return "true";
			}
		}
		return null;
	}
	
	public void setPosition(int diff_X, int diff_Y) {
		for (int i = 0; i < shapes.size(); i++) {
			Shape tmp_s = shapes.get(i);
			tmp_s.setPosition(diff_X, diff_Y);
		}
	}
}
