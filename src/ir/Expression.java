package ir;

import utils.VariableCounter;

/**
 *
 * @author beh01
 */
public abstract class Expression extends Node {
    //posible types INT, FLOAT, BOOLEAN, STRING, ERROR

    private String type;
    protected int id;

    public Expression() {
        this.id = VariableCounter.get();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return type.substring(0, 1);
    }

    public int getId() {
        return this.id;
    }
;
}
