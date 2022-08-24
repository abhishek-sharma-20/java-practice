package com.java_topics;

import java.util.Objects;

final class Person{
    private final String fname;
    private final String lname;
    private final int phoneNumber;

    Person(String fname, String lname, int phoneNumber){
        this.fname=fname;
        this.lname=lname;
        this.phoneNumber=phoneNumber;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override public int hashCode() {
        return Objects.hash(fname, lname, phoneNumber);
    }

    @Override public boolean equals(Object obj) {
        if(!((Person) obj).getLname().equals(this.lname))
            return  false;
        else if(!((Person) obj).getFname().equals(this.fname))
            return  false;
        else if(((Person) obj).getPhoneNumber() != this.phoneNumber)
            return  false;

        return true;
    }
}

