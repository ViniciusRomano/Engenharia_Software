package dao;

import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    private Connection connection;
    Long id;
    String nome;
    String sobrenome;
    String cpf;
    String rg;
    String telefone;
    String celular;
    String data;
    String email;
    String estado;
    String cidade;
    String bairro;
    String endereco;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO cliente(nome,sobrenome,rg,cpf,telefone,celular,data,email,estado,cidade,bairro,endereco) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getRg());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getCelular());
            stmt.setString(7, usuario.getData());
            stmt.setString(8, usuario.getEmail());
            stmt.setString(9, usuario.getEstado());
            stmt.setString(10, usuario.getCidade());
            stmt.setString(11, usuario.getBairro());
            stmt.setString(12, usuario.getEndereco());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
