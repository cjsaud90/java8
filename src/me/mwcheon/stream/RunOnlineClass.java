package me.mwcheon.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunOnlineClass {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "Spring Boot", true));
        springClasses.add(new OnlineClass(2, "java8", true));
        springClasses.add(new OnlineClass(3, "test1", false));
        springClasses.add(new OnlineClass(4, "core", true));
        springClasses.add(new OnlineClass(5, "Spring mvc", false));
        springClasses.add(new OnlineClass(6, "Spring data joa", true));




        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(s->s.getTitle().startsWith("Spring"))
                .forEach(s->System.out.println(s.getTitle()));


        System.out.println("close 되지 않음 수업");
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(oc-> System.out.println(oc.getTitle()));

        System.out.println("수업 이름만 모아서 ");
        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);




        List<OnlineClass> frontClasses = new ArrayList<>();

        frontClasses.add(new OnlineClass(7, "NODE", true));
        frontClasses.add(new OnlineClass(8, "REACT", true));
        frontClasses.add(new OnlineClass(9, "VUE", false));
        frontClasses.add(new OnlineClass(10, "CSS", true));
        frontClasses.add(new OnlineClass(11, "HTML", false));
        frontClasses.add(new OnlineClass(12, "JAVASCRIPT", true));

        List<List<OnlineClass>> onlineClassEvent = new ArrayList<>();
        onlineClassEvent.add(springClasses);
        onlineClassEvent.add(frontClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력 ");
        onlineClassEvent.stream().flatMap(Collection::parallelStream).forEach(s->System.out.println(s.getTitle()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개까지만");
        Stream.iterate(10, i -> i+1).skip(10).limit(10).forEach(System.out::println);

        System.out.println("자바 수업 중에 test가 들어있는지 확인");
        frontClasses.stream().anyMatch(oc->oc.getTitle().contains("Test"));

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 list 만들기");
        springClasses.stream().filter(oc -> oc.getTitle().contains("spring")).map(OnlineClass::getTitle)
                .collect(Collectors.toList()).forEach(System.out::println);






    }

}
