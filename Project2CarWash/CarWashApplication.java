import java.util.Iterator;
/**
 * The CarWashApplication class provides the main method for running the Car
 * Wash simulation.
 *
 * @author Caroline Lamb
 * @version 10/10/2021
 */
public class CarWashApplication
{
    public static void main(String[]args)
    {
        // Loop to run simulation for 7 days, simulating one week.
        for (int f = 1; f < 8; f++)
        {
            // create new simulation for each day so that data resets for
            // each day of the week. 
            CarWashSimulation c = new CarWashSimulation();
            System.out.println("......................................................................");
            System.out.println("Day: " + f);
            // loop to simulate the amount of time to run the simulation for. 
            // ie. 1 day = 600 min so loop through 600 times.
            for(int i = 0; i < 600; i++)
            {
                c.step();
            }
            c.serviceRemaining();

            // loop through the queue to print out the arrival time for each 
            // car that arrived. 
            System.out.println( "..." );
            System.out.println( "Cars in queue:" );

            for ( Iterator<Car> it = c.carQ2.iterator(); it.hasNext(); )
            {
                System.out.println( "Car arrived at time step " + 
                    it.next().arrivalT() + "." );
            }

            // print the total number of cars serviced, total wait time, and 
            // calculate then print the average wait time per car. 
            System.out.println("Total Cars Serviced: " + c.totalCarsServiced);
            System.out.println("Total Wait Time: " + c.totalWaitTime);
            System.out.println("Average wait time per car: " + c.totalWaitTime/c.totalCarsServiced);
            System.out.println("Total Cars With a Wait Time Over 10 Min: " + c.totalOverTen);
        }
    }
}
