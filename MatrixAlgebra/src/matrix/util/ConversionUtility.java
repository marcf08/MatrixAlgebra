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
	public ArrayList<Character> delimeters;
	/**
	 * The constructor instantiates the conversion utility.
	 * It builds the array of delimeters.
	 */
	public ConversionUtility() {
		delimeters = new ArrayList<Character>();
		delimeters[0] = DEG_SYMBOL;
		delimeters[1] = POW_SYMBOL;
		delimeters[2] = SQRT_SYMBOL;
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
	 * The parse expression method ensures the expression
	 * types contains the correct arguments. That is, a power
	 * should have some argument raised to a power, and not
	 * simply a "^" character.
	 * @param expression an expression to check for any of the
	 * symbols
	 * @return a String representing the type of operation. Also,
	 * returns null if nothing was found so that the arithmetic can
	 * continue in absence of any special characters. 
	 * 
	 */
	public String parseExpression(String expression) {
		//Search for the delimeter and return it
		for (int i = 0; i < delimeters.length; i++) {
			if (expression.contains(delimeters[i])) {
				return delimeters[i];
			}
				
		}
		return null;
	}
	
	
	/**
	 * The get first argument method takes whatever special
	 * character was discovered by the parse expression method.
	 * It gathers all text up to the special character, which
	 * represents the first part of the argument.
	 * @param expression
	 * @return the first argument of some user-supplied expression
	 */
	private String getFirstArgument(String expression, String type) {
		String firstArgument;
		int i = 0;
		while (i != type) {
			expression.charAt(i);
		}
	}
	
	private String getSecondArgument(String expression) {
		
	}
	
	
	
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
