package counselingProcess;

import java.util.*;
import java.io.File;
import java.io.IOException;

import queue.IQueue;
import queue.QueueUsingLinkedList;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import queue.*;

/**
 * This class is used for reading and writing data from or to Excel sheet.
 *
 */
public class ReadWriteExcel {
       
    /**
     * Read student detail from excel sheet
     * @return queue of student
     * @throws BiffException
     * @throws IOException
     */
    public static IQueue<Student> readStudentDetails() throws BiffException, IOException
    {
       Workbook workbook=Workbook.getWorkbook(
               new File("D:\\Programs.xls"));
       Sheet studentSheet=workbook.getSheet(1);
       IQueue<Student> studentQueue=new QueueUsingLinkedList<Student>();
       for(int i=1;i<studentSheet.getRows();i++)
       {
           Student student=new Student();
           Cell cell=studentSheet.getCell(0, i);
           String name=cell.getContents();
           student.setName(name);
           String[] preferences=new String[5];
           for(int j=0;j<preferences.length;j++)
           {
              cell=studentSheet.getCell(j+1, i);
              preferences[j]=cell.getContents();
           }
           student.setPreferences(preferences);
           studentQueue.enqueue(student);
       }
       return studentQueue;
   }
   
    /**
     * read Program details from excel sheet
     * @return list of program offered by college
     * @throws BiffException
     * @throws IOException
     */
   public static List<Program> readProgramDetails() throws BiffException, IOException
   {
       Workbook workbook=Workbook.getWorkbook(
               new File("D:\\Programs.xls"));
       Sheet programSheet=workbook.getSheet(0);
       List<Program> listOfProgram=new ArrayList<Program>();
       for(int i=1;i<programSheet.getRows();i++)
       {
           Program program=new Program();
           Cell cell=programSheet.getCell(0,i);
           String name =cell.getContents();
           program.setName(name);
           cell=programSheet.getCell(1,i);
           String capacity=cell.getContents();
           program.setCapacity(Integer.parseInt(capacity));
           listOfProgram.add(program);
       }
       return listOfProgram;
   }
   
   /**
    * write list of student with their corresponding allocated program in a list
    * @param allocatedProgramList
 * @throws WriteException 
 * @throws RowsExceededException 
 * @throws IOException 
    */
   public static void writeAllocatedList(HashMap<String,String> allocatedProgramList) throws RowsExceededException, WriteException, IOException
   {
       WritableWorkbook workbook=Workbook.createWorkbook(new File("D:\\AllocatedProgramList.xls"));
       WritableSheet allocatedProgramSheet = workbook.createSheet("Sheet 1", 0);
       Label label = new Label(0, 0, "Student Name");
       allocatedProgramSheet.addCell(label);
       label = new Label(1, 0, "Program name");
       allocatedProgramSheet.addCell(label);
       int cellRow=1;
       for(Map.Entry<String, String> entry:allocatedProgramList.entrySet())
       {
           String studentName=entry.getKey();
           String programName=entry.getValue();
           label=new Label(0,cellRow,studentName);
           allocatedProgramSheet.addCell(label);
           label=new Label(1,cellRow,programName);
           allocatedProgramSheet.addCell(label);
           cellRow++;
       }
       workbook.write();
       if(workbook!=null)
       {
           workbook.close();
       }
   }
}
