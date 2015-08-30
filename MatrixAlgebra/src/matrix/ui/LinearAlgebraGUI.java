package matrix.ui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;

import matrix.util.BasicOperation;

import com.jgoodies.forms.layout.CellConstraints.Alignment;

/**
 * The linear algebra GUI creates the GUI and its methods for the linear algebra
 * application.
 * 
 * @author Marcus
 *
 */
public class LinearAlgebraGUI extends JFrame implements ActionListener, KeyListener {
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 7683611975720863191L;
	/**
	 * The window state listener is used for listening to minimizing/maximizing
	 * the application.
	 */
	private WindowStateListener wsl;
	
	/**
	 * The calculator (for now) uses a basic operation instance
	 * to perform basic operations. Later development will include an
	 * operation class to maintain the MVC encapsulation.
	 */
	private BasicOperation calculate;
	/**
	 * The main window is for the main components.
	 */
	private Container mainWindow = getContentPane();
	/**
	 * The secondary window is for displaying any other options, items, etc.
	 */
	private JFrame secondaryWindow;
	/**
	 * The controls panels will be reset according to the options. It will set
	 * matrix controls, calculator buttons, etc.
	 */
	private JPanel pnlControls;
	/**
	 * The other JPanel is for the answer/working field.
	 */
	private JPanel pnlWorkArea;
	/**
	 * The text area is the area for the calculations and user work.
	 */
	private JTextArea workingPane;
	/**
	 * The string buffer builds an expression to be parsed and passed
	 * to the client.
	 */
	private StringBuffer mainExpression;
	/**
	 * The secondary expression follows the main expression.
	 */
	private StringBuffer secondaryExpression;
	/**
	 * The formatter allows the GUI to do minimal text processing.
	 */
	private Formatter format;
	/**
	 * The max size is how many expressions the GUI should hold.
	 */
	private static final int MAX_CAPACITY = 500;
	/**
	 * The boolean is false initially. Once a button is pushed,
	 * it will be turned to false, acting as a switch.
	 */
	private boolean isFirstPush = true;
	/**
	 * The card layout is for showing the different controls.
	 */
	private FlowLayout layoutControls;
	
	private final int SPACER = 600;
	/**
	 * Width of container
	 */
	private final int FRAME_WIDTH = 900;
	/**
	 * Height of container
	 */
	private final int FRAME_HEIGHT = 600;
	/**
	 * Number of numerical buttons
	 */
	private final int NUM_BASIC_BUTTONS = 10;
	/**
	 * Name of program
	 */
	private final String PRG_NAME = "Linear Calculator 1.0";
	/**
	 * Constant for work sheet
	 */
	private final String WRK_SHT = "Worksheet";
	/**
	 * Message for the about box
	 */
	private final String ABOUT = "Linear Calculator is a project started and maintained by Marcus Flores since 2015.";
	/**
	 * Constant for program name
	 */
	/**
	 * Default text for work area
	 */
	private final String DEF_MSG = "Linear Calculator 1.0";
	/**
	 * Setup the pane for buttons
	 */
	private JPanel pnlCalc;
	/**
	 * The main panel holds the components.
	 */
	private JPanel pnlMain;
	/**
	 * Label for work sheet area
	 */
	private JLabel lblWksht;
	/**
	 * This JPanel is for the bottom of the GUI. It shows the program name and
	 * status bar.
	 * 
	 */
	private JPanel pnlStatus;
	/**
	 * The update panel provides user feedback in the lower right corner of the GUI.
	 */
	private JPanel pnlFeedback;
	/**
	 * The text panel provides message updates to the program's status.
	 */
	private JLabel lblFeedback;
	/**
	 * The messages below apply to the feedback JLabel.
	 */
	private final String FDB_CLEAR = "Work area cleared.";
	private final String FDB_SAVED = "Work saved.";
	private final String FDB_WORK = "Working...";
	private final String FDB_READY = "Ready.";
	
	/**
	 * JPanel for program label at the bottom.
	 */
	private JPanel pnlText;
	
