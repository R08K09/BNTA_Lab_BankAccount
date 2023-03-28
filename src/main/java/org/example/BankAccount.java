package org.example;

public class BankAccount {

        // PROPERTIES of BankAccount -----------
        private String firstName;
        private String lastName;
        private String dateOfBirth; // could use LocalDate
        private Integer accountNumber;
        private Double balance; // double rather than int since it's currency
        private Double overdraft;
        private String accountType;

        // CONSTRUCTOR -----------
        public BankAccount(String inputFirstName, String inputLastName, String inputDateOfBirth, Integer inputAccountNumber, Double inputOverdraft, String inputAccountType){
            this.firstName = inputFirstName;
            this.lastName = inputLastName;
            this.dateOfBirth = inputDateOfBirth;
            this.accountNumber = inputAccountNumber;
            this.balance = 0.00;
            this.overdraft = inputOverdraft;
            this.accountType = inputAccountType;

        }

        // GETTERS & SETTERS -----------
        public String getFirstName(){
            return this.firstName;
        }
        public void setFirstName(String firstName){
            this.firstName = firstName;
        }


        public String getLastName(){
            return this.lastName;
        }
        public void setLastName(String lastName){
            this.lastName = lastName;
        }


        public String getDateOfBirth(){
            return this.dateOfBirth;
        }
        public void setDateOfBirth(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
        }


        public Integer getAccountNumber(){
            return this.accountNumber;
        }
        public void setAccountNumber(Integer accountNumber){
            this.accountNumber = accountNumber;
        }


        public Double getBalance(){
            return this.balance;
        }


        public Double getOverdraft(){
            return this.overdraft;
        }
        public void setOverdraft(Double overdraft){
            this.overdraft = overdraft;
        }


        public String getAccountType(){
            return this.accountType;
        }
        public void setAccountType(String accountType){
            this.accountType = accountType;
        }



        // METHODS -----------

        // deposit method to take in an amount and updates the balance
        public void deposit(Double amount){
            // update balance
            this.balance += amount;
        }

        // withdrawal method to takes away an amount and updates the balance
//        public void withdrawal(double amount){
//            // only withdraw money if the account has that amount or more (e.g. not into negatives)
//            if ((this.balance - amount) >= 0){
//                this.balance -= amount;
//            }
//        }


        // Extension: Altered withdrawal() so that balance cannot fall below overdraft
        public void withdrawal(Double amount){
            // only withdraw if amount withdrawn does not cause account to fall below overdraft
            if ((this.balance - amount) >= -overdraft){
                this.balance -= amount;
            }
        }

        // interest method to allow the account to pay interest
        public Double interestCalculation(Double percentageInterest){
            return this.balance * percentageInterest;
        }

        // Extension: Altered payInterest() method to adjust interest paid according to accountType
        public void payInterest(Double savingsInterest, Double currentInterest){
            // if the accountType is savings
            if (accountType.equals("savings")){
                this.balance += interestCalculation(savingsInterest);
            } else if (accountType.equals("current")){
                this.balance += interestCalculation(currentInterest);
            }

        }

}
