import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

		if (!temp.equals(" ")) {
			list.add(temp);
			System.out.println(temp);
			temp = "";
		}

		ArrayList<String> mList = list;
		Collections.sort(mList);

		String compare = mList.get(0);
		int count = 1;

		for (int i = 1; i < mList.size(); ++i) {
			if (compare.equals(mList.get(i)))
				++count;
			else {
				System.out.println(compare + "->" + count);

				compare = mList.get(i);
				count = 1;
			}
		}
		System.out.println(compare + "->" + count);

	}

	private void oneDimensionalArray() {
		System.out.print("Enter number of element of array: N = ");
		int n = Integer.parseInt(readLine());

		List<Integer> intList = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < n; ++i) {
			System.out.print("Enter value of " + (i + 1) + ": ");
			int temp = Integer.parseInt(readLine());
			intList.add(temp);
			if (temp > 0 && temp % 2 != 0)
				sum += temp;
		}

		System.out.println("Sum of ood number greater than 0 in Array is: " + sum);
		System.out.print("Enter k to find: k = ");
		int k = Integer.parseInt(readLine());

		int position = intList.indexOf(k);
		if (position > -1)
			System.out.println("Found k at " + position);
		else
			System.out.println("K not found");

		Collections.sort(intList);
		System.out.print("Array after sort");
		for (int val : intList)
			System.out.print(val + " ");

		System.out.print("\nInsert a number to Array, enter number k = ");
		k = Integer.parseInt(readLine());

		position = 0;
		for (int val : intList)
			if (k > val)
				++position;

		intList.add(position, k);
		System.out.println("\nArray after add a number");
		for (int val : intList)
			System.out.print(val + " ");
	}

	public void twoDimensionalArray() {
		System.out.print("Enter number of row of array: rowNum = ");
		int rowNum = Integer.parseInt(readLine());
		System.out.print("Enter number of column of array: colNum = ");
		int colNum = Integer.parseInt(readLine());
		int[][] mArray = new int[rowNum][colNum];
		int multiVal = 1;

		for (int row = 0; row < rowNum; ++row)
			for (int col = 0; col < colNum; ++col) {
				System.out.print("Enter mArray[" + row + "][" + col + "] = ");
				int temp = Integer.parseInt(readLine());
				if (row == 0 && temp % 3 == 0)
					multiVal *= temp;

				mArray[row][col] = temp;

			}

		// The value of multiple of element that divisible by 3

		System.out.println("The value of multiple of element that divisible by 3: " + multiVal);

		int[] maxOfRow = new int[rowNum];
		for (int row = 0; row < rowNum; ++row) {
			int[] a = new int[colNum];
			for (int col = 0; col < colNum; ++col) {
				a[col] = mArray[row][col];
			}
			Arrays.sort(a);
			maxOfRow[row] = a[colNum - 1];
		}
		
		System.out.println("Max value of each row: ");
		for (int val : maxOfRow)
			System.out.println(val + " ");
		
		for (int i = 0; i < rowNum - 1; ++i)
			maxOfRow[i] = maxOfRow[i+1];
		
		maxOfRow = Arrays.copyOf(maxOfRow, rowNum-1);
		System.out.println("X[i] after deleted first value: ");
		for (int val : maxOfRow)
			System.out.println(val + " ");
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

		// System.out.println("Enter String: ");
		// obj.stringProcessing(readLine());
		// obj.oneDimensionalArray();
		obj.twoDimensionalArray();
	}
}