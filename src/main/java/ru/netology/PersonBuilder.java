package ru.netology;


public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String adress;

    public PersonBuilder setName(String name) {
        if (name == null) throw new IllegalArgumentException("Некоректное имя");
        else {
            this.name = name;
            return this;
        }

    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) throw new IllegalArgumentException("Некоректная фамилия");
        else {
            this.surname = surname;
            return this;
        }
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 130) throw new IllegalArgumentException("Некоректный возраст");
        else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        if (address != null) this.adress = address;
        else this.adress = null;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) throw new IllegalStateException("Недостаточно информации");
        else if (age == 0 && adress == null) return new Person(name, surname);
        else if (age != 0 && adress == null) return new Person(name, surname, age);
        else if (age == 0 && adress != null) return new Person(name, surname, adress);
        else return new Person(name, surname, age, adress);

    }
}