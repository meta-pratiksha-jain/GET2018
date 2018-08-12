package counselingProcess;

import java.io.*;
import java.io.File;
import java.util.*;
import java.util.prefs.Preferences;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import queue.*;
import jxl.write.biff.*;
import jxl.write.*;

public class Counseling {
    
    /**
     * private helper method to get list of students
     * @return list of students in queue
     * @throws BiffException
     * @throws IOException
     */
    private IQueue<Student> getListOfStudents() throws BiffException, IOException
    {
        IQueue<Student> studentQueue=ReadWriteExcel.readStudentDetails();
        return studentQueue;
    }
    
    /**
     * private helper method to get list of program offered by college
     * @return list of program
     * @throws BiffException
     * @throws IOException
     */
    private List<Program> getListOfPrograms() throws BiffException, IOException
    {
        List<Program> listOfPrograms=ReadWriteExcel.readProgramDetails();
        return listOfPrograms;
    }
    
    /**
     * allocate program to the students according to thier preferences
     * @return list of students corresponding to alllocated program 
     * @throws BiffException
     * @throws IOException
     * @throws RowsExceededException
     * @throws WriteException
     */
    public HashMap<String,String> allocatePrograms() throws BiffException, IOException, RowsExceededException, WriteException
    {
        HashMap<String,String> allocatedProgramList=new HashMap<String,String>();
        IQueue<Student> studentQueue=getListOfStudents();
        List<Program> listOfPrograms=getListOfPrograms();
        boolean isStudentQueueEmpty=studentQueue.isEmpty();
        int cellRow=1;
        while(!isStudentQueueEmpty)
        {
            
            Student student=studentQueue.dequeue();
            String[] prefernces=student.getPreferences();
            outer:for(int i=0;i<prefernces.length;i++)
            {
                for(Program program:listOfPrograms)
                {
                    String programName=program.getName();
                    if(programName.equals(prefernces[i]))
                    {
                        int numberOfAllocatedStudents=program.getNumberOfAllocatedStudents();
                        int capacityOfProgram=program.getCapacity();
                        
                        if(numberOfAllocatedStudents<capacityOfProgram)
                        {
                            String studentName=student.getName();
                            allocatedProgramList.put(studentName, programName);
                            program.setNumberOfAllocatedStudents(numberOfAllocatedStudents+1);
                            break outer;
                        }
                    }
                }
            }
            isStudentQueueEmpty=studentQueue.isEmpty();
        }
        ReadWriteExcel.writeAllocatedList(allocatedProgramList);
        return allocatedProgramList;
    }

}
