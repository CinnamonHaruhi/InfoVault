package studentInformationSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class InfoVault extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 762013407138968484L;
	private static Date currentDate = new Date();
	private static JLabel time = new JLabel(currentDate.toString());
	
	//Main panels
	CardLayout cardLayout = new CardLayout();
	JPanel mainPanel = new JPanel(cardLayout);
	JPanel dashboard = new JPanel();
	JPanel loginPanel = new JPanel();
	JPanel userTypePanel = new JPanel();
		
	//User type select components
	JPanel userTypeButtons = new JPanel();
	JLabel userTypeText = new JLabel("LOG IN AS");
	JButton adminButton = new JButton("Admin");
	JButton studentButton = new JButton("Student");
	
	//Login components
	JPanel loginArea = new JPanel();
	JLabel loginText = new JLabel("LOG IN");
	JLabel userIDLabel = new JLabel("Student Number:");
	JTextField userIDField = new JTextField();
	JLabel userPasswordLabel = new JLabel("Password:");
	JPasswordField userPasswordField = new JPasswordField();
	JButton loginButton = new JButton("Log in"); 
	
	//Dashboard components
	JLabel welcomeText = new JLabel("Welcome to InfoVault!");
	JPanel topBar = new JPanel();
	JLabel logoPlaceholder = new JLabel("InfoVault");
	JPanel searchBar = new JPanel();
	JButton searchButton = new JButton("Search");
	JTextField searchTextField = new JTextField();
	JButton notifsButton = new JButton("!");
	
	JPanel mainArea = new JPanel();
	JPanel topMainArea = new JPanel();
	JPanel mainAreaButtons = new JPanel();
	JButton addNewButton = new JButton("Add New Student");
	JButton editInfoButton = new JButton("Edit Student Info");
	JButton deleteButton = new JButton("Delete Student");
	JPanel sideMainArea = new JPanel();
	JLabel updateTitle = new JLabel("Recent Activity");
	JPanel updatesArea = new JPanel();
	JLabel updateText = new JLabel("No updates yet");
	JScrollPane updatesScroll = new JScrollPane(updatesArea);

	JPanel sideBar = new JPanel();
	JPanel profileArea = new JPanel();
	JLabel userName = new JLabel();
	ImageIcon userIcon = new ImageIcon("userIcon100x100.png");
	JPanel buttonArea = new JPanel();
	JButton dashboardButton = new JButton("DASHBOARD");
	JButton recordsButton = new JButton("STUDENT RECORDS");
	JButton quickAddButton = new JButton("ADD NEW");
	JPanel bottomButtonArea = new JPanel();
	JButton settingsButton = new JButton("Settings");
	JButton logoutButton = new JButton("Log out");

	InfoVault() {
		setTitle("InfoVault");
		setSize(950, 600);
		setMinimumSize(new Dimension(950, 600));
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//USER TYPE
		userTypePanel.setLayout(new GridBagLayout());
		GridBagConstraints ugbc = new GridBagConstraints();
		userTypePanel.setBackground(Color.decode("#193d3d"));
	
		userTypeText.setFont(new Font("Monospace", Font.BOLD, 30));
		userTypeText.setForeground(Color.WHITE);
		
		ugbc.gridy = 0;
		ugbc.gridx = 0;
		ugbc.insets = new Insets(0, 0, 30, 0);
		userTypePanel.add(userTypeText, ugbc);
		
		userTypeButtons.setLayout(new GridLayout(1, 2, 30, 0));
		userTypeButtons.setBackground(Color.decode("#193d3d"));

		adminButton.setBackground(Color.decode("#2B2D42"));
		adminButton.setFocusable(false);
		adminButton.setFont(new Font("Monospace", Font.PLAIN, 30));
		adminButton.setForeground(Color.WHITE);
		adminButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		userTypeButtons.add(adminButton);
		
		studentButton.setBackground(Color.decode("#2B2D42"));
		studentButton.setFocusable(false);
		studentButton.setFont(new Font("Monospace", Font.PLAIN, 30));
		studentButton.setForeground(Color.WHITE);
		studentButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		userTypeButtons.add(studentButton);
		
		ugbc.gridy = 1;
		userTypePanel.add(userTypeButtons, ugbc);
		
		//LOGIN
		loginPanel.setLayout(new BorderLayout());
		loginArea.setLayout(new GridBagLayout());
		loginArea.setBackground(Color.decode("#193d3d"));
		GridBagConstraints lgbc = new GridBagConstraints();
		
		loginText.setFont(new Font("Monospace", Font.BOLD, 30));
		loginText.setForeground(Color.WHITE);
		lgbc.gridy = 0;
		lgbc.gridx = 0;
		lgbc.insets = new Insets(10, 10, 20, 10);
		loginArea.add(loginText, lgbc);
		
		userIDLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		userIDLabel.setForeground(Color.WHITE);
		lgbc.gridy = 1;
		lgbc.gridx = 0;	
		lgbc.insets = new Insets(0, 0, 5, 0);
		lgbc.anchor = GridBagConstraints.WEST;
		loginArea.add(userIDLabel, lgbc);
		
		lgbc.gridy = 2;
		lgbc.gridx = 0;		
		lgbc.insets = new Insets(0, 0, 10, 0);
		userIDField.setPreferredSize(new Dimension(300, 40));
		loginArea.add(userIDField, lgbc);
		
		userPasswordLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		userPasswordLabel.setForeground(Color.WHITE);
		lgbc.gridy = 3;
		lgbc.gridx = 0;	
		lgbc.insets = new Insets(0, 0, 5, 0);
		loginArea.add(userPasswordLabel, lgbc);

		lgbc.gridy = 4;
		lgbc.gridx = 0;	
		lgbc.insets = new Insets(0, 0, 10, 0);
		userPasswordField.setPreferredSize(new Dimension(300, 40));
		loginArea.add(userPasswordField, lgbc);
		
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.decode("#2B2D42"));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
		lgbc.gridy = 5;
		lgbc.gridx = 0;
		lgbc.ipady = 20;
		lgbc.ipadx = 30;
		lgbc.anchor = GridBagConstraints.CENTER;
		lgbc.insets = new Insets(10, 0, 0, 0);
		loginArea.add(loginButton, lgbc);
		loginPanel.add(loginArea, BorderLayout.CENTER);
		
		//DASHBOARD
		dashboard.setLayout(new BorderLayout());
		dashboard.add(topBar, BorderLayout.NORTH);
		topBar.setLayout(new GridBagLayout());
		topBar.setBackground(Color.decode("#2B2D42"));
		GridBagConstraints gbc = new GridBagConstraints();
		topBar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#1b1d30")),
				BorderFactory.createEmptyBorder(30, 20, 30, 20)
				));
		logoPlaceholder.setFont(new Font("Monospace", Font.BOLD, 25));
		logoPlaceholder.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.15;
		topBar.add(logoPlaceholder, gbc);
		searchBar.setBackground(Color.decode("#2B2D42"));
		searchButton.setBackground(Color.decode("#457171"));
		searchButton.setForeground(Color.WHITE);
		searchButton.setFocusable(false);
		searchButton.setBorder(BorderFactory.createRaisedBevelBorder());
		searchButton.setPreferredSize(new Dimension(100, 30));
		searchTextField.setMaximumSize(new Dimension(500, 30));
		searchTextField.setMinimumSize(new Dimension(300, 30));
		searchTextField.setPreferredSize(searchTextField.getMaximumSize());
	
		searchBar.add(searchTextField);
		searchBar.add(searchButton);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.7;
		topBar.add(searchBar, gbc);
		
		notifsButton.setBackground(Color.decode("#457171"));
		notifsButton.setForeground(Color.WHITE);
		notifsButton.setFocusable(false);
		notifsButton.setBorder(BorderFactory.createRaisedBevelBorder());
		notifsButton.setPreferredSize(new Dimension(30, 30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.15;
		topBar.add(notifsButton, gbc);
		
		mainArea.setLayout(new BorderLayout());
		mainArea.setBackground(Color.decode("#326060"));
		
		topMainArea.setLayout(new GridBagLayout());
		topMainArea.setPreferredSize(new Dimension(300, 150));
		GridBagConstraints tgbc = new GridBagConstraints();
		topMainArea.setBackground(Color.decode("#193d3d"));
		topMainArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(10, 10, 10, 10, Color.decode("#326060")),
				BorderFactory.createMatteBorder(2, 10, 2, 2, Color.WHITE)
				));
		
		welcomeText.setForeground(Color.WHITE);
		welcomeText.setFont(new Font("Monospace", Font.BOLD, 20));
		tgbc.gridx = 0;
		tgbc.gridy = 0;
		tgbc.insets = new Insets(10, 10, 10, 10);
		topMainArea.add(welcomeText, tgbc);
		
		time.setFont(new Font("Monospace", Font.PLAIN, 18));
		time.setForeground(Color.WHITE);
		tgbc.gridx = 0;
		tgbc.gridy = 1;
		tgbc.insets = new Insets(0, 10, 10, 10);
		topMainArea.add(time, tgbc);
		
		mainAreaButtons.setLayout(new GridBagLayout());
		GridBagConstraints maingbc = new GridBagConstraints();
		mainAreaButtons.setBackground(Color.decode("#326060"));
		
		addNewButton.setFocusable(false);
		addNewButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		addNewButton.setBackground(Color.decode("#2B2D42"));
		addNewButton.setForeground(Color.WHITE);
		addNewButton.setBorder(BorderFactory.createRaisedBevelBorder());
		maingbc.gridx = 0;
		maingbc.gridy = 0;
		maingbc.ipady = 200;
		maingbc.ipadx = 200;
		maingbc.weightx = 0.5;
		maingbc.weighty = 0.5;
		maingbc.insets = new Insets(10, 10, 10, 10);
		maingbc.fill = GridBagConstraints.HORIZONTAL;
		mainAreaButtons.add(addNewButton, maingbc);
		
		editInfoButton.setFocusable(false);
		editInfoButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		editInfoButton.setBackground(Color.decode("#2B2D42"));
		editInfoButton.setForeground(Color.WHITE);
		editInfoButton.setBorder(BorderFactory.createRaisedBevelBorder());
		maingbc.gridx = 1;
		maingbc.gridy = 0;
		mainAreaButtons.add(editInfoButton, maingbc);
		
		deleteButton.setFocusable(false);
		deleteButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		deleteButton.setBackground(Color.decode("#2B2D42"));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setBorder(BorderFactory.createRaisedBevelBorder());
		maingbc.gridx = 0;
		maingbc.gridy = 1;
		mainAreaButtons.add(deleteButton, maingbc);
		
		sideMainArea.setLayout(new BoxLayout(sideMainArea, BoxLayout.Y_AXIS));
		sideMainArea.setPreferredSize(new Dimension(300, 300));
		sideMainArea.setMinimumSize(new Dimension(100, 100));
		sideMainArea.setMaximumSize(sideMainArea.getPreferredSize());
		sideMainArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 10, 10, 10, Color.decode("#326060")),
				BorderFactory.createMatteBorder(10, 2, 2, 2, Color.WHITE)
				));
		sideMainArea.setBackground(Color.decode("#193d3d"));
		
		updateTitle.setFont(new Font("Monospace", Font.BOLD, 20));
		updateTitle.setForeground(Color.WHITE);
		updateTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
		sideMainArea.add(updateTitle);
		
		updatesArea.setLayout(new BoxLayout(updatesArea, BoxLayout.Y_AXIS));
		updatesArea.setBackground(Color.decode("#193d3d"));
		updatesArea.setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 20));
		updateText.setFont(new Font("Monospace", Font.PLAIN, 15));
		updateText.setForeground(Color.WHITE);
		
		updatesArea.add(updateText);
		updatesArea.add(new JSeparator());
		
		updatesScroll.setBorder(null);
		sideMainArea.add(updatesScroll);
				
		mainArea.add(mainAreaButtons, BorderLayout.CENTER);
		mainArea.add(topMainArea, BorderLayout.NORTH);
		mainArea.add(sideMainArea, BorderLayout.EAST);
		
		sideBar.setLayout(new GridLayout(3, 1, 0, 0));
		sideBar.setBackground(Color.decode("#457171"));
		sideBar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 0, 3, Color.decode("#193d3d")),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));	
		
		profileArea.setLayout(new GridBagLayout());
		profileArea.setBackground(Color.decode("#457171"));
		userName.setText("User");
		userName.setFont(new Font("Monospace", Font.BOLD, 25));
		userName.setForeground(Color.WHITE);
		userName.setIcon(userIcon);
		profileArea.add(userName);
		
		buttonArea.setLayout(new GridLayout(3, 1, 0, 10));
		buttonArea.setBackground(Color.decode("#457171"));
		
		dashboardButton.setFocusable(false);
		dashboardButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		dashboardButton.setBackground(Color.decode("#2B2D42"));
		dashboardButton.setForeground(Color.WHITE);
		dashboardButton.setBorder(BorderFactory.createRaisedBevelBorder());
		buttonArea.add(dashboardButton);
		
		recordsButton.setFocusable(false);
		recordsButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		recordsButton.setBackground(Color.decode("#2B2D42"));
		recordsButton.setForeground(Color.WHITE);
		recordsButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		buttonArea.add(recordsButton);
		
		quickAddButton.setFocusable(false);
		quickAddButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		quickAddButton.setBackground(Color.decode("#2B2D42"));
		quickAddButton.setForeground(Color.WHITE);
		quickAddButton.setBorder(BorderFactory.createRaisedBevelBorder());
		buttonArea.add(quickAddButton);
		
		bottomButtonArea.setLayout(new GridBagLayout());
		bottomButtonArea.setBackground(Color.decode("#457171"));
		settingsButton.setFocusable(false);
		settingsButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		settingsButton.setBackground(Color.decode("#2B2D42"));
		settingsButton.setForeground(Color.WHITE);
		settingsButton.setBorder(BorderFactory.createRaisedBevelBorder());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 10;
		gbc.ipadx = 10;
		gbc.insets = new Insets(0, 0, 0, 10);
		bottomButtonArea.add(settingsButton, gbc);
		logoutButton.setFocusable(false);
		logoutButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		logoutButton.setBackground(Color.decode("#2B2D42"));
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setBorder(BorderFactory.createRaisedBevelBorder());
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 10, 0, 0);
		bottomButtonArea.add(logoutButton, gbc);
		
		sideBar.add(profileArea);
		sideBar.add(buttonArea);
		sideBar.add(bottomButtonArea);
		
		dashboard.add(topBar, BorderLayout.NORTH);
		dashboard.add(mainArea, BorderLayout.CENTER);
		dashboard.add(sideBar, BorderLayout.WEST);
		
		mainPanel.add(userTypePanel, "usertype");
		mainPanel.add(dashboard, "dashboard");
		mainPanel.add(loginPanel, "login");
		
		add(mainPanel);
		cardLayout.show(mainPanel, "usertype");
		
		//ACTION LISTENERS 
		adminButton.addActionListener((e) -> {
			cardLayout.show(mainPanel, "login");
		});
		
		studentButton.addActionListener((e) -> {
			cardLayout.show(mainPanel, "login");
		});
		
		loginButton.addActionListener((e) -> {
			handleLogin();
		});
		
		logoutButton.addActionListener((e) -> {
			int confirmLogout = JOptionPane.showConfirmDialog(this, 
					"Are you sure you want to log out?", 
					"Confirm", JOptionPane.YES_NO_OPTION);
			if (confirmLogout == 0) {
				cardLayout.show(mainPanel, "login");
			}
		});
		
		revalidate();
		repaint();
	}
	
	public static void main(String[] args) {
		new InfoVault();
		
		ActionListener updateTime = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time.setText(new Date().toString());
			}
		};
		Timer t = new Timer(1000, updateTime);
		t.start();
	}

	void handleLogin() {
	        String userID = userIDField.getText();
	        String password = new String(userPasswordField.getPassword());
	        if (userID.trim().isEmpty() || password.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, 
	            		"Fill in the required fields", 
	            		"Login Failed", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        if (!userID.equals("12345") || !password.equals("admin123")) {
	            JOptionPane.showMessageDialog(this, 
	            		"Invalid Credentials", 
	            		"Login Failed", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
		JOptionPane.showMessageDialog(this, "Login Successful!");
		userName.setText(userID);
		welcomeText.setText("Welcome to InfoVault, " + userID);
        	cardLayout.show(mainPanel, "dashboard");
}
