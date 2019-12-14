import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SplittingPixels {
    public static String[] closestColor(String[] pixels) {
    	String[] answer = new String[pixels.length];
    	for (int i = 0; i < answer.length; i++) {
	    	int first = 0;
	    	int second = 0;
	    	int third = 0;
	    	for (int j = 0; j <= pixels.length; j++) {
	    		first = Integer.parseInt(pixels[j].substring(0,7), 2);
	    		second = Integer.parseInt(pixels[j].substring(8,15), 2);
	    		third = Integer.parseInt(pixels[j].substring(8,23), 2);
	    	}
			TreeMap<String, Float> distanceMap = new TreeMap<String, Float>();
			distanceMap.put("Black", getGeometricDistance(first, second, third, 0, 0, 0));
			distanceMap.put("White", getGeometricDistance(first, second, third, 255, 255, 255));
			distanceMap.put("Red", getGeometricDistance(first, second, third, 255, 0, 0));
			distanceMap.put("Green", getGeometricDistance(first, second, third, 0, 255, 0));
			distanceMap.put("Blue", getGeometricDistance(first, second, third, 0, 0, 255));

			Set distanceSet = distanceMap.entrySet();
			Iterator iterator = distanceSet.iterator();
			float minDistance = 0;
		    while(iterator.hasNext()) {
		        Map.Entry me = (Map.Entry)iterator.next();
		        if (me.getValue() == minDistance){
		         	answer[i] = "Ambiguous";
		         	break;
		        }
		        else {
		        	answer[i] = distanceMap.firstEntry();
		        }
		    }
		}
		return answer;
    }

    public static float getGeometricDistance(int r1, int g1, int b1, int r2, int g2, int b2) {
    	float geometricDistance = (float) (Math.sqrt(Math.pow((r1 - r2),2) + Math.pow((g1 - g2),2) + Math.pow((b1 - b2),2)));
    	return geometricDistance;
    }
	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);

		String[] testArray = new String[1];
		testArray[0] = "101111010110011011100100";
		System.out.println(closestColor(testArray));
	}
}