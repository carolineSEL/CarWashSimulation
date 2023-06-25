import java.util.Iterator;
/**
 * The CarWashSimulation class will be used in the CarWashApplication to 
 * simulate the car wash. This class will handle the functions of the queue
 * and wash each car. Data for analysis is also stored here. 
 *
 * @author Caroline Lamb (assisted by Collaboration Center on 10/20/2021)
 * @version 10/20/2021
 */
public class CarWashSimulation
{
    // Create random number generator.
    Random randGen = new Random();
    
    // Create Bay & set wash time for the bay (4 or 3 min). 
    Bay bay = new Bay(4);
    
    // Create queue to add cars to. 
    LLQueue<Car> carQ = new LLQueue<Car>();
    
    // Create a queue to add cars to after they are dequeued (serviced) so 
    // that the timestamps for each car can be printed in the CarWashApplication.
    LLQueue<Car> carQ2 = new LLQueue<Car>();
    
    // int i represents the duration of time (1 min) in the simulation. 
    int i = 0;
    // Total cars serviced and the total time. Will be used in the 
    // CarWashApplication class to calculate the averages. 
    int totalCarsServiced = 0;
    int totalWaitTime = 0;
    // Will be used to calculate the number of cars whose wait time was > than
    // 10 minutes. 
    int waitTPerCar = 0;
    int totalOverTen = 0;
    /**
     * Constructor for objects of class CarWashSimulation
     */ 
    public CarWashSimulation()
    {
        
    }

    /**
     * This method will be used in the CarWashApplication to simulate one 
     * minute in the car wash simulation. 
     *
     */
    public void step()
    {
        // For each minute, a car will be randomly added to the queue. If the 
        // bay is empty, start washing the car that is next in the queue. When
        // a car begins being washed, remove it from the queue. Increment the 
        // totalCarsServiced variable to record that the car has been serviced.
        if (randGen.nextInt(4) == 1)
        {
            carQ.enqueue( new Car(i) );
            carQ2.enqueue( new Car(i) );
            //System.out.println( "time step " + i + ": A car arrived. Bay is available in " + bay.timeLeftTillEmpty + " minutes.");
        }
        else 
        {
            //System.out.println( "time step " + i + ": No car arrived. Bay is available in " + bay.timeLeftTillEmpty + " minutes.");
        }
        // While there is a car in the bay, keep washing. 
        if(!bay.isEmpty())
        {
            bay.keepWashing();
        }
        // if the bay is empty, and there are still cars in the queue, add the
        // next car in the queue to the bay and begin washing. Record that it
        // has been serviced, and therefore is removed from the queue. 
        if(bay.isEmpty() && !carQ.isEmpty())
        {
            bay.startWash();
            Car cT = carQ.dequeue();
            // Calculate the wait time for each car that is dequeued.
            waitTPerCar = i - cT.arrivalT();
            // If a car has a wait time that is more than 10 minutes,
            // increment the variable to show this. 
            if ( waitTPerCar > 10)
            {
                totalOverTen++;
            }
            totalCarsServiced++;
            // Calculate the total wait time for all the cars. 
            totalWaitTime += i - cT.arrivalT();
        }
        // increment i to show the passage of time (each step simulates 1 min).
        i++;
    }
    
    /**
     * This method will be used in the CarWashApplication to service the 
     * remaining cars after the car wash has "closed". 
     *
     */
    public void serviceRemaining()
    {
        // Until the queue has been emptied, service the remaining cars. 
        while ( !carQ.isEmpty())
        {
            for (int j = 0; j < carQ.size(); j++)
            {
            bay.startWash();
            Car car = carQ.dequeue();
            // Calculate the wait time for each car that is dequeued.
            waitTPerCar = i - car.arrivalT();
            // If a car has a wait time that is more than 10 minutes,
            // increment the variable to show this. 
            if ( waitTPerCar > 10)
            {
                totalOverTen++;
            }
            // Add to total number of cars serviced.
            totalCarsServiced++;
            // Add to total wait time of cars.
            totalWaitTime += i - car.arrivalT();
            i++;
            }
        }
    }
}
