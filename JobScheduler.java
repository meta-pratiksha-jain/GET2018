
public class JobScheduler {
	private int[][] process;
	private int numProcess;
         /*
	 * constructor it initialize array and variables
         * @param numprocess is the number of processes
         * @param process[][] stores arrival time and burst time for each process
	 */
	public JobScheduler(int numProcess,int[][] process)
	{
		this.numProcess=numProcess;
		this.process=process;
		
	}
        /*
	 * Calculates waiting time for each process
	 * @return wait[] for waiting time of each process
	 */
	public int[] waitTime()
	{
		int[] wait=new int[numProcess];
		wait[0]=0;
		int totalTime=process[0][1];
		for(int i=1;i<numProcess;i++)
		{
			if(totalTime>process[i][0])
			{
				wait[i]=totalTime-process[i][0];
				totalTime=totalTime+process[i][1];
			}
			else
			{
				wait[i]=0;
				totalTime=process[i][0]+process[i][1];
			}
		}
		return wait;
	}
         /*
	 * Calculates completion time for each process
	 * @return comp[] for completion time of each process
	 */
	public int[] compTime()
	{
		int[] wait=waitTime();
		int[] comp=new int[numProcess];
		for(int i=0;i<numProcess;i++)
		{
			comp[i]=process[i][0]+process[i][1]+wait[i];
		}
		return comp;
	}
        /*
	 * Calculates turn around time for each process
	 * @return turnAround[] for turn around time of each process
	 */
	public int[] turnAroundTime()
	{
		int[] comp=compTime();
		int[] turnAround=new int[numProcess];
		for(int i=0;i<numProcess;i++)
		{
			turnAround[i]=comp[i]-process[i][0];
		}
		return turnAround;
	}
        /*
	 * Calculates average waiting time for processes
	 * @return average waiting time for processes
	 */
	public double averageWait()
	{
		int[] wait=waitTime();
		double totalWait=0;
		for(int i=0;i<numProcess;i++)
		{
			totalWait=totalWait+wait[i];
		}
		return totalWait/numProcess;
	}
        /*
	 * Calculates maximum waiting time from all processes
	 * @return max which is maximum waiting time from all processes
	 */
	public int maxWait()
	{
		int[] wait=waitTime();
		int max=wait[0];
		for(int i=1;i<numProcess;i++)
		{
			if(max<wait[i])
			{
				max=wait[i];
			}
		}
		return max;
	}

}
