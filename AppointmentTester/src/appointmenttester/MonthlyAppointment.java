package appointmenttester;

/** A subclass (derived class) of the Appointment class representing
 *  appointments that occur on a given day EVERY SINGLE MONTH of EVERY YEAR.
 */
public class MonthlyAppointment extends Appointment
{
    /** Creates a new appointment that occurs every month of every year
     * on a specified date.
     * @param d a description of the appointment
     * @param day the day of the month on which the appointment occurs
     */
    public MonthlyAppointment(String d, int day)
    {
        super(d, day, 1, 1);
    }
    
    /** Determines whether or not an appointment will occur on a specified day
     * @param d the day of the month that is of interest
     * @param m the number of the month (1-12) that is of interest
     * @param y the year of interest
     * @return a value of true is returned if the appointment will occur on
     * the specified day, month, and year. Otherwise, false is returned.
     * Note: Since this a recurring monthly appointment, only the value of
     * day number is really important here !
     */
    public boolean occursOn(int d, int m, int y)
    {
        return (getDay() == d);
    }
}
