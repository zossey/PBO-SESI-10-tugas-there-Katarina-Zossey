public class DetailPesanan {
    private Menu menu;
    private int jumlah;

    public DetailPesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public double hitungSubtotal() {
        return menu.getHarga() * jumlah;
    }

    public void tampilkanDetail() {
        System.out.println(
            menu.getNama() + " x " + jumlah
            + " = Rp" + hitungSubtotal()
        );
    }
}
