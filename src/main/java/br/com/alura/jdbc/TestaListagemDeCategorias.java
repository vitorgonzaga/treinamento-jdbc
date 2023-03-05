package br.com.alura.jdbc;

import br.com.alura.jdbc.DAO.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {

    public static void main(String[] args) throws SQLException {

        try(Connection con =  new ConnectionFactory().recuperaConexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(con);
//            List<Categoria> listaDeCategorias = categoriaDAO.listaCategorias();
            List<Categoria> listaDeCategorias = categoriaDAO.listaCategoriasComProdutos();
            listaDeCategorias.stream().forEach(categ -> {
                System.out.println("::" + categ.getNome() + "::");
                for(Produto produto : categ.getProdutos()) {
                    System.out.println("- " + produto.getNome());
                }
            });

        }


    }

}
