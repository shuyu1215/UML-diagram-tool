import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;

public class generalizationLine extends Line{
	Point online;
	Point normal;
	public generalizationLine(int p_x1, int p_y1, int p_x2, int p_y2) {
		x1 = p_x1;
		y1 = p_y1;
		x2 = p_x2;
		y2 = p_y2;
		newLinePorts();
	}
	
	public void draw(Graphics g) {
		Point start = new Point(x1, y1);
		Point end = new Point(x2, y2);
		int dis = (int) start.distance(end);
		if(dis != 0) {
	        int size=8;
	        online = new Point(x2+size*(x1-x2)/dis,y2+size*(y1-y2)/dis);
	        normal = new Point(-size*(y2-y1)/dis,size*(x2-x1)/dis);
	        int x[]={x2,online.x+normal.x,online.x-normal.x};
	        int y[]={y2,online.y+normal.y,online.y-normal.y};
	        g.drawLine(x1, y1, x2, y2);
	        g.drawPolygon(x, y, 3);
		}
	}

}
