package com.demo;

import java.util.concurrent.Semaphore;

public class ConcurrentDemo {

	public static void main(String[] args) {
		Semaphore	 sem = new Semaphore(2);

		new IncrThread("Ram", sem);
		new DecThread("Suresh", sem);
		new IncrThread("Shyam", sem);
		new IncrThread("Ghanshyam", sem);
		new DecThread("Dinesh", sem);
		new DecThread("Ganesh", sem);

	}

}

class Shared {
	static int counter = 0;
}

class IncrThread implements Runnable {

	String name;
	Semaphore sem;

	public IncrThread(String n, Semaphore s) {
		this.name = n;
		this.sem = s;
		new Thread(this).start(); // creating new thread using current object & then starting it
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is waiting for the permission");
			sem.acquire();
			System.out.println(name + " has got the permission");
			for (int i = 1; i <= 5; i++) {
				Shared.counter++;
				System.out.println(name + " : " + Shared.counter);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name + " released the permission");
		sem.release();

	}

}

class DecThread implements Runnable {

	String name;
	Semaphore sem;

	public DecThread(String n, Semaphore s) {
		this.name = n;
		this.sem = s;
		new Thread(this).start(); // creating new thread using current object & then starting it
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is waiting for the permission");
			sem.acquire();
			System.out.println(name + " has got the permission");
			for (int i = 1; i <= 5; i++) {
				Shared.counter--;
				System.out.println(name + " : " + Shared.counter);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name + " released the permission");
		sem.release();

	}

}
