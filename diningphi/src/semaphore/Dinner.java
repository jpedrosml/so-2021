package semaphore;

public abstract class Dinner {
	protected int allPhilosophers;
	protected States[] states;
	protected Object[] philosophers;

	protected void grab(int ID) {
		
	}
	
	protected void drop(int ID) {
		
	}
	
	protected boolean canEat(int ID) {
		return (grabRight(ID) != States.EATING && grabLeft(ID) != States.EATING);
	}
	 
	protected States grabRight(int ID) {
		return states[right(ID)];
	}
	
	protected States grabLeft(int ID) {
		return states[left(ID)];
	}
	
	protected int right(int position) {
		return (position + 1) % allPhilosophers;
	}
	
	protected int left(int position) {
		return (position + allPhilosophers - 1) % allPhilosophers;
	}
}
