public class Penilaian {
    private Mahasiswa mahasiswa;
    private MataKuliah matkul;
    private int nilaiTugas;
    private int nilaiUTS;
    private int nilaiUAS;

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

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public MataKuliah getMatkul() {
        return matkul;
    }

    public void tampilkanRingkas() {
        System.out.printf("%s | %s | Nilai Akhir: %.2f\n",
                mahasiswa.getNama(),
                matkul.getNamaMK(),
                hitungNilaiAkhir());
    }
}
