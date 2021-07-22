package semaphore;

import java.util.concurrent.Semaphore;


public class DiningPhilosophers extends Dinner {
	private Semaphore mutex;
	
	public DiningPhilosophers(int allPhilosophers) {
		this.mutex = new Semaphore(1);
		this.allPhilosophers = allPhilosophers;
		this.states = new States[this.allPhilosophers];
		this.philosophers = new Semaphore[this.allPhilosophers];
		
		for(int i = 0; i < this.allPhilosophers; i++) {
			this.states[i] = States.THINKING;
			this.philosophers[i] = new Semaphore(0);
		}
		for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}
	}
	
	public void grab(int ID) {
		try {
			mutex.acquire();
		} catch (InterruptedException exception) {
			
		}
		states[ID] = States.HUNGRY;
		if(canEat(ID)) {
			((Semaphore)philosophers[ID]).release();
			states[ID] = States.EATING;
		}
		mutex.release();
		try {
			((Semaphore)philosophers[ID]).acquire();
			for (int i = 0; i < states.length; i++) {
				System.out.println(states[i]);
			}
		} catch (InterruptedException exception) {
			
		}
	}
	
	public void drop(int ID) {
		try {
			mutex.acquire();
		} catch (InterruptedException exception) {
			
		}
		for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}
		states[ID] = States.THINKING;
		if(grabRight(ID) == States.HUNGRY && grabRight(right(ID)) != States.EATING) {
			states[right(ID)] = States.EATING;
			((Semaphore)philosophers[right(ID)]).release();
		}
		
		if(grabLeft(ID) == States.HUNGRY && grabLeft(left(ID)) != States.EATING) {
			states[left(ID)] = States.EATING;
			((Semaphore)philosophers[left(ID)]).release();
		}
		mutex.release();
	}
}
