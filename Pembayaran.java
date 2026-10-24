public class Pembayaran {
    private String metodePembayaran;
    private double jumlahBayar;

    public Pembayaran(String metodePembayaran, double jumlahBayar) {
        this.metodePembayaran = metodePembayaran;
        this.jumlahBayar = jumlahBayar;
    }

    public void cetakStruk(Pesanan pesanan) {
        System.out.println("\n===== STRUK PEMBAYARAN =====");
        System.out.println("Nomor pesanan: " + pesanan.getNomorPesanan());
        System.out.println("Nama pelanggan: "
                + pesanan.getPelanggan().getNama());
        System.out.println("Total: Rp" + pesanan.getTotal());
        System.out.println("Metode pembayaran: " + metodePembayaran);
        System.out.println("Jumlah bayar: Rp" + jumlahBayar);

        if (jumlahBayar >= pesanan.getTotal()) {
            System.out.println("Kembalian: Rp"
                    + (jumlahBayar - pesanan.getTotal()));
            System.out.println("Pembayaran berhasil.");
        } else {
            System.out.println("Uang pembayaran tidak cukup.");
        }
    }
}