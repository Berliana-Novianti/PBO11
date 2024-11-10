public class Niece implements Comparable<Niece> {
    private String name;
    private int birthDay;
    private int birthMonth;
    
    Niece(String name, int day, int month) {
        this.name = name;
        this.birthDay = day;
        this.birthMonth = month;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBirthDay() {
        return birthDay;
    }
    
    public int getBirthMonth() {
        return birthMonth;
    }
    
    public void listPresents() {
        System.out.printf("\nDaftar hadiah untuk %s:\n", name);
        // Note: Implementation would need reference to Family class to list presents
    }
    
    public int clearPresents() {
        // Note: Implementation would need reference to Family class to clear presents
        return 0;
    }
    
    @Override
    public int compareTo(Niece other) {
        if (this.birthMonth != other.birthMonth) {
            return this.birthMonth - other.birthMonth;
        }
        return this.birthDay - other.birthDay;
    }
}