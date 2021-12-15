package Views;

import Controllers.BibliotecaController;
import Models.Biblioteca;

import java.util.Scanner;

public class BibliotecaView {
    BibliotecaController controller = new BibliotecaController();

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Cadatrar Biblioteca");

        System.out.println("Infome o nome da biblioteca: ");
        biblioteca.setNome(scanner.nextLine());

        Biblioteca novaBiblioteca = controller.cadastrar(biblioteca);
        if (novaBiblioteca != null) {
            System.out.println("Biblioteca " + novaBiblioteca + " cadastrada com sucesso!" );
        } else {
            System.out.println("Falha ao realizar cadastro");
        }
    }
}
