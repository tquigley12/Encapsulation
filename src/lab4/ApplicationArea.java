
package lab4;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 *
 * This class represents the application area that has an open requisition for 
 * which we are attempting to hire a new candidate.
 * 
 * @author tquigley1
 */
public class ApplicationArea {
    
    private EmployeeReportService reportService;
    private char action;
    private Scanner keyboard = new Scanner(System.in);
    
    public ApplicationArea() {
        reportService = new EmployeeReportService();
    }
    
    public boolean ReviewResume() {
        boolean endLoop = false;
        reportService.clearReport();
        reportService.addData("<Application contact>  Resume has been reviewed. \n");
        reportService.addData("<Application contact>  Would you like to interview candidate? (Y/N) \n");
        reportService.outputReport();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        if (action == 'N') {
            reportService.clearReport();
            reportService.addData("<Application contact>  This candidate is not viable.  Discontinue vetting of candidate. \n");
            reportService.outputReport();
            endLoop = true;
        }
        return endLoop;
    }
    
    public void RequestInterview() {
        reportService.clearReport();
        reportService.addData("<Application contact>  Interview request has been sent to HR. \n");
        reportService.outputReport();
    }
    
    public void ConductInterview() {
        reportService.clearReport();
        reportService.addData("<Application contact>  Candidate is interviewed by application area contact. \n");
        reportService.outputReport();
    }
    
    public boolean RecommendHire() {
        boolean endLoop = false;
        reportService.clearReport();
        reportService.addData("<Application contact>  Interview is complete. \n");
        reportService.addData("<Application contact>  Would you recommend to hire candidate? (Y/N) \n");
        reportService.outputReport();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        if (action == 'N') {
            reportService.clearReport();
            reportService.addData("<Application contact>  This candidate is not viable.  Discontinue vetting of candidate. \n");
            reportService.outputReport();
            endLoop = true;
        }
        return endLoop;
    }
    
}
