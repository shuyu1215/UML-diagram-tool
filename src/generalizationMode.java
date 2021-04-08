import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Point;

public class generalizationMode extends Mode{
	private Canvas canvas = Canvas.getInstance();
	private Shape object;
	private Shape shapeBegin;
	private Shape shapeEnd;
	private Line line;
	private String check_contain;
	private String check_upPort;
	private String check_downPort;
	private String check_rightPort;
	private String check_leftPort;
	private List<Shape> shapes;
	private List<Port> ports;
	private Point begin = null;
	private Point drag = null;
	private Point end = null;
	public int x_1;
	public int y_1;
	public int x_2;
	public int y_2;
	public int end_X;
	public int end_Y;
	
    public generalizationMode(){}
	
	public void mousePressed(MouseEvent e) {
		shapes = canvas.getShapeList();
		check_contain = null;
		check_upPort = null;
		check_downPort = null;
		check_rightPort = null;
		check_leftPort = null;
		if(canvas.moveLine != null){
			canvas.moveLine.resetSelectedShape();
			canvas.moveLine = null;
		}
		
		canvas.selected_area.setBounds(0, 0, 0, 0);
		begin = e.getPoint();
		for (int i = shapes.size() - 1; i >= 0; i--) {
			shapeBegin = shapes.get(i);
			check_contain = shapeBegin.contain(begin);
			if(check_contain != null) {
				canvas.selectedObj = shapeBegin;
				break;
			}
		}
	
		x_1 = begin.x;
		y_1 = begin.y;
		canvas.repaint();
		
	}
	
	public void mouseDragged(MouseEvent e) {
		drag = e.getPoint();
		x_2 = e.getX();
		y_2 = e.getY();
		if(begin != null) {
			line = new generalizationLine(x_1, y_1, x_2, y_2);
		}
		if (canvas.selectedObj != null) {
			check_upPort = line.contain(canvas.selectedObj.upPort, drag);
			if(check_upPort != null) {
				x_1 = (canvas.selectedObj.x1 + canvas.selectedObj.x2)/2;
				y_1 = canvas.selectedObj.y1;
			}
			check_downPort = line.contain(canvas.selectedObj.downPort, drag);
			if(check_downPort != null) {
				x_1 = (canvas.selectedObj.x1 + canvas.selectedObj.x2)/2;
				y_1 = canvas.selectedObj.y2;
			}
			check_leftPort = line.contain(canvas.selectedObj.leftPort, drag);
			if(check_leftPort != null) {
				x_1 = canvas.selectedObj.x1;
				y_1 = (canvas.selectedObj.y1 + canvas.selectedObj.y2)/2;
			}
			check_rightPort = line.contain(canvas.selectedObj.rightPort, drag);
			if(check_rightPort != null) {
				x_1 = canvas.selectedObj.x2;
				y_1 = (canvas.selectedObj.y1 + canvas.selectedObj.y2)/2;
			}
			checkPortReset();
			canvas.moveLine = line;
			canvas.repaint();
			
			for (int i = shapes.size() - 1; i >= 0; i--) {
				shapeEnd = shapes.get(i);
				check_contain = shapeEnd.contain(drag);
				if(check_contain != null) {
					if(shapeEnd != canvas.selectedObj) {
						canvas.selectendObj = shapeEnd;
					}
					break;
				}
			}
		}
		if (canvas.selectendObj != null) {
			check_upPort = line.contain(canvas.selectendObj.upPort, drag);
			if(check_upPort != null) {
				end_X = (canvas.selectendObj.x1 + canvas.selectendObj.x2)/2;
				end_Y = canvas.selectendObj.y1;
			}
			check_downPort = line.contain(canvas.selectendObj.downPort, drag);
			if(check_downPort != null) {
				end_X = (canvas.selectendObj.x1 + canvas.selectendObj.x2)/2;
				end_Y = canvas.selectendObj.y2;
			}
			check_leftPort = line.contain(canvas.selectendObj.leftPort, drag);
			if(check_leftPort != null) {
				end_X = canvas.selectendObj.x1;
				end_Y = (canvas.selectendObj.y1 + canvas.selectendObj.y2)/2;
			}
			check_rightPort = line.contain(canvas.selectendObj.rightPort, drag);
			if(check_rightPort != null) {
				end_X = canvas.selectendObj.x2;
				end_Y = (canvas.selectendObj.y1 + canvas.selectendObj.y2)/2;
			}
		}
	}
	
	
	public void mouseReleased(MouseEvent e) {
		if (check_upPort != null || check_downPort != null || check_leftPort != null || check_rightPort != null) {
			object = new generalizationLine(x_1, y_1, end_X, end_Y);
			canvas.addObj(object);
			canvas.selectedObj.addLines(object);
			canvas.selectendObj.addLines(object);
			checkPortReset();
		}
		if(canvas.selectedObj != null) {
			canvas.selectedObj.resetSelectedShape();
			canvas.selectedObj = null;
		}
		if(canvas.selectendObj != null) {
			canvas.selectendObj.resetSelectedShape();
			canvas.selectendObj = null;
		}
		if(canvas.moveLine != null){
			canvas.moveLine.resetSelectedShape();
			canvas.moveLine = null;
		}
		canvas.repaint();
	}
	
	public void checkPortReset() {
		check_upPort = null;
		check_downPort = null;
		check_leftPort = null;
		check_rightPort = null;
	}

}