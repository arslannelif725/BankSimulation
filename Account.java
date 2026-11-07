package org.example;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    //Constructor (yapıcı metot) hesap açılırken çalışr
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        if (initialBalance >= 0){
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
            System.out.println("başlangıç bakiyesi 0'dan küçük olamaz, bakiye 0 yapıldı. ");
        }
    }
    //getter setter metotları (kapsülleme-encapsulation)
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public double getBalance() {
        return balance;
    }
    //para yatırma metodu
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("✅ \" + amount + \" TL başarıyla yatırıldı. Güncel bakiye: \" + balance + \" TL\");");
        }else{
            System.out.println("❌ Yatırılacak tutar 0'dan büyük olmalıdır!");
        }
    }

    // Para Çekme Metodu
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ " + amount + " TL başarıyla çekildi. Güncel bakiye: " + balance + " TL");
            return true;
        } else if (amount > balance) {
            System.out.println("❌ Yetersiz bakiye! Mevcut bakiyeniz: " + balance + " TL");
            return false;
        } else {
            System.out.println("❌ Çekilecek tutar 0'dan büyük olmalıdır!");
            return false;
        }
    }
}
