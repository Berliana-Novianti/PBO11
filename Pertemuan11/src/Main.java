public class Main {
    public static void main(String[] args) {
        Family family = new Family();
        
        // Menambahkan paman
        family.addUncle("Jidan");
        family.addUncle("Zaidaan");
        
        // Menambahkan keponakan
        family.addNiece("Albara", 15, 3);  // 15 Maret
        family.addNiece("Zacky", 22, 7);   // 22 Juli
        family.addNiece("Adiva", 10, 5);   // 10 Mei
        
        // Menampilkan daftar paman dan keponakan
        family.listUncles();
        family.listNieces();
        
        // Contoh menambahkan hadiah
        Uncle jidan = family.findUncle("Jidan");
        Uncle zaidaan = family.findUncle("Zaidaan");
        
        Niece albara = family.findNiece("Albara");
        Niece zacky = family.findNiece("Zacky");
        Niece adiva = family.findNiece("Adiva");
        
        // Paman Jidan memberikan hadiah
        jidan.addPresent(albara, "Buku Cerita");
        jidan.addPresent(zacky, "Mainan Robot");
        jidan.addPresent(adiva, "Boneka");
        
        // Paman Zaidaan memberikan hadiah
        zaidaan.addPresent(albara, "Sepeda");
        zaidaan.addPresent(zacky, "Playstation");
        zaidaan.addPresent(adiva, "Sepatu");
        
        // Menampilkan daftar hadiah dari setiap paman
        jidan.listPresents();
        zaidaan.listPresents();
    }
}