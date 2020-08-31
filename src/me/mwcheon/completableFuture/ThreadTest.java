package me.mwcheon.completableFuture;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        //다른 스레드 만들기
        //1. 쓰레드 상속
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Hello");


        //2
        Thread thread = new Thread(()->{
            try {
                // 자는 동안에 누군가가 깨우면 들어오는데 깨우는 방법이 있다
//                Thread.sleep(1000L);
                while(true){
                    System.out.println("Thread : "+ Thread.currentThread().getName());
                    Thread.sleep(1000L);
                }

            } catch (InterruptedException e) {
                System.out.println("exit!");
                return;
            }

        });

        thread.start();

        System.out.println("Hello : "+ Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread.interrupt();

    }

    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("TREAD : "+ Thread.currentThread().getName());
        }



    }


}
