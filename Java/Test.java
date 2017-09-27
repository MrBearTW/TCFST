import java.util.*;
public class Test implements Runnable
{
	public static void main(String args[]) throws Exception
	{
		Test r = new Test();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
	Scanner scan = new Scanner(System.in);
	ArrayList stack = new ArrayList();
	public synchronized void run() 
	{
		while(true)
		{
			notify();
			System.out.print(Thread.currentThread().getName()+" Input : ");
			String cmd = scan.nextLine();
			//System.out.println(Thread.currentThread().getName()+" Value : " + cmd);
			
			if(cmd.contains("add") && stack.size() < 4 && stack.size() >= 0)
			{
				stack.add(cmd.substring(4));
				System.out.println(stack);
			}
			else if(cmd.contains("del") && stack.size() <= 4 && stack.size() > 0)
			{
				stack.remove(cmd.substring(4));
				System.out.println(stack);
			}
			
			if(stack.size() >= 4 || stack.size() <= 0)
			{
				try{wait();}
				catch(Exception e){}
			}
			
			if(cmd.equals("quit"))
			{
				notify();
				break;
			}
			
		}
	}
}