import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.util.List;

public class selectMode extends Mode{
	private Canvas canvas = Canvas.getInstance();
	private List<Shape> shapes;
	private List<Shape> Lines;
	private String check_contain = null;
	private String check_connect = null;
	private Point begin = null;
	private boolean area_contain = false; 
	public int diff_X;
	public int diff_Y;
	public int boundX;
	public int boundY;
	
	public void mousePressed(MouseEvent e) {
		shapes = canvas.getShapeList();
		if(canvas.selectedObj != null){
			canvas.selectedObj.resetSelectedShape();
			canvas.selectedObj = null;
		}
		if(canvas.selectGroup != null) {
			canvas.selectGroup = null;
		}
		if(canvas.connectLines != null) {
			canvas.connectLines = null;
		}
		canvas.selected_area.setBounds(0, 0, 0, 0);
		begin = e.getPoint();
		for (int i = shapes.size() - 1; i >= 0; i--) {
			Shape shape = shapes.get(i);
			check_contain = shape.contain(begin);
			if (check_contain != null) {
				canvas.selectedObj = shape;
				break;
			}
		}
		if(canvas.selectedObj != null) {
			Lines = canvas.selectedObj.getLineList();
		}
		canvas.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		diff_X = e.getX() - begin.x;
		diff_Y = e.getY() - begin.y;
		if(canvas.selectedObj != null){
			canvas.selectedObj.setPosition(diff_X, diff_Y);
			if(Lines != null) {
				for (int i = Lines.size() - 1; i >= 0; i--) {
					Shape s_line = Lines.get(i);
					if(s_line.check_group != true) {
						if(distance(e.getX(), e.getY(), s_line.x1, s_line.y1) < distance(e.getX(), e.getY(), s_line.x2, s_line.y2)) {
							s_line.setPosition(diff_X, diff_Y, "begin");
						}
						else{
							s_line.setPosition(diff_X, diff_Y, "end");
						}
					}
				}
			}
			begin.x = e.getX();
			begin.y = e.getY();
		}
		else {
			canvas.draw_area = "draw";
			if(e.getX() > begin.x) {
				boundX = begin.x;
			}
			else{
				boundX = e.getX();
			}
			if(e.getY() > begin.y){
				boundY = begin.y;
			}
			else{
				boundY = e.getY();
			}
			
			canvas.selected_area.setBounds(boundX, boundY, Math.abs(diff_X), Math.abs(diff_Y));
			
			for (int i = shapes.size() - 1; i >= 0; i--) {
				Shape temp = shapes.get(i);
				area_contain = canvas.selected_area.contains(temp.x1, temp.y1, Math.abs(temp.x2-temp.x1)+5, Math.abs(temp.y1-temp.y2)+5);
				if (area_contain != false) {
					temp.check_group = true;
				}
			}
		}
		canvas.repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	
	public String checkLine(Shape s, Shape L) {
		if((s.upPort.x+5) == L.x1 && s.upPort.y+10 == L.y1) {
			return "begin";
		}
		else if((s.downPort.x+5) == L.x1 && s.downPort.y == L.y1) {
			return "begin";
		}
		else if((s.leftPort.x+10) == L.x1 && s.leftPort.y+5 == L.y1) {
			return "begin";
		}
		else if((s.rightPort.x) == L.x1 && s.rightPort.y+5 == L.y1) {
			return "begin";
		}
		else if((s.upPort.x+5) == L.x2 && s.upPort.y+10 == L.y2) {
			return "end";
		}
		else if((s.downPort.x+5) == L.x2 && s.downPort.y == L.y2) {
			return "end";
		}
		else if((s.leftPort.x+10) == L.x2 && s.leftPort.y+5 == L.y2) {
			return "end";
		}
		else if((s.rightPort.x) == L.x2 && s.rightPort.y+5 == L.y2) {
			return "end";
		}
		else {
			return null;
		}
	}
	
	public double distance(int Px1, int Py1, int Px2, int Py2) {
		double dis = Math.sqrt(Math.abs((Px1 - Px2)* (Px1 - Px2) + (Py1 - Py2)* (Py1 - Py2)));
		return dis;
	}
}
