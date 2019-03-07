
package lab4;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 *
 * This class represents the Human Resources representative that will field the 
 * incoming resume.
 * 
 * @author tquigley1
 */
public class HumanResources {
   
    private EmployeeReportService reportService;
    private char action;
    private String firstName;
    private String lastName;
    private String ssn;
    private Scanner keyboard = new Scanner(System.in);
    
    public HumanResources() {
        reportService = new EmployeeReportService();
    }
    
    public String getFirstName() {
        reportService.clearReport();
        reportService.addData("You have received an resume for an open position at your company. \n\n");
        reportService.addData("Please enter name and SSN of the candidate. \n\n");
        reportService.addData("First name: ");
        reportService.outputReport();
        firstName = keyboard.nextLine();
        return firstName;
    }
    
    public String getLastName() {
        reportService.clearReport();
        reportService.addData("Last name: ");
        reportService.outputReport();
        lastName = keyboard.nextLine();
        return lastName;
    }
    
    public String getSSN() {
        reportService.clearReport();
        reportService.addData("SSN: ");
        reportService.outputReport();
        ssn = keyboard.nextLine();
        return ssn;
    }
    
    public boolean ReviewResume() {
        boolean endLoop = false;
        reportService.clearReport();
        reportService.addData("<HR representative>  Resume has been reviewed. \n");
        reportService.addData("<HR representative>  Is the candidate viable for interview? (Y/N) ");
        reportService.outputReport();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        if (action == 'N') {
            reportService.clearReport();
            reportService.addData("<HR representative>  This candidate is not viable.  Discontinue vetting of candidate. ");
            reportService.outputReport();
            endLoop = true;
        }
        return endLoop;
    }
    
    public void RouteResume() {
        reportService.clearReport();
        reportService.addData("<HR representative>  Resume is routed to application area for review. ");
        reportService.outputReport();
    }
    
    public void SetUpInterview() {
        reportService.clearReport();
        reportService.addData("<HR representative>  Candidate is contacted and interview is arranged. ");
        reportService.outputReport();
    }
    
    public void ExtendOffer() {
        reportService.clearReport();
        reportService.addData("<HR representative>  Candidate is contacted and offer is extended. ");
        reportService.outputReport();
    }
    
    public boolean ProcessNextResume() {
        boolean endLoop = false;
        reportService.clearReport();
        reportService.addData("<HR representative>  Candidate has been fully vetted and considered. \n");
        reportService.addData("<HR representative>  Would you like to examine another candidate? (Y/N) ");
        reportService.outputReport();
        action = toUpperCase(keyboard.nextLine().charAt(0));
        if (action == 'N') {
            reportService.clearReport();
            reportService.addData("<HR representative>  No more candidates will be considered.  Hiring process is complete. ");
            reportService.outputReport();
            endLoop = true;
        }
        return endLoop;
    }
    
}
