import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JMenuBar{
	private Canvas canvas = Canvas.getInstance();
	
	public Menu() {
		JMenu menu;
		menu = new JMenu("File");
		add(menu);
		menu = new JMenu("Tool");
		add(menu);
		JMenuItem mItem;
		JMenuItem mItem1;
		JMenuItem mItem2;
		mItem = new JMenuItem("Rename");
		mItem1 = new JMenuItem("Group");
		mItem2 = new JMenuItem("Ungroup");
		menu.add(mItem);
		menu.add(mItem1);
		menu.add(mItem2);
		mItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	renameWindow();
            }
        });
		mItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.selectObjGroup();
			}
		});
		mItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.unGroup();
			}
		});
	}
	
	private void renameWindow() {
		JFrame renameFrame = new JFrame("Rename");
		JPanel panel = null;
		JTextField enterField;
		JButton OK;
		renameFrame.setSize(300, 100);
		renameFrame.getContentPane().setLayout(new GridLayout(0, 1));
		
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		enterField =  new JTextField();
		panel.add(enterField);
		renameFrame.getContentPane().add(panel);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		OK = new JButton("OK");
		panel.add(OK);
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.renameObj(enterField.getText());
				renameFrame.dispose();
				
			}
		});
		renameFrame.getContentPane().add(panel);
		renameFrame.setLocationRelativeTo(null);
		renameFrame.setVisible(true);
	}
}
