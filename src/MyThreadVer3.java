public class MyThreadVer3  implements Runnable {
    Thread thread;

    MyThreadVer3(String name) {
        thread = new Thread(this, name);
    }

    //

    public static MyThreadVer3 createAndStart(String name){
        MyThreadVer3 myThreadVer3 = new MyThreadVer3(name);
        myThreadVer3.thread.start();
        return myThreadVer3;
    }
    //starts executing a new thread
    public void run(){
        System.out.println(thread.getName()+"starts to operate");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(100);
                System.out.println(thread.getName()+"is executed , the counter value"+count);
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName()+"has been interrupted");
        }
        System.out.println(thread.getName() +"finishes running");
    }
}
class MoreThreads2{
    public static void main(String[] args){
        System.out.println("The main threads starts running");
        MyThreadVer3 Thread1= MyThreadVer3.createAndStart("Child thread #1");
        MyThreadVer3 Thread2=MyThreadVer3.createAndStart("Child thread #2");
        MyThreadVer3 Thread3=MyThreadVer3.createAndStart("Child thread #3");
            System.out.print(".");
            try{

                Thread1.thread.join();
                Thread2.thread.join();
                Thread3.thread.join();
            }
            catch (InterruptedException e) {
                System.out.println("The Threads thread has been terminated");
            }

        System.out.println("The main thread is exiting");
    }
}