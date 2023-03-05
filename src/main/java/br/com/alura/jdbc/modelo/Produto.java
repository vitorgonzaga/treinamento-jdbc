package br.com.alura.jdbc.modelo;

public class Produto {

    private final String nome;
    private final String descricao;
    private Integer id;
    private Integer categoriaId;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(String nome, String descricao, Integer categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    @Override
    public String toString() {
        return String.format("Produto :: %d, %s, %S", this.id, this.nome, this.descricao);
    }
}
