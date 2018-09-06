package com.metacube.training.collectionInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class AppConfiguration {

    @Bean
    public PersonCollection personCollection()
    {
        PersonCollection personCollection=new PersonCollection();
        List<String> listOfName=new ArrayList<String>();
        listOfName.add("Pratiksha");
        listOfName.add("nisha");
        Set<String> setOfName=new HashSet<String>();
        setOfName.add("pratiksha");
        setOfName.add("nisha");
        Map<Integer,String> mapOfPerson=new HashMap<>();
        mapOfPerson.put(1, "Pratiksha");
        mapOfPerson.put(2, "nisha");
        personCollection.setListOfPerson(listOfName);
        personCollection.setMapOfPerson(mapOfPerson);
        personCollection.setSetOfPerson(setOfName);
        return personCollection;
    }
    
}
