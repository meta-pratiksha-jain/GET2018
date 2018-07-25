/**
 * Immutable IntSet class represents set of Inegers in the range of 1-1000(both inclusive)
 */
import java.util.*;
public final class IntSet {
    private final int[] set;
    private final int UPPERLIMIT=1000;
    private final int LOWERLIMIT=1;
     
    /**
     * constructor initializes set
     * @param setArray
     */
    public IntSet(int[] setArray)
    {
       for(int i=0;i<setArray.length;i++)
       {
           if(setArray[i]<LOWERLIMIT || setArray[i]>UPPERLIMIT)
           {
               throw new AssertionError("some elements are not in the range of "+LOWERLIMIT+"-"+UPPERLIMIT);
           }
           for(int j=0;j<i;j++)
           {
               if(setArray[i]==setArray[j])
               {
                   throw new AssertionError("some elements are duplicated");
               }
           }
       }
       set=setArray;
    }
    
    public int[] getSet()
    {
        return set;
    }
    
    /**
     * Checks whether element is in set or not
     * @param element 
     * @return true if element is in set otherwise false
     */
    public boolean isMember(int element)
    {
        boolean isMemberOfSet=false;
        for(int i:set)
        {
            if(i==element)
            {
                isMemberOfSet=true;
                return isMemberOfSet;
            }
        }
        return isMemberOfSet;
    }
    
    /**
     * returns size of set
     * @return size
     */
    public int getSize()
    {
        int size=set.length;
        return size;
    }
    
    /**
     * checks whether a set is subset of another set or not
     * @param intSetInstance contains the subset which is to be checked
     * @return subSet returns true if it is subset of set otherwise false
     */
    public boolean isSubSet(IntSet intSetInstance)
    {
        boolean subSet=true;
        for(int i:intSetInstance.set)
        {
            boolean isMemberOfSet=this.isMember(i);
            if(!isMemberOfSet)
            {
                subSet=false;
                break;
            }
        }
        return subSet;
    }
    
    /**
     * finds complement of a set
     * @return complementSet contains complement of set 
     */
    public IntSet getComplement()
    {
        int sizeOfSet=this.getSize();
        int sizeOfComplement=UPPERLIMIT-LOWERLIMIT+1-sizeOfSet;
        int[] complementArray=new int[sizeOfComplement];
        int index=0;
        for(int i=LOWERLIMIT;i<=UPPERLIMIT;i++)
        {
            boolean isMemberOfSet=this.isMember(i);
            if(!isMemberOfSet)
            {
               complementArray[index]=i;
               index++;
            }
        }
        IntSet complementSet=new IntSet(complementArray);
        return complementSet;
    }
    /**
     * finds union of two sets
     * @param setInstance contains set whose union operation is performed with set object which calls this function.
     * @return union of two sets
     */
    public IntSet getUnion(IntSet setInstance)
    {
        int temporarySize=this.getSize()+setInstance.getSize();
        int[] temporaryArray=new int[temporarySize];
        int index=0;
        for(int i:this.set)
        {
            temporaryArray[index]=i;
            index++;
        }
        for(int i:setInstance.set)
        {
            boolean ismember=this.isMember(i);
            if(!ismember)
            {
                temporaryArray[index]=i;
                index++;
            }
        }
        int[] unionArray=new int[index];
        for(int i=0;i<index;i++)
        {
            unionArray[i]=temporaryArray[i];
        }
        IntSet unionSet=new IntSet(unionArray);
        return unionSet;
    }

}
