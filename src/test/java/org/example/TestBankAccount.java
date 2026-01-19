package org.example;

import net.datafaker.Faker;
public class TestBankAccount {
    private double balance;

    public TestBankAccount(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        public void withdraw(double amount) {
            if (amount > 100) {
                System.out.println("Withdrawal failed: maximum limit is 100");
                return;
            }

            if (amount > balance) {
                System.out.println("Withdrawal failed: insufficient balance");
                return;
            }

            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }

        public double getBalance() {
            return balance;
        }
    }

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        double initialBalance = faker.number().numberBetween(200, 1000);
        TestBankAccount account = new TestBankAccount(initialBalance);

        System.out.println("Initial balance: " + account.getBalance());

        double depositAmount = faker.number().numberBetween(50, 200);
        account.deposit(depositAmount);

        double withdrawAmount = faker.number().numberBetween(50, 150);
        account.withdraw(withdrawAmount);

        System.out.println("Final balance: " + account.getBalance());
    }
}

