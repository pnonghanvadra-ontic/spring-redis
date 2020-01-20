package com.example.springredis;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String firstName; // required
    private String lastName; // required
    private String age;
    private String phone;

    public User(){}

    private User(UserBuilder builder) {
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User: "+"{\n\tEmail: "+this.email+"\n\t"+"FirstName: "+(this.firstName==null?"-":this.firstName)+"\n\t"+"LastName: "+(this.lastName==null?"-":this.lastName)+"\n\t"+"Age: "+(this.age==null?"-":this.age)+"\n\t"+"Phone: "+(this.phone==null?"-":this.phone)+"\n}";
    }

    public static class UserBuilder
    {
        private final String email;
        private final String firstName;
        private final String lastName;
        private String age;
        private String phone;

        public UserBuilder(String email, String firstName, String lastName) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public UserBuilder age(String age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}

