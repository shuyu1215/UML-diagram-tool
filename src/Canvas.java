import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Vector;
import java.util.List;

public class Canvas extends JPanel{
	private List<Shape> objects = new ArrayList<Shape>();
	public List<Shape> connectLines = new ArrayList<Shape>();
	public Shape selectedObj = null;
	public Shape selectendObj = null;
	public Shape moveLine = null;
	public Shape selectGroup = null;
	public String draw_area = null;
	public int startX, startY;
	private EventListener listener = null;
	public Mode currentMode = null;
	private static Canvas instance = null;
	public Rectangle selected_area = new Rectangle();
    private Canvas(){
        this.setLayout(null); 
        this.setOpaque(false);
        this.setBackground(Color.darkGray);
    }
    
    public static Canvas getInstance(){
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}
    
    public void paint(Graphics g) {
		Dimension dim = getSize();
		g.setColor(new Color(35, 37, 37));
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		
		for(int i = objects.size() - 1; i >= 0; i--){
			Shape shape = objects.get(i);
			shape.draw(g);
		}
		
		if(selectedObj != null) {
			selectedObj.show(g);
		}
		
		if(selectendObj != null) {
			selectendObj.show(g);
		}
		
		if(moveLine != null) {
			moveLine.draw(g);
		}
		
		if(connectLines != null) {
			for(int i = connectLines.size()-1; i>=0;) {
				Shape Line = connectLines.get(i);
				Line.draw(g);
			}
		}
		
		if(selectGroup != null) {
			selectGroup.show(g);
		}
		
		if(draw_area != null) {
			g.setColor(new Color(192, 192, 192, 75));
			g.fillRect(selected_area.x, selected_area.y, selected_area.width, selected_area.height);
			g.setColor(new Color(192, 192, 192, 100));
			g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{16, 4}, 0));
			g.setColor(new Color(192, 192, 192));
			g.drawRect(selected_area.x, selected_area.y, selected_area.width, selected_area.height);
		}
		
    }
    
    public void renameObj(String name) {
		if(selectedObj != null){
			selectedObj.Rename(name);
			repaint();
		}
    }
    
    public void addObj(Shape obj) {
    	objects.add(obj);
	}
	
    
    
	public List<Shape> getShapeList() {
		return this.objects;
	}
	
    public void changeMode() {
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		listener = currentMode;
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}
    
    public void selectObjGroup() {
    	Group group = new Group();
		for (int i = 0; i < objects.size(); i++) {
			Shape shape = objects.get(i);
			if (shape.check_group == true) {
				group.addToGroup(shape);
				objects.remove(i);
				i--;
			}
		}
		objects.add(group);
		selectGroup = group;
	}
    
    public void unGroup() {
    	if(selectedObj instanceof Group) {
    		for(int i = selectedObj.shapes.size() - 1; i >= 0; i--) {
    			selectedObj.shapes.get(i).check_group = false;
    			objects.add(selectedObj.shapes.get(i));
    		}
    		objects.remove(selectedObj);
    	}
    }
}
