package data;

import com.github.javafaker.Faker;

public class AuthorizationTestsData {
    private Faker faker = new Faker();
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password();

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
