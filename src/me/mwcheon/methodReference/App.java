package me.mwcheon.methodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {

        // 메서드 레퍼런스 ::
        UnaryOperator<String> hi = Greeting::hi; //이상태로는 인스턴스가 만들어진게 아니라
        hi.apply("mwcheon"); // 이렇게 해야지 인스턴스가 만들어 지는거

        // 생성자도 가능하다
        Supplier<Greeting> newGreeting = Greeting::new; // 이렇게한다고 인스턴스가 만들어지는게 아니라 ( 그냥 참조하는 newGreeting가 만들어지는거 )
        newGreeting.get(); // 이렇게 해야지 나오는거어

        Function<String, Greeting> mwcheonGreeting = Greeting::new;
        Greeting greet = mwcheonGreeting.apply("mwcheon");
        System.out.println(greet.getName());

        String [] names = {"mwcheon", "cheon", "testName"};
        Arrays.sort(names, String::compareToIgnoreCase);




    }
}
