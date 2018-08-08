package uniqueCharacterCount;

import java.util.*;

/**
 * This class represents cache of string with their unique character count
 * which are previously counted by method getNumberOfUniqueCharacter().
 *
 */

public class CacheOfCount {
    Map<String, Integer> mapOfCharacterCount;
    
    /**
     * constructor
     */
    public CacheOfCount()
    {
        mapOfCharacterCount=new HashMap<String, Integer>();
    }

    public Map<String, Integer> getMapOfCharacterCount() {
        return mapOfCharacterCount;
    }
    
    /**
     * adds an result to the cache.
     * @param string
     * @param numberOfUniqueCharacters
     */
    public void addResult(String string,int numberOfUniqueCharacters)
    {
        mapOfCharacterCount.put(string, numberOfUniqueCharacters);
    }
    
    /**
     * search cache for string and returns its unique character count.
     * @param string
     * @return returns number of unique characters if cache contains character count for string otherwise return -1.
     */
    public int getCharacterCount(String string)
    {
        int numberOfUniqueCharacters=-1;
        for(Map.Entry<String, Integer> entry:mapOfCharacterCount.entrySet())
        {
            String cachedString=entry.getKey();
            if(string.equals(cachedString))
            {
                numberOfUniqueCharacters=entry.getValue();
                return numberOfUniqueCharacters;
            }
        }
        return numberOfUniqueCharacters;
    }

}
