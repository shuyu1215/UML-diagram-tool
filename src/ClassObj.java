import java.awt.Graphics;

public class ClassObj extends BasicObj{
	private int segment;
	private int nameWidth;
	private float space;
	private int x_abs;
	public ClassObj(int X, int Y) {
		width = 90;
		height = 120;
		x1 = X;
		y1 = Y;
		x2 = x1 + width;
		y2 = y1 + height;
		this.objectName = "Class";
		newObjPorts();
	}
	
	public void draw(Graphics g) {
		segment = height / 3;
		g.drawRect(x1, y1, width, height);
		g.drawLine(x1, y1+segment, x2, y1+segment);
		g.drawLine(x1, y1+segment*2, x2, y1+segment*2);
		nameString(g);
	}
	
	public void nameString(Graphics g) {
		nameWidth = g.getFontMetrics(font).stringWidth(objectName);
		x_abs = Math.abs(x1-x2);
		space = (x_abs - nameWidth)/2;
		space = (int)space;
		g.setFont(font);
		g.drawString(objectName, x1 + (int)space, y1 + 25);
	}
	
}