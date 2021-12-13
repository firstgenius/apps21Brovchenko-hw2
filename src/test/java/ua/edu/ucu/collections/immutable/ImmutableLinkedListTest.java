package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList linkList, test_arr;

    @Test
    public void testAdd() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {555, 55, 35, 35}, linkList.add(1,55).toArray());
        assertArrayEquals(new Object[] {555, 35, 35, 55}, linkList.add(55).toArray());
    }

    @Test
    public void testAddAll() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {555, 25, 75, 35, 35}, linkList.addAll(1, new Object[] {25, 75}).toArray());
    }

    @Test
    public void testGet() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertEquals(35, linkList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFail() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        test_arr = (ImmutableLinkedList) linkList.get(100);
    }

    @Test
    public void testRemove() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[]{555, 35}, linkList.remove(2).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFail() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        test_arr = (ImmutableLinkedList) linkList.remove(10000);
    }

    @Test
    public void testSet() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {555, 35, 24}, linkList.set(2, 24).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetFail() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        test_arr = (ImmutableLinkedList) linkList.set(10000, 5);
    }

    @Test
    public void testIndexOf() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35});
        assertEquals(linkList.indexOf(35), 1);
    }

    @Test
    public void testSize() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35});
        assertEquals(2, linkList.size());
    }

    @Test
    public void testClear() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertEquals(3, linkList.clear().size());
        assertNull(linkList.clear().get(1));
    }

    @Test
    public void testIsEmpty() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertFalse( linkList.isEmpty());
    }

    @Test
    public void testToArray() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[]{555, 35, 35}, linkList.toArray());
    }

    @Test
    public void testAddFirst() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {15, 555, 35, 35}, linkList.addFirst(15).toArray());
    }

    @Test
    public void testAddLast() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {555, 35, 35, 15}, linkList.addLast(15).toArray());
    }

    @Test
    public void testGetHead() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertEquals(555, linkList.getHead().getValue());
    }

    @Test
    public void testGetTail() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertEquals(35, linkList.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertEquals(555, linkList.getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstFail() {
        linkList = new ImmutableLinkedList(new Object[] {});
        test_arr = (ImmutableLinkedList) linkList.getFirst();
    }

    @Test
    public void testGetLast() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertEquals(35, linkList.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastFail() {
        linkList = new ImmutableLinkedList(new Object[] {});
        test_arr = (ImmutableLinkedList) linkList.getLast();
    }

    @Test
    public void removeFirst() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {35, 35}, linkList.removeFirst().toArray());
    }

    @Test
    public void removeLast() {
        linkList = new ImmutableLinkedList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {555, 35}, linkList.removeLast().toArray());
    }
}