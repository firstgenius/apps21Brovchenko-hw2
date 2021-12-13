package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList arrayList, test_arr;

    @Test
    public void testAdd() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[]{555, 35, 35, 25}, arrayList.add(25).toArray());

        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[]{555, 25, 35, 35}, arrayList.add(1, 25).toArray());
    }

    @Test
    public void testAddAll() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[]{555, 35, 35, 25, 75}, arrayList.addAll(new Object[] {25, 75}).toArray());
        assertArrayEquals(new Object[]{555, 15, 55, 35, 35}, arrayList.addAll(1, new Object[] {15, 55}).toArray());
    }

    @Test
    public void testGet() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertEquals(35, arrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFail() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        test_arr = (ImmutableArrayList) arrayList.get(1000);
    }

    @Test
    public void testRemove() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {35, 35}, arrayList.remove(0).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFail() {
        arrayList = new ImmutableArrayList(new Object[] {});
        test_arr = (ImmutableArrayList) arrayList.remove(0);
    }

    @Test
    public void testSet() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[] {35, 35, 35}, arrayList.set(0, 35).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFail() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        test_arr = (ImmutableArrayList) arrayList.set(100, 5);
    }

    @Test
    public void testIndexOf() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertEquals(1, arrayList.indexOf(35));
        assertEquals(-1, arrayList.indexOf(438758));
    }

    @Test
    public void testSize() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testClear() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertEquals(3, arrayList.clear().size());
        assertNull(arrayList.clear().get(1));
    }

    @Test
    public void testIsEmpty() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertTrue(new ImmutableArrayList().isEmpty());
    }

    @Test
    public void testToArray() {
        arrayList = new ImmutableArrayList(new Object[] {555, 35, 35});
        assertArrayEquals(new Object[]{555, 35, 35}, arrayList.toArray());
    }
}