package support;





import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import dictionary.Demo;
import dictionary.FoodInfo;

public class ReadDictionary {
	String foodInfo;
	String description;
	int capacity = 1;
	public FoodInfo [ ] fmArray = new FoodInfo [capacity];
	public ArrayList<FoodInfo> flist = new ArrayList<FoodInfo>();
	int size = 0;
	
	public void readFoodData (String infileName)
	{
		Scanner infile = null;
		try
		{
			infile = new Scanner (new File (infileName));
		}
		catch (FileNotFoundException ex)
		{
			System.out.println ("file not found");
			System.exit (0);
		}

		while (infile.hasNext ( ))
		{
			String name = infile.nextLine();
			String description = infile.nextLine();			
			FoodInfo fInfo = new FoodInfo(name,description);
			flist.add(fInfo);
			/*
			FoodInfo fInfo = new FoodInfo (name,description);
		
			append(fInfo);			*/
		}
		
		infile.close ( );
		
	}
	/*private void expand ( )
	{
		// System.out.println ("\n\narray being expanded.......\n\n");
		capacity += 1;
		FoodInfo[ ] temp = new FoodInfo[capacity];
		for (int i = 0; i < size; i++)
			temp[i] = fmArray[i];
		fmArray = temp;

	}
	public void append (FoodInfo newFood)
	{
		if (size == capacity){
			expand();
		}
		fmArray[size++] = newFood;
	}*/
	public void writeBackToFile (String outfileName)
	{

		PrintWriter outfile = null;

		try
		{
			outfile = new PrintWriter (outfileName);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println ("fail to open file");
			System.exit (0);
		}
		for(int i = 0; i <flist.size(); i++){
			outfile.println(flist.get(i).getFoodName());
			outfile.println(flist.get(i).getDescription());
		}
		outfile.close ( );


	}

}
