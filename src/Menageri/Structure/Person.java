package Menageri.Structure;

/**
 * Package: Menageri.Structure
 */
public abstract class Person {
    private String name;
    private String ID;

    public Person(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public String skrivUt() {
        return this.name + " " + this.ID;
    }

}
