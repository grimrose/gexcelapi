package org.jggug.commons.gexcelapi

class CellLabelRange implements Range {

    private List list

    CellLabelRange(int beginRow, int beginColumn, int endRow, int endColumn) {
        list = new CellLabelIterator(beginRow, beginColumn, endRow, endColumn).collect { it }
    }

    CellLabelRange(String beginCellLabel, String endCellLabel) {
        list = new CellLabelIterator(beginCellLabel, endCellLabel).collect { it }
    }

    boolean containsWithinBounds(Object o) {
        list.contains(o)
    }

    Comparable getFrom() {
        list.first()
    }

    Comparable getTo() {
        list.tail()
    }

    String inspect() {
        "#$list"
    }

    boolean isReverse() {
        false // fixed
    }

    List step(int step) {
    }

    void step(int step, Closure closure) {
    }

    // --------------------------------------------
    // delegate list as List
    boolean add(Object o) {
        list.add(o)
    }
    void add(int index, Object element) {
        list.add(index, element)
    }
    boolean addAll(Collection c) {
        list.addAll(c)
    }
    boolean addAll(int index, Collection c) {
        list.addAll(index, c)
    }
    void clear() {
        list.clear()
    }
    boolean contains(Object o) {
        if (o instanceof CellLabelRange && o.list.size() == 1) {
            return list.contains(o.first())
        }
        list.contains(o)
    }
    boolean containsAll(Collection c) {
        if (o instanceof CellLabelRange) {
            return list.containsAll(o.list)
        }
        list.containsAll(c)
    }
    boolean equals(Object o) {
        list.equals(o)
    }
    Object get(int index) {
        list.get(index)
    }
    int hashCode() {
        list.hashCode()
    }
    int indexOf(Object o) {
        list.indexOf(o)
    }
    boolean isEmpty() {
        list.isEmpty()
    }
    Iterator iterator() {
        list.iterator()
    }
    int lastIndexOf(Object o) {
        list.lastIndexOf(o)
    }
    ListIterator listIterator() {
        list.listIterator()
    }
    ListIterator listIterator(int index) {
        list.listIterator(index)
    }
    Object remove(int index) {
        list.remove(index)
    }
    boolean remove(Object o) {
        list.remove(o)
    }
    boolean removeAll(Collection c) {
        list.removeAll(c)
    }
    boolean retainAll(Collection c) {
        list.retainAll(c)
    }
    Object set(int index, Object element) {
        list.set(index, element)
    }
    int size() {
        list.size()
    }
    List subList(int fromIndex, int toIndex) {
        list.subList(fromIndex, toIndex)
    }
    Object[] toArray() {
        list.toArray()
    }
    Object[] toArray(Object[] a)  {
        list.toArray(a)
    }

}
