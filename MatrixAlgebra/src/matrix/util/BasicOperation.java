package matrix.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

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
	private Evaluator parse;
	/**
	 * The equals sign helps format the output.
	 */
	private static final String FORMAT_EQUALS = " = ";
	/**
	 * The error message is a full description of what
	 * the program prints to the GUI when the parser
	 * encounters an error.
	 */
	private static final String ERR_MSG_ONE = "Expression \"";
	/**
	 * The error message is a full description of what
	 * the program prints to the GUI when the parser
	 * encounters an error.
	 */
	private static final String ERR_MSG_TWO = "\" returned a Syntax Error.";
	/**
	 * The instance field is for the broken expression.
	 */
	private String brokenExpression;
	/**
	 * There's only a null constructor to use.
	 * The GUI sets up the null constructor as an
	 * instance variable and performs the operations
	 * using the instance variable. 
	 */
	public BasicOperation() {
		parse = new Evaluator();
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
			result = parse.evaluate(expression);
			fullResult = format(expression, result);
			return fullResult;
		} catch (EvaluationException e) {
			return formatSyntaxError(expression);
		}

	}

	/**
	 * The format syntax error will pass the broken expression
	 * so that it can be formatted correctly and returned to 
	 * the GUI.
	 * @param badExpression an expression that throws an error
	 * @return errorMessage the error message formatted properly
	 */
	private String formatSyntaxError(String badExpression) {
		String errorMessage = ERR_MSG_ONE + badExpression + ERR_MSG_TWO; 
		return errorMessage; 
		
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
