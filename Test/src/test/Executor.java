package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Executor {
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 100; i++) {
			service.execute(new Kurde());
		}
		
		service.shutdown();
	}
}

class Kurde implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " ist jetzt dran");
		while(true) {
			
		}
	}
}
