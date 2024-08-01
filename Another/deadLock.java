package Another;

public class deadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
           synchronized (lock1){
               System.out.println("Thread1 get Lock1");

               try{
                  Thread.sleep(1000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               System.out.println("Thread1 waiting for Lock2");
               synchronized (lock2){
                   System.out.println("Thread1 get Lock2");
               }
           }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2){
                System.out.println("Thread2 get Lock2");

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread2 waiting for Lock1");
                synchronized (lock1){
                    System.out.println("Thread2 get Lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
