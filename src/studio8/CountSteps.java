package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.
public class CountSteps{
	public static void main(String [] args) throws FileNotFoundException
	{
		double average = 0;
		int counter = 0;
		int count = 0;
		int peaks = 0;
		double values[] = new double[3];
		String line = "";
		String set[] = new String[4];
		
		File file = new File("/Users/JonathanRichter/git/studio-8-richter_studio_8/src/studio8/PeakDataZ.csv");
		Scanner scan = new Scanner(file);
		if(file.exists())
		{
			while(scan.hasNextLine())
			{
				line = scan.nextLine();
				set = line.split(",");
				average += Double.parseDouble(set[2]);
				values[counter] = Double.parseDouble(set[2]);
				counter++;
				count++;
				
				if(counter > 2)
					counter = 0;
				if(count >= 2)
				{
					if ((values[1] > values[0]) && ( values[1] > values[2]))
					{
						if(values[1] > average/count ){
								peaks++;
								System.out.println(count);
						}
						
					}
				}
				
			}
			System.out.println(peaks);
		}
	}
}
