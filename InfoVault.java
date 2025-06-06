package studentInformationSystem;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import java.util.Date;

public class InfoVault extends JFrame{
	/**
	 * 
	 */	
	private static final long serialVersionUID = 762013407138968484L;
	private static Date currentDate = new Date();
	private static JLabel time = new JLabel(currentDate.toString());
	private ImageIcon logo = new ImageIcon("systemLogo32x32.png");
	private boolean isAdmin;

	//Main panels
	CardLayout cardLayout = new CardLayout();
	JPanel mainPanel = new JPanel(cardLayout);
	JPanel dashboard = new JPanel();
	JPanel studentDashboard = new JPanel();
	JPanel loginPanel = new JPanel();
	JPanel userTypePanel = new JPanel();
	JPanel registerPanel = new JPanel();
	
	//Register components
	JPanel registerArea = new JPanel();
	JLabel registerTitle = new JLabel("REGISTER");
	JLabel regFirstName = new JLabel("First Name:");
	JTextField regFnameField = new JTextField();
	JLabel regLastName = new JLabel("Last Name:");
	JTextField regLnameField = new JTextField();
	JLabel studentNum = new JLabel("Student Number:");
	JTextField studentNumField = new JTextField();
	JLabel regPasswordLabel = new JLabel("Password:");
	JPasswordField regPasswordField = new JPasswordField();
	JLabel passwordConfirmLabel = new JLabel("Confirm Password:");
	JPasswordField regPassConfirmField = new JPasswordField();
	JButton registerButton = new JButton("Register");
	JButton regBackButton = new JButton("Back"); 
	JPanel regButtonArea = new JPanel();
	
	//User type select components
	JLabel userTypeLogo = new JLabel();
	JPanel userTypeButtons = new JPanel();
	JLabel userTypeText = new JLabel("LOG IN AS");
	JButton adminButton = new JButton("Admin");
	JButton studentButton = new JButton("Student");
	JPanel registerLabelArea = new JPanel();
	JLabel registerLabel = new JLabel("Don't have an account? ");
	JButton registerLink = new JButton("Register here!");
	
	//Login components
	JPanel loginArea = new JPanel();
	JLabel loginText = new JLabel("LOG IN");
	JLabel userIDLabel = new JLabel("Student Number:");
	JTextField userIDField = new JTextField();
	JLabel userPasswordLabel = new JLabel("Password:");
	JPasswordField userPasswordField = new JPasswordField();
	JButton loginButton = new JButton("Log in"); 
	JButton loginBackButton = new JButton("Back");
	
	//Dashboard components
	CardLayout dashboardCardLayout = new CardLayout();
	JPanel mainArea = new JPanel(dashboardCardLayout);
	
	JLabel welcomeText = new JLabel("Welcome to InfoVault!");
	JPanel topBar = new JPanel();
	JLabel logoPlaceholder = new JLabel("InfoVault");
	JPanel searchBar = new JPanel();
	JButton searchButton = new JButton("Search");
	JTextField searchTextField = new JTextField();
	JButton notifsButton = new JButton("!");
	
	JPanel mainAreaHome = new JPanel();
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
	
	//
	JPanel mainAreaAdd = new JPanel();
	
	JPanel mainAreaAddInfo = new JPanel();
	JLabel studentIDLabel = new JLabel("Student ID:");
	JTextField studentIDField = new JTextField();
	JLabel firstNameLabel = new JLabel("First name:");
	JTextField firstNameField = new JTextField();
	JLabel middleNameLabel = new JLabel("Middle name:");
	JTextField middleNameField = new JTextField();
	JLabel lastNameLabel = new JLabel("Last name:");
	JTextField lastNameField = new JTextField();
	
	JPanel sexOptions = new JPanel();
	JLabel sexLabel = new JLabel("Sex:");
	ButtonGroup sexButtonOptions = new ButtonGroup();
	JRadioButton sexOptionFemale = new JRadioButton("Female");
	JRadioButton sexOptionMale = new JRadioButton("Male");
	JRadioButton sexOptionOther = new JRadioButton("Other");
	
	JLabel birthDateLabel = new JLabel("Birth date:");
	JSpinner birthDateSelect;
		
	JLabel strandLabel = new JLabel("Strand:");
	String[] strandArray = {"STEM",
							"ABM",
							"HUMMS",
							"GAS",
							"HE",
							"ICT"};
	JComboBox<?> strandList = new JComboBox<Object>(strandArray);
	JLabel yearEnrolledLabel = new JLabel("Year enrolled:");
	JSpinner yearEnrolledSelect;
	JLabel yearLevelLabel = new JLabel("Year level:");
	JLabel currentSemLabel = new JLabel("Semester:");
	String[] semArray = {"Semester 1", "Semester 2"};
	JComboBox<?> semList = new JComboBox<Object>(semArray);
	JPanel mainAreaAddButtons = new JPanel();
	JButton addStudent = new JButton("Add");
	JButton backButton = new JButton("Back");
	JLabel tempPassLabel = new JLabel("Temporary password:");
	JTextField tempPassField = new JTextField();
	//
	
	//
	JPanel mainAreaEdit = new JPanel();
	JScrollPane editTableScroll;
	JTable editTable;
	JButton editButton = new JButton("Edit");
	JTextField idField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField mnameField = new JTextField();
	JTextField lnameField = new JTextField();
	JSpinner bdaySelectE;
	JComboBox<?> strandListE = new JComboBox<Object>(strandArray);
	JSpinner yearSelectE;
	JComboBox<?> semListE = new JComboBox<Object>(semArray);
	JTextField passFieldE = new JTextField();
	JPanel sexOptionsE = new JPanel();
	ButtonGroup sexButtonOptionsE = new ButtonGroup();
	JRadioButton sexOptionFemaleE = new JRadioButton("Female");
	JRadioButton sexOptionMaleE = new JRadioButton("Male");
	JRadioButton sexOptionOtherE = new JRadioButton("Other");
	JButton submitEditButton = new JButton("Submit");
	String idToEdit;
	JPanel editButtonArea = new JPanel();
	//

	//
	JPanel mainAreaDelete = new JPanel();
	JScrollPane deleteTableScroll;
	JTable deleteTable;
	JPanel deleteRowButtonArea = new JPanel();
	JButton deleteRowButton = new JButton("Delete");
	//
	
	JPanel studentRecords = new JPanel();
	JScrollPane recordsTableScroll;
	JTable recordsTable;
 
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
	
	//Student dashboard components
	JLabel topBarText = new JLabel("InfoVault");
	CardLayout cardLayout2 = new CardLayout();
	JPanel studentMainPanel = new JPanel(cardLayout2);
	JPanel studentInfoPanel = new JPanel();
	JPanel studentInfoArea = new JPanel();
	JPanel studentGreet = new JPanel();
	JPanel studentTopBar = new JPanel();
	JLabel studentWelcomeText = new JLabel();
	JPanel studentProfile = new JPanel();
	JLabel studentUser = new JLabel();
	JLabel studentUserIcon = new JLabel();
	
	JPanel studentSideBar = new JPanel();
	JPanel studentSideBarButtons = new JPanel();
	JButton editMyInfoButton = new JButton("EDIT INFO");
	JButton changePasswordButton = new JButton("CHANGE PASSWORD");
	JButton studentLogoutButton = new JButton("LOG OUT");
	
	JLabel studentNameLabel = new JLabel("Name:");
	JLabel studentName = new JLabel();
	JLabel studentMnameLabel = new JLabel("Middle name:");
	JLabel studentMname = new JLabel();
	JLabel studentLnameLabel = new JLabel("Last name:");
	JLabel studentLname = new JLabel();
	JLabel studentSexLabel = new JLabel("Sex:");
	JLabel studentSex = new JLabel();
	JLabel studentBdayLabel = new JLabel("Birthday:");
	JLabel studentBday = new JLabel();
	JLabel studentStrandLabel = new JLabel("Strand:");
	JLabel studentStrand = new JLabel();
	JLabel studentYenrolledLabel = new JLabel("Year enrolled:");
	JLabel studentYenrolled = new JLabel();
	JLabel studentSemLabel = new JLabel("Semester:");
	JLabel studentSem = new JLabel(); 
	
