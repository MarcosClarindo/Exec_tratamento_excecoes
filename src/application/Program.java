package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessExceptions;

/* Estudo de caso: saque em conta bancária
           * Conceito
           * Delegação
           * Manutenção / código limpo
           * Soluções:
                * Tudo na programação principal
                * Função "gambiarra"
                * Exceções

            Fazer um programa para ler os dados de um conta bancária
            e depois realizar um saque nesta conta bancária, mostrando 
            o novo saldo. Um saque não pode ocorrer ou se não houver saldo na conta,
            ou se o valor do saque for superior ao limite de saque da conta.
        */
public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe os dados da conta: ");
        System.out.print("Número: ");
        // Váriaveis auxiliares
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        // Objeto
        Account acc = new Account(number, holder, balance, withdrawLimit);
        System.out.println();

        System.out.print("Informe a quantia para sacar: ");
        double amount = sc.nextDouble();

        
        try {
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }
        catch (BusinessExceptions e) {
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
}
