package lab4;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 * This class is the startup class for the program. But together with the other
 * classes provided it is not a particularly good simulation of the real world.
 * Employees don't just hire themselves and them tell themselves to go through
 * orientation. There's usually a company and a HR person involved.
 *
 * @author Jim Lombardo, WCTC Instructor
 * @version 1.02
 */
public class Startup {

    public static void main(String[] args) {

        /**
         * Add logic to work through a process flow of the hiring process.  It goes something
         * like this:
         * 
         * Responsibility       Action
         * Human Resources      Process incoming resume, getting first name, last name and ssn
         * Human Resources      Review resume from job candidate
         * Human Resources      Route resume to work area
         * Application Area     Review resume to determine if interview desired
         * Application Area     Request interview with candidate
         * Human Resources      Set up interview with candidate
         * Application Area     Interview candidate
         * Application Area     Recommendation to hire/ not hire
         * Human Resources      Extend offer to candidate
         * Candidate            Accept or decline offer
         * Human Resources      If offer accepted, set up candidate as new employee and end candidate hiring process
         * Human Resources      If new employee not hired, process next resume
         * 
         * To implement this process flow, classes for HumanResources and ApplicationArea will be 
         * required at a minimum.  Note:  for this exercise I am not doing full edit checking
         * of input values.  Assumption is that valid information is entered.
         */
 
        boolean endUserLoop = false;
        String firstName = "";
        String lastName = "";
        String ssn = "";
        HumanResources HRcontact = new HumanResources();
        ApplicationArea applicationContact = new ApplicationArea();
        Candidate candidate = new Candidate();
            
        do {
            firstName = HRcontact.getFirstName();
            lastName = HRcontact.getLastName();
            ssn = HRcontact.getSSN();
            endUserLoop = HRcontact.ReviewResume();
            if (!endUserLoop) {
                HRcontact.RouteResume();
            }
            if (!endUserLoop) {
                endUserLoop = applicationContact.ReviewResume();
            }
            if (!endUserLoop) {
                applicationContact.RequestInterview();
            }
            if (!endUserLoop) {
                HRcontact.SetUpInterview();
            }
            if (!endUserLoop) {
                applicationContact.ConductInterview();
            }
            if (!endUserLoop) {
                endUserLoop = applicationContact.RecommendHire();
            }
            if (!endUserLoop) {
                HRcontact.ExtendOffer();
            }
            if (!endUserLoop) {
                endUserLoop = candidate.ConsiderOffer();
            }
            if (!endUserLoop) {
                Employee employee = new Employee(firstName, lastName, ssn);
                employee.doFirstTimeOrientation("A101");
                employee.getReportService().outputReport();
                endUserLoop = true;
            } else {
                endUserLoop = HRcontact.ProcessNextResume();
            }
        } while (!endUserLoop);
        
    }

}
