package Menageri.Structure;

import java.io.Serializable;

/**
 * Package: Menageri.Interface
 */
public interface SpelKortGränssnitt extends Serializable{
    String color = "spader";
    String value = "A";

    String getColor();
    String getValue();

    String skrivUt();
}
