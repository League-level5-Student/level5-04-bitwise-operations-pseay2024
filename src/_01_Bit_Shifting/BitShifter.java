package _01_Bit_Shifting;

import java.util.ArrayList;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 7;
		int numShifted = num << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted);
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		//ya
		// 4. Try shifting num 3 places.
		System.out.println(ctb(num));
		System.out.println(ctb(numShifted));
		numShifted = num << 3;
		System.out.println(ctb(numShifted));
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
	}
	static String ctb(int a)
	{
		int i = 0;
		ArrayList<Integer> doubles = new ArrayList<Integer>();
		while (Math.pow(2, i) <= a)
		{
			doubles.add((int)Math.pow(2, i));
			i++;
		}
		String r = "";
		for (int j = doubles.size() - 1; j >= 0; j--)
		{
			if (a - doubles.get(j) >= 0)
			{
				a-=doubles.get(j);
				r+="1";
			}
			else r+="0";
		}
		return r;
	}
}
