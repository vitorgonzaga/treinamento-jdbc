package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer id;

    private String nome;

    private List<Produto> produtos = new ArrayList<>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("id: %d, nome: %s", this.id, this.nome);
    }

    public void adiciona(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
