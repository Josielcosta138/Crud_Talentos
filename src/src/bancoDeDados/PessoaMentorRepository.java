package bancoDeDados;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PessoaMentorRepository {

    //ConexaoComBanco
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/crudtalentos";
        Connection connection = DriverManager.getConnection(url, "root", "janice27");
        return connection;

    }

    public void insere(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {

        Connection connection = getConnection();
        PreparedStatement stmt1 = connection.prepareStatement("INSERT INTO pessoamentor VALUES (null, ?, ?, ?, ?, ?, ?, ?)");
       // stmt1.setLong(1, Entity.getId());
        stmt1.setString(1, pessoaMentor.getNome());
        stmt1.setString(2, pessoaMentor.getEnumSexo().toString());
        stmt1.setInt(3, pessoaMentor.getIdade());
        stmt1.setString(4, pessoaMentor.getHistorioDeMentorias());
        stmt1.setString(5, pessoaMentor.getEnumFormacao().toString());
        stmt1.setString(6, pessoaMentor.getEnumCidades().getDescricao());
        stmt1.setString(7, pessoaMentor.getEnumtipoAreaAtuacao().getDescricao());
                stmt1.executeUpdate();

        PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO contato  VALUES (null, ?, ?, ?)");
       // stmt2.setLong(1, Contato.getId());
        stmt2.setString(1, Contato.getEnumContato().toString());
        stmt2.setString(2, Contato.getDescricaoContato());
        stmt2.setLong(3, Contato.getIdd());
        stmt2.executeUpdate();
        connection.close();
    }


    public List<PessoaMentor> busca() throws SQLException, ClassNotFoundException {
        List<PessoaMentor> pessoaMentors = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("select * from pessoamentor");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            PessoaMentor pessoaMentor = new  PessoaMentor();
            pessoaMentor.setNome(resultSet.getString(2));
            pessoaMentor.setEnumSexo(EnumSexo.valueOf(resultSet.getString(3)));
            pessoaMentor.setIdade(resultSet.getInt(4));
            pessoaMentor.setHistorioDeMentorias(resultSet.getString(5));
            pessoaMentor.setEnumFormacao(EnumFormacao.valueOf(resultSet.getString(6)));
            pessoaMentor.setEnumCidades(EnumCidades.CIDADE_CRICIUMA);
            pessoaMentor.setEnumCidades(EnumCidades.CIDADE_GUARULHOS);
            pessoaMentor.setEnumtipoAreaAtuacao(EnumtipoAreaAtuacao.MARKTING);
            pessoaMentor.setContatos(Collections.singletonList(EnumContato.TELEFONE));
            pessoaMentor.setDescricaoContato(resultSet.getString(8));

            pessoaMentors.add(pessoaMentor);
        }
        connection.close();
        return pessoaMentors;
    }

    public void update(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt1 = connection.prepareStatement("UPDATE pessoamentor " +
                "SET nome = ?, idade = ?, sexo = ? WHERE id = ?");
        stmt1.setString(1, pessoaMentor.getNome());
        stmt1.setInt(2, pessoaMentor.getIdade());
        stmt1.setInt(3, EnumSexo.MASCULINO.ordinal());
        //stmt1.setInt(4, pessoaMentor.getId().intValue());

        stmt1.executeUpdate();
        connection.close();
    }


    public void delete(PessoaMentor pessoaMentor) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM pessoamentor" +
                " WHERE id = ?");
        //stmt.setInt(1, (int) Entity.getId());
        stmt.executeUpdate();
        connection.close();
    }

}






