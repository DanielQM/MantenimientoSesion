package model;

public class UsuarioM {

    private String CODIGO;
    private String NOMBRE;
    private String CONTRAS;
    private String TIPO;
    private String ESTADO;

    /*
    GETTER && SETTER
     */

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCONTRAS() {
        return CONTRAS;
    }

    public void setCONTRAS(String CONTRAS) {
        this.CONTRAS = CONTRAS;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }
    
}
