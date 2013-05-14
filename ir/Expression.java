/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ir;

/**
 *
 * @author beh01
 */
public abstract class Expression extends Node {
    //posible types INT, FLOAT, BOOLEAN, STRING, ERROR
    private String type;
    public Expression() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
  
}
