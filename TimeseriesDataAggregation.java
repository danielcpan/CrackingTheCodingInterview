import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeseriesDataAggregation {
    public static void main(String args[] ) throws Exception {
    	readFileByLine("input002.txt");
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }

    public static void readFileByLine(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	
			Date start = new Date();
			Date end = new Date();
			String[] firstLine = scanner.nextLine().split("\\s*,\\s*");
			try {
				// System.out.println(firstLine[0]+"-01");
				// start = sdf.parse(firstLine[0]+"-01");
				// end = sdf.parse(firstLine[1]+"-00");
				start = sdf.parse(firstLine[0]);
				end = sdf.parse(firstLine[1]);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
			// firstLine.split(",");
			// firstLine = firstLine.split("\\s*,\\s*");
			// System.out.println(convertStringToDate(start));
			System.out.println(sdf.format(start));
			System.out.println(sdf.format(end));
			System.out.println("Break");
			int index = 0;
			Date temp = new Date();
			List<String> entries = new ArrayList<String>();
			TreeMap<String, String> output = new TreeMap<String, String>(Collections.reverseOrder());
			// TreeMap<String, Integer> keyTreeMap = new TreeMap<String, Integer>();
			// TreeMap<String, TreeMap<String, Integer>> output = new TreeMap<String, TreeMap<String, Integer>>(Collections.reverseOrder());
			while (scanner.hasNextLine()) {
				// if (scanner.nextLine().isEmpty() == true) {
				// 	System.out.println("Skip");
				// 	continue;
				// }
				// String[] entries = scanner.nextLine().split("\\s*,\\s*");
				// String[] entry = Arrays.asList(scanner.nextLine().splt("\\s*,\\s*"));
				String[] entry = scanner.nextLine().split("\\s*,\\s*");
				entries.add(Arrays.toString(Arrays.copyOfRange(entry, 0, 3)));
				// System.out.println(entires);
				// entries.add(entry);
				// System.out.println(Arrays.toString(entries));
				// System.out.println(entries);
				// System.out.println(scanner.nextLine());
				try {
					temp = sdf.parse(entry[0]);
				}
				catch (ParseException e) {
					// e.printStackTrace();
				}
				if (temp.compareTo(start) > 0 && temp.compareTo(end) < 0 || temp.compareTo(start) == 0 || temp.compareTo(end) == 0) {
					// System.out.println(entries);
					// String input = sdf.format(temp) + ", " + entry[1] + ", " + entry[2];
					String input = entry[1] + ", " + entry[2];
					// TimeseriesData myData = new TimeseriesData(entry[1], entry[2]);
					// System.out.println(input);
					if (!output.containsKey(sdf.format(temp))) {
						output.put(sdf.format(temp), input);
					}
					else if (output.containsKey(sdf.format(temp))) {
						String tempVal = output.get(sdf.format(temp));
						// if (sdf2.parse(tempVal))
						// String[] concatVal = (tempVal + ", " + input).split("(\\,|[^,])+");
						// output.put(sdf.format(temp), Arrays.toString(concatVal));
						output.put(sdf.format(temp), tempVal + ", " + input);
					}
					// String input = sdf.format(temp) + ", " entry[1] + ", " entry[2];
					// System.out.printf("%s, %s, %s\n", sdf.format(temp), entry[1], entry[2]);
					// System.out.println(Arrays.toString(entry));
				}
				// if (entries[index]) {
				// 	System.out.println(Arrays.toString(entries));
				// }
				// System.out.println(scanner.nextLine());
				// System.out.println("Next");
				// index+=3;
			}
			printMap(output);

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

    public static void printMap(TreeMap<String, String> charMap) {
              // Get a set of the entries
      Set charSet = charMap.entrySet();
      
      // Get an iterator
      Iterator iterator = charSet.iterator();
      
      // Display elements
      while(iterator.hasNext()) {
         Map.Entry me = (Map.Entry)iterator.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
    }	

	// public static String convertStringToDate(String myDate) {
	//     try {
	//     	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//     	Date date = sdf.parse(myDate);
	//     }
	//     catch (ParseException e) {
	//       e.printStackTrace();
	//     }		
	//     return date;
	// }
}

// public class TimeseriesData {
// 	public String name;
// 	public int count;

// 	public TimeseriesData(String _name, int _count) {
// 		name = _name;
// 		count = _count;
// 	}

// 	public String getData() {
// 		return name + ", " + count;
// 	}
// }
