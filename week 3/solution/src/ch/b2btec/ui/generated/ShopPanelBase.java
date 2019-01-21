package ch.b2btec.ui.generated;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ch.b2btec.bl.OrderManagement;
import ch.b2btec.bl.domain.Customer;

public class ShopPanelBase extends JPanel {
	private static final long serialVersionUID = -7443063218232359943L;

	public ShopPanelBase(Customer customer, OrderManagement orderManagement) {
		setLayout(new BorderLayout(5, 5));

		JPanel overview = createOverviewPanel(customer, orderManagement);
		add(overview, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		add(tabbedPane);

		JPanel shopTab = createShopTab();
		tabbedPane.addTab("Shop", null, shopTab, null);

		JPanel ordersTab = createOrdersTab();
		tabbedPane.addTab("Orders", null, ordersTab, null);

		JPanel profileTab = createProfileTab(customer);
		tabbedPane.addTab("Profile", null, profileTab, null);

		JPanel panel_1 = createBottomPanel();
		add(panel_1, BorderLayout.SOUTH);
	}

	public ShopPanelBase() {
		this(null, null);
	}

	protected JPanel createOverviewPanel(Customer customer, OrderManagement orderManagement) {
		return new JPanel();
	}

	protected JPanel createShopTab() {
		return new JPanel();
	}

	protected JPanel createOrdersTab() {
		return new JPanel();
	}

	protected JPanel createProfileTab(Customer customer) {
		return new JPanel();
	}

	protected JPanel createBottomPanel() {
		JPanel bottomPanel = new JPanel();
		JButton btnLogout = new JButton("Logout");
		bottomPanel.add(btnLogout);

		JButton btnExit = new JButton("Exit");
		bottomPanel.add(btnExit);
		btnExit.addActionListener(event -> {
			Arrays.stream(JFrame.getFrames()).filter(JFrame.class::isInstance).map(JFrame.class::cast)
					.forEach(frame -> {
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.dispose();
					});
		});
		return bottomPanel;
	}

}
