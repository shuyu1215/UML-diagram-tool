//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JButton;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class UML_homework extends JFrame {
//
//	private Canvas canvas;
//	private Menu menu;
//	private Button btn;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UML_homework frame = new UML_homework();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public UML_homework(){
//        setFrame();
//        setMenu();
//		setCanvas();
//		setButton();
//		
//    }
//	
//	public void setFrame() {
//		this.getContentPane().setLayout(new BorderLayout());
//		this.setTitle("UML editor");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(960, 720);
//        this.setLocationRelativeTo(null);
//	}
//	
//	public void setMenu() {
//		menu = new Menu();
//		this.getContentPane().add(menu, BorderLayout.NORTH);
//	}
//	
//	public void setCanvas() {
//		canvas = Canvas.getInstance();
//		this.getContentPane().add(canvas, BorderLayout.CENTER);
//	}
//	
//	public void setButton() {
//		btn = new Button();
//		this.getContentPane().add(btn, BorderLayout.WEST);
//	}
//}