	/**
	 * Menu bar for file, save, settings, etc
	 */
	private JMenuBar menuBar;
	/**
	 * Menu bar items
	 */
	private JMenu fileDropDown;
	private JMenu editDropDown;
	private JMenu helpDropDown;
	/**
	 * The main button group is for the file, edit, etc.
	 */
	private ButtonGroup btnGrpMain;
	/**
	 * The JPanel holds the buttons used for file, edit, etc.
	 */
	private JPanel pnlButtonsMain;
	
	/**
	 * The JPanel corresponds to the basic operations
	 */
	private JPanel pnlBasicOperations;
	
	/**
	 * Specific menu items
	 * 
	 */
	private JMenuItem optionNew;
	private JMenuItem optionSave;
	private JMenuItem optionExit;
	private JMenuItem optionHelp;
	private JMenuItem optionAbout;
	private JMenuItem optionCompleteClear;
	/**
	 * Default Font for the text box--this is for the title
	 */
	private Font fntTextArea;
	/**
	 * The primary font is used when the user inputs using the numbers
	 */
	private Font fntPrimary;
	/**
	 * Top level panel for calculation tools
	 */
	private JPanel pnlTools;
	/**
	 * Create buttons
	 */
	private JButton btnsCalculator0;
	private JButton btnsCalculator1;
	private JButton btnsCalculator2;
	private JButton btnsCalculator3;
	private JButton btnsCalculator4;
	private JButton btnsCalculator5;
	private JButton btnsCalculator6;
	private JButton btnsCalculator7;
	private JButton btnsCalculator8;
	private JButton btnsCalculator9;
	/**
	 * Create buttons for basic operations
	 */
	private JButton btnEquals;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMult;
	private JButton btnDiv;
	private JButton btnSin;
	private JButton btnCos;
	private JButton btnTan;
	private JButton btnClearLine;
	
	/**
	 * This simple array is for the buttons
	 */
	private JButton[] buttonList;
	
	/**
	 * Status/program information
	 */
	private JLabel lblProgramName;

	/**
	 * Add components to their respective containers, set up the GUI.
	 */
	public void setupGUI() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setTitle(PRG_NAME);
		mainWindow.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		calculate = new BasicOperation();
		
			
		setupMainBar();

		setupWorkArea();

		setupCalcButtons();
		
		setupBasicOperations();

		setupTools();

		registerListeners();
		
		setupLower();
		setupFeedback();
		
		updateFeedback(FDB_READY);
		
