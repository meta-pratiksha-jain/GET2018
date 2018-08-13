package counselingProcess;

/**
 * This class represents student who has apply for a program.
 *
 */
public class Student {
    public String name;
    public String[] preferences=new String[5];
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getPreferences() {
        return preferences;
    }
    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    } 

}
