package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        Node previousNode = null;
        if (elements.length == 0) {
            head = null;
            return;
        }
        for (Object obj: elements) {
            Node curNode = new Node();
            curNode.setPrevious(previousNode);

            if (previousNode != null) {
                previousNode.setNext(curNode);
            } else {
                head = curNode;
            }

            curNode.setValue(obj);
            previousNode = curNode;
        }
        tail = previousNode;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public ImmutableList add(Object e) { 
        return addAll(size(), new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public Object[] toArray() {
        int ind = 0;
        Object[] newArr = new Object[size()];
        Node curNode = head;

        while (curNode != null) {
            newArr[ind] = curNode.getValue();
            curNode = curNode.getNext();
            ind++;
        }

        return newArr;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() + c.length) {
            throw new IllegalArgumentException();
        }

        int ind = 0;
        Node curNode = getHead();
        Object[] newList = new Object[size() + c.length];

        for (int i = 0; i < index; i++) {
            newList[ind] = curNode.getValue();
            curNode = curNode.getNext();
            ind++;
        }
        for (Object element : c) {
            newList[ind] = element;
            ind++;
        }
        for (int i = index; i < size(); i++) {
            newList[ind] = curNode.getValue();
            curNode = curNode.getNext();
            ind++;
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public Object get(int index) {
        if (size() == 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node curNode = head;
        int counter = 0;
        while (counter <= index) {
            curNode = curNode.getNext();
            counter++;
        }
        return curNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (size() == 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node curNode = head;
        Object[] newList = new Object[size() - 1];
        int counter = 0;

        while (counter < index) {
            newList[counter] = curNode.getValue();
            curNode = curNode.getNext();
            counter++;
        }
        curNode = curNode.getNext();
        for (int i = index; i < newList.length; i++) {
            newList[i] = curNode.getValue();
            curNode = curNode.getNext();
        }

        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (size() == 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = toArray();
        newArr[index] = e;
        return new ImmutableLinkedList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node curNode = head;

        while (curNode.getValue() != e) {
            index++;
            curNode = curNode.getNext();
        }

        return index;
    }

    @Override
    public int size() {
        Node curNode = head;
        int length = 0;

        while (curNode != null) {
            curNode = curNode.getNext();
            length++;
        }

        return length;
    }

    @Override
    public ImmutableList clear() { 
        return new ImmutableLinkedList(new Object[size()]);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() { return head; }

    public Node getTail() { return tail; }

    public Object getFirst() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return head.getValue();
    }

    public Object getLast() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = Arrays.copyOfRange(toArray(), 1, size());
        return new ImmutableLinkedList(newArr);
    }

    public ImmutableLinkedList removeLast() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = Arrays.copyOfRange(toArray(), 0, size()-1);
        return new ImmutableLinkedList(newArr);
    }
}
