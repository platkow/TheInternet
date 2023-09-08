package models;

public class User {

    private String customerFirstName;
    private String customerLastName;
    private String password;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String company;
    private String address;
    private String city;
    private int state;
    private int postalCode;
    private String country;
    private int mobilePhone;
    private String addressAlias;


    public User(String customerFirstName, String customerLastName, String password, int dayOfBirth, int monthOfBirth,
                int yearOfBirth, String company, String address, String city, int state, int postalCode,
                String country, int mobilePhone, String addressAlias) {

        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getPassword() {
        return password;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getState() {
        return state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public static final class Builder {
        private String customerFirstName;
        private String customerLastName;
        private String password;
        private int dayOfBirth;
        private int monthOfBirth;
        private int yearOfBirth;
        private String company;
        private String address;
        private String city;
        private int state;
        private int postalCode;
        private String country;
        private int mobilePhone;
        private String addressAlias;

        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder dayOfBirth(int dayOfBirth) {
            this.dayOfBirth = dayOfBirth;
            return this;
        }

        public Builder monthOfBirth(int monthOfBirth) {
            this.monthOfBirth = monthOfBirth;
            return this;
        }

        public Builder yearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(int state) {
            this.state = state;
            return this;
        }

        public Builder postalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder mobilePhone(int mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder addressAlias(String addressAlias) {
            this.addressAlias = addressAlias;
            return this;
        }

        public User build() {
            if (customerFirstName.isEmpty()) {
                throw new IllegalStateException("Customer first name cannot be empty.");
            }

            if (customerLastName.isEmpty()) {
                throw new IllegalStateException("Customer last name cannot be empty.");
            }

            if (password.isEmpty()) {
                throw new IllegalStateException("Password cannot be empty.");
            }

            if (address.isEmpty()) {
                throw new IllegalStateException("Address cannot be empty.");
            }

            if (city.isEmpty()) {
                throw new IllegalStateException("City cannot be empty.");
            }

            if (String.valueOf(state).isEmpty()) {
                throw new IllegalStateException("State cannot be empty.");
            }

            if (String.valueOf(postalCode).isEmpty()) {
                throw new IllegalStateException("Zip/postal code cannot be empty.");
            }

            if (country.isEmpty()) {
                throw new IllegalStateException("Country cannot be empty.");
            }

            if (String.valueOf(mobilePhone).isEmpty()) {
                throw new IllegalStateException("Mobile phone cannot be empty.");
            }

            if (addressAlias.isEmpty()) {
                throw new IllegalStateException("Address alias cannot be empty.");
            }

            return new User(customerFirstName, customerLastName, password, dayOfBirth, monthOfBirth, yearOfBirth, company, address,
                    city, state, postalCode, country, mobilePhone, addressAlias);
        }
    }
}
