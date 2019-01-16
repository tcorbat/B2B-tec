package ch.b2btec.ui;

import ch.b2btec.ApplicationContext;

public class MainController {
	private MainFrame frame;
	private ApplicationContext context;
	
	public MainController(MainFrame frame, ApplicationContext context) {
		if (frame == null) {
			throw new IllegalArgumentException("frame must not be null.");
		}
		if (context == null) {
			throw new IllegalArgumentException("context must not be null.");
		}
		
		this.frame = frame;
		this.context = context;
	}

	public void show() {
		frame.setVisible(true);
	}
}

