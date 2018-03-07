package pajkouisn.unit;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import pajkouisn.utilities.collections.MapOperations;


/**
 * 
 * 	JUnit tests for MapOperations.
 * 	
 * 	@author kartiklaw@gmail.com (www.kartik-reddy.com)
 *
 */
public class TestMapOperations
{
	
	static Map<String, Integer> map = new HashMap<String, Integer>();

	static
	{
		map.put("B", 2);
		map.put("A", 1);
		map.put("C", 3);
		map.put("E", 5);
		map.put("D", 4);
	}
	
	/*
	 * 	Ascending sort of the map.
	 */
	@Test
	public void testSortMapAscending()
	{
		int currentValue = 0;
		boolean check = true;
		
		for(Entry<String, Integer> entry : MapOperations.sortMap(map, true).entrySet())
		{
			if(currentValue <= entry.getValue())
			{
				check &= true;
				currentValue = entry.getValue();
			}
			else check &= false;
		}
		
		assertTrue(check);
	}
	
	/*
	 * 	Descending sort of the map.
	 */
	@Test
	public void testSortMapDescending()
	{
		int currentValue = 6;
		boolean check = true;
		
		for(Entry<String, Integer> entry : MapOperations.sortMap(map, false).entrySet())
		{
			if(currentValue >= entry.getValue())
			{
				check &= true;
				currentValue = entry.getValue();
			}
			else check&=false;
		}
		
		assertTrue(check);
	}
	
	/*
	 * 	Transpose the map.
	 */
	@Test
	public void testTransposeMap()
	{
		boolean check = true;
		
		for(Entry<?, ?> entry : MapOperations.transposeMap(map).entrySet())
		{
			if ((entry.getKey() instanceof Integer) && (entry.getValue() instanceof String))
				check &= true;
			else check &= false;
		}
		
		assertTrue(check);
	}
}
