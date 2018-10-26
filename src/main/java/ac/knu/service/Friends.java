package ac.knu.service;

import lombok.Data;

@Data
public class Friends {

    private String name;
    private int age;
    private Gender gender;

    public Friends(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return name + "\t" + String.valueOf(age) + "\t" + gender;
    }
}
