public class Ulasan {
    private Pelanggan pelanggan;
    private int rating;
    private String komentar;

    public Ulasan(Pelanggan pelanggan, int rating, String komentar) {
        this.pelanggan = pelanggan;
        this.rating = rating;
        this.komentar = komentar;
    }

    public void tampilkanUlasan() {
        System.out.println("\n===== ULASAN PELANGGAN =====");
        System.out.println("Nama: " + pelanggan.getNama());
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Komentar: " + komentar);
    }
}
