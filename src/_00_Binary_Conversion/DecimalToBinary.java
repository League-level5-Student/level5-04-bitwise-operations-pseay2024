package _00_Binary_Conversion;

import java.util.ArrayList;

public class DecimalToBinary {
	public static void main(String[] args) {
		//Converting a decimal number to binary is a little trickier.
		
		//EXAMPLE: Convert 43 to binary
		
		/*
		 *  Step 1: Start with one and add a digit the left that is double the value of the previous number.
		 *          Stop when you've passed the target number        
		 *          eg. 43
		 *         	64	32	16	8	4	2	1
		 *        
		 *	Step 2: Remove the left most value (the one that is higher than the target). 
		 *			eg. 43
		 *         	32	16	8	4	2	1
		 *         
		 *  Step 3: Find the combination of values that add up to the target number.
		 *  		eg. 43
		 *         	32	16	8	4	2	1
		 *          43= 32 + 8 + 2 + 1
		 *         
		 *  Step 4: Every matching number in the list is a 1, and non-matching is a 0.
		 *  		eg. 43
		 *         	32	16	8	4	2	1
		 *          43 = 32 + 8 + 2 + 1
		 *         
		 *          1    0   1   0   1   1
		 *          32	16	 8	 4	 2	 1
		 *         
		 *         43 in decimal is 101011 in binary!
		 */
		System.out.println(convertToBin(43));
		
	}
	static String convertToBin(int a)
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
