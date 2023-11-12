public class Main{
    public static void main(String[] args) {

        Forest skov = new Forest();

        skov.addTree(2);
        skov.addTree(1);

        skov.growOneYear();

        System.out.println(skov);


    }
}