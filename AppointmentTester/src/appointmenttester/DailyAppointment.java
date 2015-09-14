package appointmenttester;

/** A subclass (derived class) of the Appointment class representing
 *  appointments that occur EVERY SINGLE DAY of EVERY MONTH of EVERY YEAR.
 *  That is, these appointments occur constantly -- regardless of the date !
 */
public class DailyAppointment extends Appointment
{
    /** Creates a daily appointment -- that is, one that occurs every day
     * of every month of every year.
     * @param d a description of the daily appointment.
     */
     public DailyAppointment(String d)
     {
         super(d,1,1,1);
     }
     
     /** Determines whether or not an appointment will occur on a specified day
     * @param d the day of the month that is of interest
     * @param m the number of the month (1-12) that is of interest
     * @param y the year of interest
     * @return a value of true is always returned by this method, since
      * daily appointments are guaranteed to occur every day !
     */
     public  boolean occursOn(int d, int m, int y)
     {
         return true;
     }
}
