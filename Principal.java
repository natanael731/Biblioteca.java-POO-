package Biblioteca;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        Usuario aluno = new Aluno(1, "Amanda", "amanda@email.com");
        Usuario professor = new Professor(2, "Carlos", "carlos@email");

        biblioteca.adicionarLivro(new Livro("L1", "Java Básico", "Autor X"));
        biblioteca.adicionarLivro(new Livro("L2", "POO Avançada", "Autor Y"));
        biblioteca.adicionarLivro(new Livro("L3", "Estruturas de Dados", "Autor Z"));

        int opcao;
        do {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código do livro: ");
                    String codigo = sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    biblioteca.adicionarLivro(new Livro(codigo, titulo, autor));
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite ID do usuário (1 = Amanda, 2 = Carlos): ");
                    int idEmp = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o código do livro: ");
                    String codEmp = sc.nextLine();
                    if (idEmp == 1) {
                        biblioteca.emprestarLivro(aluno, codEmp);
                    } else if (idEmp == 2) {
                        biblioteca.emprestarLivro(professor, codEmp);
                    } else {
                        System.out.println("Usuário inválido!");
                    }
                    break;
                case 4:
                    System.out.print("Digite ID do usuário (1 = Amanda, 2 = Carlos): ");
                    int idDev = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o código do livro: ");
                    String codDev = sc.nextLine();
                    if (idDev == 1) {
                        biblioteca.devolverLivro(aluno, codDev);
                    } else if (idDev == 2) {
                        biblioteca.devolverLivro(professor, codDev);
                    } else {
                        System.out.println("Usuário inválido!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
