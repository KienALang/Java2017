package com.kien;

import java.util.ArrayList;
import java.util.List;

public class Helper {

	public static List<Element> SeparateExpression(String expression) {
		String mExpression = expression.replace(" ", "");

        List<Element> elements = new ArrayList<Element>();
        String element = "";

        for (char item: mExpression.toCharArray())
        {
            if (!isOperator(String.valueOf(item)))
            {
                element += String.valueOf(item);
            }
            else
            {
                if (!element.equals(""))
                    elements.add(new Element(element));

                elements.add(new Element(String.valueOf(item)));
                element = "";
            }
        }
        if (!element.equals(""))
            elements.add(new Element(element));

        return elements;
	}
	
	public static boolean isOperator(String sym) {
		return ("+-*/%()".indexOf(sym) > -1);
	}

	public static boolean isOpenBracket(String sym) {
		return sym.equals("(");
	}

	public static boolean isCloseBracket(String sym) {
		return sym.equals(")");
	}

	public static boolean isSharpSymbol(String sym) {
		return sym.equals("#");
	}

}
