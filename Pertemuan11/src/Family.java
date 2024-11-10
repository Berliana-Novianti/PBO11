import java.util.*;

public class Family {
    private Map<String, Uncle> uncles;
    private Map<String, Niece> nieces;
    
    public Family() {
        uncles = new TreeMap<>();  // TreeMap untuk menjaga urutan alfabetis
        nieces = new HashMap<>();
    }
    
    public boolean addUncle(String name) {
        if (uncles.containsKey(name)) {
            return false;
        }
        uncles.put(name, new Uncle(name, this));
        return true;
    }
    
    public boolean addNiece(String name, int day, int month) {
        if (nieces.containsKey(name)) {
            return false;
        }
        nieces.put(name, new Niece(name, day, month));
        return true;
    }
    
    public Uncle findUncle(String name) {
        return uncles.get(name);
    }
    
    public Niece findNiece(String name) {
        return nieces.get(name);
    }
    
    public void listUncles() {
        System.out.println("\nDaftar Paman:");
        for (Uncle uncle : uncles.values()) {
            System.out.println("- " + uncle.getName());
        }
    }
    
    public void listNieces() {
        System.out.println("\nDaftar Keponakan (urut berdasarkan ulang tahun):");
        List<Niece> sortedNieces = new ArrayList<>(nieces.values());
        Collections.sort(sortedNieces);
        for (Niece niece : sortedNieces) {
            System.out.printf("- %s (Ulang tahun: %d/%d)\n", 
                niece.getName(), niece.getBirthDay(), niece.getBirthMonth());
        }
    }
    
    // Method untuk mengecek hadiah duplikat
    public boolean isGiftDuplicate(Uncle uncle, Niece niece, String gift) {
        // Cek apakah paman ini sudah memberikan hadiah yang sama ke keponakan lain
        for (Niece otherNiece : nieces.values()) {
            if (otherNiece != niece && uncle.getGiftForNiece(otherNiece) != null 
                && uncle.getGiftForNiece(otherNiece).equals(gift)) {
                return true;
            }
        }
        
        // Cek apakah keponakan ini sudah menerima hadiah yang sama dari paman lain
        for (Uncle otherUncle : uncles.values()) {
            if (otherUncle != uncle && otherUncle.getGiftForNiece(niece) != null 
                && otherUncle.getGiftForNiece(niece).equals(gift)) {
                return true;
            }
        }
        
        return false;
    }

    public Collection<Niece> getAllNieces() {
        return nieces.values();
    }

    public Collection<Uncle> getAllUncles() {
        return uncles.values();
    }
}