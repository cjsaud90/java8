package me.mwcheon.functionalInterface;

public class RunSomething {

    public static void main(String[]args){

        // 익명 내부 클래스 anonymous inner class
        SomethingDo somethingDo = new SomethingDo() {
            @Override
            public void doIt() {
                System.out.println("HI!");
            }
        };

    }
}
