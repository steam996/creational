package ru.netology;

import java.util.OptionalInt;

public class Person {
    protected final String NAME;
    protected final String SURNAME;
    protected int age;
    protected String address;

    public Person(String NAME, String SURNAME, int age, String address) {
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname, String address) {
        this.NAME = name;
        this.SURNAME = surname;
        this.address = address;
    }

    public Person(String name, String surname) {
        this.NAME = name;
        this.SURNAME = surname;
    }

    public Person(String name, String SURNAME, int age) {
        this.NAME = name;
        this.SURNAME = SURNAME;
        this.age = age;
    }

    public boolean hasAge() {
        if (age == 0) return false;
        else return true;
    }

    public boolean hasAddress() {
        if (address == null) return false;
        else return true;
    }

    public String getName() {
        return NAME;
    }

    public String getSurname() {
        return SURNAME;
    }

    public OptionalInt getAge() {
        if (hasAge()) return OptionalInt.of(age);
        else return null;
    }

    public String getAddress() {
        if (hasAddress()) return address;
        else return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    @Override
    public String toString() {
        if (hasAddress() && hasAge()) return ("Имя - " + getName() + ", "
                + "Фамилия - " + getSurname() + ", " + "Возраст - " + getAge().getAsInt() + ", "
                + "Проживает по адресу - " + getAddress());
        else if (hasAge() && !hasAddress()) return ("Имя - " + getName() + ", "
                + "Фамилия - " + getSurname() + ", " + "Возраст - " + getAge().getAsInt());
        else if (!hasAge() && !hasAge()) return ("Имя - " + getName() + ", "
                + "Фамилия - " + getSurname() + ", " +
                "Проживает по адресу - " + getAddress());
        else return ("Имя - " + getName() + ", " + "Фамилия - " + getSurname());
    }

    @Override
    public int hashCode() {
        return Person.class.hashCode();
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(SURNAME).setAge(age).setAddress(address);
    }

}

