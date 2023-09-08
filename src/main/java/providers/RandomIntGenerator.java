package providers;

import java.util.Random;

public class RandomIntGenerator {
    Random rnd = new Random();

    public int generateRandomIntBound(int min, int max) {
        return rnd.nextInt(max - min) + min;
    }

    public int generateRandomIndex(int bound) {
        return rnd.nextInt(bound);
    }

    public int generatePostalCode() {
        return 10000 + rnd.nextInt(90000);
    }

    public int generateMobilePhoneNumber() {
        return 100000000 + rnd.nextInt(900000000);
    }

    public String getRandomSize() {
        RandomIntGenerator rndInt = new RandomIntGenerator();
        int index = rndInt.generateRandomIntBound(1, 4);
        String size = " ";

        switch (index) {
            case 1:
                size = "S";
                break;
            case 2:
                size = "M";
                break;
            case 3:
                size = "L";
                break;
            default:
                System.out.println("Chosen size is not available.");
        }
        return size;
    }
}
