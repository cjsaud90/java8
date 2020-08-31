package me.mwcheon.completableFuture;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//callable 는 runnable과 다르게 결과를 리턴할수 있다
public class CallableEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };


        Future<String> stringFuture = executorService.submit(hello);


        System.out.println("started!!");
        System.out.println(stringFuture.isDone()); // 끝났으면 true / 아니면 false

        stringFuture.get(); // 를 만나는 순간 멈춘다
        // 값을 가져올때까지 get에서 멈춰 있다 .
        // 이것을 blocking


        // 작업 취소는
        stringFuture.cancel(false); //true는 현재 작업 종료 // false 는 기다리는데
        // 일단 false를


        stringFuture.get(); // 여기 한번 더 호출하면 이미 취소한 값이라서 에러가 발생한다.
        System.out.println(stringFuture.isDone()); // cancel을 하고 난 뒤 이걸 호출하면 이건 true다 작업이 끝났으니까


        System.out.println("END!!!!!!");


        Callable<String> callable1 = () -> {
            Thread.sleep(2000L);
            return "hello1";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(3000L);
            return "hello2";
        };


        Callable<String> callable3 = () -> {
            Thread.sleep(1000L);
            return "hello3";
        };


        List<Future<String>> futureList = executorService.invokeAll(Arrays.asList(callable1, callable2, callable3));
        //invokeAll은 3개를 다 기다리는데 가장 오래걸리는 시간까지 기다린다
        // 그중에 가장 빨리되는걸 가져오는데 invokAny

        for(Future<String> future : futureList){
            System.out.println(future.get());
        }

        String s = executorService2.invokeAny(Arrays.asList(callable1, callable2, callable3)); // 타입이 바로 나온다
        System.out.println(s);


        executorService.shutdown();



    }

}