		setupExpression();

	}


	
	
	/**
	 * Set up the file, edit, etc, bar for the top of the window
	 */
	public void setupMainBar() {
		pnlButtonsMain = new JPanel(new FlowLayout());

		menuBar = new JMenuBar();

		setupMenuOptions();

		// Build file drop down
		fileDropDown = new JMenu();
		fileDropDown.setText("File");
		fileDropDown.add(optionNew);
		fileDropDown.add(optionSave);
		fileDropDown.add(optionExit);

		// Build edit drop down
		editDropDown = new JMenu();
		editDropDown.setText("Edit");
		editDropDown.add(optionCompleteClear);

		// Build help drop down
		helpDropDown = new JMenu();
		helpDropDown.setText("Help");
		helpDropDown.add(optionAbout);

		menuBar.add(fileDropDown);
		menuBar.add(editDropDown);
		menuBar.add(helpDropDown);

		// Build main button group
		mainWindow.add(menuBar, BorderLayout.NORTH);

	}

	/**
	 * The method sets up the menu items for the JMenus
	 */
	public void setupMenuOptions() {
		// Set up options
		optionNew = new JMenuItem();
		optionNew.setText("New");

		optionExit = new JMenuItem();
		optionExit.setText("Exit");

		optionSave = new JMenuItem();
		optionSave.setText("Save");

		optionAbout = new JMenuItem();
		optionAbout.setText("About");

		optionCompleteClear = new JMenuItem();
		optionCompleteClear.setText("Complete Clear");

	}

	/**
	 * The main panel holds the work related components.
	 * 
	 */
	public void setupWorkArea() {
		workingPane = new JTextArea(DEF_MSG);
		workingPane.setEditable(true);
		workingPane.setLineWrap(true);
		workingPane.setWrapStyleWord(true);
		workingPane.setSize(400, 200);
		workingPane.setFont(fntTextArea);
		fntTextArea = new Font("Garamond", Font.BOLD, 16);
		workingPane.setFont(fntTextArea);
		pnlWorkArea = new JPanel(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(workingPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlWorkArea.add(scroll, BorderLayout.EAST);
		
		
		//Add and set key listener
		
		configureWorkArea();  
		
		// Add the work area to the main layout
		format = new Formatter();
		
		mainWindow.add(pnlWorkArea, BorderLayout.WEST);
	}
	
	
	/**
	 * Configure work area sets a key listener
	 * to the working pane. It also sets up the
	 * string buffer used to accept expressions.
	 */
	public void configureWorkArea() {
		workingPane.addKeyListener(this);
		mainExpression = new StringBuffer();
		mainWindow.revalidate();
		
	}
	
	/**
	 * The key pressed registers the enter key to the working pane
	 * text area.
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			workingPane.append("\n");
			String firstLine = format.getFirstLine(workingPane.getText());
			String result = calculate.parse(firstLine);
			e.consume();
			workingPane.setText("");
			workingPane.append("\n");
			format.addToBuffer(result);
			workingPane.append(format.getBuffer());
			workingPane.setCaretPosition(0);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			e.consume();
			workingPane.setCaretPosition(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			e.consume();
			workingPane.setCaretPosition(0);
		}
	}
	

	/**
	 * The expression section stores the expressions.
	 */
	public void setupExpression() {
		mainExpression = new StringBuffer();
	}
	
	
	/**
	 * Set up basic calculator buttons.
	 */
	public void setupCalcButtons() {
		// Initialize the buttons
		btnsCalculator0 = new JButton("0");
		btnsCalculator1 = new JButton("1");
		btnsCalculator2 = new JButton("2");
		btnsCalculator3 = new JButton("3");
		btnsCalculator4 = new JButton("4");
		btnsCalculator5 = new JButton("5");
		btnsCalculator6 = new JButton("6");
		btnsCalculator7 = new JButton("7");
		btnsCalculator8 = new JButton("8");
		btnsCalculator9 = new JButton("9");

		// Set up the panel of buttons
		pnlCalc = new JPanel();
		pnlCalc.setBorder(BorderFactory.createBevelBorder(1));
		GridBagLayout layoutGridButtons = new GridBagLayout();

		// Build constraints for manually adding buttons
		GridBagConstraints zero = new GridBagConstraints();
		GridBagConstraints one = new GridBagConstraints();
		GridBagConstraints two = new GridBagConstraints();
		GridBagConstraints three = new GridBagConstraints();
		GridBagConstraints four = new GridBagConstraints();
		GridBagConstraints five = new GridBagConstraints();
		GridBagConstraints six = new GridBagConstraints();
		GridBagConstraints seven = new GridBagConstraints();
		GridBagConstraints eight = new GridBagConstraints();
		GridBagConstraints nine = new GridBagConstraints();

		// Manually set the constraints
		zero.gridx = 0;
		zero.gridy = 0;

		one.gridx = 1;
		one.gridy = 0;

		two.gridx = 2;
		two.gridy = 0;

		three.gridx = 0;
		three.gridy = 1;

		four.gridx = 1;
		four.gridy = 1;

		five.gridx = 2;
		five.gridy = 1;

		six.gridx = 0;
		six.gridy = 2;

		seven.gridx = 1;
		seven.gridy = 2;

		eight.gridx = 2;
		eight.gridy = 2;

		nine.gridx = 1;
		nine.gridy = 3;

		// Set the layout
		pnlCalc.setLayout(layoutGridButtons);

		// Add buttons
		pnlCalc.add(btnsCalculator1, zero);
		pnlCalc.add(btnsCalculator2, one);
		pnlCalc.add(btnsCalculator3, two);
		pnlCalc.add(btnsCalculator4, three);
		pnlCalc.add(btnsCalculator5, four);
		pnlCalc.add(btnsCalculator6, five);
		pnlCalc.add(btnsCalculator7, six);
		pnlCalc.add(btnsCalculator8, seven);
		pnlCalc.add(btnsCalculator9, eight);
		pnlCalc.add(btnsCalculator0, nine);
		pnlCalc.setVisible(true);

		buttonList = new JButton[NUM_BASIC_BUTTONS];
		buttonList[1] = btnsCalculator1;
		buttonList[2] = btnsCalculator2;
		buttonList[3] = btnsCalculator3;
		buttonList[4] = btnsCalculator4;
		buttonList[5] = btnsCalculator5;
		buttonList[6] = btnsCalculator6;
		buttonList[7] = btnsCalculator7;
		buttonList[8] = btnsCalculator8;
		buttonList[9] = btnsCalculator9;
		buttonList[0] = btnsCalculator0;
		
		// Add panel of buttons to the main tool panel
		pnlControls = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlControls.add(pnlCalc);

	}
	
	/**
	 * The set up basic ops button adds basic operations to the
	 * calculator
	 */
	private void setupBasicOperations() {
		btnEquals = new JButton("=");
		btnDiv = new JButton("/");
		btnMinus = new JButton("-");
		btnMult = new JButton("x");
		btnPlus = new JButton("+");
		btnClearLine = new JButton("Clear Line");
		
		btnSin = new JButton("Sin(x)");
		btnCos = new JButton("Cos(x)");
		btnTan = new JButton("Tan(x)");
		
		btnEquals.setPreferredSize(btnClearLine.getMaximumSize());
		btnDiv.setPreferredSize(btnClearLine.getMaximumSize());
		btnMinus.setPreferredSize(btnClearLine.getMaximumSize());
		btnMult.setPreferredSize(btnClearLine.getMaximumSize());
		btnPlus.setPreferredSize(btnClearLine.getMaximumSize());
		btnCos.setPreferredSize(btnClearLine.getMaximumSize());
		btnTan.setPreferredSize(btnClearLine.getMaximumSize());
		btnSin.setPreferredSize(btnClearLine.getMaximumSize());
		
		
		GridBagLayout layoutGridButtons = new GridBagLayout();

		// Build constraints for manually adding buttons
		GridBagConstraints zero = new GridBagConstraints();
		GridBagConstraints one = new GridBagConstraints();
		GridBagConstraints two = new GridBagConstraints();
		GridBagConstraints three = new GridBagConstraints();
		GridBagConstraints four = new GridBagConstraints();
		GridBagConstraints five = new GridBagConstraints();
		GridBagConstraints six = new GridBagConstraints();
		GridBagConstraints seven = new GridBagConstraints();
		GridBagConstraints eight = new GridBagConstraints();
		GridBagConstraints nine = new GridBagConstraints();
		
		// Manually set the constraints
		zero.gridx = 0;
		zero.gridy = 0;

		one.gridx = 1;
		one.gridy = 0;

		two.gridx = 2;
		two.gridy = 0;

		three.gridx = 0;
		three.gridy = 1;

		four.gridx = 1;
		four.gridy = 1;

		five.gridx = 2;
		five.gridy = 1;

		six.gridx = 0;
		six.gridy = 2;

		seven.gridx = 1;
		seven.gridy = 2;

		eight.gridx = 2;
		eight.gridy = 2;

		nine.gridx = 1;
		nine.gridy = 3;
		
		pnlBasicOperations = new JPanel(layoutGridButtons);
		
		pnlBasicOperations.add(btnSin, zero);
		pnlBasicOperations.add(btnCos, one);
		pnlBasicOperations.add(btnTan, two);
		pnlBasicOperations.add(btnEquals, three);
		pnlBasicOperations.add(btnDiv, four);
		pnlBasicOperations.add(btnMinus, five);
		pnlBasicOperations.add(btnMult, six);
		pnlBasicOperations.add(btnPlus, seven);
		pnlBasicOperations.add(btnClearLine, eight);
		
		pnlBasicOperations.setBorder(BorderFactory.createBevelBorder(1));
		pnlControls.add(pnlBasicOperations);
		
		
		
		
	}

	/**
	 * Set up tool area on right hand side of GUI
	 */
	public void setupTools() {
		pnlTools = new JPanel();
		pnlTools.setLayout(new FlowLayout());
		pnlTools.add(pnlControls);
		mainWindow.add(pnlTools, BorderLayout.CENTER);
		mainWindow.validate();
	}
	
	/**
	 * The feedback area sets up the feedback for displaying
	 * errors or status updates to the user.
	 */
	public void setupFeedback() {
		pnlFeedback = new JPanel();
		lblFeedback = new JLabel(); 
		pnlFeedback.add(lblFeedback);
		
		
		
		//Since pnlStatus uses a flow layout,
		//The spacer panel is needed to keep the
		//feedback label separate from the other information.
		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(SPACER, 0));
		pnlStatus.add(spacer);
		pnlStatus.add(pnlFeedback);
		mainWindow.revalidate();
		
		
	}
	
	/**
	 * The update feedback updates the feedback label
	 * based on what the program is doing.
	 */
	public void updateFeedback(String status) {
		Timer t = new Timer(1500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFeedback.setText(FDB_READY);
				lblFeedback.revalidate();
				mainWindow.revalidate();
			}
		});
		t.setRepeats(false);
		t.start();
		lblFeedback.setText(status);
		lblFeedback.revalidate();
		mainWindow.revalidate();
	}
	
	/**
	 * Set up the Action listeners
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == optionCompleteClear) {
			format.clearBuffer();
			workingPane.setText("");
			mainExpression.delete(0, mainExpression.length());
			updateFeedback(FDB_CLEAR);
		}
		if (src == optionExit) {
			System.exit(0);
		}
		if (src == optionAbout) {
			JOptionPane.showMessageDialog(new JFrame(), ABOUT);
		}
		// Loop for buttons
		for (Integer i = 0; i < NUM_BASIC_BUTTONS; i++) {
			if (src == buttonList[i] && isFirstPush) {
				fntPrimary = new Font("Arial", Font.BOLD, 18);
				workingPane.setFont(fntPrimary);
				workingPane.setText("");
				isFirstPush = false;
				workingPane.setText(i.toString());
			}
				else if (src == buttonList[i] && !isFirstPush) {
				workingPane.append(i.toString());
			}
				
			
		}
		
		// For addition functionality
		if (src == btnPlus) {
			workingPane.append("+");
		}
		
		// For subtraction functionality
		if (src == btnMinus) {
			workingPane.append("-");
		}
		// For multiplication functionality
		if (src == btnMult) {
			workingPane.append("*");
		}
		// For division functionality
		if (src == btnDiv) {
			workingPane.append("/");
		}

	}
	

	/**
	 * Add the action listeners
	 */
	public void registerListeners() {
		// Simple exit option
		optionExit.addActionListener(this);
		
		// Simple about dialog
		optionAbout.addActionListener(this);
			
		// Simple complete clear dialog
		optionCompleteClear.addActionListener(this);
		
		// Add listeners to buttons
		for (int i = 0; i < buttonList.length; i++) {
			buttonList[i].addActionListener(this);
		}
		
		// Add listeners to basic calculation buttons
		btnMult.addActionListener(this);
		btnPlus.addActionListener(this);
		btnDiv.addActionListener(this);
		btnMinus.addActionListener(this);
		
		
		
		// Add listener to text area for its behavior
		workingPane.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				//Empty method stub, nothing needed for when
				//the user leaves the text area
			}
			
			public void focusGained(FocusEvent e) {
				if (e.getSource() == workingPane && isFirstPush) {
					workingPane.setText("");
					isFirstPush = false;
				}
				
			}
			
		});
		
		
	}

	/**
	 * The status panel sits at the bottom of the GUI and relays information
	 * about the program and it's processing.
	 */
	public void setupLower() {
		// Components should add to the left
		pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
		mainWindow.add(pnlStatus, BorderLayout.SOUTH);
		lblProgramName = new JLabel(PRG_NAME);
		pnlText = new JPanel();
		pnlText.add(lblProgramName);
		pnlText.validate();
		pnlStatus.add(pnlText, LEFT_ALIGNMENT);
		pnlStatus.setBorder(BorderFactory.createEtchedBorder());
		mainWindow.validate();

	}

	/**
	 * Call methods, register listeners, set up the GUI.
	 */
	public LinearAlgebraGUI() {
		setupGUI();

	}

	/**
	 * Start the GUI
	 * 
	 * @param args
	 *            an array of command line arguments
	 */
	public static void main(String[] args) {
		new LinearAlgebraGUI();
	}

	//TODO: Edit or delete, etc
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//TODO: Edit or delete, etc
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	



}