package controller;

import dao.UsuarioD;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.UsuarioM;

@Named(value = "usuarioC")
@SessionScoped
public class UsuarioC implements Serializable {

    /* OBJETO DE SESION */
    private UsuarioM usuario = new UsuarioM();

    /* VARIABLES DE LOGUEO */
    private String User;
    private String Pass;
    
    
    public void iniciarSesion() throws Exception {
        UsuarioD dao;
        try {
            dao = new UsuarioD();
            usuario = dao.iniciarSesion(User, Pass);
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombreUsuario", usuario);   
                FacesContext.getCurrentInstance().getExternalContext().redirect("/MantSesion/faces/index.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Contraseña/Usuario Incorrecto",null));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /* CIERA LA SESION */
    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); // CIERRA LA SESION
        FacesContext.getCurrentInstance().getExternalContext().redirect("/MantSesion"); // MANDAMOS AL LOGUIN
    }

    /* SI LA SESION YA ESTA INICIADA, REDIRECCIONA A ESTA VISTA */
    public void seguridadLogin() throws IOException {
        UsuarioM us = obtenerObjetoSesion();
        if (us != null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/MantSesion/faces/index.xhtml");
        }
    }
    
    /* NO PERMITE INGRESAR A NINGUNA VISTA SI LA SESION NO ESTÁ INICIADA */
    public void seguridadSesion() throws IOException {
        if (obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/MantSesion");
        }
    }

    public static UsuarioM obtenerObjetoSesion() {
        return (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreUsuario");
    }

    public UsuarioM getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioM usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
}
