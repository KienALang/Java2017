public class Chapter01 {

	public void linearEquation(float a, float b) {
		System.out.println((a != 0) ? "x = "+ -b/a :
			(b == 0 ? "The equation has a lot of root!" : "the equation has no root"));
	}

	public void quadraticEquation(float a, float b, float c) {
		if (a == 0) {
			this.linearEquation(b, c);
		}else {
			float delta = b*b - 4*a*c;
			boolean isComplexRoot = delta < 0 ? true : false;
			if (delta == 0) System.out.println("x = "+ -b/(2*a));
			else {
				delta = isComplexRoot ? -delta : delta;
				float sqrtDelta = (float) Math.sqrt(delta);

				System.out.print("x1 = ");
				System.out.print(isComplexRoot ? -b/(2*a) + " + "+ sqrtDelta/(2*a)+"i" : (-b + sqrtDelta)/(2*a));
				System.out.print(";\t");
				System.out.print("x2 = ");
				System.out.print(isComplexRoot ? -b/(2*a) + " + "+ -sqrtDelta/(2*a)+"i": (-b - sqrtDelta)/(2*a));
				System.out.println();
			}
			
		}		
	}

	public void middleNumber(float a, float b, float c) {
		float max = (a > b && a > c) ? a : (b > c ? b : c);
		float min = (a < b && a < c) ? a : (b < c ? b : c);

		System.out.println("The middle number is: " + (a+b+c-max-min));
	}

	public void karaokeCalculation(int startTime, int endTime) {
		int payment = (startTime <= 18) ? (endTime - startTime) * 45000 : (endTime - startTime) * 60000;
		System.out.println("You have to pay: "+payment);
	}

	public void numberofDay(int year, int month) {
		int number = 31;
		boolean isLeapYear = (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)) ? true : false;

		switch(month) {
			case 4:  case 6: case 9: case 11: number = 30; break;
			case 2: {number = isLeapYear ? 29 : 28; break;}
		}

		System.out.println("Numer of day in the month and year given: "+number);
	}

	public float calculation_06(int n) {

		float result = 0;
		if (n > 0) {			
			while (n > 0) {
				result += (float) 1/n;
				--n;
			}
		}
		return result;
	}

	public float calculation_07(int n) {
		float result = 0;
		if (n > 0) {	
			result = 15;
			int negative = 1;			
			int i = 1;
			int denominator = 1;

			while (i <= n) {				
				negative = -negative;	

				denominator *= i;			
				result += (float) negative/denominator;
				++i;
			}
		}
		return result;
	}

	public float calculation_08(int n) {

		float result = 0;
		if (n > 0) {	
			int i = 1;
			int denominator = 1;

			while (i <= n) {				
				denominator *= i * (2*i -1);			
				result += (float) 1/denominator;
				++i;
			}
		}
		return result;
	}

	public int calculation_09(int n) {

		int result = 1;
		if (n > 0) {
			while (n > 1) {
				result *= n;
				n -= 2;
			}
		}

		return result;
	}

	public int calculation_10(int n) {

		int result = 0;
		while (n > 0) {
			result += n%10;
			n /= 10;
		}
		return result;
	}

	public boolean isPrimeNumber(int num) {
		if ( num > 2 && num%2 == 0 ) return false;

		int top = (int) Math.sqrt(num) + 1;
		for(int i = 3; i < top; i+=2) 
			if(num % i == 0) return false;

		return true;
	}
	
	public boolean isSquareNumber(int number) {
		int res = (int) Math.sqrt(number);
		return res*res == number;
	}

	public boolean isSymmetryNumber(int number) {
		int array[] = new int[10];
		int num = -1;
		while (number > 0) {			
			array[++num] = number % 10;
			number /= 10;			
		}
		int index = 0;
		while (num >= index) {
			if (array[index] != array[num])
				return false;
			--num; ++index;
		}
		
		return true;
	}

	public void primeNumberLessThanOrEqual(int n) {;
		boolean array[] = new boolean[n+1];
		java.util.Arrays.fill(array, true);
		
		int notExceed = (int) Math.sqrt(n);
		for (int i = 2; i <= notExceed; ++i ) {
			if (array[i]) 
				for (int k = i*i; k <= n; k += i) array[k] = false;
			}

		for (int i = 2; i <= n; ++i )
			if (array[i]) System.out.println(i);
	}

	public void perfectNumberLessThan_1000() {
		int[] p = {2, 3, 5, 7, 13, 17, 19, 31, 61, 89, 107, 127, 521, 607};
		int i = 0;
		int k = p[i] - 1;
		int value = (2 << k) - 1;
		value *= 2 << (k-1);

		while(value < 1000)
		{
			System.out.println(value);
			k = p[++i] - 1;
			value = (2 << k) - 1;
			value *= 2 << (k-1);
		}

	}

	public void print_N_FirstFinonaci(int n) {
		int f1 = 1, f2 = 1;
		System.out.print(f1+";\t"+f2);
		int i = 3;
		while(i <= n) {			
			int temp = f2;
			f2 = f2 + f1;
			f1 = temp;

			System.out.print(";\t"+f2);
			++i;
		}
	}

	public boolean checkFibonaci(int n) {				
		double phi = 0.5 + 0.5*Math.sqrt(5.0);
		double a = phi * n;

		return n == 0 || Math.abs(Math.round(a) - a) < 1.0/n;
	}

	public void greatestCommonDivisorAndLeastCommonMultiple(int a, int b) {
		int multiAB = a*b;
		int temp;
		while(b != 0){
			temp = a % b;
			a = b;
			b= temp;
		}
		System.out.println("Greatest Common Divisor of a and b is: "+a);
		System.out.println("Least Common Multiple a and b is: "+ multiAB/a);
	}

	public static void main(String[] args) {
		
		Chapter01 object = new Chapter01();
		
		object.linearEquation(0, 0);

		object.quadraticEquation(4, 4, 8);

		object.middleNumber(18,6,3);

		object.karaokeCalculation(12, 15);

		object.numberofDay(2016, 2);

		System.out.println("Exercise 6: S = "+object.calculation_06(10));
		System.out.println("Exercise 7: S = "+object.calculation_07(20));
		System.out.println("Exercise 8: S = "+object.calculation_08(2));
		System.out.println("Exercise 9: S = "+object.calculation_09(4));
		System.out.println("Exercise 9: S = "+object.calculation_09(5));
		System.out.println("Exercise 10: S = "+object.calculation_10(7832));
		
		System.out.println(object.isPrimeNumber(997));
		object.primeNumberLessThanOrEqual(997);

		object.greatestCommonDivisorAndLeastCommonMultiple(0, 14);
		
		System.out.println(object.isSquareNumber(16));
		System.out.println(object.isSymmetryNumber(121));
		object.print_N_FirstFinonaci(30);

		System.out.println("\n"+object.checkFibonaci(832040));	
		object.perfectNumberLessThan_1000();

	}
	
}