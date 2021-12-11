package pharmacyPackage;

public class Drug {
    private String drugcode;
    private String drugname;
    private String drugdesc;

    public Drug(String drugcode, String drugname, String drugdesc) {
        this.drugcode = drugcode;
        this.drugname = drugname;
        this.drugdesc = drugdesc;
    }


    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDrugdesc() {
        return drugdesc;
    }

    public void setDrugdesc(String drugdesc) {
        this.drugdesc = drugdesc;
    }
}
