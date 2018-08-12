package nestedList;

import java.io.FileReader;
import java.util.List;

public class ValueInNestedList {
    NestedList nestedListInstance;
    
    public ValueInNestedList()
    {
        nestedListInstance=new NestedList();
    }
    
    private List<List<Integer>> getNestedList()
    {
        List<List<Integer>> nestedList= nestedListInstance.getNestedList();
        return nestedList;
    }
    
    /**
     * finds value at specified position in nested list.
     * The position is defined by string containing characters 'T' and 'H', where H represents first value in nested list and T represents list formed by removing head of nested list.
     * @param position
     * @return returns value if position contains value otherwise throws exception.
     */
    public int getValue(String position)
    {
        int value=0;
        position=position.toUpperCase();
        List<List<Integer>> nestedList=getNestedList();
        Object temporaryListForTraversal=nestedList;
        if(nestedList.size()==0)
        {
            throw new AssertionError("nested list is empty");
        }
        for(int i=0;i<position.length();i++)
        {
            switch(position.charAt(i))
            {
            case 'T':
                ((List)temporaryListForTraversal).remove(0);
                int sizeOfTail=((List)temporaryListForTraversal).size();
                if(sizeOfTail==0 || i==position.length()-1)
                {
                    throw new AssertionError("position "+position+" doesn't exist in nestedList");
                }
                break;
            case 'H':
                Object object=((List)temporaryListForTraversal).get(0);
                if(object instanceof List)
                {
                    temporaryListForTraversal=(List)object;
                    if(i==position.length()-1)
                    {
                        throw new AssertionError("position "+position+" doesn't contain value.");
                    }
                }
                else if(object instanceof Integer)
                {
                    value=(int)((List)temporaryListForTraversal).get(0);
                    if(i!=position.length()-1)
                    {
                        throw new AssertionError("position "+position+" doesn't exist in nestedList");
                    }
                }
            }
        }
        return value;
    }

}
