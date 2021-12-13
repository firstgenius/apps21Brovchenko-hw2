package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node nextNode;
    Node previousNode;

    @Test
    public void testToString() {
        nextNode = new Node();
        nextNode.setValue(5);
        assertEquals("5", nextNode.toString());
    }

    @Test
    public void getPrevious() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        previousNode.setValue(7);
        nextNode.setPrevious(previousNode);

        assertEquals(previousNode, nextNode.getPrevious());
    }

    @Test
    public void setPrevious() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        previousNode.setValue(7);
        nextNode.setPrevious(previousNode);

        assertEquals(previousNode, nextNode.getPrevious());
    }

    @Test
    public void getValue() {
        previousNode = new Node();
        previousNode.setValue(7);

        assertEquals(7, previousNode.getValue());
    }

    @Test
    public void setValue() {
        previousNode = new Node();
        previousNode.setValue(7);

        assertEquals(7, previousNode.getValue());
    }

    @Test
    public void getNext() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        nextNode.setValue(7);

        assertEquals(nextNode, previousNode.getNext());
    }

    @Test
    public void setNext() {
        nextNode = new Node();
        previousNode = new Node();
        previousNode.setNext(nextNode);
        nextNode.setValue(7);

        assertEquals(nextNode, previousNode.getNext());
    }
}