package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] arrayList;


    public ImmutableArrayList(Object[] elements) {
        arrayList = Arrays.copyOf(elements, elements.length);
    }


    public ImmutableArrayList() {
        arrayList = new Object[0];
    }


    @Override
    public ImmutableList add(Object e) {
        return addAll(size(), new Object[] {e});
    }


    @Override
    public ImmutableList addAll(Object[] c) { return addAll(size(), c); }


    @Override
    public ImmutableList add(int index, Object e) { return addAll(index, new Object[] {e}); }


    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (size() == 0 || c == null || index > size() + c.length) {
            throw new IllegalArgumentException();
        }

        int ind = 0;
        int newLen = size() + c.length;
        Object[] newArr = new Object[newLen];

        for (int i = 0; i < index; i++) {
            newArr[ind] = arrayList[i];
            ind++;
        }
        for (Object element : c) {
            newArr[ind] = element;
            ind++;
        }
        for (int i = index; i < size(); i++) {
            newArr[ind] = arrayList[i];
            ind++;
        }

        return new ImmutableArrayList(newArr);
    }


    @Override
    public Object get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return arrayList[index];
    }


    @Override
    public ImmutableList remove(int index) {
        if (size() == 0 || index > size()) {
            throw new IllegalArgumentException();
        }

        int newLen = size() - 1;
        Object[] newArr = new Object[newLen];

        for (int i = 0; i < index; i++) {
            newArr[i] = arrayList[i];
        }
        for (int i = index; i < newArr.length; i++) {
            newArr[i] = arrayList[i + 1];
        }

        return new ImmutableArrayList(newArr);
    }


    @Override
    public ImmutableList set(int index, Object e) {
        if (index > size() || (size() == 0 && index != 0)) {
            throw new IllegalArgumentException();
        }

        Object[] newArr = new Object[size()];
        System.arraycopy(arrayList, 0, newArr, 0, size());
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }


    @Override
    public int indexOf(Object e) {
        for (int ind = 0; ind < size(); ind++) {
            if (arrayList[ind] == e) {
                return ind;
            }
        }
        return -1;
    }


    @Override
    public int size() { return arrayList.length;}


    @Override
    public ImmutableList clear() { return new ImmutableArrayList(new Object[size()]); }


    @Override
    public boolean isEmpty() { return size() == 0; }


    @Override
    public Object[] toArray() {
        int ind = -1;
        Object[] newObjectsArray = new Object[arrayList.length];

        for (Object obj: arrayList) {
            ind += 1;
            newObjectsArray[ind] = obj;
        }

        return newObjectsArray;
    }
}
