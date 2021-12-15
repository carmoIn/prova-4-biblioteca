package Models;

import java.util.ArrayList;

public class Biblioteca {
    private Long id;
    private String nome;
    private ArrayList<Genero> generos = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(String nome, ArrayList<Genero> generos) {
        this.nome = nome;
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", livros=" + generos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Genero> getLivros() {
        return generos;
    }

    public void setLivros(ArrayList<Genero> generos) {
        this.generos = generos;
    }
}
