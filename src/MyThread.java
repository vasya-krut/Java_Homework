public class MyThread extends Thread{

    static  String name;

    public MyThread(String name){
        this.name = name;
    }



    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.print(i + " ");
            if(i == 50) System.out.println(name + " is running");
        }

        Thread thread2 = new Thread(new ThreadWait());
        thread2.start();
        try{
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }



    public void printStatus(){
        System.out.println(this.name + " status = " + this.getState());
    }


}
