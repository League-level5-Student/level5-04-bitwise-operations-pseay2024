package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Base64;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c)
	{
		for (byte i = 0; i < base64Chars.length; i++)
		{
			if (c == base64Chars[i]) return i;
		}
		return 0;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		byte[] bs = new byte[3];
		String binary = "";
		for (int i = 0; i < s.length() && i < 4; i++)
		{
			char c = s.charAt(i);
			binary+=convertToBin(convertBase64Char(c));
		}
		bs[0] = (byte)convertToInt(binary.substring(0,8));
		bs[1] = (byte)convertToInt(binary.substring(8,16));
		bs[2] = (byte)convertToInt(binary.substring(16));
		return bs;
	}
	
	static int convertToInt(String curbin)
	{
		int total = 0;
		for (int i = 0; i < curbin.length(); i++)
		{
			if (curbin.charAt(i) == '1')
			{
				int x = curbin.length() - i - 1;
				total+=Math.pow(2.0, (double)x);
			}
		}
		return total;
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
		while (r.length() < 6)
		{
			r = "0" + r;
		}
		return r;
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] bytes = new byte[(file.length()/4)*3];
		int index = 0;
		for (int i = 0; i <= file.length() - 4; i+=4)
		{
			byte[] bs = (convert4CharsTo24Bits(file.substring(i, i+4)));
			for (byte b : bs)
			{
				bytes[index] = b;
				index++;
			}
		}
		return bytes;
	}
}
