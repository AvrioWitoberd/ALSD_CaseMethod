public class Mahasiswa {
    String nim;
    String nama;
    String prodi;

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public void tampilMahasiswa() {
        System.out.printf("NIM: %s | Nama: %s | Prodi: %s\n", nim, nama, prodi);
    }
}
