package repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<E> {

    void salvar (E objeto);
    void remover (E objeto) throws SQLException, ClassNotFoundException;

    List<E> buscarTodos() throws  SQLException, ClassNotFoundException;

    List<E> buscarPorNomes(String nome);



}
