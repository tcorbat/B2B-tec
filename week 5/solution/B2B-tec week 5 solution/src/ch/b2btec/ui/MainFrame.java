package ch.b2btec.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.b2btec.ApplicationContext;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.ui.models.LoginModel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 5560027704969737784L;
	
	private JPanel contentPane;

	private final LoginPanel loginPanel;
	private ApplicationPanel shopPanel;

	private ApplicationContext context;

	/**
	 * Create the frame.
	 * @param context 
	 */
	public MainFrame(ApplicationContext context) {
		this.context = context;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("B2B-tec");
		LoginModel loginModel = new LoginModel(context.getUserManagement(),
				(customer) -> {
					setTitle("B2B-tec - User: " + customer.getName());
					showShopPanel(customer);
				});
		loginPanel = new LoginPanel(loginModel);
		contentPane = loginPanel;
		setContentPane(contentPane);
	}

	public void showLoginScreen() {
		loginPanel.setVisible(true);
	}

	public void hideLoginScreen() {
		loginPanel.setVisible(false);
	}

	public void showShopPanel(Customer customer) {
		hideLoginScreen();
		shopPanel = new ApplicationPanel(customer, context.getOrderManagement(), context.getCatalogManagement(),
				context.getUserManagement());
		setBounds(getX(), getY(), 1024, 768);
		setContentPane(shopPanel);
	}
}
