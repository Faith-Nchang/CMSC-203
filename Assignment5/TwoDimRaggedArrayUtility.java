/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Two Dimensional Ragged Array Utility
 * Due: 11/13/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Faith Fru Nchang
*/


import java.io.*;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility {
	private static final int MAX_ROW = 10;
	private static final int MAX_COLUMN = 10;
	
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		// Stores the doubles from a file as a string
		String[][] temporaryArray = new String[10][10];
		
		int lineNumber = 0; // the current line number in the file
		// an input file object
		Scanner inFile = new Scanner(file);
		// reads all the lines in the file
		while(inFile.hasNext())
		{
			// tokenize each line and store it in an array
			String[] line = inFile.nextLine().split(" ");
			for(int i =0; i < line.length; i++)
			{
				temporaryArray[lineNumber][i] = line[i];
			}
			lineNumber++;
		}
		
		int rows = 0;
		for(int i = 0; i<10; i++)
		{
		   if (temporaryArray[i][0] != null)
		        rows++;
		  
		} 
		
		double[][] array = new double[rows][];
		
		int columns = 0;
		for(int i = 0; i<rows; i++)
		{
		   for (int j = 0; j< 10; j++)
		   {
			   if (temporaryArray[i][j] != null)
				   columns++;
		   }
		   array[i] = new double[columns];
		   for(int column =0; column <columns; column++)
		   {
			   array[i][column] = Double.parseDouble(temporaryArray[i][column]);
		   }
		   // sets the number of columns for the next row to 0
		   columns = 0;
		} 
		
		inFile.close();
		return array;
	}
	
	/**
	 * 
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter outFile = new PrintWriter(outputFile);
		for(int row =0; row < data.length; row++)
		{
			for (int column =0; column < data[row].length; column++) {
				outFile.print(data[row][column] +" ");
			}
			outFile.println();
		}
		outFile.close();
	}
	
	/**
	 *  returns the sum of all the elements in the two Dimensional ragged array
	 * @param data - two dimensional ragged array
	 * @return total - sum of all the elements in the array
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0.0;
		for(int i =0; i < data.length; i++)
		{
			for(int j =0; j< data[i].length; j++)
			{
				total += data[i][j];
			}
		}
		return total;
	}
	
	/**
	 * computes the average of all the elements in the array
	 * @param data - two dimensional array
	 * @return average -  the average of the elements in the two dimensional array
	 */
	public static double getAverage(double[][] data)
	{
		int numberOfElements = 0;
		double total = 0.0;
		for(int i =0; i < data.length; i++)
		{
			for(int j =0; j< data[i].length; j++)
			{
				total += data[i][j];
				numberOfElements++;
			}
		}
		
		double average = total / numberOfElements;
		return average;
	}
	
	/**
	 * computes the sum of all the elements in a row
	 * @param data - two dimensional array
	 * @param row - row index
	 * @return rowTotal - sum of the row
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double rowTotal = 0.0;
		for(int column=0; column < data[row].length; column++)
		{
			rowTotal += data[row][column];
		}
		
		return rowTotal;
	}
	
	/**
	 * 
	 * @param data
	 * @param column
	 * @return
	 */
	public static double getColumnTotal(double[][] data, int column)
	{
		double columnTotal = 0.0;
		for(int row =0; row < data.length; row++)
		{
			if (column < data[row].length)
				columnTotal += data[row][column];
		}
		return columnTotal;
	}
	
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		double highestInRow = data[row][0];
		for(int column =1; column < data[row].length; column++)
		{
			if(highestInRow < data[row][column])
			{
				highestInRow =  data[row][column];
			}
		}
		return highestInRow;
		
	}
	
	
	
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double highestElement = getHighestInRow(data, row);
		int index =0;
		for (int j =0; j< data[row].length; j++)
		{
			if (data[row][j] == highestElement)
				index = j;
		}
		return index;
		
	}
	
	/**
	 * finds the lowest value in the row
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowestInRow = data[row][0];
		for(int column =0; column < data[row].length; column++)
		{
			if (data[row][column] < lowestInRow)
			{
				lowestInRow = data[row][column];
			}
		}
		return lowestInRow;
	}
	
	/**
	 *  finds the index of the lowest element in a row
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowestInRow = getLowestInRow(data, row);
		int index = 0;
		for(int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] == lowestInRow)
				index = column;
		}
		return index;
	}
	
	/**
	 * 
	 * @param data
	 * @param column
	 * @return
	 */
	public static double getHighestInColumn(double[][] data, int column)
	{
//		double highestInColumn = data[0][column];
		double highestInColumn = 0;
		for(int row=0; row< data.length; row++)
		{
			if (column < data[row].length)
			{
				if(data[row][column] > highestInColumn)
					highestInColumn = data[row][column];
			}
		}
		return highestInColumn;
	}
	
	/**
	 * 
	 * @param data
	 * @param column
	 * @return
	 */
	public static int getHighestInColumnIndex(double[][] data, int column)
	{
		double highestInColumn = getHighestInColumn(data, column);
		int index = 0;
		for(int row =0; row < data.length; row++)
		{
			if (column < data[row].length)
			{
				if (data[row][column] == highestInColumn)
					index = row;
			}
			else
				continue;
			
		}
		return index;
	}
	
	/**
	 * 
	 * @param data
	 * @param column
	 * @return
	 */
	public static double getLowestInColumn(double[][] data, int column)
	{
//		double lowestInColumn =  data[0][column];
		double lowestInColumn = getHighestInColumn(data, column);
		for( int row = 0; row < data.length; row++)
		{
			if (column < data[row].length)
			{
				if (data[row][column] < lowestInColumn)
				{
					lowestInColumn = data[row][column];
				}
			}
		}
		return lowestInColumn;
	}
	
	
	/**
	 * 
	 * @param data
	 * @param column
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][] data, int column)
	{
		double lowestInColumn = getLowestInColumn(data, column);
		int index =0;
		for(int row =0; row < data.length; row++)
		{
			if (column < data[row].length)
			{
				if (data[row][column] == lowestInColumn)
					index = row;
			}
		}
		return index;
	}
	
	/**
	 *  finds the highest element in the array
	 * @param data
	 * @return
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highestInArray = data[0][0];
		for (int row =0; row < data.length; row++)
		{
			for (int column =0; column < data[row].length; column++)
			{
				if (data[row][column] > highestInArray)
					highestInArray = data[row][column];
			}
		}
		return highestInArray;
	}
	
	/**
	 * finds the lowest elements in the array
	 * @param data
	 * @return
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowestInArray = data[0][0];
		for (int row =0; row < data.length; row++)
		{
			for (int column =0; column < data[row].length; column++)
			{
				if (data[row][column] < lowestInArray)
					lowestInArray = data[row][column];
			}
		}
		return lowestInArray;
	}
}
