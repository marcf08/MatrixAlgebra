import java.awt.Container;
import java.awt.FlowLayout;

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
	private JPanel pnlTablet;
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
	 * The main panel holds the components
	 */
	private JPanel pnlMain;
	
	/**
	 * Add components to their respective containers
	 */
	public void setupGUI() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setTitle(PRG_NAME);
		
	}
	
	
	
	
	
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