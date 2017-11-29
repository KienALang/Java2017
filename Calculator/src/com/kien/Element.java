package com.kien;

public class Element {

	private String value;

	public Element(String string) {
		value = string;
	}

	public boolean isOperator() {
		return Helper.isOperator(value);
	}

	public boolean isOpenBracket() {
		return Helper.isOpenBracket(value);
	}

	public boolean isCloseBracket() {
		return Helper.isCloseBracket(value);
	}

	public int priority() {
		int priority = 0;
        switch (value)
        {
            case "+":
            case "-":
                priority = 2;
                break;
            case "*":
            case "/":
            case "%":
                priority = 3;
                break;
            case "^":
                priority = 4;
                break;
            case "(":
            case ")":
            case "#":
                priority = 1;
                break;
        }
        return priority;
	}

	public boolean isSharpSymbol() {
		return Helper.isSharpSymbol(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
