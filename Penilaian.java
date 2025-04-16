public class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah matkul;
    int nilaiTugas;
    int nilaiUTS;
    int nilaiUAS;

    public Penilaian(Mahasiswa mahasiswa, MataKuliah matkul, int nilaiTugas, int nilaiUTS, int nilaiUAS) {
        this.mahasiswa = mahasiswa;
        this.matkul = matkul;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    public double hitungNilaiAkhir() {
        return (0.3 * nilaiTugas) + (0.3 * nilaiUTS) + (0.4 * nilaiUAS);
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public MataKuliah getMatkul() {
        return matkul;
    }

    public String getNIM() {
        return mahasiswa.getNim();
    }

    public void tampilkanDetail() {
        System.out.println("NIM\t\t: " + mahasiswa.getNim());
        System.out.println("Nama\t\t: " + mahasiswa.getNama());
        System.out.println("Mata Kuliah\t: " + matkul.getNamaMK());
        System.out.println("Tugas\t\t: " + nilaiTugas);
        System.out.println("UTS\t\t: " + nilaiUTS);
        System.out.println("UAS\t\t: " + nilaiUAS);
        System.out.printf("Nilai Akhir\t: %.2f\n", hitungNilaiAkhir());
        System.out.println("---------------------------");
    }
}
