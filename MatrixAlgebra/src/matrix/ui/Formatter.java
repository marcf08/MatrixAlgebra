package matrix.ui;

import java.util.ArrayList;

/**
 * The formatter class formats the Strings, StringBuffers
 * and other data generated and used by the calculator.
 * @author Marcus
 *
 */
public class Formatter {
	/**
	 * The expression buffer is an array list of Strings
	 * to be maintained in the text area.
	 */
	private ArrayList<String> expressionBuffer;
	
	/**
	 * The constructor is null. It formats information, and handles
	 * the buffer. The class minimizes the amount of text editing that
	 * must be done in the GUI itself, thereby maintaining MVC.
	 */
	public Formatter() {
		expressionBuffer = new ArrayList<>();
	}
	
	
	/**
	 * The get first line method gets the first line of text
	 * from the JTextArea. 
	 * @param fromTextArea
	 * @return firstLine the first line of the text area.
	 */
	public String getFirstLine(String fromTextArea) {
		if (fromTextArea == null) {
			return null;
		}
		StringBuffer firstLine = new StringBuffer();
		//Look at the whole text area, but stop at the
		//first line.
		for (int i = 0; i < fromTextArea.length(); i++) {
			char toAdd = fromTextArea.charAt(i);
			if (toAdd == '\n') {
				break;
			}
			firstLine.append(toAdd);
			
		
		}
		return firstLine.toString();
		
	}
	
	/**
	 * The get buffer list gets the text currently in the buffer.
	 */
	public String getBuffer() {
		String fullList = null;
		StringBuffer list = new StringBuffer();
		for (int i = expressionBuffer.size() - 1; i >= 0; i--) {
			list.append(expressionBuffer.get(i));
			list.append("\n");
		}
		fullList = list.toString();
		return fullList;
	}
	
	/**
	 * The clear buffer method clears all buffers from the list.
	 */
	public void clearBuffer() {
		expressionBuffer.clear();
	}
	
		
	/**
	 * The add to buffer method adds the previous line of text
	 * to the array list buffer.
	 * @param text text to add to the buffer
	 */
	public void addToBuffer(String text) {
		expressionBuffer.add(text);
	}

	
}
