package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import cartao.Cartao;
import compra.Compra;

public class App {
    public static void main(String[] args) {
        int opcao = 1;
        String desc;
        double valor;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nDigite o limite do cartão:");
        double limite = scan.nextDouble();

        Cartao cartao = new Cartao(limite);
        List<Compra> arrCompras = new ArrayList<>();

        while (opcao != 0) {
            switch (opcao) {
                case 1: {
                    System.out.println("\nDigite a descrição da compra:");
                    desc = scan.next();
                    System.out.println("\nDigite o valor da compra:");
                    valor = scan.nextDouble();

                    if (cartao.getLimite() < valor) {
                        if (cartao.getLimite() == 0) {
                            System.out.println("\nVocê não possui mais limite!");
                            opcao = 0;
                            break;
                        }
                        System.out.println("\nSem limite para essa compra");
                        System.out.println(String.format("Limite disponível: %.2f. Limite utilizado: %.2f", cartao.getLimite(), cartao.getSaldo()));
                        opcao = 2;
                        break;
                    }

                    cartao.comprar(valor);
                    arrCompras.add(new Compra(valor, desc));

                    Collections.sort(arrCompras);
                    System.out.println("\n------------------Resumo-----------------\n");
                    arrCompras.forEach(System.out::println);

                    double totalGasto = cartao.getSaldo();
                    double limiteDisponivel = cartao.getLimite();

                    System.out.println(
                            String.format(
                                    "%nR$ %.2f do seu limite já foi usado. Você ainda tem disponível R$ %.2f para uso.%n",
                                    totalGasto, limiteDisponivel));
                    System.out.println("-------------------------------------------");
                    opcao = 2;
                }
                    break;
                case 2: {
                    System.out.println("\nDigite 1: para adicionar compra ou 0: para sair.");
                    opcao = scan.nextInt();
                }
                    break;
                default: {
                    System.out.println("Valor desconhecido. Digite 1: para adicionar compra ou 0: para sair.");
                    opcao = scan.nextInt();
                }
                    break;
            }
        }
        
        System.out.println("\n-----------------------------------------");
        System.out.println("\nObrigado! Suas compras são:");
        arrCompras.forEach(System.out::println);

        double totalGasto = cartao.getSaldo();
        double limiteDisponivel = cartao.getLimite();

        System.out.println(
                String.format("%nR$ %.2f do seu limite já foi usado. Você ainda tem disponível R$ %.2f para uso.",
                        totalGasto, limiteDisponivel));

        scan.close();
    }
}