public class RunnableDemo {
	public static void main(String[] args) {
		Thread thr1 = new Thread( new MyThread1());
		thr1.start();
		Thread thr2 = new Thread( new MyThread2());
		thr2.start();
	}
}

class MyThread1 implements Runnable {
	public void run() {
		
	}
}

class MyThread2 implements Runnable {
	public void run() {
		
	}
}