/**
 * 
 */
package rcp.util;

/**
 * @author Tuan
 *
 */
public class MathF {
	public static String removeDot(String floatString) {
		StringBuilder str = new StringBuilder();
		char[] fChar = floatString.toCharArray();
		
		for(char i : fChar) {
			if (i >= '0' && i <= '9')
				str.append(i);
		}
		
		return str.toString();
	}
	
	public static String formatFloat(float number) {
		return String.format("%.3f", number);
	}
}
