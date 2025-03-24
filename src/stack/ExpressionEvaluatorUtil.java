package stack;

public class ExpressionEvaluatorUtil {
	
	public ExpressionEvaluatorUtil() {
		super();
	}
	
	public static boolean isOperand (char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	public static boolean isOperator (char ch) {
		return ch == '/' || ch == '*' || ch == '+' || ch == '-';
	}
	
	public static int precedence (char ch) {
		switch (ch) {
		case '/':
		case '*':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		default: throw new IllegalArgumentException();
		}
	}
	
	public static int evaluate (int num2, int num1, char operator) {
		int result =0;
		switch (operator) {
		case '/': result = num1 / num2;
		break;
		case '*': result = num1 * num2;
		break;
		case '+': result = num1 + num2;
		break;
		case '-': result = num1 - num2;
		break;
		}
		return result;
	}

}
