package org.launchcode.techjobs.oo;

import java.util.Objects;

abstract class JobField {

    protected int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }


    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

  //  @Override
  //  public boolean equals(Object o) {  // Two objects are equal if they have the same id.

  //  }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
