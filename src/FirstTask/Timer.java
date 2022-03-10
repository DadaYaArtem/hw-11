package FirstTask;

public class Timer {
    volatile int vol = 0;

    public static void main(String[] args){
        Timer timer = new Timer();
        Thread t1 = new Thread(timer::displayTime);
        Thread t2 = new Thread(timer::showMessage);
        t1.start();
        t2.start();
    }

    public void displayTime() {
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(1000);
                    notify();
                    vol++;
                } catch (InterruptedException e) {
                    System.out.println("Error");
                }
            }
            System.out.println(vol + "secs");
        }
    }

    public void showMessage() {
        while (true) {
            if (vol != 0 && vol % 5 == 0) {
                synchronized (this) {
                    try {
                        System.out.println("5 seconds passed");
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error");
                    }
                }
            }
        }
    }
}