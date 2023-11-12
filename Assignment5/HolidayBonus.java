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
public class HolidayBonus extends TwoDimRaggedArrayUtility{
	public static  final int BONUS_FOR_HIGHEST_STORE = 5000;
	public static  final int BONUS_FOR_LOWEST_STORE = 1000;
	public static  final int BONUS_FOR_EACH_STORE = 2000;
	
	
	public HolidayBonus()
	{
		super();
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][] data)
	{
		final int NUM_OF_STORES = data.length;
		double[] hotelBonuses = new double[NUM_OF_STORES];
		double currentStoreBonus = 0.0;
		for(int row =0; row < NUM_OF_STORES; row++)
		{
			for(int column = 0; column < data[row].length; column++)
			{
				if (column < data[row].length)
				{
					if (getHighestInColumnIndex(data, column) == row)
						currentStoreBonus += BONUS_FOR_HIGHEST_STORE;
					else if ((getLowestInColumnIndex(data, column) == row)&& (data[row][column] >0) )
						currentStoreBonus += BONUS_FOR_LOWEST_STORE;
					else if (data[row][column] <= 0)
						currentStoreBonus +=0;
					else 
						currentStoreBonus += BONUS_FOR_EACH_STORE;
				}
			}
			hotelBonuses[row] = currentStoreBonus;
			currentStoreBonus=0.0;	
		}
		return hotelBonuses;
	}
	
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double[] allBonus =  calculateHolidayBonus(data);
		double totalBonus = 0.0;
		for(int i =0; i< allBonus.length; i++)
		{
			totalBonus += allBonus[i];
		}
		return totalBonus;
	}
}
