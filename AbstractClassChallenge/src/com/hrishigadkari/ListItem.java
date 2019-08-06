package com.hrishigadkari;

public abstract class ListItem {
    protected ListItem next = null;
    protected ListItem previous = null;
    protected Object value;
    public ListItem(Object value){
        this.value = value;
    }

    abstract ListItem moveNext();
    abstract ListItem setNext(ListItem next);
    abstract ListItem movePrevious();
    abstract ListItem setPrevious(ListItem previous);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
