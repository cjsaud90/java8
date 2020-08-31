package me.mwcheon.completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 쓰레드를 하나만
//        executorService.submit(()->{
//
//            System.out.println("Thread : "+ Thread.currentThread().getName());
//        });
//
//        executorService.shutdown();


        //쓰레드 2개
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnalbe("hello1"));
        executorService.submit(getRunnalbe("hello2"));
        executorService.submit(getRunnalbe("hello3"));
        executorService.submit(getRunnalbe("hello4"));
        executorService.submit(getRunnalbe("hello5"));
        // 쓰레드 2개에 일이 할당되고 나머지는 큐에 ( blocking que) 적



        //스케줄 쓰레드
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnalbe("hello  "), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(getRunnalbe("JAVA :: "), 1, 2, TimeUnit.SECONDS);


//        executorService.shutdown();
//        executorService1.shutdown();
//        scheduledExecutorService.shutdown();

        //forkJoin << 이것도 알아보면 좋을거 같음

        //callable << 이건 리턴을 할 수 있는데 runnable은 못한다...
        //callable 의 리턴값으로 받아 올수 있는게 Futurealbe 임!!


    }

    private static Runnable getRunnalbe(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }


}
