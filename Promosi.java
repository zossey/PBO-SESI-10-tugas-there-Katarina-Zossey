public class Promosi {
    private String namaPromosi;
    private double diskonPersen;

    public Promosi(String namaPromosi, double diskonPersen) {
        this.namaPromosi = namaPromosi;
        this.diskonPersen = diskonPersen;
    }

    public double hitungDiskon(double total) {
        return total * diskonPersen / 100;
    }

    public String getNamaPromosi() {
        return namaPromosi;
    }
}

