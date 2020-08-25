package me.mwcheon.defaultMethodStaticMethod;

public interface TestInterface {

    void printName();

    default void pringNameUpperCase() {
        System.out.println("test default");
    }
}
