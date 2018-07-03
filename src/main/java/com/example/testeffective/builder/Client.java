
package com.example.testeffective.builder;

public class Client {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("Lyndon", "ShangHai", "1")
                .isEmployed(true).isFemale(true).isHomeOwner(false).suffix("Hello").createPerson();
        System.out.println(person.toString());
    }
}
