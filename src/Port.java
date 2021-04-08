import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Port extends Rectangle{
	private List<Line> lines = new ArrayList<Line>(); 

	public void setPort(int point_x, int point_y, int offset) {
		int x = point_x - offset;
		int y = point_y - offset;
		int w = offset * 2;
		int h = offset * 2;
		setBounds(x, y, w, h);
	}
	
	public void addLine(Line line) {
		lines.add(line);
	}
	
	public void removeLine(Line line) {
		lines.remove(line);
	}
	
}