package providers;

import models.User;

public class UserFactory {

    public User getRandomUser() {
        RandomStringGenerator rndString = new RandomStringGenerator();
        RandomIntGenerator rndInt = new RandomIntGenerator();

        return new User.Builder()
                .customerFirstName(rndString.generateRandomString(5))
                .customerLastName(rndString.generateRandomString(7))
                .password(rndString.generateRandomString(8))
                .dayOfBirth(rndInt.generateRandomIntBound(1, 29))
                .monthOfBirth(rndInt.generateRandomIntBound(1, 13))
                .yearOfBirth(rndInt.generateRandomIntBound(1950, 2010))
                .company(rndString.generateRandomString(4))
                .address(rndString.generateRandomString(6) + " " + rndInt.generateRandomIntBound(1, 10))
                .city(rndString.generateRandomString(5))
                .state(rndInt.generateRandomIntBound(1, 54))
                .postalCode(rndInt.generatePostalCode())
                .country("United States")
                .mobilePhone(rndInt.generateMobilePhoneNumber())
                .addressAlias(rndString.generateRandomString(5))
                .build();
    }
}
