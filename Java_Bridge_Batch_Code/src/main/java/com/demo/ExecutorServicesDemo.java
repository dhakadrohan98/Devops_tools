package com.demo;

import java.util.concurrent.*;

public class ExecutorServicesDemo
{
	public static void main(String args[])
	{
		try
		{
			//Runtime rt = Runtime.getRuntime();
			//System.out.println("Total no. of processors : "+rt.availableProcessors());
			ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
 
			Future<Integer> f1 = es.submit(new Sum(50));	
			Future<Integer> f2 = es.submit(new Sum(5));
			Future<Integer> f3 = es.submit(new Sum(5000));
			Future<Integer> f6 = es.submit(new Factorial(10));
			Future<Integer> f4 = es.submit(new Square(25));
			Future<Integer> f5 = es.submit(new Square(1000));
			es.submit(new MyThread());
 
			System.out.println("Sum(50) : "+f1.get());	
			System.out.println("Sum(5) : "+f2.get());
			System.out.println("Sum(5000) : "+f3.get());
			System.out.println("Factorial(10)) : "+f6.get());
			System.out.println("Square(25) : "+f4.get());
			System.out.println("Square(1000) : "+f5.get());
 
			es.shutdown();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
 
class Sum implements Callable<Integer>
{
	int val;
	Sum(int v)
	{
		val = v;
	}
	public Integer call()
	{
		int result = 0;
		for(int i=1; i<=val; i++)
		{
			result = result + i;
		}
		return result;
	}
}
class Square implements Callable<Integer>
{
	int val;
	Square(int v)
	{
		val = v;
	}
	public Integer call()
	{
		return val * val;
	}
}
class Factorial implements Callable<Integer>
{
	int val;
	Factorial(int v)
	{
		val = v;
	}
	public Integer call()
	{
		int result = 1;
		for(int i=1; i<=val; i++)
		{
			result = result * i;
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return result;
	}
}
class MyThread implements Runnable
{
	public void run()
	{
		for(int i=1; i<=20; i++)
		{
			System.out.println(" i : "+i);
			try
			{
				Thread.sleep(400);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}