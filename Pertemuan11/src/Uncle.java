import java.util.*;

public class Uncle {
    private String name;
    private Map<Niece, String> gifts;  // Menyimpan hadiah untuk setiap keponakan
    private Family family;
    
    Uncle(String name, Family family) {
        this.name = name;
        this.family = family;
        this.gifts = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }
    
    public boolean addPresent(Niece recipient, String description) {
        if (recipient == null || description == null || description.trim().isEmpty()) {
            return false;
        }
        
        // Cek duplikasi hadiah
        if (family.isGiftDuplicate(this, recipient, description)) {
            return false;
        }
        
        gifts.put(recipient, description);
        return true;
    }
    
    public void listPresents() {
        System.out.printf("\nDaftar hadiah dari Paman %s:\n", name);
        
        // Tampilkan hadiah yang sudah dipilih
        for (Map.Entry<Niece, String> entry : gifts.entrySet()) {
            System.out.printf("- Untuk %s: %s\n", 
                entry.getKey().getName(), entry.getValue());
        }
        
        // Tampilkan keponakan yang belum dapat hadiah
        for (Niece niece : family.getAllNieces()) {
            if (!gifts.containsKey(niece)) {
                System.out.printf("- Untuk %s: (belum ada hadiah)\n", 
                    niece.getName());
            }
        }
    }
    
    public String getGiftForNiece(Niece niece) {
        return gifts.get(niece);
    }
}