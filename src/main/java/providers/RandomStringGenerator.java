package providers;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class RandomStringGenerator {

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomEmail(int length) {
        return (RandomStringUtils.randomAlphabetic(length).toLowerCase(Locale.ROOT) + "@wp.pl");
    }
}
