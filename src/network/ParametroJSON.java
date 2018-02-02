package network;
/**
 * Created by desarrollo-win on 02/02/2018.
 */

public class ParametroJSON
{
    private String nombreParametro;
    private Object valor;

    public ParametroJSON() {
    }

    public ParametroJSON(String nombreParametro, Object valor) {
        this.nombreParametro = nombreParametro;
        this.valor = valor;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
