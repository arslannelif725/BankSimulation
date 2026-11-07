package org.example;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    //bankadaki tüm hesapları tutacağımız liste
    private List<Account> accounts;
    public BankService(){
        accounts = new ArrayList<>();
    }
    //yeni hesap ekleme
    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("✅ Hesap başarıyla oluşturuldu: " + account.getAccountNumber() + " (" + account.getAccountHolder() + ")");
    }
    //hesap numarasına göre hesap arama (yardımcı metot)
    public Account findAccount(String accountNumber){
        for (Account acc : accounts){
            if (acc.getAccountNumber().equals(accountNumber)){
                return acc;
            }
        }
        return null;
    }
    //para transferi
    public void transfer(String fromAccNo, String toAccNo, double amount){
        Account sender = findAccount(fromAccNo);
        Account receiver = findAccount(toAccNo);
        if(sender == null){
            System.out.println("❌ Gönderici hesap bulunamadı!");
            return;
        }
        if(receiver == null){
            System.out.println("❌ Alıcı hesap bulunamadı!");
            return;
        }
        //önce göndericiden para çekmeyi dene
        boolean isWithdrawn = sender.withdraw(amount);
        if(isWithdrawn){
            //para başarıyla çekildiyse alıcıya yatır
            receiver.deposit(amount);
            System.out.println("✅ Para transferi başarıyla gerçekleşti! " + fromAccNo + " -> " + toAccNo);
        }else{
            System.out.println("❌ Transfer başarısız (Yetersiz bakiye veya geçersiz tutar).");
        }
    }
}
