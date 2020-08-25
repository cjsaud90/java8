package me.mwcheon.functionalInterface;

import javax.sound.midi.Soundbank;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class RunSomething {

    public static void main(String[]args){

        // -------------------

        // 익명 내부 클래스 anonymous inner class
        //1.
        SomethingDo somethingDo = new SomethingDo() {
            @Override
            public void doIt() {
                System.out.println("HI!");
            }
        };
        // 적용된 람다식
        //2.
        SomethingDo somethingDo1 = () -> System.out.println("test");
        somethingDo1.doIt();

        // -------------------


        // -------------------
        //plus10
        //1.
        Plus10 plus = new Plus10();
        System.out.println(plus.apply(3));
        //2.
        Function<Integer, Integer> plus10 = (integer) -> integer+15;
        System.out.println(plus10.apply(30));
        // -------------------


        //compose 매개변수를 먼저 계산하고 그 계산한 값을 계산한다
        Function<Integer, Integer> multiply2 = (integer) -> integer * 2;
        Function<Integer, Integer> multiply2Plus10 =  plus10.compose(multiply2);
        System.out.println(multiply2Plus10.apply(2));

        //andThen 은 앞에걸 계산하고 매개변수를 계산하게 된다.
        Function<Integer, Integer> plusAndTherMultiply = plus10.andThen(multiply2);
        System.out.println(plusAndTherMultiply.apply(5));

        RunSomething runSomething = new RunSomething();

        runSomething.run();





    }

    private void run() {
        int baseNumber = 10;

        //로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        //익명클래스
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                int baseNumber = 11;
                System.out.println(value+baseNumber); //11
            }
        };

        //람다
        IntConsumer printInt = (i) -> {
            System.out.println(i+baseNumber);
        };

        printInt.accept(10);

    }
}
