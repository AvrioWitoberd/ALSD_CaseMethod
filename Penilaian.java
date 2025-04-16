public class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilaiTugas;
    double nilaiUTS;
    double nilaiUAS;
    double nilaiAkhir;

    public Penilaian(Mahasiswa mahasiswa, MataKuliah mataKuliah, double tugas, double uts, double uas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
        hitungNilaiAkhir();
    }

    public void hitungNilaiAkhir() {
        this.nilaiAkhir = (nilaiTugas * 0.3) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4);
    }

    public void tampilkanRingkas() {
        System.out.printf("%s | %s | Nilai Akhir: %.1   xf\n",
                mahasiswa.nama, mataKuliah.namaMK, nilaiAkhir);
    }
}
