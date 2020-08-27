package me.mwcheon.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("cheon");
        names.add("mwcheon");
        names.add("win");
        names.add("muyeong");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//        names.forEach(System.out::println);
//        stringStream.forEach(System.out::println);

        //Stream 의 메서드들 중 크게 2가지로 나눌수 있다.
        //1. 중계 2. 터미널 --> 큰 차이점 : 스트림을 리턴한다.

        names.stream().map((s)->{
            System.out.println(s);
            return s.toUpperCase();
        }); //  출력이 되지 않음. terminal operator가 올때까지 실행이 안된다 그냥 정의만 할뿐.

        // 병렬 처리
        // 안쓸때
        for(String name : names){
            if(name.startsWith("m")){
                System.out.println(name.toUpperCase());
            }
        } // -> 병렬적으로 처리하기 어렵다
        // 쓸때 parallelStream 대용량일때 처리하면 빠름..왠만한건 다 stream으로 처리가 가능함

        List<String> collect = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
