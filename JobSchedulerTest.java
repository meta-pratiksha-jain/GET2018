import java.util.*;
public class JobSchedulerTest {
	public static void main(String args[])
	{
		System.out.println("Enter no.of processes");
		Scanner sc=new Scanner(System.in);
		int numProcess=sc.nextInt();
		int[][] process=new int[numProcess][2];
		for(int i=0;i<numProcess;i++)
		{
			System.out.println("Enter process arrival time in seconds");
			process[i][0]=sc.nextInt();
			System.out.println("Enter process burst time in seconds");
			process[i][1]=sc.nextInt();
		}
		JobScheduler job=new JobScheduler(numProcess,process);
		System.out.println("Operations:");
		System.out.println("1.Waiting Time of each process");
		System.out.println("2.Completion time of each process");
		System.out.println("3.Turn around time of each process");
		System.out.println("4.Average Waiting time");
		System.out.println("5.Maximum Waiting time of Process");
		System.out.println("6.Exit");
		System.out.println();
		System.out.println("Enter Your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			int[] wait=job.waitTime();
			for(int i=0;i<numProcess;i++)
			{
				System.out.println("process "+i+":"+wait[i]);
			}
			break;
		case 2:
			int[] comp=job.compTime();
			for(int i=0;i<numProcess;i++)
			{
				System.out.println("process "+i+":"+comp[i]);
			}
			break;
		case 3:
			int[] turnAround=job.turnAroundTime();
			for(int i=0;i<numProcess;i++)
			{
				System.out.println("process "+i+":"+turnAround[i]);
			}
			break;
		case 4:
			System.out.println("average waiting time:"+job.averageWait());
			break;
		case 5:
			System.out.println("maximum waiting time:"+job.maxWait());
			break;
		case 6:
			return;
		default:
			System.out.println("Invalid choice");
		}
	}

}
