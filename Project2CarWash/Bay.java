import java.lang.IndexOutOfBoundsException;
//
//    Car Wash Simulation Project:  Bay Class
//
//    The Car Wash Simulation Project is described in 
//    <a href="http://max.cs.kzoo.edu/cs210/Labs/Queues/CarWashProgram.html">Car
//    Wash Project Description</a>.
//
//    Authors:   Autumn C. Spaulding and Alyce Brady,
//               based on a description by
//               <a href="mailto:trollend@nb.net">Todd Ollendyke</a>.
//    Date:      13 July 2000
//    Modified:  12 October 2000
//      Added Bay class.
//    Modified:  21 April 2013 by Alyce Brady
//      Parameterized durationOfCarWash.
//
/**
 *  This class represents a car wash bay in the Car Wash program.  In
 *  particular, it keeps track of when the bay is empty or, if
 *  there is a car being washed, how long it will be until the bay
 *  is empty again.
 *  
 *  (modified by Caroline Lamb 10/10/2021)
*/
public class Bay
{
    // represents the time it takes to wash a car.
    int timeToWashACar;
    // represents the remaining time to complete the wash.
    int timeLeftTillEmpty;
    
    /** Represents a bay in the car wash. Resets at the start of each
     *  simulation and stores the time to wash each car for.
     * 
     * @param   time it takes to wash a single car.
     */
    public Bay (int durationOfCarWash)
    {
        timeToWashACar = durationOfCarWash;
        reset();
    }

    /** Re-initialize the bay for the start of a new run of the simulation.
     * 
     */
    public void reset ()
    {
        // reset bay to be empty
        timeLeftTillEmpty = 0;
    }

    /** Is the bay empty, or is there a car in it being washed?
     * 
     * @return  true if it is empty, otherwise false
     */
    public boolean isEmpty ()
    {
        return this.timeLeftTillEmpty <= 0;
    }

    /** Start washing a new car.  This function sets the timer to show how
     *  many more minutes it will take to finish washing this new car. 
     */ 
    public void startWash ()
    // pre: isEmpty()
    {
        // Set timer to indicate how many minutes to go.  (If a car wash
        // takes 3 minutes, that means the current minute plus 2 more.)
        if (this.isEmpty())
        {
            timeLeftTillEmpty = timeToWashACar;
        }
        else
        {
            keepWashing();
        }
    }

    /** This function tells the bay about the passage of time as it washes
     *  a car.
     */
    public void keepWashing ()
    // pre: ! isEmpty()
    // post: bay is one unit of time closer to being empty
    {
        // Check that pre-condition is met to ensure that we don't go
        // into negative numbers!
        if ( this.isEmpty())
        {
            throw new IndexOutOfBoundsException(); 
        }
        else
        {
            timeLeftTillEmpty--;
        }
    }

}  // end Bay class