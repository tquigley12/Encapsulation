
package lab4;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 *
 * This class is for the job candidate.
 * 
 * @author tquigley1
 */
public class Candidate {
    
    private EmployeeReportService reportService;
    private char action;
    private Scanner keyboard = new Scanner(System.in);
    
    public Candidate() {
        reportService = new EmployeeReportService();
    }
    
    public boolean ConsiderOffer() {
        boolean endLoop = false;
        reportService.clearReport();
        reportService.addData("<Candidate>  Job offer has been extended. \n");
        reportService.addData("<Candidate>  Do you accept? (Y/N) ");
        reportService.outputReport();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        if (action == 'N') {
            reportService.clearReport();
            reportService.addData("<Candidate>  Offer was declined by candidate.  Discontinue vetting of candidate. ");
            reportService.outputReport();
            endLoop = true;
        }
        return endLoop;
    }
    
    
}
