import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Button extends JPanel{
    JButton[] buttons;
    private JButton selectBtn;
    private JButton associateBtn;
    private JButton generalBtn;
    private JButton compositeBtn;
    private JButton classBtn;
    private JButton usecaseBtn;
    private Canvas canvas;
    public ClassObj test;
    private Mode class_mode;
    private Mode usecase_mode;
    private Mode select_mode;
    private Mode associate_mode;
    private Mode general_mode;
    private Mode composite_mode;
    
    public Button(){
    	setLayout(new GridLayout(6, 1, 2, 2));
        buttons = new JButton[6];
        canvas = Canvas.getInstance();
        //this.setBackground(new Color(83, 85, 87));
        setButton();
        this.setOpaque(false);
    }

    private void setButton(){
        selectBtn = new JButton("select");
        buttons[0] = selectBtn;

		associateBtn = new JButton("associate");
        buttons[1] = associateBtn;

		generalBtn = new JButton("general");
        buttons[2] = generalBtn;

        compositeBtn = new JButton("composite");
		buttons[3] = compositeBtn;

		classBtn = new JButton("class");
		buttons[4] = classBtn;
		
		usecaseBtn = new JButton("usecase");
        buttons[5] = usecaseBtn;

        for(int i = 0; i < 6; i++){
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setBackground(Color.BLACK);
            this.add(buttons[i]);
        }
        ButtonSelect();
    }
    
    private void setButtonImg() {
    	ImageIcon selectImg = new ImageIcon("selectImg.png");
        ImageIcon associateImg = new ImageIcon("img/associate.jpg");
        ImageIcon generalImg = new ImageIcon("img/general.png");
		ImageIcon compositeImg = new ImageIcon("img/composite.png");
        ImageIcon classImg = new ImageIcon("img/class.png");
        ImageIcon usecaseImg = new ImageIcon("img/usecase.png");
    }
    
    private void ButtonSelect() {
    	buttons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	changeBtnColor(0);
            	select_mode = new selectMode();
            	canvas.currentMode = select_mode;
            	canvas.changeMode();
            }
        });
			
    	buttons[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeBtnColor(1);
				associate_mode = new AssociationMode();
				canvas.currentMode = associate_mode;
				canvas.changeMode();
			}
		});
    	buttons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	changeBtnColor(2);
            	general_mode = new generalizationMode();
            	canvas.currentMode = general_mode;
            	canvas.changeMode();
            }
        });
    	buttons[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	changeBtnColor(3);
            	composite_mode = new compositionMode();
            	canvas.currentMode = composite_mode;
            	canvas.changeMode();
            }
        });
    	buttons[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	changeBtnColor(4);
            	class_mode = new ClassMode();
            	canvas.currentMode = class_mode;
            	canvas.changeMode();
            }
        });
    	buttons[5].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	changeBtnColor(5);
            	usecase_mode = new usecaseMode();
            	canvas.currentMode = usecase_mode;
            	canvas.changeMode();
            }
        });
    }
    
    
    public void changeBtnColor(int n) {
    	for(int i = 0; i < 6; i++){
			buttons[i].setForeground(Color.BLACK);
		}
		buttons[n].setForeground(Color.RED);
		canvas.repaint();
    }
    
}