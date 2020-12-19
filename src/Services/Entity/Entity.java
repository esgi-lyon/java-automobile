package Services.Entity;

import java.io.Serializable;

public interface Entity extends Serializable {
    /**
     * This method is for java components like combobox
     */
    String toString();
    /**
     * This method should return ordered comma list separated entity items
     */
    String toString(boolean list);

    int getId();

    Entity setId(int id);
}
