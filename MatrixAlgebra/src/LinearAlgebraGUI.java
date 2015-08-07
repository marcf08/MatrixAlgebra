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

import com.jgoodies.forms.layout.CellConstraints.Alignment;

/**
 * The linear algebra GUI creates the GUI and its methods for the linear algebra
 * application.
 * 
 * @author Marcus
 *
 */
public class LinearAlgebraGUI extends JFrame implements ActionListener {
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
	 * The boolean is false initially. Once a button is pushed,
	 * it will be turned to false, acting as a switch.
	 */
	private boolean isFirstPush = true;
	/**
	 * The card layout is for showing the different controls.
	 */
	private FlowLayout layoutControls;
	/**
	 * Width of container
	 */
	private final int FRAME_WIDTH = 800;
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

		setupMainBar();

		setupWorkArea();

		setupCalcButtons();

		setupCalcButtons();

		setupTools();

		registerListeners();
		
		

		setupLower();

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
		workingPane.setSize(400, 100);
		workingPane.setFont(fntTextArea);
		fntTextArea = new Font("Garamond", Font.BOLD, 16);
		workingPane.setFont(fntTextArea);
		pnlWorkArea = new JPanel();

		// Draw work area panel
		pnlWorkArea.setLayout(new BoxLayout(pnlWorkArea, BoxLayout.Y_AXIS));

		// Add to main panel
		pnlWorkArea.add(workingPane);
		pnlWorkArea.setVisible(true);

		// Add the work area to the main layout
		mainWindow.add(pnlWorkArea, BorderLayout.WEST);
		this.setVisible(true);
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
	 * Set up tool area on right hand side of GUI
	 */
	public void setupTools() {
		pnlTools = new JPanel();
		pnlTools.setLayout(new BoxLayout(pnlTools, BoxLayout.Y_AXIS));
		pnlTools.add(pnlControls);
		mainWindow.add(pnlTools, BorderLayout.CENTER);
		mainWindow.validate();
	}

	/**
	 * Set up the Action listeners
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == optionCompleteClear) {
			workingPane.setText("");
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
				workingPane.setText(i.toString());
			}
				
			
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
		
		//Add listeners to buttons
		for (int i = 0; i < buttonList.length; i++) {
			buttonList[i].addActionListener(this);
		}
		

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

}