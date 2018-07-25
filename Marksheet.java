
public class Marksheet {
	
	public Marksheet(){}
	/*
	 * calculates average of grades of all students
	 * @param num contains total number of students.
	 * @param grades is the array of grades of all students.
	 * Assume grades lie in the range 0 to 100 (both inclusive).
	 * Assume num is positive Integer
	 * @return avg contains average of all grades.
	 */
	public double average(int num, int[] grades)
	{
		int sum=0;
		double avg=0.0;
		for(int i=0;i<num;i++)
		{
			sum=sum+grades[i];
		}
		try{
		    avg=(double)(sum/num);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("divide by zero error");
		}
		return avg;
	}
	
	/*
	 * find maximum grade from all grades
	 * @param num contains total number of students.
	 * @param grades is the array of grades of all students.
	 * Assume grades lie in the range 0 to 100 (both inclusive).
	 * Assume num is positive Integer
	 * @return max contains maximum grade
	 */
	public int maximum(int num, int[] grades)
	{
		int max=grades[0];
		for(int i=1;i<num;i++)
		{
			if(max<grades[i])
			{
				max=grades[i];
			}
		}
		return max;
	}
	
	/*
	 * find minimum grade from all grades
	 * @param num contains total number of students.
	 * @param grades is the array of grades of all students.
	 * Assume grades lie in the range 0 to 100 (both inclusive).
	 * Assume num is positive Integer
	 * @return min contains minimum grade
	 */
	public int minimum(int num, int[] grades)
	{
		int min=grades[0];
		for(int i=0;i<num;i++)
		{
			if(min>grades[i])
			{
				min=grades[i];
			}
		}
		return min;
	}
	
	/*
	 * Calculates percentage of passed students.
	 * @param num contains total number of students.
	 * @param grades is the array of grades of all students.
	 * Assume grades lie in the range 0 to 100 (both inclusive).
	 * Assume num is positive Integer
	 * @return percentage contains percentage of passed students.
	 */
	public double percentPassed(int num,int[] grades)
	{
		int passed=0;
		double percentage=0.0;
		for(int i=0;i<num;i++)
		{
			if(grades[i]>=40)
			{
				passed++;
			}
		}
		try{
		    percentage=(double)(passed*100/num);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("divide by zero error");
		}
		return percentage;
	}

}
