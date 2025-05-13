package com.zeynalovv.Resource;

import java.util.Objects;

public class Data {
    private final String name, surname;
    private final int birthYear;

    public Data(String name, String surname, int birthYear){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Data(Data data){
        this.name = data.getName();
        this.birthYear = data.getBirthYear();
        this.surname = data.getSurname();
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return birthYear == data.birthYear && Objects.equals(name, data.name) && Objects.equals(surname, data.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthYear);
    }
}
