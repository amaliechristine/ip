import java.util.ArrayList;

public class Forest {
    private ArrayList<Tree> trees;

    public Forest() {
        trees = new ArrayList<Tree>();
    }

    public void addTree(int growthRate) {
        trees.add(new Tree(growthRate));
    }

    public String toString() {
        String forestlist = "Forest(";
        for (Tree tree : trees){
            forestlist = forestlist + tree.toString();
        }
        forestlist = forestlist + ")";
        return forestlist;
    }

    public void growOneYear() {
        for (Tree tree : trees) {
            tree.growOneYear();
        }
    }
}
