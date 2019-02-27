package com.example.demo.domain;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMultiset;

public class Teacher {
    String name;
    String gender;
    int age;
    String skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("gender", gender)
                .add("age", age)
                .add("skill", skill)
                .omitNullValues().toString();
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setAge(22);
        teacher.setName("张三");

        ImmutableMultiset immutableMultiset = ImmutableMultiset.of("11", " 22", "33");
        System.out.println(teacher);
    }
}
