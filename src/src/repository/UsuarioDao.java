package repository;

import model.*;

import java.util.*;

public class UsuarioDao {
    public static List<Usuario> findUsuariosSistema() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setLogin("Alessandro");
        usuario.setSenha("123");

        Usuario usuario1 = new Usuario();
        usuario1.setLogin("Josiel");
        usuario1.setSenha("123");

        Usuario usuario2 = new Usuario();
        usuario2.setLogin("Ramon");
        usuario2.setSenha("123");

        Usuario usuario3 = new Usuario();
        usuario3.setLogin("Wesley");
        usuario3.setSenha("123");

        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);


        return usuarios;
    }

    public static Object[] findUsuariosSistemaInArray() {
        List<Usuario> usuarios = findUsuariosSistema();
        List<String> usuariosLogins = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuariosLogins.add(usuario.getLogin());
        }

        return usuariosLogins.toArray();
    }

    public static Usuario findUsuarioByLogin(String login) {
        List<Usuario> usuariosSistema = findUsuariosSistema();

        for (Usuario usuario : usuariosSistema) {
            if (login.equals(login)) {
                return usuario;
            }
        }
        return null;
    }

}


