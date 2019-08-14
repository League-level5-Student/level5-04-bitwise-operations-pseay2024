package _03_Printing_Binary;

import java.util.ArrayList;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public static void main(String[] args) {
		byte b = Byte.MAX_VALUE;
		short s = Short.MAX_VALUE;
		int i = Integer.MAX_VALUE;
		long l = Long.MAX_VALUE;
		printByteBinary(b);
		printShortBinary(s);
		printIntBinary(i);
		printLongBinary(l);
		
	}
	
	static public void printByteBinary(byte b) {
		System.out.println(ctb(b));
	}
	
	static public void printShortBinary(short s) {
		System.out.println(ctb(s));
	}
	
	static public void printIntBinary(int i) {
		System.out.println(ctb(i));
	}
	
	static public void printLongBinary(long l) {
		System.out.println(ctb(l));
	}
	
	static String ctb(long a)
	{
		long i = 0;
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
