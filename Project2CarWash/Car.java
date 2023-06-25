
/**
 * A Car object represents a car in the CarWashSimulation. 
 *
 * @author Caroline Lamb
 * @version 10/10/2021
 */
public class Car
{
    // represents the arrival time of the car. 
    private int arrivalT;
    
    /**
     * Constructor for objects of class Car. Contains the arrival time for 
     * each car. 
     * 
     * @param   arrival time of the car.
     */
    public Car(int arrived)
    {
        arrivalT = arrived;
    }
    
    /**
     * A method to give the arrival time for each car. 
     *
     * @return    the time a particular car arrived at the car wash.
     */
    public int arrivalT()
    {
        return arrivalT;
    }
}
