package ch.b2btec.ui;

import ch.b2btec.ApplicationContext;
import ch.b2btec.ui.MainFrame;

public class MainController {
	private MainFrame frame;
	private ApplicationContext context;
	
	public MainController(MainFrame frame, ApplicationContext context) {
		if (frame == null) { throw new IllegalArgumentException("frame mustn't be null."); }
		if (context == null) { throw new IllegalArgumentException("context mustn't be null."); }
		
		this.frame = frame;
		this.context = context;
	}

	public void show() {
		frame.setVisible(true);
	}
}

