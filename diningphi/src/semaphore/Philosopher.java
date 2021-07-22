package semaphore;

public class Philosopher implements Runnable {
	private int ID;
	private int timeThinking;
	private int timeDinning;
	private Dinner dinner;
	
	public Philosopher (int ID, int timeThinking, int timeDinning, Dinner dinner) {
		this.ID = ID;
		this.timeThinking = timeThinking;
		this.timeDinning = timeDinning;
		this.dinner = dinner;
		new Thread((Runnable)this, "philosopher " + ID).start();
	}
	
	@Override
	public void run() {
		while(true) {
			think();
			grab();
			eat();
			drop();	
		}
	}
	
	private void think() {
		try {
			Thread.sleep(this.timeThinking);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}
	
	private void grab() {
		dinner.grab(this.ID);
	}
	
	private void eat() {
		try {
			Thread.sleep(this.timeDinning);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}
	
	private void drop() {
		dinner.drop(this.ID);
	}
}
