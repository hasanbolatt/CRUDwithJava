

public class Market {
    private int id;
    private String urun_adi;
    private String uretici;
    private double fiyat;

    public Market(int id, String urun_adi, String uretici, double  fiyat) {
        this.id = id;
        this.urun_adi = urun_adi;
        this.uretici = uretici;
        this.fiyat = fiyat;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
    
    
}
