package pajkouisn.utilities.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 	This Class adds extra functionalities to a Map.
 * 	1)	sortMap(Map, boolean) 	-->	Sorts the Map based on values.
 * 	2)	transposeMap(Map)	-->	Returns value key pairs.
 * 
 * 	@author kartiklaw@gmail.com (www.kartik-reddy.com)
 *
 */
public class MapOperations 
{
	
	/*
	 * 	Default Constructor to allow map operations.
	 */
	MapOperations()
	{
		
	}
	
	/**
	 * 
	 * 	Sort the map based on values.
	 * 	The boolean field ascending allows you to set whether you want to sort in ascending or descending order.
	 * 
	 * 	@param unsortMap
	 * 	@param ascending
	 * 	@return
	 */
	public static Map<String, Integer> sortMap(Map<String, Integer> unsortMap, boolean ascending) 
	{
		/*
		 * 	Create a linked List of the Entry set.
		 */
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());
		
		/*
		 * 	Override the comparator and sort by values.
		 */
		Collections.sort(list, new Comparator<Entry<String, Integer>>()
		{

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) 
			{
				if(ascending)
					return (o1.getValue()).compareTo( o2.getValue() );
				else
					return (o2.getValue()).compareTo( o1.getValue() );
			}
			
		});
		
		// 	Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
	}

	/**
	 * 	Reverse the key value pairs (Make keys the value and values the key).
	 * 
	 * 	@param originalMap
	 * 	@return transposeMap
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<?, ?> transposeMap(Map<?, ?> originalMap) 
	{
		Map transposedMap = new HashMap();
		
		for(Object key: originalMap.keySet())
		{
			transposedMap.put(originalMap.get(key), key);
		}
			
		return transposedMap;
	}
}
