public class Tree {
    private int age;
    private double height;
    private double growthRate;


    public Tree(double growthRate) {
        height = 0.12;
        age = 1;
        this.growthRate = growthRate;    
    }

    public String toString() {
        return "Tree(age = " + age + ", height = " + height + ")";
    }

    public void growOneYear() {
        age++;
        height = height * (1 + growthRate / 100);
        if (height > 14) {
            height = 14;
        }
    }


}