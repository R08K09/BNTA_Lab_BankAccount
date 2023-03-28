import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount account1;

    @BeforeEach
    public void setUp(){
        account1 = new BankAccount("Sophie",
                "Harrison",
                "12-08-1998",
                4325436,
                250.00,
                "current");
    }

    // Test for getting firstName;
    @Test
    public void testFirstName(){
        String actualFirstName = "Sophie";
        String expectedFirstName = "Sophie";
        assertThat(actualFirstName).isEqualTo(expectedFirstName);
    }

    // Test for setting firstName;
    @Test
    public void testSetFirstName(){
        account1.setFirstName("Chris");
        assertThat(account1.getFirstName()).isEqualTo("Chris");
    }

    // Test for getting lastName;
    @Test
    public void testLastName(){
        String actualLastName = "Harrison";
        String expectedLastName = "Harrison";
        assertThat(actualLastName).isEqualTo(expectedLastName);
    }

    // Test for setting lastName;
    @Test
    public void testSetLastName(){
        account1.setLastName("Murray");
        assertThat(account1.getLastName()).isEqualTo("Murray");
    }

    // Test for getting dateOfBirth;
    @Test
    public void testDOBName(){
        String actualDOB = "12-08-1998";
        String expectedDOB = "12-08-1998";
        assertThat(actualDOB).isEqualTo(expectedDOB);
    }

    // Test for setting dateOfBirth;
    @Test
    public void testSetDOBName(){
        account1.setDateOfBirth("22-03-1992");
        assertThat(account1.getDateOfBirth()).isEqualTo("22-03-1992");
    }

    // Test for getting AccountNumber;
    @Test
    public void testAccountNumber(){
        Integer actualAccountNumber = 4325436;
        Integer expectedAccountNumber = 4325436;
        assertThat(actualAccountNumber).isEqualTo(expectedAccountNumber);
    }

    // Test for setting AccountNumber;
    @Test
    public void testSetAccountNumber(){
        account1.setAccountNumber(6857243);
        assertThat(account1.getAccountNumber()).isEqualTo(6857243);
    }

    // Test for getting Overdraft;
    @Test
    public void testOverdraft(){
        Double actualOverdraft = 250.00;
        Double expectedOverdraft = 250.00;
        assertThat(actualOverdraft).isEqualTo(expectedOverdraft);
    }

    // Test for setting Overdraft;
    @Test
    public void testSetOverdraft(){
        account1.setOverdraft(300.00);
        assertThat(account1.getOverdraft()).isEqualTo(300.00);
    }

    // Test for getting AccountType;
    @Test
    public void testAccountType(){
        String actualAccountType = "current";
        String expectedAccountType = "current";
        assertThat(actualAccountType).isEqualTo(expectedAccountType);
    }

    // Test for setting AccountType;
    @Test
    public void testSetAccountType(){
        account1.setAccountType("savings");
        assertThat(account1.getAccountType()).isEqualTo("savings");
    }


    // Test deposit method
    @Test
    public void canDeposit(){
        account1.deposit(200.00);
        // if balance starts at 0.00 then depositing 200.00 should result in a balance of 200.00
        assertThat(account1.getBalance()).isEqualTo(200.00);
    }

    // Test withdrawal method
    @Test
    public void canWithdrawal(){
        account1.withdrawal(200.00);
        // if balance starts at 0.00 and 200.00 gets withdrawn then -200.00 remains in balance
        assertThat(account1.getBalance()).isEqualTo(-200.00);
    }

    // Test interest method with current AccountType
    @Test
    public void canPayCurrentInterest(){
        account1.deposit(100.00);
        account1.payInterest(0.15, 0.10);
        assertThat(account1.getBalance()).isEqualTo(110.00);
    }

    // Test interest method with savings AccountType
    @Test
    public void canPaySavingsInterest(){
        account1.setAccountType("savings");
        account1.deposit(100.00);
        account1.payInterest(0.15, 0.10);
        assertThat(account1.getBalance()).isEqualTo(115.00);
    }


}
