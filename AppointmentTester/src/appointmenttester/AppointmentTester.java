package appointmenttester;

import java.util.Scanner;

public class AppointmentTester {

    public static void main(String[] args) {

        // Define some appointments ...
        Appointment a = new OnetimeAppointment("Go to court",
                                                5, 2, 2014);
        // I am going to court on 2/5/2014 (Feb. 5th, 2014)
        Appointment b = new OnetimeAppointment("Go to Six Flags",
                                                13, 7, 2014);
        Appointment c = new OnetimeAppointment("Celebrate Tim's birthday",
                                                13, 10, 2014);


        Appointment d = new DailyAppointment("Eat breakfast");
        // I eat breakfast every day of every month of every year
        Appointment e = new DailyAppointment("Visit mother");

        Appointment f = new MonthlyAppointment("See doctor", 13);
        // I see the doctor on the 13th day of every month of every year
        Appointment g = new MonthlyAppointment("Volunteer at zoo", 2);


        // Assemble the calendar
        Appointment [] calendar = new Appointment[7];
        calendar[0] = a;
        calendar[1] = b;
        calendar[2] = c;
        calendar[3] = d;
        calendar[4] = e;
        calendar[5] = f;
        calendar[6] = g;


        int day, month, year;

        // Retrieve user input for values of day, month, and year

        Scanner input = new Scanner(System.in);
        System.out.println("What is year of this appointment ?");
        year = input.nextInt();
        System.out.println("What is month (1-12) of this appointment ?");
        month = input.nextInt();
        System.out.println("What is day (1-31) of this appointment ?");
        day = input.nextInt();

        // Determine which appointments are on the given date + show them !

        System.out.println("On the date that you specified, here" +
                           "are the appointments to keep: ");
        for (Appointment appt: calendar)
        {
            if (appt.occursOn(day, month, year))
            {
                System.out.println("TODO: " + appt.getDescription());
            }
        }

    }
}
