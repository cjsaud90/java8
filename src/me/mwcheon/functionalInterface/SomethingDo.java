package me.mwcheon.functionalInterface;

/**
 * 함수형 인터페이스
 * 추상 메소드를 딱 하나만 가지고 있는 인터페이스
 * SAM(Single Abstract Method) 인터페이스
 * @FuncationInterface 애노테이션을 가지고 있는 인터페이
 */

@FunctionalInterface
public interface SomethingDo {

    void doIt();
//    void doItAgaing(); << 이렇게 두개가 있으면 함수형 인터페이스가 아님

}