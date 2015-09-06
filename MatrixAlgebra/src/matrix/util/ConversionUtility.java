package matrix.util;

import java.util.ArrayList;

/**
 * The conversion utility converts strings of certain types from a calculator-based
 * syntax (input supplied by the user) to a syntax recognized by the evaluator. It takes
 * a string like x^2 and translates it to Java syntax, operation(argument, argument).
 * @author Marcus
 *
 */
public class ConversionUtility {
	/**
	 * We simply begin with an initial capacity of 
	 * 10 elements.
	 */
	public static final int DEL_CAPACITY = 10;
	/**
	 * The max length for some numbers is twenty. There should not be any
	 * expression that contains greater than twenty digits raised to a power.
	 */
	public static final int EXP_MAX_LENGTH = 20;
	
	/**
	 * Symbol for degrees
	 */
	public static final Character DEG_SYMBOL = '°';
	/**
	 * Symbol for powers, exponents
	 */
	public static final Character POW_SYMBOL = '^';
	/**
	 * TODO: Symbol for square root
	 */
	public static final Character SQRT_SYMBOL = '\u221A';
	/**
	 * The array of delimeters allows the program to
	 * loop through it efficiently to determine if it
	 * needs to understand certain arguments. 
	 */
	public ArrayList <Character> delimeters;
	/**
	 * The constructor instantiates the conversion utility.
	 * It builds the array of delimeters.
	 */
	public ConversionUtility() {
		delimeters = new ArrayList<Character>();
		buildSymbolList();
	}
	
	/**
	 * The private method simply builds the
	 * list of symbols. Additional symbols can be
	 * added here.
	 */
	private void buildSymbolList() {
		delimeters.add(DEG_SYMBOL);
		delimeters.add(POW_SYMBOL);
		delimeters.add(SQRT_SYMBOL);
	}
	
	
	/**
	 * This method examines the expression for degrees, powers,
	 * square roots or any other symbols not supported by the 
	 * evaluator's syntax.
	 * @param expression
	 */
	public String expressionType(String expression) {
		String argumentZero = null;
		String argumentOne = null;
		
	}
	
	/**
	 * A two part expression is an expression of two parts,
	 * such as the power symbol. Without 
	 * @param expression an expression to manipulate
	 */
	private void prepTwoPartExpression(String expression) {
		Character expressionType = getExpressionType(expression);
		String argumentZero = getFirstArgument(expression, expressionType);
		String argumentOne = getSecondArgument(expression, expressionType);
	}
	
	
	
	
		
	
	/**
	 * The get expression type method returns the expression
	 * types. That is, a power should have some argument raised 
	 * to a power, and not simply a "^" character.
	 * @param expression an expression to check for any of the
	 * symbols
	 * @return a character indicating the type of operation.
	 * Returns null if there are no special characters. 
	 * 
	 */
	public Character getExpressionType(String expression) {
		//Search for the delimeter and return it
		char[] expressionArray = expression.toCharArray();
		for (int i = 0; i < expressionArray.length; i++) {
			if (expressionArray[i] == delimeters.get(i)) {
				return delimeters.get(i);
			}
		}
		return null;
	}
	
	
	/**
	 * The get first argument method takes whatever special
	 * character was discovered by the parse expression method.
	 * It gathers all text up to the special character, which
	 * represents the first part of the argument.
	 * @param expression or string of text
	 * @return the first argument of some user-supplied expression
	 */
	private String getFirstArgument(String expression, Character type) {
		StringBuilder firstArgument = new StringBuilder();
		int i = 0;
		//Build the first half of the expression
		while (i != type) {
			firstArgument.append(expression.charAt(i));
		}
		return firstArgument.toString();
	}
	
	/**
	 * The get second argument method builds the second half
	 * of the expression delivered from the parse expression method.
	 * It gathers the text occurring after the special character and
	 * to the end of the expression.
	 * @param expression or string of text
	 * @return the second half of the expression
	 */
	private String getSecondArgument(String expression, Character type) {
		StringBuilder secondArgument = new StringBuilder();
		int i = 0;
		//Build the second half of the expression
		while (i != type) {
			expression.charAt(i);
			i++;
		}
		//The loop variable starts where i leaves off (assuming a type
		//exists)
		int j = i;
		while (j < expression.length()) {
			secondArgument.append(expression.charAt(j));
		}
		return secondArgument.toString();
	}
	
	/**
	 * The is valid expression method verifies that if an expression
	 * contains a special character, it contains the proper arguments.
	 * For example, 5^ is syntactically invalid, whereas 5^5 is not.
	 * @param expression
	 * @return true if the expression is valid and false otherwise
	 */
	//TODO: Implement this
	
	/**
	 * This method takes a string value, converts it to
	 * a numerical value, and converts it to degrees.
	 * @param value
	 * @return the degree value
	 */
	public double toDegrees(String value) {
		
	}
	
	/**
	 * This private method takes a string value and
	 * converts it to a double for the sake of
	 * conversion. Most methods will use this as
	 * the arguments supplied come in the form of a 
	 * string.
	 * @param value
	 * @return  
	 */
	private double toDouble(String value) throws NumberFormatException {
		double convertedValue = Double.parseDouble(value);
	
	}
	
	
	
	
}
