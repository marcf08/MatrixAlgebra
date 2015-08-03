import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;


/**
 * The linear algebra GUI creates the GUI and its methods
 * for the linear algebra application.
 * 
 * @author Marcus
 *
 */
public class LinearAlgebraGUI extends JFrame {
	/**
	 * The main window is for the main components.
	 */
	private Container mainWindow = getContentPane();
	/**
	 * The secondary window is for displaying any other options,
	 * items, etc. 
	 */
	private JFrame secondaryWindow;
	/**
	 * The controls panels will be reset according to the options.
	 * It will set matrix controls, calculator buttons, etc.
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
	 * Name of program
	 */
	private final String PRG_NAME = "Linear Calculator";
	/**
	 * Constant for work sheet
	 */
	private final String WRK_SHT = "Worksheet";
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
	 * Menu bar for file, save, settings, etc
	 */
	private JMenuBar menuBar;
	/**
	 * Menu bar items
	 */
	 private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem, printItem;
	 /**
	  * Font for the text box
	  */
	private Font fntTextArea;
	/**
	 * Set up array of buttons
	 */
	private JButton[] btnsCalculator;
	
	/**
	 * Add components to their respective containers, set up the GUI.
	 */
	public void setupGUI() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setTitle(PRG_NAME);
		mainWindow.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setupWorkArea();
		
		setupCalcButtons();
		
		
		
	}
	
	/**
	 * The main panel holds the work related components.
	 *  
	 */
	public void setupWorkArea() {
		workingPane = new JTextArea(DEF_MSG);
		workingPane.setEditable(true);
		workingPane.setLineWrap(true);
		workingPane.setSize(400, 50);
		workingPane.setFont(fntTextArea);
		fntTextArea = new Font("Garamond", Font.BOLD, 16);
		workingPane.setFont(fntTextArea);
		pnlWorkArea = new JPanel();
		
		//Draw work area panel
		pnlWorkArea.setLayout(new BoxLayout(pnlWorkArea, BoxLayout.Y_AXIS));
		
		
		//Add to main panel
		pnlWorkArea.add(workingPane);
		pnlWorkArea.setVisible(true);
		
		//Add the work area to the main layout
		mainWindow.add(pnlWorkArea, BorderLayout.WEST);
		this.setVisible(true);
	}
	
	
	
	/**
	 * Set up basic calculator buttons.
	 */
	public void setupCalcButtons() {
		//Initialize the buttons
		for (int i = 0; i <=9; i++) {
			btnsCalculator[i] = new JButton();
		}
		
		btnsCalculator[0].setText("0");
		btnsCalculator[1].setText("1");
		btnsCalculator[2].setText("2");
		btnsCalculator[3].setText("3");
		btnsCalculator[4].setText("4");
		btnsCalculator[5].setText("5");
		btnsCalculator[6].setText("6");
		btnsCalculator[7].setText("7");
		btnsCalculator[8].setText("8");
		btnsCalculator[9].setText("9");
		
		//Set up the panel of buttons
		pnlCalc = new JPanel();
		pnlCalc.setLayout(new FlowLayout());
		
		//Add them via a for-loop
		for(int i = 1; i <= btnsCalculator.length; i++) {
			pnlCalc.add(btnsCalculator[i]);
		}
		
		pnlCalc.setVisible(true);
		mainWindow.add(pnlCalc);

	}
	
	
	
	
	
	
	
	/**
	 * Set up the JMenu bar for file, settings, save, etc.
	 */
	//public void 
	
	
	
	/**
	 * Call methods, register listeners, set up the GUI.
	 */
	public LinearAlgebraGUI() {
		setupGUI();
		
		
	}
	
	/**
	 * Start the GUI
	 * @param args an array of command line arguments
	 */
	public static void main(String[] args) {
		new LinearAlgebraGUI();
	}
	
	
	
	
}