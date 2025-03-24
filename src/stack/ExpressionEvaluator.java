package stack;

import java.util.Stack;

public class ExpressionEvaluator {
	
	public static int evaluate (String strExpression) {
		if (strExpression == null || strExpression.length() == 0) {
			return 0;
		}
		char[] expression = strExpression.toCharArray();
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();
		for (int i = 0; i < expression.length; i++) {
			if (expression[i] == ' ') {
				continue;
			}
			if (ExpressionEvaluatorUtil.isOperand(expression[i])) {
				StringBuffer buff = new StringBuffer();
				while (i < expression.length && 
						ExpressionEvaluatorUtil.isOperand(expression[i])) {
					buff.append(expression[i++]);
				}
				operand.push(Integer.parseInt(buff.toString()));
				i--; //for loop will also increase the
			} else if (ExpressionEvaluatorUtil.isOperator(expression[i])) {
				while (!operator.isEmpty() && 
						ExpressionEvaluatorUtil.precedence(operator.peek()) >= 
						ExpressionEvaluatorUtil.precedence(expression[i])) {
					evaluateAndPush(operand, operator);
				}
				operator.push(expression[i]);
			} else if (expression[i] == '(') {
				operator.push(expression[i]);
			} else if (expression[i] == ')') {
				while (operator.peek() != '(') {
					evaluateAndPush(operand, operator);
				}
				operator.pop();
			}
		}
		while (!operator.isEmpty()) {
			evaluateAndPush(operand, operator);
		}
		return operand.pop();
	}
	
	public static void evaluateAndPush (Stack<Integer> operand, Stack<Character> operator) {
		if (operand.isEmpty() || operator.isEmpty()) {
			return;
		}
		operand.push(ExpressionEvaluatorUtil.evaluate(operand.pop(), operand.pop(), operator.pop()));
	}

	public static void main(String[] args) {
		System.out.println(evaluate("10 + 2 * 6"));
		System.out.println(evaluate("100 * 2 + 12"));
		System.out.println(evaluate("1+2/1+3*2"));
		System.out.println(evaluate("100 * ( 2 + 12 )"));
		System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
		System.out.println(evaluate("100 * ( 2 / 2 + 12 / 6 )"));


	}

}
