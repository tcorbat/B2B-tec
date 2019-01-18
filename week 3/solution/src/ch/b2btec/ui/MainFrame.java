package ch.b2btec.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.b2btec.ApplicationContext;
import ch.b2btec.bl.OrderManagementService;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.ui.models.LoginModel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 5560027704969737784L;
	
	private JPanel contentPane;

	private final LoginPanel loginPanel;
	private ShopPanel shopPanel;

	/**
	 * Create the frame.
	 * @param context 
	 */
	public MainFrame(ApplicationContext context) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		LoginModel loginModel = new LoginModel(context.getUserManagement(),
				(customer) ->
				// JOptionPane.showMessageDialog(this, "Login successful " + customer.getName())
				showShopPanel(customer));
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
		shopPanel = new ShopPanel(customer, new OrderManagementService());
		setContentPane(shopPanel);
	}
}
