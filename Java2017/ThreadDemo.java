public class ThreadDemo {
	public static void main(String[] args) {
		Thread1 thr1 = new Thread1();
		thr1.start();

		Thread2 thr2 = new Thread2();
		thr2.start();
	}
}

class Thread1 extends Thread {
	public void run() {
		for (int i = 0; i < 1000 ; ++i) {
			System.out.println("This is thread 1");
		}
	}
}

class Thread2 extends Thread {
	public void run() {
		for (int i = 0; i < 1000 ; ++i) {
			System.out.println("This is thread 2");
		}
	}
}