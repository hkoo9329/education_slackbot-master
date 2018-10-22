package ac.knu.service;

import lombok.Data;

@Data
public class Friends {
    public enum Sex {
        남("M"),
        여("W");

        private String sex;

        Sex(String sex) {
            this.sex = sex;
        }
    }
    private String name;
    private int age;
    private Sex sex;

    public Friends (String name, int age, Sex sex){
        this.name = name;
        this.age =age;
        this.sex = sex;
    }

    public String toString(){
        return name + "\t"+ String.valueOf(age) +"\t"+ sex;
    }
}
