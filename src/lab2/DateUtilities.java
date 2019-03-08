package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jlombardo
 */

// update input value from "M/d/yy" to "M/d/yyyy" to match logic in Employee.java (package lab2)
public class DateUtilities {
    public String getFormattedDate(Date date) {
        //SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(date);
    }
}