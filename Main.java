package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("BANKA HESAP SİMÜLASYONUNA HOŞ GELDİNİZ");
        while (!exit){
            System.out.println("\n---İŞLEM MENÜSÜ---");
            System.out.println("1. Yeni Hesap Aç");
            System.out.println("2. Bakiye Sorgula");
            System.out.println("3. Para Yatır");
            System.out.println("4. Para Çek");
            System.out.println("5. Para Transferi (Havale)");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("hesap numarası girin: ");
                    String accNo = scanner.nextLine();
                    System.out.print("ad soyad girin: ");
                    String holder = scanner.nextLine();
                    System.out.print("başlangıç bakiyesi girin: ");
                    double initialBalance = scanner.nextDouble();

                    Account newAcc = new Account(accNo, holder, initialBalance);
                    bank.addAccount(newAcc);
                    break;

                case 2:
                    System.out.print("sorgulanacak hesap numarası: ");
                    String queryAccNo = scanner.nextLine();
                    Account accToQuery = bank.findAccount(queryAccNo);
                    if(accToQuery != null){
                        System.out.println("hesap sahibi: "+ accToQuery.getAccountHolder());
                        System.out.println("güncel bakiye: "+ accToQuery.getBalance()+"TL");
                    }else{
                        System.out.println("bu numaraya ait hesap bulunamadı");
                    }
                    break;
                case 3:
                    System.out.print("para yatırılıacak hesap numarası: ");
                    String depositAccNo = scanner.nextLine();
                    Account depositAcc = bank.findAccount(depositAccNo);
                    if (depositAcc != null) {
                        System.out.print("Yatırılacak Tutar: ");
                        double depAmount = scanner.nextDouble();
                        depositAcc.deposit(depAmount);
                    } else {
                        System.out.println("❌ Hesap bulunamadı!");
                    }
                    break;

                case 4:
                    System.out.print("Para Çekilecek Hesap Numarası: ");
                    String withdrawAccNo = scanner.nextLine();
                    Account withdrawAcc = bank.findAccount(withdrawAccNo);
                    if (withdrawAcc != null) {
                        System.out.print("Çekilecek Tutar: ");
                        double drawAmount = scanner.nextDouble();
                        withdrawAcc.withdraw(drawAmount);
                    } else {
                        System.out.println("❌ Hesap bulunamadı!");
                    }
                    break;

                case 5:
                    System.out.print("Gönderen Hesap Numarası: ");
                    String senderNo = scanner.nextLine();
                    System.out.print("Alıcı Hesap Numarası: ");
                    String receiverNo = scanner.nextLine();
                    System.out.print("Transfer Edilecek Tutar: ");
                    double transferAmount = scanner.nextDouble();

                    bank.transfer(senderNo, receiverNo, transferAmount);
                    break;

                case 6:
                    exit = true;
                    System.out.println("Sistemden çıkılıyor. İyi günler dileriz!");
                    break;

                default:
                    System.out.println("❌ Geçersiz seçim! Lütfen 1-6 arasında bir sayı girin.");
            }
        }
        scanner.close();

            }
        }

