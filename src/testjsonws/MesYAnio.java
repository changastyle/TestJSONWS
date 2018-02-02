package testjsonws;


public class MesYAnio
{
    private int mes;
    private int year;

    public MesYAnio() {
    }

    public MesYAnio(int mes, int year) {
        this.mes = mes;
        this.year = year;
    }

    // GYS:
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStrMes()
    {
        return "";
        //return MasterController.resuelveMes(mes);
    }

    @Override
    public String toString() {
        return "MesYAnio{" +
                "mes=" + mes +
                ", year=" + year +
                '}';
    }
}