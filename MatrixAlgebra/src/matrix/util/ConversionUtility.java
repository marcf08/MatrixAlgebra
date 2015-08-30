package matrix.util;
/**
 * The conversion utility converts strings of certain types from a calculator-based
 * syntax to a syntax recognized by the evaluator.
 * @author Marcus
 *
 */
public class ConversionUtility {
	/**
	 * Symbol for degrees
	 */
	public static final String DEG_SYMBOL = "°";
	/**
	 * Symbol for powers, exponents
	 */
	public static final String POW_SYMBOL = "^";
	/**
	 * TODO: Symbol for square root
	 */
	public static final String SQRT_SYMBOL = "\u221A";
	
	
	
	/**
	 * The constructor instantiates the 
	 */
	public ConversionUtility() {
		//Null constructor
	}
	
	
	/**
	 * This method examines the expression for degrees, powers,
	 * square roots or any other symbols not supported by the 
	 * evaluator's syntax.
	 * @param expression
	 */
	public void expressionType(String expression) {
		
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
