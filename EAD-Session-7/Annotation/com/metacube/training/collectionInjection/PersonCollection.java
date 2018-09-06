package com.metacube.training.collectionInjection;

import java.util.*;

public class PersonCollection {
    private List listOfPerson;
    private Set setOfPerson;
    private Map mapOfPerson;
    
    public List getListOfPerson() {
        return listOfPerson;
    }
    
    public void setListOfPerson(List listOfPerson) {
        this.listOfPerson = listOfPerson;
    }
    
    public Set getSetOfPerson() {
        return setOfPerson;
    }
    
    public void setSetOfPerson(Set setOfPerson) {
        this.setOfPerson = setOfPerson;
    }
    
    public Map getMapOfPerson() {
        return mapOfPerson;
    }
    
    public void setMapOfPerson(Map mapOfPerson) {
        this.mapOfPerson = mapOfPerson;
    }

}
