package appointmenttester;

/** A base class for representing appointments that a person might put
 * on their calendar
 * @author Professor Yenerall
 */
public abstract class Appointment {

    private String description;
    private int day, month, year;
    
    /** Creates an appointment with a specified day, month, year, 
     *  as well as a description of the appointment.
     * @param descript a short description of what the appointment is for
     * @param d the day of the month on which the appointment occurs
     * @param m the number of the month (1-12) when the appointment occurs
     * @param y the year in which the appointment occurs
     */
    public Appointment(String descript, int d, int m, int y)
    {
        description = descript;
        day = d;
        month = m;
        year =  y;
    }
    
    /** Returns a brief  description of the purpose of the appointment. 
     * @return a description of the purpose of the appointment
     */
    public String getDescription() { return description; }
   
    /** Returns the day of an appointment.
     * @return the day of the month on which the appointment occurs
     */
    public int getDay() { return day; }
    
    /** Returns the month of the appointment.
     * @return the number of the month in which the appointment occurs,
     * using the convention that January is month number 1, etc.
     */
    public int getMonth() { return month; }
    
    /** Returns the year of the appointment.
     * @return the year in which the appointment occurs
     */
    public int getYear() { return year; }
    
    /** Determines whether or not an appointment will occur on a specified day
     * @param d the day of the month that is of interest
     * @param m the number of the month (1-12) that is of interest
     * @param y the year of interest
     * @return a value of true is returned if the appointment will occur on
     * the specified day, month, and year. Otherwise, false is returned.
     */
    public abstract boolean occursOn(int d, int m, int y);
  
}