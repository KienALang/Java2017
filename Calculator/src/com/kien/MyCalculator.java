package com.kien;

public class MyCalculator {
	private double baseValue;
	private double secondValue;
	private String oper;

	public MyCalculator(Element baseElement, Element secondElement, Element operator) {
		baseValue = Double.parseDouble(baseElement.getValue());
		secondValue = Double.parseDouble(secondElement.getValue());
		oper = operator.getValue();
	}

	public Element getResult() {
		double result = 0;
		
		switch (oper) {
		case "+":
			result = baseValue + secondValue;
			break;
		case "-":
			result = baseValue - secondValue;
			break;
		case "*":
			result = baseValue * secondValue;
			break;
		case "/":
			result = baseValue / secondValue;
			break;
		case "%":
			result = baseValue % secondValue;
			break;
		default:
			break;
		}
		
		
		return new Element(String.valueOf(result));
	}

}
