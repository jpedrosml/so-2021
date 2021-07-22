package main;

import semaphore.DiningPhilosophers;
import semaphore.Philosopher;

public class Main {
    private static final int PHILOSOPHERS = 5;
    private static final int[] TIME_THINKING = {600,600,600,600,600};
    private static final int[] TIME_EATING = {600,600,600,600,600};

	public static void main(String[] args) {
        DiningPhilosophers dinner = new DiningPhilosophers(PHILOSOPHERS);

        for (int i = 0; i < PHILOSOPHERS; i++) {
            new Philosopher(i, TIME_EATING[i], TIME_THINKING[i], dinner);
        }
	}
}
