package me.mwcheon.optional;

import me.mwcheon.stream.OnlineClass;
import me.mwcheon.stream.Progress;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "Spring Boot", true));
        springClasses.add(new OnlineClass(2, "java8", true));
        springClasses.add(new OnlineClass(3, "test1", false));
        springClasses.add(new OnlineClass(4, "core", true));
        springClasses.add(new OnlineClass(5, "Spring mvc", false));
        springClasses.add(new OnlineClass(6, "Spring data joa", true));

        OnlineClass spring_boot = new OnlineClass(1,"springBoot2.0", true);

//        Duration studyDuraion = spring_boot.getProgress().getStudyDuration();
//        System.out.println(studyDuraion); // null이 나온다

        // 이전 코드
//        Progress progress = spring_boot.getProgress();
//        if(progress != null){
//            System.out.println(progress.getStudyDuration());
//        }

        //optional 적용

        Optional<OnlineClass> springOptional = springClasses.stream().filter(oc -> oc.getTitle().contains("spring")).findFirst();
        boolean present = springOptional.isPresent();
        OnlineClass onlineClass = springOptional.get();
        System.out.println(onlineClass.getTitle()); // 있는건 괜찮은데, 없다면? 에러를 발생할 수 있어 그래서 확인을 하고 꺼내자

        springOptional.ifPresent(oc -> System.out.println(oc.getTitle()));
        springOptional.orElse(createNewClass()); // 이건 없으면 만들어라.. 없으며 실행해라! 이런 거;
        springOptional.orElseGet(OptionalClass::createNewClass);
        springOptional.orElseThrow(IllegalAccessError::new);



    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10,"232", false);
    }
}