	//Student dashboard edit components
	JButton submitEditButtonS = new JButton("Submit");
	JTextField idFieldS = new JTextField();
	JTextField nameFieldS = new JTextField();
	JTextField mnameFieldS = new JTextField();
	JTextField lnameFieldS = new JTextField();
	JPanel sexOptionsS = new JPanel();
	ButtonGroup sexButtonOptionsS = new ButtonGroup();
	JRadioButton sexOptionFemaleS = new JRadioButton("Female");
	JRadioButton sexOptionMaleS = new JRadioButton("Male");
	JRadioButton sexOptionOtherS = new JRadioButton("Other");
	JSpinner bdaySelectS;
	JComboBox<?> strandListS = new JComboBox<Object>(strandArray);
	JSpinner yearSelectS;
	JComboBox<?> semListS = new JComboBox<Object>(semArray);
	
	//Student dashboard change password components
	JTextField oldPassField = new JTextField();
	JTextField newPassField = new JTextField();
	JTextField confirmPassField = new JTextField();
	JButton changePassButton = new JButton("Change password");
	
	InfoVault() {
		setTitle("InfoVault");
		setIconImage(logo.getImage());
		setSize(950, 600);
		setMinimumSize(new Dimension(950, 600));
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//CALENDAR MODEL
		Calendar calendar = Calendar.getInstance();
		Date initialDate = calendar.getTime();
		calendar.add(Calendar.YEAR, -100);
		Date earliestDate = calendar.getTime();
		calendar.add(Calendar.YEAR, 300);
		Date latestDate = calendar.getTime();
		SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);
		birthDateSelect = new JSpinner(dateModel);
		birthDateSelect.setEditor(new JSpinner.DateEditor(birthDateSelect, "yyy-MM-dd"));
		SpinnerDateModel dateModel2 = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);
		yearEnrolledSelect = new JSpinner(dateModel2);
		yearEnrolledSelect.setEditor(new JSpinner.DateEditor(yearEnrolledSelect, "yyyy"));
		SpinnerDateModel dateModel3 = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);
		bdaySelectE = new JSpinner(dateModel3);
		SpinnerDateModel dateModel4 = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);
		yearSelectE = new JSpinner(dateModel4);
		SpinnerDateModel dateModel5 = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);
		bdaySelectS = new JSpinner(dateModel5);
		SpinnerDateModel dateModel6 = new SpinnerDateModel(initialDate, earliestDate, latestDate, Calendar.YEAR);
		yearSelectS = new JSpinner(dateModel6);

		
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
		
		ugbc.gridy = 2;
		registerLabelArea.setBackground(Color.decode("#193d3d"));
		registerLabel.setFont(new Font("Monospace", Font.PLAIN, 15));
		registerLabel.setForeground(Color.WHITE);
		registerLabelArea.add(registerLabel);
		registerLink.setFocusable(false);
		registerLink.setBackground(Color.decode("#2B2D42"));
		registerLink.setFont(new Font("Monospace", Font.PLAIN, 15));
		registerLink.setForeground(Color.WHITE);
		registerLabelArea.add(registerLink);
		userTypePanel.add(registerLabelArea, ugbc);
		
		//REGISTER
		registerPanel.setLayout(new GridBagLayout());
		registerPanel.setBackground(Color.decode("#326060"));
		registerArea.setLayout(new GridBagLayout());
		registerArea.setBackground(Color.decode("#326060"));
		GridBagConstraints rgbc = new GridBagConstraints();
		
		rgbc.gridy = 0;
		rgbc.gridx = 0;
		rgbc.gridwidth = 2;
		rgbc.anchor = GridBagConstraints.CENTER;
		rgbc.insets = new Insets(10, 10, 10, 10);
		registerTitle.setFont(new Font("Monospace", Font.BOLD, 30));
		registerTitle.setForeground(Color.WHITE);
		registerArea.add(registerTitle, rgbc);
		
		rgbc.insets = new Insets(0, 10, 10, 10);
		rgbc.anchor = GridBagConstraints.WEST;
		rgbc.gridy = 1;
		rgbc.gridwidth = 1;
		regFirstName.setFont(new Font("Monospace", Font.BOLD, 15));
		regFirstName.setForeground(Color.WHITE);
		registerArea.add(regFirstName, rgbc);
		rgbc.gridx = 1;
		regLastName.setFont(new Font("Monospace", Font.BOLD, 15));
		regLastName.setForeground(Color.WHITE);
		registerArea.add(regLastName, rgbc);
		
		rgbc.gridx = 0;
		rgbc.gridy = 2;
		rgbc.fill = 1;
		rgbc.weightx = 1;
		regFnameField.setPreferredSize(new Dimension(200, 30));
		registerArea.add(regFnameField, rgbc);
		rgbc.gridx = 1;
		regLnameField.setPreferredSize(new Dimension(200, 30));
		registerArea.add(regLnameField, rgbc);
		
		rgbc.gridy = 3;
		rgbc.gridx = 0;
		studentNum.setFont(new Font("Monospace", Font.BOLD, 15));
		studentNum.setForeground(Color.WHITE);
		registerArea.add(studentNum, rgbc);
		rgbc.gridy = 4;
		rgbc.gridwidth = 2;
		studentNumField.setPreferredSize(new Dimension(200, 30));
		registerArea.add(studentNumField, rgbc);
		rgbc.gridy = 5;
		regPasswordLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		regPasswordLabel.setForeground(Color.WHITE);
		registerArea.add(regPasswordLabel, rgbc);
		rgbc.gridy = 6;
		regPasswordField.setPreferredSize(new Dimension(200, 30));
		registerArea.add(regPasswordField, rgbc);
		rgbc.gridy = 7;
		passwordConfirmLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		passwordConfirmLabel.setForeground(Color.WHITE);
		registerArea.add(passwordConfirmLabel, rgbc);
		rgbc.gridy = 8;
		regPassConfirmField.setPreferredSize(new Dimension(200, 30));
		registerArea.add(regPassConfirmField, rgbc);
		
		rgbc.gridy = 9;
		regButtonArea.setLayout(new GridLayout(1, 2, 10, 10));
		regBackButton.setFocusable(false);
		regBackButton.setBackground(Color.decode("#2B2D42"));
		regBackButton.setFont(new Font("Monospace", Font.BOLD, 20));
		regBackButton.setForeground(Color.WHITE);
		regBackButton.setBorder(BorderFactory.createRaisedBevelBorder());
		regButtonArea.add(regBackButton);
		registerButton.setFocusable(false);
		registerButton.setBackground(Color.decode("#2B2D42"));
		registerButton.setFont(new Font("Monospace", Font.BOLD, 20));
		registerButton.setForeground(Color.WHITE);
		registerButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		regButtonArea.add(registerButton);
		regButtonArea.setBackground(Color.decode("#326060"));
		
		rgbc.insets = new Insets(20, 10, 10, 10);
		registerArea.add(regButtonArea, rgbc);
		registerPanel.add(registerArea);
		
		//LOGIN
		loginPanel.setLayout(new BorderLayout());
		loginArea.setLayout(new GridBagLayout());
		loginArea.setBackground(Color.decode("#193d3d"));
		GridBagConstraints lgbc = new GridBagConstraints();
		
		loginText.setFont(new Font("Monospace", Font.BOLD, 30));
		loginText.setForeground(Color.WHITE);
		lgbc.gridy = 0;
		lgbc.gridx = 0;
		lgbc.gridwidth = 2;
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
		
		loginBackButton.setFocusable(false);
		loginBackButton.setBackground(Color.decode("#2B2D42"));
		loginBackButton.setForeground(Color.WHITE);
		loginBackButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		loginBackButton.setBorder(BorderFactory.createRaisedBevelBorder());
		lgbc.insets = new Insets(10, 0, 0, 0);
		lgbc.gridx = 0;
		lgbc.gridy = 5;
		lgbc.ipady = 20;
		lgbc.ipadx = 30;
		lgbc.anchor = GridBagConstraints.WEST;
		loginArea.add(loginBackButton, lgbc);
		
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.decode("#2B2D42"));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
		lgbc.gridx = 1;
		lgbc.anchor = GridBagConstraints.EAST;
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
		
		mainAreaHome.setLayout(new BorderLayout());
		mainAreaHome.setBackground(Color.decode("#326060"));
		
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
				
		mainAreaHome.add(mainAreaButtons, BorderLayout.CENTER);
		mainAreaHome.add(topMainArea, BorderLayout.NORTH);
		mainAreaHome.add(sideMainArea, BorderLayout.EAST);
		mainArea.add(mainAreaHome, "mainareahome");
		
		mainAreaAdd.setLayout(new BorderLayout());
		mainAreaAdd.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		mainAreaAdd.setBackground(Color.decode("#326060"));

		mainAreaAddInfo.setLayout(new GridBagLayout());
		GridBagConstraints agbc = new GridBagConstraints();
		
		mainAreaAddInfo.setBackground(Color.decode("#326060"));
		agbc.gridx = 0;
		agbc.gridwidth = 1;
		agbc.fill = GridBagConstraints.HORIZONTAL;
		agbc.anchor = GridBagConstraints.WEST;
		agbc.insets = new Insets(5, 5, 2, 5);
		agbc.ipadx = 5;
		agbc.ipady = 5;
		studentIDLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		studentIDLabel.setForeground(Color.WHITE);
		mainAreaAddInfo.add(studentIDLabel, agbc);
		agbc.gridwidth = 2;
		studentIDField.setPreferredSize(new Dimension(300, 20));
		studentIDField.setMinimumSize(studentIDField.getPreferredSize());
		mainAreaAddInfo.add(studentIDField, agbc);
		firstNameLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		firstNameLabel.setForeground(Color.WHITE);
		agbc.gridwidth = 1;
		mainAreaAddInfo.add(firstNameLabel, agbc);
		agbc.gridwidth = 2;
		mainAreaAddInfo.add(firstNameField, agbc);
		middleNameLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		middleNameLabel.setForeground(Color.WHITE);
		agbc.gridwidth = 1;
		mainAreaAddInfo.add(middleNameLabel, agbc);
		agbc.gridwidth = 2;
		mainAreaAddInfo.add(middleNameField, agbc);
		lastNameLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		lastNameLabel.setForeground(Color.WHITE);
		agbc.gridwidth = 1;
		mainAreaAddInfo.add(lastNameLabel, agbc);
		agbc.gridwidth = 2;
		mainAreaAddInfo.add(lastNameField, agbc);
		
		sexLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		sexLabel.setForeground(Color.WHITE);
		agbc.gridwidth = 1;
		mainAreaAddInfo.add(sexLabel, agbc);
		sexOptions.setLayout(new FlowLayout());
		sexButtonOptions.add(sexOptionFemale);
		sexOptionFemale.setBackground(Color.decode("#326060"));
		sexOptionFemale.setFont(new Font("Monospace", Font.BOLD, 15));
		sexOptionFemale.setForeground(Color.WHITE);
		sexButtonOptions.add(sexOptionMale);
		sexOptionMale.setBackground(Color.decode("#326060"));
		sexOptionMale.setFont(new Font("Monospace", Font.BOLD, 15));
		sexOptionMale.setForeground(Color.WHITE);
		sexButtonOptions.add(sexOptionOther);
		sexOptions.add(sexOptionFemale);
		sexOptionOther.setBackground(Color.decode("#326060"));
		sexOptionOther.setFont(new Font("Monospace", Font.BOLD, 15));
		sexOptionOther.setForeground(Color.WHITE);
		sexOptions.add(sexOptionMale);
		sexOptions.add(sexOptionOther);
		agbc.gridwidth = 2;
		sexOptions.setBackground(Color.decode("#326060"));
		mainAreaAddInfo.add(sexOptions, agbc);
		
		agbc.gridx = 2;
		birthDateLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		birthDateLabel.setForeground(Color.WHITE);
		mainAreaAddInfo.add(birthDateLabel, agbc);
		Component bdayselectc = birthDateSelect.getEditor().getComponent(0);
		bdayselectc.setBackground(Color.decode("#2B2D42"));
		bdayselectc.setForeground(Color.WHITE);
		mainAreaAddInfo.add(birthDateSelect, agbc);
		
		agbc.gridwidth = 2;
		strandLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		strandLabel.setForeground(Color.WHITE);
		mainAreaAddInfo.add(strandLabel, agbc);
		strandList.setFocusable(false);
		strandList.setBackground(Color.decode("#2B2D42"));
		strandList.setForeground(Color.WHITE);
		mainAreaAddInfo.add(strandList, agbc);
		
		yearEnrolledLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		yearEnrolledLabel.setForeground(Color.WHITE);
		mainAreaAddInfo.add(yearEnrolledLabel, agbc);
		Component yearenrolledselectc = yearEnrolledSelect.getEditor().getComponent(0);
		yearenrolledselectc.setBackground(Color.decode("#2B2D42"));
		yearenrolledselectc.setForeground(Color.WHITE);
		mainAreaAddInfo.add(yearEnrolledSelect, agbc);
		
		currentSemLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		currentSemLabel.setForeground(Color.WHITE);
		mainAreaAddInfo.add(currentSemLabel, agbc);
		semList.setFocusable(false);
		semList.setBackground(Color.decode("#2B2D42"));
		semList.setForeground(Color.WHITE);
		mainAreaAddInfo.add(semList, agbc);
		
		tempPassLabel.setFont(new Font("Monospace", Font.BOLD, 18));
		tempPassLabel.setForeground(Color.WHITE);
		mainAreaAddInfo.add(tempPassLabel, agbc);
		mainAreaAddInfo.add(tempPassField, agbc);
		
		mainAreaAddButtons.setLayout(new GridLayout(1, 2, 20, 0));
		mainAreaAddButtons.setBackground(Color.decode("#326060"));
		addStudent.setFocusable(false);
		addStudent.setBorder(BorderFactory.createRaisedBevelBorder());
		addStudent.setBackground(Color.decode("#2B2D42"));
		addStudent.setFont(new Font("Monospace", Font.PLAIN, 15));
		addStudent.setForeground(Color.WHITE);
		mainAreaAddButtons.add(addStudent);
		backButton.setFocusable(false);
		backButton.setBorder(BorderFactory.createRaisedBevelBorder());
		backButton.setBackground(Color.decode("#2B2D42"));
		backButton.setFont(new Font("Monospace", Font.PLAIN, 15));
		backButton.setForeground(Color.WHITE);
		mainAreaAddButtons.add(backButton);
		agbc.gridy = 12;
		mainAreaAddInfo.add(mainAreaAddButtons, agbc);
		mainAreaAdd.add(mainAreaAddInfo, BorderLayout.CENTER);

		mainArea.add(mainAreaAdd, "mainareaadd");
		
		try {
			createTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mainArea.add(studentRecords, "studentrecords");

		studentRecords.setLayout(new BorderLayout());	
		studentRecords.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		studentRecords.setBackground(Color.decode("#326060"));
		recordsTable.setGridColor(Color.decode("#326060"));
		
		recordsTableScroll.setBorder(BorderFactory.createEmptyBorder());
		recordsTableScroll.getViewport().setBorder(null);
		recordsTableScroll.getViewport().setBackground(Color.decode("#326060"));
		studentRecords.add(recordsTableScroll);
		
		mainAreaDelete.setLayout(new BoxLayout(mainAreaDelete, BoxLayout.Y_AXIS));
		mainAreaDelete.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainAreaDelete.setBackground(Color.decode("#326060"));
		
		deleteTableScroll.setBorder(BorderFactory.createEmptyBorder());
		deleteTableScroll.getViewport().setBorder(null);
		deleteTableScroll.getViewport().setBackground(Color.decode("#326060"));
		mainAreaDelete.add(deleteTableScroll);
		

		deleteRowButtonArea.setLayout(new GridBagLayout());
		GridBagConstraints dgbc = new GridBagConstraints();
		deleteRowButton.setFocusable(false);
		deleteRowButton.setBackground(Color.decode("#2B2D42"));
		deleteRowButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		deleteRowButton.setForeground(Color.WHITE);
		deleteRowButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		dgbc.weightx = 1.0;
		dgbc.fill = GridBagConstraints.NONE;
		dgbc.anchor = GridBagConstraints.EAST;
		deleteRowButtonArea.setBackground(Color.decode("#326060"));
		deleteRowButtonArea.add(deleteRowButton, dgbc);
		mainAreaDelete.add(deleteRowButtonArea);
		
		mainArea.add(mainAreaDelete, "mainareadelete");
		
		mainAreaEdit.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainAreaEdit.setBackground(Color.decode("#326060"));
		mainAreaEdit.setLayout(new BoxLayout(mainAreaEdit, BoxLayout.Y_AXIS));
		mainAreaEdit.add(editTableScroll, BorderLayout.CENTER);
		
		editButtonArea.setLayout(new GridBagLayout());
		editButtonArea.setBackground(Color.decode("#326060"));
		GridBagConstraints egbc = new GridBagConstraints();
		editButtonArea.add(editButton);
		egbc.weightx = 1.0;
		egbc.fill = GridBagConstraints.NONE;
		egbc.anchor = GridBagConstraints.EAST;
		editButtonArea.add(editButton, egbc);
		mainAreaEdit.add(editButtonArea);
		
		submitEditButton.setBackground(Color.decode("#2B2D42"));
		submitEditButton.setFocusable(false);
		submitEditButton.setForeground(Color.WHITE);
		submitEditButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		
		editTableScroll.setBorder(BorderFactory.createEmptyBorder());
		editTableScroll.getViewport().setBorder(null);
		editTableScroll.getViewport().setBackground(Color.decode("#326060"));
		editButton.setBackground(Color.decode("#2B2D42"));
		editButton.setFocusable(false);
		editButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		editButton.setForeground(Color.WHITE);
		editButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		mainArea.add(mainAreaEdit, "mainareaedit");

		
		//SIDEBAR
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
		
		//STUDENT DASHBOARD
		studentDashboard.setLayout(new BorderLayout());
		studentDashboard.add(studentTopBar, BorderLayout.NORTH);
		studentDashboard.add(studentMainPanel, BorderLayout.CENTER);
		studentDashboard.add(studentSideBar, BorderLayout.WEST);
		
		studentTopBar.setBackground(Color.decode("#2B2D42"));
		studentTopBar.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.decode("#1b1d30")));
		topBarText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		topBarText.setFont(new Font("Monospace", Font.BOLD, 25));
		topBarText.setForeground(Color.WHITE);
		studentTopBar.add(topBarText);
	
		studentSideBar.setLayout(new BoxLayout(studentSideBar, BoxLayout.Y_AXIS));
		studentSideBar.setBackground(Color.decode("#457171"));
		studentSideBar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 0, 3, Color.decode("#193d3d")),
				BorderFactory.createEmptyBorder(10, 10, 20, 10)
				));
		
		studentProfile.setLayout(new BoxLayout(studentProfile, BoxLayout.LINE_AXIS));
		studentProfile.setBackground(Color.decode("#457171"));
		studentUser.setFont(new Font("Monospace", Font.BOLD, 25));
		studentUser.setForeground(Color.WHITE);
		studentUserIcon.setIcon(userIcon);
		studentProfile.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
		studentProfile.add(studentUserIcon);
		studentProfile.add(studentUser);
		studentSideBar.add(studentProfile);
		
		studentSideBarButtons.setLayout(new GridLayout(3, 1, 10, 30));
		studentSideBarButtons.setBackground(Color.decode("#457171"));
		
		editMyInfoButton.setFocusable(false);
		editMyInfoButton.setBackground(Color.decode("#2B2D42"));
		editMyInfoButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		editMyInfoButton.setForeground(Color.WHITE);
		editMyInfoButton.setBorder(BorderFactory.createRaisedBevelBorder());
		studentSideBarButtons.add(editMyInfoButton);
		
		changePasswordButton.setFocusable(false);
		changePasswordButton.setBackground(Color.decode("#2B2D42"));
		changePasswordButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		changePasswordButton.setForeground(Color.WHITE);
		changePasswordButton.setBorder(BorderFactory.createRaisedBevelBorder());
		studentSideBarButtons.add(changePasswordButton);
		
		studentLogoutButton.setFocusable(false);
		studentLogoutButton.setBackground(Color.decode("#2B2D42"));
		studentLogoutButton.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentLogoutButton.setForeground(Color.WHITE);
		studentLogoutButton.setBorder(BorderFactory.createRaisedBevelBorder());
		studentSideBarButtons.add(studentLogoutButton);
		studentSideBar.add(studentSideBarButtons);
		
		studentInfoPanel.setLayout(new BorderLayout());
		studentInfoPanel.setBackground(Color.decode("#326060"));
		studentInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		studentInfoPanel.add(studentGreet, BorderLayout.NORTH);
		studentGreet.setBackground(Color.decode("#2B2D42"));
		studentGreet.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.decode("#326060")));
		studentWelcomeText.setFont(new Font("Monospace", Font.BOLD, 20));
		studentWelcomeText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		studentWelcomeText.setForeground(Color.WHITE);
		studentGreet.add(studentWelcomeText);
		
		studentInfoArea.setLayout(new GridBagLayout());
		GridBagConstraints sgbc = new GridBagConstraints();
		studentInfoArea.setBackground(Color.decode("#2B2D42"));
		
		sgbc.gridx = 0;
		sgbc.gridy = 0;
		sgbc.anchor = GridBagConstraints.WEST;
		sgbc.fill = GridBagConstraints.HORIZONTAL;
		sgbc.insets = new Insets(0, 0, 0, 10);
		studentNameLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentNameLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentNameLabel, sgbc);
		sgbc.gridy = 1;
		sgbc.insets = new Insets(0, 0, 10, 10);
		studentName.setOpaque(true);
		studentName.setBackground(Color.decode("#326060"));
		studentName.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentName.setForeground(Color.WHITE);
		studentName.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentName.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentName, sgbc);
		
		sgbc.gridy = 2;
		sgbc.insets = new Insets(0, 0, 0, 10);
		studentMnameLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentMnameLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentMnameLabel, sgbc);
	
		sgbc.gridy = 3;
		sgbc.insets = new Insets(0, 0, 10, 10);
		
		studentMname.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentMname.setForeground(Color.WHITE);
		studentMname.setBorder(studentName.getBorder());
		studentMname.setOpaque(true);
		studentMname.setBackground(Color.decode("#326060"));
		studentMname.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentMname.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentMname, sgbc);
		
		sgbc.gridy = 4;
		sgbc.insets = new Insets(0, 0, 0, 10);
		studentLnameLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentLnameLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentLnameLabel, sgbc);
		sgbc.gridy = 5;
		sgbc.insets = new Insets(0, 0, 10, 10);
		studentLname.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentLname.setForeground(Color.WHITE);
		studentLname.setOpaque(true);
		studentLname.setBackground(Color.decode("#326060"));
		studentLname.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentLname.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentLname, sgbc);
		
		sgbc.gridy = 6;
		sgbc.insets = new Insets(0, 0, 0, 10);
		studentSexLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentSexLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentSexLabel, sgbc);
		sgbc.gridy = 7;
		sgbc.insets = new Insets(0, 0, 10, 10);
		studentSex.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentSex.setForeground(Color.WHITE);
		studentSex.setOpaque(true);
		studentSex.setBackground(Color.decode("#326060"));
		studentSex.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentSex.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentSex, sgbc);
		
		sgbc.gridx = 1;
		sgbc.gridy = 0;
		sgbc.insets = new Insets(0, 10, 0, 0);
		studentBdayLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentBdayLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentBdayLabel, sgbc);
		sgbc.gridy = 1;
		sgbc.insets = new Insets(0, 10, 10, 0);
		studentBday.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentBday.setForeground(Color.WHITE);
		studentBday.setPreferredSize(new Dimension(280, 30));
		studentBday.setOpaque(true);
		studentBday.setBackground(Color.decode("#326060"));
		studentBday.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentBday.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentBday, sgbc);
		
		sgbc.gridy = 2;
		sgbc.insets = new Insets(0, 10, 0, 0);
		studentStrandLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentStrandLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentStrandLabel, sgbc);
		sgbc.gridy = 3;
		sgbc.insets = new Insets(0, 10, 10, 0);
		studentStrand.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentStrand.setForeground(Color.WHITE);
		studentStrand.setOpaque(true);
		studentStrand.setBackground(Color.decode("#326060"));
		studentStrand.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentStrand.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentStrand, sgbc);
		
		sgbc.gridy = 4;
		sgbc.insets = new Insets(0, 10, 0, 0);
		studentYenrolledLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentYenrolledLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentYenrolledLabel, sgbc);
		sgbc.gridy = 5;
		sgbc.insets = new Insets(0, 10, 10, 0);
		studentYenrolled.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentYenrolled.setForeground(Color.WHITE);
		studentYenrolled.setOpaque(true);
		studentYenrolled.setBackground(Color.decode("#326060"));
		studentYenrolled.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentYenrolled.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentYenrolled, sgbc);
		
		sgbc.gridy = 6;
		sgbc.insets = new Insets(0, 10, 0, 0);
		studentSemLabel.setFont(new Font("Monospace", Font.BOLD, 20));
		studentSemLabel.setForeground(Color.WHITE);
		studentInfoArea.add(studentSemLabel, sgbc);
		sgbc.gridy = 7;
		sgbc.insets = new Insets(0, 10, 10, 0);
		studentSem.setFont(new Font("Monospace", Font.PLAIN, 20));
		studentSem.setForeground(Color.WHITE);
		studentSem.setOpaque(true);
		studentSem.setBackground(Color.decode("#326060"));
		studentSem.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		studentSem.setPreferredSize(new Dimension(280, 30));
		studentInfoArea.add(studentSem, sgbc);

		studentInfoPanel.add(studentInfoArea, BorderLayout.CENTER);
		studentMainPanel.add(studentInfoPanel, "studentinfo");
		cardLayout2.show(studentMainPanel, "studeninfo");
		
		sideBar.add(profileArea);
		sideBar.add(buttonArea);
		sideBar.add(bottomButtonArea);
		
		dashboard.add(topBar, BorderLayout.NORTH);
		dashboard.add(mainArea, BorderLayout.CENTER);
		dashboard.add(sideBar, BorderLayout.WEST);
		
		mainPanel.add(userTypePanel, "usertype");
		mainPanel.add(dashboard, "dashboard");
		mainPanel.add(studentDashboard, "sdashboard");
		mainPanel.add(loginPanel, "login");
		mainPanel.add(registerPanel, "register");

		add(mainPanel);
		cardLayout.show(mainPanel, "usertype");
		dashboardCardLayout.show(mainArea, "mainarea");
		
		//ACTION LISTENERS 
		adminButton.addActionListener((e) -> {
			isAdmin = true;
			userIDLabel.setText("Username:");
			cardLayout.show(mainPanel, "login");
		});
		
		studentButton.addActionListener((e) -> {
			isAdmin = false;
			userIDLabel.setText("Student ID:");
			cardLayout.show(mainPanel, "login");
		});
		
		loginButton.addActionListener((e) -> {
			try {
				handleLogin();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		registerLink.addActionListener((e) -> {
			cardLayout.show(mainPanel, "register");
		});
		
		registerButton.addActionListener((e) -> {
			try {
				handleRegister();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		regBackButton.addActionListener((e) -> {
			cardLayout.show(mainPanel, "usertype");
		});
		
		loginBackButton.addActionListener((e) -> {
			cardLayout.show(mainPanel, "usertype");
		});
		
		dashboardButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea, "mainareahome");
		});

		quickAddButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea, "mainareaadd");
		});
		
		addNewButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea, "mainareaadd");
		});
		
		editInfoButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea, "mainareaedit");
		});
		
		editButton.addActionListener((e) -> {
			if (editTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, 
		            	"Select a row", 
		            	"Edit failed", JOptionPane.ERROR_MESSAGE);
		         return;
			}
			
			try {
				createEditDialog();
			} catch (SQLException | ParseException e1) {
				e1.printStackTrace();
			}
		});
		
		submitEditButton.addActionListener((e) -> {
			try {
				editStudentRow();
				refreshTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		submitEditButtonS.addActionListener((e) -> {
			try {
				editMyInfo();
				refreshStudentInfo();
				refreshTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		editMyInfoButton.addActionListener((e) -> {
			try {
				createStudentEditDialog();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		});
		
		changePasswordButton.addActionListener((e) -> {
			try {
				changePassDialog();
			} catch (HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		changePassButton.addActionListener((e) -> {
			try {
				updatePassword();
				refreshStudentInfo();
				refreshTable();
			} catch (HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		
		deleteButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea,  "mainareadelete");
		});
		
		deleteRowButton.addActionListener((e) -> {
			if (deleteTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, 
		            	"Select a row", 
		            	"Delete Failed", JOptionPane.ERROR_MESSAGE);
		         return;
			}
			
            int confirmDelete= JOptionPane.showConfirmDialog(this, 
            		"Are you sure you want to delete this student?", 
            		"Confirm", JOptionPane.YES_NO_OPTION);
			
            if (!(confirmDelete == 0)) {
            	return;
            }
            
			try {
				deleteStudentRow();
				refreshTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		backButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea, "mainareahome");
		});
		
		recordsButton.addActionListener((e) -> {
			dashboardCardLayout.show(mainArea, "studentrecords");
		});
		
		addStudent.addActionListener((e) -> {
			try {
				handleAddingStudent();
				refreshTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		logoutButton.addActionListener((e) -> {
			comfirmLogout();
		});
		
		studentLogoutButton.addActionListener((e) -> {
			comfirmLogout();
		});
				
		revalidate();
		repaint();
	}

	
	public static void main(String[] args) throws SQLException {
		//Class.forName("com.mysql.cj-jdbc.Driver");		
		new InfoVault();
		
		ActionListener updateTime = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time.setText(new Date().toString());
			}
		};
		Timer t = new Timer(1000, updateTime);
		t.start();
	}
	
	void handleLogin() throws SQLException {
        String userID = userIDField.getText();
        String password = new String(userPasswordField.getPassword());
        
        if (userID.trim().isEmpty() || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
            		"Fill in the required fields", 
            		"Login Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement(userTypeCheck());	
		st.setString(1, userID);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
	
        if (! rs.next()) {
            JOptionPane.showMessageDialog(this, 
            		"Invalid Credentials", 
            		"Login Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
    	
        JOptionPane.showMessageDialog(this, "Login Successful!");
		if (isAdmin) {
			userName.setText(userID);
			welcomeText.setText("Welcome to InfoVault, " + userID);
			cardLayout.show(mainPanel, "dashboard");
		} else {
			retrieveUserInfo();
			studentWelcomeText.setText("Welcome to InfoVault, " + studentName.getText());
			studentUser.setText(userID);
			cardLayout.show(mainPanel, "sdashboard");
		}
	}
	
	void handleRegister() throws SQLException {
		String password = new String(regPasswordField.getPassword());
		String comfirmPass = new String(regPassConfirmField.getPassword());
		String studentNum = studentNumField.getText();
		String fname = regFnameField.getText();
		String lname = regLnameField.getText();
		
		if (password.isEmpty() || comfirmPass.isEmpty() || studentNum.isEmpty() || fname.isEmpty() || lname.isEmpty()) {
			JOptionPane.showMessageDialog(this, 
            		"Fill in all the required fields", 
            		"Registration Failed", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (! validateID(studentNum)) {
			JOptionPane.showMessageDialog(this, 
            		"Enter a valid ID", 
            		"Registration Failed", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (!password.equals(comfirmPass)) {
			JOptionPane.showMessageDialog(this, 
            		"Passwords don't match", 
            		"Registration Failed", JOptionPane.ERROR_MESSAGE);
			return;
		}

        if (checkIDduplicate(studentNum)) {
			JOptionPane.showMessageDialog(this, 
            		"Student ID already exists", 
            		"Registration Failed", JOptionPane.ERROR_MESSAGE);
			return;
        }
        
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
        PreparedStatement st2 = con.prepareStatement("INSERT INTO students(student_id, first_name, last_name, password) VALUES (?, ?, ?, ?);");
		st2.setString(1, studentNum);
        st2.setString(2, fname);
        st2.setString(3, lname);
        st2.setString(4, password);
        st2.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Registration Successful");
	}
	
	void handleAddingStudent() throws SQLException {		
		String studentID = studentIDField.getText();
		String fname = firstNameField.getText();
		String mname = middleNameField.getText();
		String lname = lastNameField.getText();
		String sex = checkSelectedSex();
		String birthday = new SimpleDateFormat("yyyy-MM-dd").format(birthDateSelect.getValue());
		String strand = strandList.getSelectedItem().toString();
		String yearEnrolled = new SimpleDateFormat("yyyy").format(yearEnrolledSelect.getValue());
		String sem = semList.getSelectedItem().toString();
		String tempPass = tempPassField.getText();
		boolean sexSelected = sexSelected();
		
		if (studentID.isEmpty() || fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || !sexSelected || tempPass.isEmpty()) {
			JOptionPane.showMessageDialog(this, 
            		"Fill in the required Fields", 
            		"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (! validateID(studentID) || studentID.length() > 9) {
			JOptionPane.showMessageDialog(this, 
            		"Enter a valid ID", 
            		"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (checkIDduplicate(studentID)) { 
			JOptionPane.showMessageDialog(this, 
            		"Student ID already exists", 
            		"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");	
		st.setString(1, studentID);     
		st.setString(2, fname);
		st.setString(3, mname);
		st.setString(4, lname);
		st.setString(5, sex);
		st.setString(6, birthday);
		st.setString(7, strand);
		st.setString(8, yearEnrolled);
		st.setString(9, sem);
		st.setString(10, tempPass);
		st.executeUpdate();
		
        JOptionPane.showMessageDialog(this, "Student successfuly added");
	}
	
	String userTypeCheck() {
		if (isAdmin) {
			return "SELECT * FROM admins WHERE username=? and password=?";
		} else {
			return "SELECT * FROM students WHERE student_id=? and password=?";
		}
	}
	
	String checkSelectedSex() {
		if (sexOptionFemale.isSelected()) {
			return "Female";
		} 
		if (sexOptionMale.isSelected()) {
			return "Male";
		}
		if (sexOptionOther.isSelected()) {
			return "Other";
		}
		return null;
	}
	
	String checkSelectedSexInEdit() {
		if (sexOptionFemaleE.isSelected()) {
			return "Female";
		} 
		if (sexOptionMaleE.isSelected()) {
			return "Male";
		}
		if (sexOptionOtherE.isSelected()) {
			return "Other";
		}
		return null;
	}
	
	String checkSelectedSexInStudentEdit() {
		if (sexOptionFemaleS.isSelected()) {
			return "Female";
		} 
		if (sexOptionMaleS.isSelected()) {
			return "Male";
		}
		if (sexOptionOtherS.isSelected()) {
			return "Other";
		}
		return null;
	}

	boolean validateID(String id) {
		for (int i = 0; i < id.length(); i++) {
			if (!Character.isDigit(id.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	boolean sexSelected() {
		if (sexOptionFemale.isSelected() || sexOptionMale.isSelected() || sexOptionOther.isSelected()) {
			return true;
		}
		return false;
	}
	
	boolean checkIDduplicate(String ID) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("SELECT student_id FROM students WHERE student_id=?");
		st.setString(1, ID);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
        	return true;
        }
        return false;
	}
	
	void retrieveUserInfo() throws SQLException {
		String ID = userIDField.getText();
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("SELECT first_name, middle_name, last_name, sex, birthday, strand, year_enrolled, semester FROM students WHERE student_id=?");
		st.setString(1, ID);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			String name = rs.getString("first_name");
			String mname = rs.getString("middle_name");
			String lname = rs.getString("last_name");
			String sex = rs.getString("sex");
			String birthday = rs.getString("birthday");
			String strand = rs.getString("strand");
			String year_enrolled = rs.getString("year_enrolled");
			String semester = rs.getString("semester");
			
			studentName.setText(name);
			studentMname.setText(mname);
			studentLname.setText(lname);
			studentSex.setText(sex);
			studentBday.setText(birthday);
			studentStrand.setText(strand);
			studentYenrolled.setText(year_enrolled);
			studentSem.setText(semester);
		} 
	}
	
	void createTables() throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		DefaultTableCellRenderer noFocusRenderer = new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value,
		            boolean isSelected, boolean hasFocus, int row, int column) {
		        
		        Component c = super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
		        return c;
		    }
		};
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("SELECT * from students");
		ResultSet rs = st.executeQuery();
		
		ResultSetMetaData metaData = rs.getMetaData();
		int colCount = metaData.getColumnCount();
		String columns[] = new String[colCount];
		for (int i = 1; i <= colCount; i++) {
			columns[i-1] = metaData.getColumnName(i);
		}
		tableModel.setColumnIdentifiers(columns);
		
		while (rs.next()) {
			Object[] row = new Object[colCount];
			for (int i = 1; i <= colCount; i++) {
				row[i-1] = rs.getObject(i);
			}
			tableModel.addRow(row);
		}
		
		rs.close();
		st.close();
		
		recordsTable = new JTable(tableModel);
		recordsTable.setEnabled(false);
		recordsTableScroll = new JScrollPane(recordsTable);

		deleteTable = new JTable(tableModel);
		for (int i = 0; i < deleteTable.getColumnCount(); i++) {
		    deleteTable.getColumnModel().getColumn(i).setCellRenderer(noFocusRenderer);
		}
		deleteTable.setCellSelectionEnabled(false);
		deleteTable.setColumnSelectionAllowed(false);
		deleteTable.setRowSelectionAllowed(true);
		deleteTableScroll = new JScrollPane(deleteTable);
		
		editTable = new JTable(tableModel);
		editTableScroll = new JScrollPane(editTable);
		
	}
	
	void refreshTable() throws SQLException {
		createTables();
		studentRecords.removeAll();
		recordsTableScroll.setBorder(BorderFactory.createEmptyBorder());
		recordsTableScroll.getViewport().setBorder(null);
		recordsTableScroll.getViewport().setBackground(Color.decode("#326060"));
		studentRecords.add(recordsTableScroll);
		
		mainAreaDelete.removeAll();
		deleteTableScroll.setBorder(BorderFactory.createEmptyBorder());
		deleteTableScroll.getViewport().setBorder(null);
		deleteTableScroll.getViewport().setBackground(Color.decode("#326060"));
		mainAreaDelete.add(deleteTableScroll);
		mainAreaDelete.add(deleteRowButtonArea);
		
		mainAreaEdit.removeAll();
		editTableScroll.setBorder(BorderFactory.createEmptyBorder());
		editTableScroll.getViewport().setBorder(null);
		editTableScroll.getViewport().setBackground(Color.decode("#326060"));
		mainAreaEdit.add(editTableScroll);
		mainAreaEdit.add(editButtonArea);
	}
	
	void createEditDialog() throws SQLException, ParseException {
		JLabel idLabel = new JLabel("Student ID:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel mnameLabel = new JLabel("Middle name:");
		JLabel lnameLabel = new JLabel("Last name:");
		JLabel sexLabel = new JLabel("Sex:");
		JLabel bdayLabel = new JLabel("Birthday:");
		bdaySelectE.setEditor(new JSpinner.DateEditor(birthDateSelect, "yyy-MM-dd"));
		sexButtonOptionsE.add(sexOptionFemaleE);
		sexButtonOptionsE.add(sexOptionMaleE);
		sexButtonOptionsE.add(sexOptionOtherE);
		JLabel strandLabel = new JLabel("Strand:");
		JLabel yearLabel = new JLabel("Year Enrolled:");
		
		JLabel semLabel = new JLabel("Semester:");
		JLabel passLabel = new JLabel("Password:");
		
		int col = 0;
		int row = editTable.getSelectedRow();
		idToEdit = editTable.getModel().getValueAt(row, col).toString();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("SELECT * FROM students WHERE student_id=?");
		st.setString(1, idToEdit);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			String name = rs.getString("first_name");
			String mname = rs.getString("middle_name");
			String lname = rs.getString("last_name");
			String sex = rs.getString("sex");
			String birthday = rs.getString("birthday");
			String strand = rs.getString("strand");
			String year_enrolled = rs.getString("year_enrolled");
			String semester = rs.getString("semester");
			String password = rs.getString("password");
	
			idField.setText(idToEdit);
			nameField.setText(name);
			mnameField.setText(mname);
			lnameField.setText(lname);
			
			if (sex.equals("Female")) {
			    sexOptionFemaleE.setSelected(true);
			} else if (sex.equals("Male")) {
			    sexOptionMaleE.setSelected(true);
			} else {
			    sexOptionOtherE.setSelected(true);
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bdayDate = sdf.parse(birthday);
			bdaySelectE.setValue(bdayDate);
			DateEditor editor = new DateEditor(bdaySelectE, "yyyy-MM-dd");
			bdaySelectE.setEditor(editor);
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
			Date yearDate = sdf2.parse(year_enrolled);
			yearSelectE.setValue(yearDate);
			DateEditor editor2 = new DateEditor(yearSelectE, "yyyy");
			yearSelectE.setEditor(editor2);
			
			strandListE.setSelectedItem(strand);
			semListE.setSelectedItem(semester);
			passFieldE.setText(password);

			System.out.println(name + mname + lname + sex + birthday + strand + year_enrolled + semester);
			
			JDialog editDialog = new JDialog(this, "Edit student", true);
			editDialog.setSize(700, 500);
			editDialog.setResizable(false);
			editDialog.setLocationRelativeTo(this);

			editDialog.getContentPane().setBackground(Color.decode("#326060"));
			editDialog.setLayout(new GridBagLayout());
			GridBagConstraints egbc = new GridBagConstraints();
			egbc.gridx = 0;
			egbc.gridy = 0;
			egbc.insets = new Insets(0, 10, 10, 10);
			egbc.anchor = GridBagConstraints.WEST;
			egbc.fill = GridBagConstraints.HORIZONTAL;

			idLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			idLabel.setForeground(Color.WHITE);
			editDialog.add(idLabel, egbc);

			egbc.gridy = 1;
			idField.setPreferredSize(new Dimension(200, 20));
			editDialog.add(idField, egbc);

			egbc.gridy = 2;
			nameLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			nameLabel.setForeground(Color.WHITE);
			editDialog.add(nameLabel, egbc);

			egbc.gridy = 3;
			editDialog.add(nameField, egbc);

			egbc.gridy = 4;
			mnameLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			mnameLabel.setForeground(Color.WHITE);
			editDialog.add(mnameLabel, egbc);

			egbc.gridy = 5;
			editDialog.add(mnameField, egbc);

			egbc.gridy = 6;
			lnameLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			lnameLabel.setForeground(Color.WHITE);
			editDialog.add(lnameLabel, egbc);

			egbc.gridy = 7;
			editDialog.add(lnameField, egbc);

			egbc.gridy = 8;
			sexLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			sexLabel.setForeground(Color.WHITE);
			editDialog.add(sexLabel, egbc);

			egbc.gridy = 9;
			sexOptionsE.add(sexOptionFemaleE);
			sexOptionFemaleE.setBackground(Color.decode("#326060"));
			sexOptionFemaleE.setFont(new Font("Monospace", Font.BOLD, 15));
			sexOptionFemaleE.setForeground(Color.WHITE);
			sexOptionsE.add(sexOptionMaleE);
			sexOptionMaleE.setBackground(Color.decode("#326060"));
			sexOptionMaleE.setFont(new Font("Monospace", Font.BOLD, 15));
			sexOptionMaleE.setForeground(Color.WHITE);
			sexOptionsE.add(sexOptionOtherE);
			sexOptionOtherE.setBackground(Color.decode("#326060"));
			sexOptionOtherE.setFont(new Font("Monospace", Font.BOLD, 15));
			sexOptionOtherE.setForeground(Color.WHITE);
			sexOptionsE.setBackground(Color.decode("#326060"));
			editDialog.add(sexOptionsE, egbc);

			egbc.gridx = 1;
			egbc.gridy = 0;
			bdayLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			bdayLabel.setForeground(Color.WHITE);
			editDialog.add(bdayLabel, egbc);

			egbc.gridy = 1;
			editDialog.add(bdaySelectE, egbc);

			egbc.gridy = 2;
			strandLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			strandLabel.setForeground(Color.WHITE);
			editDialog.add(strandLabel, egbc);

			egbc.gridy = 3;
			editDialog.add(strandListE, egbc);

			egbc.gridy = 4;
			yearLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			yearLabel.setForeground(Color.WHITE);
			editDialog.add(yearLabel, egbc);

			egbc.gridy = 5;
			editDialog.add(yearSelectE, egbc);

			egbc.gridy = 6;
			semLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			semLabel.setForeground(Color.WHITE);
			editDialog.add(semLabel, egbc);

			egbc.gridy = 7;
			editDialog.add(semListE, egbc);

			egbc.gridy = 8;
			passLabel.setFont(new Font("Monospace", Font.BOLD, 15));
			passLabel.setForeground(Color.WHITE);
			editDialog.add(passLabel, egbc);

			egbc.gridy = 9;
			editDialog.add(passFieldE, egbc);

			egbc.gridx = 1;
			egbc.gridy = 10;
			egbc.fill = GridBagConstraints.NONE;
			egbc.anchor = GridBagConstraints.EAST;
			editDialog.add(submitEditButton, egbc);

			editDialog.setVisible(true);

		}
	}
		
	void editStudentRow() throws SQLException {
		String studentID = idField.getText();
		String fname = nameField.getText();
		String mname = mnameField.getText();
		String lname = lnameField.getText();
		String sex = checkSelectedSexInEdit();
		String birthday = new SimpleDateFormat("yyyy-MM-dd").format(bdaySelectE.getValue());
		String strand = strandListE.getSelectedItem().toString();
		String yearEnrolled = new SimpleDateFormat("yyyy").format(yearSelectE.getValue());
		String sem = semListE.getSelectedItem().toString();
		String pass = passFieldE.getText();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("UPDATE students SET "
				+ "student_ID=?, first_name=?, middle_name=?, last_name=?, sex=?, birthday=?, strand=?, year_enrolled=?, semester=?, password=? "
				+ "WHERE student_ID=?");	
		
		if (! validateID(studentID) || studentID.length() > 9) {
			JOptionPane.showMessageDialog(this, 
            		"Enter a valid ID", 
            		"Registration Failed", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		st.setString(1, studentID);
		st.setString(2, fname);
		st.setString(3, mname);
		st.setString(4, lname);
		st.setString(5, sex);
		st.setString(6, birthday);
		st.setString(7, strand);
		st.setString(8, yearEnrolled);
		st.setString(9, sem);
		st.setString(10, pass);
		st.setString(11, idToEdit);
		st.executeUpdate();

        JOptionPane.showMessageDialog(this, "Changes succesful");	}
	
	void createStudentEditDialog() throws ParseException {

		String userID = userIDField.getText();
		
		JLabel idLabel = new JLabel("Student ID:");
		JLabel nameLabel = new JLabel("Name:");
		JLabel mnameLabel = new JLabel("Middle name:");
		JLabel lnameLabel = new JLabel("Last name:");
		JLabel sexLabel = new JLabel("Sex:");
		JLabel bdayLabel = new JLabel("Birthday:");
		JLabel strandLabel = new JLabel("Strand:");
		JLabel yearLabel = new JLabel("Year Enrolled:");
		JLabel semLabel = new JLabel("Semester:");
		
		idFieldS.setText(userID);
		idFieldS.setEditable(false);
		nameFieldS.setText(studentName.getText());
		mnameFieldS.setText(studentMname.getText());
		lnameFieldS.setText(studentLname.getText());
		if (studentSex.getText().equals("Female")) {
		    sexOptionFemaleS.setSelected(true);
		} else if (studentSex.getText().equals("Male")) {
		    sexOptionMaleS.setSelected(true);
		} else {
		    sexOptionOtherS.setSelected(true);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bdayDate = sdf.parse(studentBday.getText());
		bdaySelectS.setValue(bdayDate);
		semListS.setSelectedItem(studentSem.getText());
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
		Date yearDate = sdf2.parse(studentYenrolled.getText());
		yearSelectS.setValue(yearDate);
		strandListS.setSelectedItem(studentStrand.getText());
		
		sexButtonOptionsS.add(sexOptionFemaleS);
		sexButtonOptionsS.add(sexOptionMaleS);
		sexButtonOptionsS.add(sexOptionOtherS);
		sexOptionsS.add(sexOptionFemaleS);
		sexOptionsS.add(sexOptionMaleS);
		sexOptionsS.add(sexOptionOtherS);
		
		sexOptionFemaleS.setBackground(Color.decode("#326060"));
		sexOptionMaleS.setBackground(Color.decode("#326060"));
		sexOptionOtherS.setBackground(Color.decode("#326060"));
		sexOptionFemaleS.setForeground(Color.WHITE);
		sexOptionMaleS.setForeground(Color.WHITE);
		sexOptionOtherS.setForeground(Color.WHITE);
		
		bdaySelectS.setEditor(new JSpinner.DateEditor(bdaySelectS, "yyy-MM-dd"));
		yearSelectS.setEditor(new JSpinner.DateEditor(yearSelectS, "yyy"));

		JDialog editDialog = new JDialog(this, "Edit your info", true);
		editDialog.setSize(600, 500);
		editDialog.setResizable(false);
		editDialog.setLocationRelativeTo(this);
		editDialog.getContentPane().setBackground(Color.decode("#326060"));
		editDialog.setLayout(new GridBagLayout());
		GridBagConstraints sgbc = new GridBagConstraints();
	
		sgbc.gridx = 0;
		sgbc.gridy = 0;
		sgbc.anchor = GridBagConstraints.WEST;
		sgbc.fill = GridBagConstraints.HORIZONTAL;
		sgbc.insets = new Insets(0, 10, 10, 10);

		idLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		idLabel.setForeground(Color.WHITE);
		editDialog.add(idLabel, sgbc);
		sgbc.gridy = 1;
		editDialog.add(idFieldS, sgbc);

		sgbc.gridy = 2;
		nameLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		nameLabel.setForeground(Color.WHITE);
		editDialog.add(nameLabel, sgbc);
		sgbc.gridy = 3;
		editDialog.add(nameFieldS, sgbc);

		sgbc.gridy = 4;
		mnameLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		mnameLabel.setForeground(Color.WHITE);
		editDialog.add(mnameLabel, sgbc);
		sgbc.gridy = 5;
		editDialog.add(mnameFieldS, sgbc);

		sgbc.gridy = 6;
		lnameLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		lnameLabel.setForeground(Color.WHITE);
		editDialog.add(lnameLabel, sgbc);
		sgbc.gridy = 7;
		editDialog.add(lnameFieldS, sgbc);

		sgbc.gridy = 8;
		sexLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		sexLabel.setForeground(Color.WHITE);
		editDialog.add(sexLabel, sgbc);
		sgbc.gridy = 9;
		sexOptionsS.setBackground(Color.decode("#326060"));
		editDialog.add(sexOptionsS, sgbc);

		sgbc.gridx = 1;
		sgbc.gridy = 0;
		bdayLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		bdayLabel.setForeground(Color.WHITE);
		editDialog.add(bdayLabel, sgbc);
		sgbc.gridy = 1;
		editDialog.add(bdaySelectS, sgbc);

		sgbc.gridy = 2;
		strandLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		strandLabel.setForeground(Color.WHITE);
		editDialog.add(strandLabel, sgbc);
		sgbc.gridy = 3;
		editDialog.add(strandListS, sgbc);

		sgbc.gridy = 4;
		yearLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		yearLabel.setForeground(Color.WHITE);
		editDialog.add(yearLabel, sgbc);
		sgbc.gridy = 5;
		editDialog.add(yearSelectS, sgbc);

		sgbc.gridy = 6;
		semLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		semLabel.setForeground(Color.WHITE);
		editDialog.add(semLabel, sgbc);
		sgbc.gridy = 7;
		editDialog.add(semListS, sgbc);

		sgbc.gridy = 9;
		submitEditButtonS.setFocusable(false);
		submitEditButtonS.setBackground(Color.decode("#2B2D42"));
		submitEditButtonS.setFont(new Font("Monospace", Font.PLAIN, 15));
		submitEditButtonS.setForeground(Color.WHITE);
		submitEditButtonS.setBorder(BorderFactory.createCompoundBorder(
		        BorderFactory.createRaisedBevelBorder(),
		        BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		editDialog.add(submitEditButtonS, sgbc);
		editDialog.setVisible(true);
	}
	
	void editMyInfo() throws SQLException {
		String idToEdit = idFieldS.getText();
		String fname = nameFieldS.getText();
		String mname = mnameFieldS.getText();
		String lname = lnameFieldS.getText();
		String sex = checkSelectedSexInStudentEdit();
		String birthday = new SimpleDateFormat("yyyy-MM-dd").format(bdaySelectS.getValue());
		String strand = strandListS.getSelectedItem().toString();
		String yearEnrolled = new SimpleDateFormat("yyyy").format(yearSelectS.getValue());
		String sem = semListS.getSelectedItem().toString();
		
		System.out.println("fname: " + fname);
		System.out.println("mname: " + mname);
		System.out.println("lname: " + lname);
		System.out.println("sex: " + sex);
		System.out.println("birthday: " + birthday);
		System.out.println("strand: " + strand);
		System.out.println("yearEnrolled: " + yearEnrolled);
		System.out.println("sem: " + sem);
		
		if (fname.isEmpty() || mname.isEmpty() || lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
            		"Fill in the required fields", 
            		"Edit Failed", JOptionPane.ERROR_MESSAGE);
            return;
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("UPDATE students SET"
				+ " first_name=?, middle_name=?, last_name=?, sex=?, birthday=?, strand=?, year_enrolled=?, semester=? "
				+ "WHERE student_ID=?");	
		
		st.setString(1, fname);
		st.setString(2, mname);
		st.setString(3, lname);
		st.setString(4, sex);
		st.setString(5, birthday);
		st.setString(6, strand);
		st.setString(7, yearEnrolled);
		st.setString(8, sem);
		st.setString(9, idToEdit);
		st.executeUpdate();
		
        JOptionPane.showMessageDialog(this, "Changes succesful");
	}
	
	void refreshStudentInfo() {

	    String fname = nameFieldS.getText();
	    String mname = mnameFieldS.getText();
	    String lname = lnameFieldS.getText();
	    String sex = checkSelectedSexInStudentEdit();
	    String birthday = new SimpleDateFormat("yyyy-MM-dd").format(bdaySelectS.getValue());
	    String strand = strandListS.getSelectedItem().toString();
	    String yearEnrolled = new SimpleDateFormat("yyyy").format(yearSelectS.getValue());
	    String sem = semListS.getSelectedItem().toString();

	    studentName.setText(fname);
	    studentMname.setText(mname);
	    studentLname.setText(lname);
	    studentSex.setText(sex);
	    studentBday.setText(birthday);
	    studentStrand.setText(strand);
	    studentYenrolled.setText(yearEnrolled);
	    studentSem.setText(sem);
	}
	
	void changePassDialog() throws HeadlessException, SQLException {
		JLabel oldPassLabel = new JLabel("Old password:");
		JLabel newPassLabel = new JLabel("New password:");
		JLabel comfirmPassLabel = new JLabel("Confirm password:");

		JDialog passDialog = new JDialog(this, "Change password", true);
		passDialog.setSize(400, 500);
		passDialog.setResizable(false);
		passDialog.setLocationRelativeTo(this);
		
		passDialog.getContentPane().setBackground(Color.decode("#326060"));
		passDialog.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints bgbc = new GridBagConstraints();
		
		oldPassLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		oldPassLabel.setForeground(Color.WHITE);

		newPassLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		newPassLabel.setForeground(Color.WHITE);

		comfirmPassLabel.setFont(new Font("Monospace", Font.BOLD, 15));
		comfirmPassLabel.setForeground(Color.WHITE);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 10, 10);
		passDialog.add(oldPassLabel, gbc);

		gbc.gridy = 1;
		oldPassField.setPreferredSize(new Dimension(200, 30));
		passDialog.add(oldPassField, gbc);

		gbc.gridy = 2;
		passDialog.add(newPassLabel, gbc);

		gbc.gridy = 3;
		newPassField.setPreferredSize(new Dimension(200, 30));
		passDialog.add(newPassField, gbc);

		gbc.gridy = 4;
		passDialog.add(comfirmPassLabel, gbc);

		gbc.gridy = 5;
		confirmPassField.setPreferredSize(new Dimension(200, 30));
		passDialog.add(confirmPassField, gbc);

		bgbc.gridx = 0;
		bgbc.gridy = 6;
		bgbc.anchor = GridBagConstraints.CENTER;
		bgbc.fill = GridBagConstraints.NONE;
		changePassButton.setBackground(Color.decode("#2B2D42"));
		changePassButton.setFocusable(false);
		changePassButton.setFont(new Font("Monospace", Font.BOLD, 15));
		changePassButton.setForeground(Color.WHITE);
		changePassButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
				));
		passDialog.add(changePassButton, bgbc);

		passDialog.setVisible(true);
		
	}
	
	void updatePassword() throws HeadlessException, SQLException {
		String id = userIDField.getText();

		if (oldPassField.getText().isEmpty() || newPassField.getText().isEmpty() || confirmPassField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
            		"Fill in the required fields", 
            		"Login Failed", JOptionPane.ERROR_MESSAGE);
            return;
		}
		
		if (! matchOldPassword()) {
            JOptionPane.showMessageDialog(this, 
            		"Old password does not match", 
            		"Update Failed", JOptionPane.ERROR_MESSAGE);
            return;
		}
		
		if (! newPassField.getText().equals(confirmPassField.getText())) {
			JOptionPane.showMessageDialog(this, 
            		"Passwords don't match", 
            		"Change Password Failed", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (newPassField.getText().equals(oldPassField.getText())) {
			JOptionPane.showMessageDialog(this, 
            		"New password cannot be the same as the old password", 
            		"Change Password Failed", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("UPDATE students SET password=? WHERE student_id=?");
		st.setString(1, newPassField.getText());
		st.setString(2, id);
		st.executeUpdate();
		
        JOptionPane.showMessageDialog(this, "Password changed successfully");
	}
	
	boolean matchOldPassword() throws SQLException {
		String id = userIDField.getText();
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("SELECT password FROM students WHERE student_id = ?");	
		st.setString(1, id);
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {
			String pass = rs.getString("password");
			if (oldPassField.getText().equals(pass)) {
	            return true;
			}else {
				return false;
			}
        } else {
        	return false;
        }
	}	
	
	
	void deleteStudentRow() throws SQLException {
		int col = 0;
		int row = deleteTable.getSelectedRow();
		String idToDel = deleteTable.getModel().getValueAt(row, col).toString();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/infovaultdb", "root", "grizzywizzy");
		PreparedStatement st = con.prepareStatement("DELETE FROM students WHERE student_id=?");
		st.setString(1, idToDel);
		st.executeUpdate();
	}
	
	void comfirmLogout() {
		int confirmLogout = JOptionPane.showConfirmDialog(this, 
				"Are you sure you want to log out?", 
				"Confirm", JOptionPane.YES_NO_OPTION);
		if (confirmLogout == 0) {
			cardLayout.show(mainPanel, "usertype");
		}
	}

}