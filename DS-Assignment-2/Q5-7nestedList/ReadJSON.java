package nestedList;

import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * this class reads Values from Json File.
 *
 */
public class ReadJSON {
    
    /**
     * static method to read values from json file.
     * @return returns nested list.
     */
    public static List<List<Integer>> readJSON()
    {
        List<List<Integer>> nestedList=new ArrayList<List<Integer>>();
        
        try {
            JSONParser parser=new JSONParser();
            Object object=parser.parse(new FileReader("JsonTest.json.txt"));
            JSONObject jsonObject=(JSONObject)object;
            for(Object jsonKey:jsonObject.keySet())
            {
                int key=Integer.parseInt(jsonKey.toString());
                JSONArray jsonArray= (JSONArray) jsonObject.get(jsonKey);
                List<Integer> list=new ArrayList<>();
                for (Object value : jsonArray) {
                    list.add(Integer.parseInt(value.toString()));
                } 
                nestedList.add(list);
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("file not found");
        }
        catch(IOException exception)
        {
            System.out.println("IOException");
        }
        catch(ParseException exception)
        {
            System.out.println("Exception in parsing of JSON object");
        }
        return nestedList;
    }
    

}
