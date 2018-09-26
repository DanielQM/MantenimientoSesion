package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UsuarioM;

public class UsuarioD extends Dao {
    
    /* INICIA SESIÓN SIEMPRE Y CUANDO EL NOMBRE Y AL CONTRASEÑA COINCIDAN Y ESTÉ ACTIVO */
    public UsuarioM iniciarSesion(String User, String Pass) throws Exception {
        this.conectar();
        ResultSet rs;
        UsuarioM usuario = null;
        try {
            String sql = "SELECT CODIGO, TIPO FROM USUARIO WHERE NOMBRE LIKE ? AND CONTRAS LIKE ? AND ESTADO LIKE 'A'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioM();
                usuario.setCODIGO(rs.getString("CODIGO"));
                usuario.setTIPO(rs.getString("TIPO"));
                usuario.setNOMBRE(User);
                usuario.setCONTRAS(Pass);
            }
            return usuario;
        } catch (SQLException e) {
            throw e;
        }
    }
}
