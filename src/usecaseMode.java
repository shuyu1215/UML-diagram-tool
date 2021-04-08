import java.awt.Color;
import java.awt.event.MouseEvent;

public class usecaseMode extends Mode{
	private Shape object;
    private Canvas canvas = Canvas.getInstance();
    
    public usecaseMode(){}
    
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    	int x1 = e.getX();
    	int y1 = e.getY();
		object = new usecaseObj(x1, y1);
		canvas.addObj(object);
		canvas.repaint();
	}
}
