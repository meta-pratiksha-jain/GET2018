package uniqueCharacterCount;

import java.util.*;

public class UniqueCharacterCount {
    CacheOfCount cache;
    
    /**
     * constructor
     */
    public UniqueCharacterCount()
    {
        cache=new CacheOfCount();
    }
    
    /**
     * counts the number of unique characters in a string.
     * @param string
     * @return returns numberOfUniqueCharacters
     */
    public int getNumberOfUniqueCharacter(String string)
    {
        if(string==null)
        {
            throw new AssertionError("String is null");
        }
        int numberOfUniqueCharacters=cache.getCharacterCount(string);
        if(numberOfUniqueCharacters!=-1)
        {
            return numberOfUniqueCharacters;
        }
        Set<Character> setOfUniqueCharacters=new HashSet<Character>();
        Set<Character> setOfRepeatedCharacters=new HashSet<Character>();
        for(int i=0;i<string.length();i++)
        {
            char currentCharacter=string.charAt(i);
            boolean isContainBySetOfReapeatedCharacters=setOfRepeatedCharacters.contains(currentCharacter);
            boolean isContainBySetOfUniqueCharacters=setOfUniqueCharacters.contains(currentCharacter);
            if(!isContainBySetOfReapeatedCharacters)
            {
                if(isContainBySetOfUniqueCharacters)
                {
                    setOfUniqueCharacters.remove(currentCharacter);
                    setOfRepeatedCharacters.add(currentCharacter);
                }
                else
                {
                    setOfUniqueCharacters.add(currentCharacter);
                }
            }
        }
        numberOfUniqueCharacters=setOfUniqueCharacters.size();
        //add the result to cache
        cache.addResult(string,numberOfUniqueCharacters);
        return numberOfUniqueCharacters;
    }

}
