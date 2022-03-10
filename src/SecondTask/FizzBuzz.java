package SecondTask;


import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    volatile int point = 1;
    int number = 20;
    List<String> list = new ArrayList();



    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz();
        Thread threadA = new Thread(() -> {
            try {
                fb.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();

        Thread threadB = new Thread(() -> {
            try {
                fb.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadB.start();

        Thread threadC = new Thread(() -> {
            try {
                fb.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadC.start();



        Thread threadD = new Thread(() -> {
            try {
                fb.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadD.start();

        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();

        System.out.println(fb.list);



    }


    public void fizzbuzz() throws InterruptedException {
        synchronized (this) {
            while (point <= number) {
                if (point % 15 == 0) {
                    point++;
                    list.add("fizzbuzz");
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }


    public void fizz() throws InterruptedException {
        synchronized (this) {
            while (point <= number) {
                if (point % 3 == 0 && point % 5 != 0) {
                    point++;
                    list.add("fizz");
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }


    public void buzz() throws InterruptedException {
        synchronized (this) {
            while (point <= number) {
                if (point % 5 == 0 && point % 3 != 0) {
                    point++;
                    list.add("buzz");
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void number() throws InterruptedException {
        synchronized (this) {
            while (point <= number) {
                if (point % 3 == 0 || point % 5 == 0){
                    wait();
                }else {
                    list.add(String.valueOf(point));
                    notifyAll();
                    point++;
                }
            }
        }
    }
}
