/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import utils.IRVisitor;

/**
 *
 * @author beh01
 */
public abstract class Node {

    public Node() {
    }

    public abstract void accept(IRVisitor visitor);

    @Override
    public abstract String toString();

    public abstract String getCode();

    public String toString(int n, String space) {
        return this.repeat(space, n) + this.toString();
    }    
    
    public String repeat(String s, int times) {
        if (times <= 0) {
            return "";
        } else if (times % 2 == 0) {
            return repeat(s + s, times / 2);
        } else {
            return s + repeat(s + s, times / 2);
        }
    }
}
