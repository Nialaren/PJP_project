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
}
