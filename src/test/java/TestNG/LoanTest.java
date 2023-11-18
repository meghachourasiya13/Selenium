package TestNG;

import org.testng.annotations.Test;

public class LoanTest {

    @Test
    public void TC01_HomeLoantest()
    {
        System.out.println("Inside Homeloan");
    }

    @Test
    public void TC02_CarLoantest()
    {
        System.out.println("Inside Carloan");
    }

    @Test
    public void TC00_PersonalLoantest()
    {
        System.out.println("Inside PersonalLoan");
    }
}
