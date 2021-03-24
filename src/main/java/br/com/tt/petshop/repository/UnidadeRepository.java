package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Unidade> listar(){
        return jdbcTemplate.query("select id,nome,endereco from tb_unidade", new UnidadeMapper());
    }

    public void criar(Unidade unidade) {
        // esse update maroto: faz insert, faz delete, faz update, qualquer coisa que não retorne dados
        jdbcTemplate.update("insert into tb_unidade (nome, endereco) values (?, ?)",
                    unidade.getNome(), unidade.getEndereco());
    }

    public void atualizar(Unidade unidade) {
        jdbcTemplate.update("update tb_unidade set nome=?,endereco=? where id=?",
                unidade.getNome(), unidade.getEndereco(), unidade.getId());
    }
}
