import java.awt.Graphics;
import java.awt.Point;

public class AssociationLine extends Line{
	Point online;
	Point normal_L;
	Point normal_R;
	int size = 10;
	public AssociationLine(){}
	
	public AssociationLine(int p_x1, int p_y1, int p_x2, int p_y2) {
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
			online = new Point(x2+size*(x1-x2)/dis,y2+size*(y1-y2)/dis);
	        normal_R = new Point(-size*(y2-y1)/dis,size*(x2-x1)/dis);
	        normal_L = new Point(size*(y2-y1)/dis,-size*(x2-x1)/dis);
	        int R_x[]={x2,online.x+normal_R.x,online.x-normal_R.x};
	        int R_y[]={y2,online.y+normal_R.y,online.y-normal_R.y};
	        int L_x[]={x2,online.x+normal_L.x,online.x-normal_L.x};
	        int L_y[]={y2,online.y+normal_L.y,online.y-normal_L.y};
	        g.drawLine(x1, y1, x2, y2);
	        g.drawPolygon(R_x, R_y, 2);
	        g.drawPolygon(L_x, L_y, 2);  
		}
	}

}
