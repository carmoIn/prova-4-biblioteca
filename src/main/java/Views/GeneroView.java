package Views;

import Controllers.GeneroController;
import Models.Genero;

import java.util.Scanner;

public class GeneroView {
    GeneroController controller = new GeneroController();

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        Genero genero = new Genero();
        System.out.println("Cadatrar Genero");

        System.out.println("Infome o nome do genero: ");
        genero.setNome(scanner.nextLine());

        Genero novoGenero = controller.cadastrar(genero);
        if (novoGenero != null) {
            System.out.println("Genero " + novoGenero + " cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao realizar cadastro");
        }
    }

    public void editar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Editar Genero");

        System.out.println("Infome o id do genero que deseja editar: ");
        Long generoId = scanner.nextLong();

        Genero genero = controller.obterGeneroPeloId(generoId);

        if (genero != null) {
            scanner.nextLine();

            System.out.println("Infome o nome do genero: ");
            genero.setNome(scanner.nextLine());

            genero = controller.editar(genero);
            if (genero != null) {
                System.out.println("Genero editado com sucesso!");
            } else {
                System.out.println("Falha ao realizar edição");
            }
        } else {
            System.out.println("Genero não encontrado");
        }
    }
}
