import java.util.Scanner;

public class SiakadMain {
    static Mahasiswa[] mahasiswa;
    static MataKuliah[] mataKuliah;
    static Penilaian[] penilaian;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        isiDataAwal();

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilihan) {
                case 1 -> tampilkanDaftarMahasiswa();
                case 2 -> tampilkanDaftarMataKuliah();
                case 3 -> tampilkanDataPenilaian();
                case 4 -> urutkanDanTampilkanPenilaian();
                case 5 -> cariMahasiswaByNIM(input);
                case 0 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    static void tampilkanMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Tampilkan Daftar Mahasiswa");
        System.out.println("2. Tampilkan Daftar Mata Kuliah");
        System.out.println("3. Tampilkan Data Penilaian");
        System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
        System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void isiDataAwal() {
        mahasiswa = new Mahasiswa[]{
            new Mahasiswa("22001", "Ali Rahman", "Informatika"),
            new Mahasiswa("22002", "Budi Santoso", "Informatika"),
            new Mahasiswa("22003", "Citra Dewi", "Informatika")
        };

        mataKuliah = new MataKuliah[]{
            new MataKuliah("MK001", "Struktur Data", 3),
            new MataKuliah("MK002", "Basis Data", 3),
            new MataKuliah("MK003", "Desain Web", 3)
        };

        penilaian = new Penilaian[]{
            new Penilaian(mahasiswa[0], mataKuliah[0], 80, 85, 90),
            new Penilaian(mahasiswa[0], mataKuliah[1], 60, 75, 70),
            new Penilaian(mahasiswa[1], mataKuliah[0], 75, 70, 80),
            new Penilaian(mahasiswa[2], mataKuliah[1], 85, 90, 95),
            new Penilaian(mahasiswa[2], mataKuliah[2], 80, 90, 65)
        };
    }

    static void tampilkanDaftarMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        for (Mahasiswa m : mahasiswa) {
            System.out.printf("NIM: %s | Nama: %s | Prodi: %s\n",
                    m.getNim(), m.getNama(), m.getProdi());
        }
    }

    static void tampilkanDaftarMataKuliah() {
        System.out.println("\nDaftar Mata Kuliah:");
        for (MataKuliah mk : mataKuliah) {
            System.out.printf("Kode MK: %s | Nama: %s | SKS: %d\n",
                    mk.getKodeMK(), mk.getNamaMK(), mk.getSks());
        }
    }

    static void tampilkanDataPenilaian() {
        System.out.println("\nData Penilaian:");
        for (Penilaian p : penilaian) {
            p.tampilkanRingkas();
        }
    }

    static void urutkanDanTampilkanPenilaian() {
        // Bubble Sort descending by nilai akhir
        for (int i = 0; i < penilaian.length - 1; i++) {
            for (int j = 0; j < penilaian.length - i - 1; j++) {
                if (penilaian[j].hitungNilaiAkhir() < penilaian[j + 1].hitungNilaiAkhir()) {
                    Penilaian temp = penilaian[j];
                    penilaian[j] = penilaian[j + 1];
                    penilaian[j + 1] = temp;
                }
            }
        }

        System.out.println("\nData Penilaian (Diurutkan):");
        for (Penilaian p : penilaian) {
            p.tampilkanRingkas();
        }
    }

    static void cariMahasiswaByNIM(Scanner input) {
        System.out.print("\nMasukkan NIM yang dicari: ");
        String cariNIM = input.nextLine();
        boolean ditemukan = false;

        System.out.println("\nHasil Pencarian:");
        for (Penilaian p : penilaian) {
            if (p.getMahasiswa().getNim().equalsIgnoreCase(cariNIM)) {
                p.tampilkanRingkas();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }
}
