import java.util.ArrayList;

public class Pesanan {
    private String nomorPesanan;
    private Pelanggan pelanggan;
    private ArrayList<DetailPesanan> daftarPesanan;
    private Promosi promosi;

    public Pesanan(String nomorPesanan, Pelanggan pelanggan) {
        this.nomorPesanan = nomorPesanan;
        this.pelanggan = pelanggan;
        this.daftarPesanan = new ArrayList<>();
    }

    public void tambahMenu(Menu menu, int jumlah) {
        DetailPesanan detail = new DetailPesanan(menu, jumlah);
        daftarPesanan.add(detail);
    }

    public void gunakanPromosi(Promosi promosi) {
        this.promosi = promosi;
    }

    public double hitungSubtotal() {
        double total = 0;

        for (DetailPesanan detail : daftarPesanan) {
            total += detail.hitungSubtotal();
        }

        return total;
    }

    public double hitungDiskon() {
        if (promosi != null) {
            return promosi.hitungDiskon(hitungSubtotal());
        }

        return 0;
    }

    public double hitungTotal() {
        return hitungSubtotal() - hitungDiskon();
    }

    public void tampilkanPesanan() {
        System.out.println("\n===== DETAIL PESANAN =====");
        System.out.println("Nomor pesanan: " + nomorPesanan);
        System.out.println("Pelanggan: " + pelanggan.getNama());

        for (DetailPesanan detail : daftarPesanan) {
            detail.tampilkanDetail();
        }

        System.out.println("Subtotal: Rp" + hitungSubtotal());
        System.out.println("Diskon: Rp" + hitungDiskon());
        System.out.println("Total: Rp" + hitungTotal());
    }

    public String getNomorPesanan() {
        return nomorPesanan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public double getTotal() {
        return hitungTotal();
    }
}
