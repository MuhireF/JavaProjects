package com.hrishigadkari;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newitem) {
        if(this.root == null) {
            this.root = newitem;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(newitem);
            if(comparison < 0){
                //newItem is greater than currentItem moveNext
                if(currentItem.moveNext() != null){
                    currentItem = currentItem.moveNext();
                }else {
                    currentItem.setNext(newitem).setPrevious(currentItem);
                }
                return true;
            }else if(comparison > 0){
                //newItem is less than currentItem
                if(currentItem.movePrevious() != null){
                    currentItem.movePrevious().setNext(newitem).setPrevious(currentItem.movePrevious());
                    newitem.setNext(currentItem).setPrevious(newitem);
                }else{
                    newitem.setNext(this.root).setPrevious(newitem);
                    this.root = newitem;
                }
                return true;
            }
            else{
                System.out.println(newitem + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null)
            System.out.println("List is empty");
        else{
            while(root != null){
                System.out.println(root.getValue());
                root = root.moveNext();
            }
        }
    }
}
