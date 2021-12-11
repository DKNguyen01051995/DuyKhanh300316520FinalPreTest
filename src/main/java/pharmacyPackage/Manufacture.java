package pharmacyPackage;

public class Manufacture {

    private String manucode;
    private String manuname;

    public Manufacture(String manucode, String manuname) {
        this.manucode = manucode;
        this.manuname = manuname;
    }

    public String getManucode() {
        return manucode;
    }

    public void setManucode(String manucode) {
        this.manucode = manucode;
    }

    public String getManuname() {
        return manuname;
    }

    public void setManuname(String manuname) {
        this.manuname = manuname;
    }
}
