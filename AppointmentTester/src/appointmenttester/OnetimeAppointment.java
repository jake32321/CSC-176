package appointmenttester;

/** A subclass (derived class) of the Appointment class representing
 *  appointments that occur only one time.
 */
public class OnetimeAppointment extends Appointment {

    public OnetimeAppointment(String descript, int d, int m, int y)
    {
        super(descript, d, m, y);
    }

    public boolean occursOn(int d, int m, int y)
    {
      return ((getDay() == d) && (getMonth() == m) && (getYear() == y));
    }
}