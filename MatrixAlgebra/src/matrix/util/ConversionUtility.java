package matrix.util;

import java.util.ArrayList;

/**
 * The conversion utility converts strings of certain types from a calculator-based
 * syntax (input supplied by the user) to a syntax recognized by the evaluator. It takes
 * a string like x^2 and translates it to Java syntax, operation(argument, argument).
 * @author Marcus Flores
 *
 */
public class ConversionUtility {
	/**
	 * Begin with an initial capacity of 10 elements.
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
	public static final Character ROOT_SYMBOL = '\u221A';
	/**
	 * The tolerance values are used for angular measurements.
	 */
	public static final double posTolerance = 0.0001;
	/**
	 * Negative tolerance value.
	 */
	public static final double negTolerance = 0.0001;
	/**
	 * The default root value is 1/2. If the user does not
	 * supply a value prior to the root symbol, the calculator
	 * performs the operation with this default value.
	 */
	public static final double defaultRoo = 0.5;
	
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
		delimeters.add(ROOT_SYMBOL);
	}

	/**
	 * A two part expression is an expression of two parts,
	 * such as the power symbol. (It contains two arguments.) 
	 * @param expression an expression to manipulate
	 */
	private double threePartExpression(String expression) {
		Character expressionType = getExpressionType(expression);
		String argumentZero = getFirstArgument(expression, expressionType);
		String argumentOne = getSecondArgument(expression, expressionType);
		return evaluate(argumentZero, argumentOne, expressionType);
		
	}
	
	/**
	 * The evaluate method evaluates an expression given the arguments.
	 * @param argumentZero the first argument of an expression
	 * @param argumentOne the second argument of an expression
	 * @param type the argument type
	 */
	public double evaluate(String argumentZero, String argumentOne, Character type) {
		if (type == POW_SYMBOL) {
			return toPower(argumentZero, argumentOne);
		} if (type == ROOT_SYMBOL) {
			return toRoot(argumentZero, argumentOne);
		} if (type == DEG_SYMBOL) {
			//TODO: Evaluate
		}
		
		
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
	
	
	
	private String getZeroArgument(String expression, Character type) {
		StringBuilder zeroArgument = new StringBuilder();
		int i = 0;
		while (i)
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
		double valueToConvert = Double.parseDouble(value);
		return Math.toDegrees(valueToConvert);
	}
	
	/**
	 * The power method takes two arguments and returns the result
	 * of raising the base to a power.
	 * @param argumentZero the base
	 * @param argumentOne the exponent
	 * @return the result of the operation
	 */
	private double toPower(String argumentZero, String argumentOne) {
		double base = Double.parseDouble(argumentZero);
		double power = Double.parseDouble(argumentOne);
		return Math.pow(base, power);
	}
	
	/**
	 * The root symbol takes two arguments and returns the result of
	 * taking the root of one. (Naturally, it uses the toPower function.)
	 * @param argumentZero the argument beneath the root symbol (the base)
	 * @param argumentOne the argument outside the root symbol (the power)
	 * @return the result of the operation
	 */
	private double toRoot(String argumentZero, String argumentOne) {
		double base = Double.parseDouble(argumentZero);
		double powerOutside = Double.parseDouble(argumentOne);
		
		
	}
	
	/**
	 * The get power method gets the power of the argument beneath the
	 * root symbol. 
	 * @param argument
	 * @return
	 */
	private double getPower(String argument) {
		
	}
	
	
	
	
	
	
}
