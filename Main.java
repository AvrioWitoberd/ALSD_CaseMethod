import java.util.Scanner;

public class Main {
    static Penilaian[] penilaian;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        isiDataAwal();

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine(); // bersihkan newline

            switch (pilihan) {
                case 1:
                    tampilkanDataMahasiswa();
                    break;
                case 2:
                    tampilkanNilaiMahasiswa();
                    break;
                case 3:
                    urutkanNilaiAkhir();
                    break;
                case 4:
                    cariMahasiswaByNIM(input);
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
        input.close();
    }

    // === Fungsi Menu ===
    static void tampilkanMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Tampilkan Data Mahasiswa dan Mata Kuliah");
        System.out.println("2. Tampilkan Nilai Mahasiswa (dengan detail)");
        System.out.println("3. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
        System.out.println("4. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    static void isiDataAwal() {
        Mahasiswa[] mahasiswa = {
            new Mahasiswa("22001", "Ali Rahman"),
            new Mahasiswa("22002", "Budi Santoso"),
            new Mahasiswa("22003", "Citra Dewi")
        };

        MataKuliah[] matkul = {
            new MataKuliah("MK001", "Struktur Data"),
            new MataKuliah("MK002", "Basis Data"),
            new MataKuliah("MK003", "Desain Web")
        };

        penilaian = new Penilaian[]{
            new Penilaian(mahasiswa[0], matkul[0], 80, 85, 90),
            new Penilaian(mahasiswa[0], matkul[1], 60, 75, 70),
            new Penilaian(mahasiswa[1], matkul[0], 75, 70, 80),
            new Penilaian(mahasiswa[2], matkul[1], 85, 90, 95),
            new Penilaian(mahasiswa[2], matkul[2], 80, 90, 65)
        };
    }

    static void tampilkanDataMahasiswa() {
        System.out.println("=== Data Mahasiswa dan Mata Kuliah ===");
        for (Penilaian p : penilaian) {
            System.out.println(p.getMahasiswa().getNim() + " - " + p.getMahasiswa().getNama() +
                               " | " + p.getMatkul().getKodeMK() + " - " + p.getMatkul().getNamaMK());
        }
    }

    static void tampilkanNilaiMahasiswa() {
        System.out.println("=== Nilai Mahasiswa ===");
        for (Penilaian p : penilaian) {
            p.tampilkanDetail();
        }
    }

    static void urutkanNilaiAkhir() {
        // Bubble Sort Descending
        for (int i = 0; i < penilaian.length - 1; i++) {
            for (int j = 0; j < penilaian.length - i - 1; j++) {
                if (penilaian[j].hitungNilaiAkhir() < penilaian[j + 1].hitungNilaiAkhir()) {
                    Penilaian temp = penilaian[j];
                    penilaian[j] = penilaian[j + 1];
                    penilaian[j + 1] = temp;
                }
            }
        }

        System.out.println("=== Setelah Diurutkan Berdasarkan Nilai Akhir (Tinggi ke Rendah) ===");
        tampilkanNilaiMahasiswa();
    }

    static void cariMahasiswaByNIM(Scanner input) {
        System.out.print("Masukkan NIM yang dicari: ");
        String nimCari = input.nextLine();
        boolean ditemukan = false;

        for (Penilaian p : penilaian) {
            if (p.getNIM().equalsIgnoreCase(nimCari)) {
                p.tampilkanDetail();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }
}
