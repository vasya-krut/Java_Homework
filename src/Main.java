import static java.lang.Thread.sleep;

public class Main{
    public static MyThread thread = new MyThread("MyThread");

    public static void main(String[] args) throws InterruptedException {
       thread.printStatus();
       thread.start();
       thread.printStatus();
       sleep(2000);
       thread.printStatus();
    }







}


