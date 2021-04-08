import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class compositionLine extends Line{
	Point online;
	Point normal_L;
	Point normal_R;
	
	public compositionLine(int p_x1, int p_y1, int p_x2, int p_y2) {
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
        int size=8;
        if(dis != 0) {
	        Point online = new Point(end.x+size*(start.x-end.x)/dis,end.y+size*(start.y-end.y)/dis);
	        Point twoonline = new Point(end.x+size*2*(start.x-end.x)/dis,end.y+size*2*(start.y-end.y)/dis);
	        Point normal = new Point(-size*(end.y-start.y)/dis,size*(end.x-start.x)/dis);
	        int x[]={end.x,online.x+normal.x,twoonline.x,online.x-normal.x};
	        int y[]={end.y,online.y+normal.y,twoonline.y,online.y-normal.y};
	        g.drawLine(start.x,start.y,twoonline.x,twoonline.y);
	        g.drawPolygon(x, y, 4);
        }
	}
}
