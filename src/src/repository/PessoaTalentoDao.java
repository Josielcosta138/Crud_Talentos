package repository;

import java.sql.SQLException;
import java.util.List;

public class PessoaTalentoDao implements GenericDao{
    @Override
    public void salvar(Object objeto) {

    }

    @Override
    public void remover(Object objeto) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List buscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List buscarPorNomes(String nome) {
        return null;
    }
}
