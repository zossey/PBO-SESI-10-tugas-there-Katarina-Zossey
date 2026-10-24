import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Menu[] menu = {
            new Menu("Nasi Goreng", 25000, "Makanan"),
            new Menu("Mie Goreng", 22000, "Makanan"),
            new Menu("Ayam Bakar", 30000, "Makanan"),
            new Menu("Es Teh", 7000, "Minuman"),
            new Menu("Jus Jeruk", 12000, "Minuman")
        };

        System.out.println("===== SISTEM PEMESANAN RESTORAN =====");

        System.out.print("Masukkan nama pelanggan: ");
        String nama = input.nextLine();

        System.out.print("Masukkan nomor telepon: ");
        String telepon = input.nextLine();

        Pelanggan pelanggan = new Pelanggan(nama, telepon);
        Pesanan pesanan = new Pesanan("ORD001", pelanggan);

        int pilihan;

        do {
            System.out.println("\n===== DAFTAR MENU =====");

            for (int i = 0; i < menu.length; i++) {
                System.out.print((i + 1) + ". ");
                menu[i].tampilkanInfo();
            }

            System.out.println("0. Selesai memesan");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= menu.length) {
                System.out.print("Masukkan jumlah: ");
                int jumlah = input.nextInt();

                if (jumlah > 0) {
                    pesanan.tambahMenu(menu[pilihan - 1], jumlah);
                    System.out.println("Menu berhasil ditambahkan.");
                } else {
                    System.out.println("Jumlah harus lebih dari 0.");
                }
            } else if (pilihan != 0) {
                System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 0);

        System.out.print("\nGunakan diskon 10%? (1 = Ya, 0 = Tidak): ");
        int diskon = input.nextInt();

        if (diskon == 1) {
            Promosi promosi = new Promosi("Diskon 10%", 10);
            pesanan.gunakanPromosi(promosi);
        }

        pesanan.tampilkanPesanan();

        input.nextLine();

        System.out.print("\nMetode pembayaran: ");
        String metode = input.nextLine();

        System.out.print("Masukkan jumlah uang: Rp");
        double uang = input.nextDouble();

        Pembayaran pembayaran = new Pembayaran(metode, uang);
        pembayaran.cetakStruk(pesanan);

        input.nextLine();

        System.out.print("\nBerikan rating pelayanan (1-5): ");
        int rating = input.nextInt();
        input.nextLine();

        if (rating < 1 || rating > 5) {
            rating = 5;
            System.out.println("Rating tidak valid, rating diatur menjadi 5.");
        }

        System.out.print("Masukkan komentar: ");
        String komentar = input.nextLine();

        Ulasan ulasan = new Ulasan(pelanggan, rating, komentar);
        ulasan.tampilkanUlasan();

        System.out.println("\nTerima kasih sudah memesan!");

        input.close();
    }
}
