package matrix.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * The basic operations class defines a basic
 * operation using the Java Script engine.
 * @author Marcus
 *
 */
public class BasicOperation {
	/**
	 * The Basic Operation uses the Java Script manager
	 * to parse the expression.
	 */
	private ScriptEngineManager parse;
	/**
	 * The engine uses the JavaScript engine to 
	 * perform calculations.
	 */
	private ScriptEngine engine;
	/**
	 * The equals sign helps format the output.
	 */
	private static final String FORMAT_EQUALS = " = ";
	/**
	 * There's only a null constructor to use.
	 * The GUI sets up the null constructor as an
	 * instance variable and performs the operations
	 * using the instance variable. 
	 */
	public BasicOperation() {
		parse = new ScriptEngineManager();
		engine = parse.getEngineByName("JavaScript");
	}
	
	/**
	 * The parse function evaluates an expression and
	 * returns the result.
	 * @param expression an expression to evaluate
	 * @return result the result of the operation, or null
	 * if the expression executed erroneously
	 */
	public String parse(String expression) {
		try {
			String fullResult = null;
			Object result = null;
			result = engine.eval(expression);
			fullResult = format(expression, result);
			return fullResult;
		} catch (ScriptException e) {
			return null;
		}
	}
	
	/**
	 * The format string method appends the result of the
	 * calculation to the end of the expression. This allows
	 * the expression to be read completely.
	 * @param expression
	 * @return
	 */
	private String format(String expression, Object result) {
		StringBuffer formattedResult = new StringBuffer();
		formattedResult.append(expression);
		formattedResult.append(FORMAT_EQUALS);
		formattedResult.append(result);
		return formattedResult.toString();
		
	}
	
	
	
}
