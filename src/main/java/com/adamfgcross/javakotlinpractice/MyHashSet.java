package com.adamfgcross.javakotlinpractice;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class MyHashSet<T> {
    List<List<T>> elementsList;
    int size;

    public MyHashSet(int size) {
        this.size = size;

        while (!checkIsPrime(size)) {
            size++;
        }

        elementsList = new ArrayList<List<T>>();
        for (int i = 0; i < size; i++) {
            elementsList.add(new LinkedList<T>());
        }
    }

    public class MyHashSetIterator implements Iterator<T> {
        List<Iterator<T>> iterators;
        int index = 0;
        T last;
        int lastIndex;
        public MyHashSetIterator() {
            iterators = new ArrayList<>();
            iterators.addAll(elementsList.stream().map(List::iterator).collect(Collectors.toList()));
        }


        @Override
        public boolean hasNext() {
            int workingIndex = index;
            if (index < iterators.size()) {
                if (iterators.get(index).hasNext()) {
                    return true;
                } else {
                    while (workingIndex < iterators.size()) {
                        if (iterators.get(workingIndex).hasNext())
                            return true;
                        else
                            workingIndex++;
                    }
                    return false;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (iterators.get(index).hasNext()) {
                last = iterators.get(index).next();
                lastIndex = index;
                return last;
            } else {
                while (index < iterators.size()) {
                    if (iterators.get(index).hasNext()) {
                        last = iterators.get(index).next();
                        lastIndex = index;
                        return last;
                    } else {
                        index++;
                    }
                }
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            elementsList.get(lastIndex).remove(last);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            while (hasNext()) {
                action.accept(next());
            }
        }
    }



    private boolean checkIsPrime(int n) {
        for (int i = 2; i < n-1 ; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    private int hash(T elt) {
        if (elt == null) {
            return 0;
        }
        return elt.hashCode() % size;
    }


    public void add (T elt) {
        int hashVal = hash(elt);
        List<T> elementList = elementsList.get(hashVal);
        if (elementList.contains(elt))
            return;
        elementList.add(elt);
    }

    public Boolean contains(T elt) {
        int hashElt = hash(elt);
        return elementsList.get(hashElt).contains(elt);
    }

    public int size() {
        int setSize = 0;
        for (List<T> list: elementsList) {
            setSize+= list.size();
        }
        return setSize;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public MyHashSetIterator iterator() {
        return new MyHashSetIterator();
    }

    public boolean remove(Object o) {
        @SuppressWarnings("unchecked")
        T searchObject = (T) o;
        int hashVal = hash(searchObject);
        List<T> elementList = elementsList.get(hashVal);
        return (elementList.remove(searchObject));
    }

    public void clear() {
        for (List<T> list: elementsList) {
            list.clear();
        }
    }

    public void addAll(Collection<? extends T> collection) {
        Iterator<? extends T> itr = collection.iterator();
        while (itr.hasNext()) {
            add(itr.next());
        }
    }

    public void removeAll(Collection<? extends T> collection) {
        for (T elt : collection) {
            remove(elt);
        }
    }

    public void retainAll(Collection<? extends T> toRetain) {
        Iterator<T> itr = iterator();
        while (itr.hasNext()) {
            T elt = itr.next();
            if (!toRetain.contains(elt)) {
                itr.remove();
            }
        }
    }
}