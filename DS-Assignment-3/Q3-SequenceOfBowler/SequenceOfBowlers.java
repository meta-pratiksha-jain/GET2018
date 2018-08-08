package sequenceOfBowlers;

import java.util.*;
import priorityQueue.*;
import priorityQueue.PriorityQueue;

public class SequenceOfBowlers {
    IPriorityQueue bowlerBallsQueue;
    int numberOfBowler;
    int ballsOfVirat;
    Bowler[] bowlerArray;
    
    /**
     * constructor
     * @param numberOfBowler
     * @param ballsOfVirat
     * @param bowlerArray
     */
    public SequenceOfBowlers(int numberOfBowler,int ballsOfVirat,Bowler[] bowlerArray)
    {
        this.numberOfBowler=numberOfBowler;
        this.ballsOfVirat=ballsOfVirat;
        this.bowlerArray=bowlerArray;
        bowlerBallsQueue=new PriorityQueue(numberOfBowler);
    }
    
    /**
     * Gives list of bowler name in the order of their balling sequence to make virat's score as low as possible.  
     * @return sequence of bowlers
     */
    public List<String> getSequenceOfBowlers()
    {
        boolean isvalid=checkValidity();
        if(!isvalid)
        {
            throw new AssertionError("balls of virat are greater than total balls of bowler");
        }
        List<String> sequenceOfBowlers=new ArrayList<String>();
        initializeQueue();
        while(ballsOfVirat>0)
        {
            String chosenBowlerName=getBowlerFromQueue();
            sequenceOfBowlers.add(chosenBowlerName);
            ballsOfVirat--;
        }        
        return sequenceOfBowlers;
    }
    
    /**
     * private helper method to initialize bowler's queue.
     */
    private void initializeQueue() {
        for(Bowler bowler:bowlerArray)
        {
            String bowlerName=bowler.getName();
            int priority=bowler.getBallsLeft();
            bowlerBallsQueue.enqueue(bowlerName, priority);
        }
    }
    
    /**
     * private helper method to check validity for number of balls.
     * @return true if balls of Virat are less than or equal to total balls of all bowlers otherwise false.
     */
    private boolean checkValidity()
    {
        int totalBalls=0;
        for(Bowler bowler:bowlerArray)
        {
            totalBalls+=bowler.getBallsLeft();
        }
        if(ballsOfVirat>totalBalls)
        {
            return false;
        }
        return true;
    }
    
    /**
     * private helper method to get bowler name for sequence from queue
     * @return bowler name
     */
    private String getBowlerFromQueue()
    {
        Node node=bowlerBallsQueue.dequeue();
        String bowlerName=node.getData();
        int ballsLeft=node.getPriority()-1;
        bowlerBallsQueue.enqueue(bowlerName, ballsLeft);
        return bowlerName;
    }
}