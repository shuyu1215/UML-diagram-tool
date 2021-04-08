import java.awt.Graphics;

public class usecaseObj extends BasicObj{
	private int nameWidth;
	private float space;
	private int x_abs;
	public usecaseObj(int X, int Y) {
		x1 = X;
		y1 = Y;
		width = 110;
		height = 65;
		x2 = x1 + width;
		y2 = y1 + height;
		this.objectName = "useCase";
		newObjPorts();
	}
	
	public void draw(Graphics g) {
		g.drawOval(x1, y1, width, height);
		nameString(g);
	}
	
	public void nameString(Graphics g) {
		nameWidth = g.getFontMetrics(font).stringWidth(objectName);
		x_abs = Math.abs(x1-x2);
		space = (x_abs - nameWidth)/2;
		space = (int)space;
		g.setFont(font);
		g.drawString(objectName, x1+(int)space, y1+36);
	}
	
}
