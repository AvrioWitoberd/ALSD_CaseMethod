public class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah matkul;
    int nilaiTugas;
    int nilaiUTS;
    int nilaiUAS;

    public Penilaian(Mahasiswa mahasiswa, MataKuliah matkul, int tugas, int uts, int uas) {
        this.mahasiswa = mahasiswa;
        this.matkul = matkul;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
    }

    public double hitungNilaiAkhir() {
        return 0.3 * nilaiTugas + 0.3 * nilaiUTS + 0.4 * nilaiUAS;
    }

    public void tampilkanRingkas() {
        System.out.printf("%s | %s | Nilai Akhir: %.2f\n",
                mahasiswa.nama,
                matkul.namaMK,
                hitungNilaiAkhir());
    }
}
