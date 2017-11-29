package com.kien;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixCalculator {
	private String expression;
	public List<Element> postfixList;
	public Stack<Element> myStack;

	public PostfixCalculator(String expression) {
		this.expression = expression;
		postfixList = new ArrayList<Element>();
		myStack = new Stack<Element>();
	}

	public void translateExpression() {
		// Separate elements (operand, operator, bracket) in expression to a list of
		// element.
		List<Element> infixexpression = Helper.SeparateExpression(expression);

		// Translate list of element to Postfix list
		translate(infixexpression);
	}

	private void translate(List<Element> elements) {

		// MyStack is a stack that contains the operator.
		myStack.push(new Element("#"));

		// Clear List before using
		postfixList.clear();

		for (Element element : elements) {
			if (!element.isOperator())
				postfixList.add(element);
			else {
				if (element.isOpenBracket())
					myStack.push(element);
				else if (element.isCloseBracket()) {
					// Pop all value from stack while top stack value not an open bracket and add it
					// to post fix list.
					while (!myStack.peek().isOpenBracket())
						postfixList.add(myStack.pop());

					// Pop the open bracket to throw it away.
					myStack.pop();
				} else {
					if (element.priority() > myStack.peek().priority())
						myStack.push(element);
					else {
						while (element.priority() <= myStack.peek().priority())
							postfixList.add(myStack.pop());

						myStack.push(element);
					}
				}
			}
		}

		while (!myStack.peek().isSharpSymbol())
			postfixList.add(myStack.pop());
	}

	public String getResult() {
		translateExpression();
		return calculate(postfixList);
	}

	public String calculate(List<Element> postfixList) {

		for (Element element : postfixList) {
			if (element.isOperator()) {
				Element secondElement = myStack.pop();
				Element baseElement = myStack.pop();
				Element oper = element;

				MyCalculator myCal = new MyCalculator(baseElement, secondElement, oper);

				myStack.push(myCal.getResult());
			} else
				myStack.push(element);
		}

		// Return the value which is the last number in myStack.
		return myStack.pop().getValue();
	}

}
