package com.hrishigadkari;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branchList;
    private String name;

    public Bank(String name){
        this.name = name;
        this.branchList = new ArrayList<Branch>();
    }



    public Branch findBranch(String name){
        for(int i =0; i < this.branchList.size(); i++){
            if (this.branchList.get(i).getName().equals(name)){
                System.out.println("The branch with name " + name + " was found");
                return this.branchList.get(i);
            }
        }

        return null;
    }

    public void printBranches(){
        System.out.println("Printing Branches..");
        for(int i =0; i < this.branchList.size(); i++){
            System.out.println((i+1) + ". " + this.branchList.get(i).getName());
        }
    }

    public String getName() {
        return name;
    }


    public Branch createBranch(String name){
         Branch branch = new Branch((name));
         this.branchList.add(branch);
         return branch;
    }

}
