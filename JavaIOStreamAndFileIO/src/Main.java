import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public void greatestCommonDivisorAndLeastCommonMultiple(int a, int b) {
		int multiAB = a * b;
		int temp;
		while (b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		System.out.println("Greatest Common Divisor of a and b is: " + a);
		System.out.println("Least Common Multiple a and b is: " + multiAB / a);
	}

	public void stringProcessing(String mStr) {
		char charArr[] = mStr.toCharArray();
		// Bai tap 6.2
		System.out.print("String revert: ");
		for (int i = charArr.length - 1; i >= 0; --i) {
			System.out.print(charArr[i]);
		}

		System.out.print("\nString to UPERCASE: ");
		System.out.println(mStr.toUpperCase());

		System.out.print("\nString to lowercase: ");
		System.out.println(mStr.toLowerCase());

		System.out.print("\nString change UP to LOW and LOW to UP: ");
		for (char ch : charArr) {
			if (ch >= 'a' && ch <= 'z')
				System.out.print((char) (ch - 32));
			else if (ch >= 'A' && ch <= 'Z')
				System.out.print((char) (ch + 32));
			else
				System.out.print(ch);
		}
		
		
		// BAI TAP 6.3
		ArrayList<String> list = new ArrayList<>();
		
		System.out.print("\nPrint word: ");
		String temp = "";
		for (char ch : charArr) {
			if (ch == ' ' && !temp.equals(" ")) {
				list.add(temp);
				System.out.println(temp);
				temp = "";
			} else 
				temp += ch;
		}
		
		if (!temp.equals(" "))
		{
			list.add(temp);
			System.out.println(temp);
			temp = "";
		}
		
		ArrayList<String> mList = list;
		Collections.sort(mList);

	}

	public static String readLine() {
		InputStreamReader cin = null;
		int a;
		String first = "";
		try {
			cin = new InputStreamReader(System.in);
			do {
				a = cin.read();
				if (a != 13)
					first += (char) a;
			} while (a != 13);

		} catch (IOException e) {

		}
		return first;
	}

	public static void main(String[] args) {
		Main obj = new Main();
		//
		// System.out.println("Enter a: ");
		// int a = Integer.parseInt(readLine());
		// System.out.println("Enter b: ");
		// int b = Integer.parseInt(readLine());
		//
		// obj.greatestCommonDivisorAndLeastCommonMultiple(a, b);

		System.out.println("Enter String: ");
		obj.stringProcessing(readLine());
	}
}