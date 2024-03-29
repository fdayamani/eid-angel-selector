package domain;

import data.Angel;

import java.util.Objects;
import java.util.Optional;

public class Child {
    private final String name;

    private final String age;
    private final String mothersMobile;
    private final Optional<Angel> lastYearsAngel;
    public Child(String name, String age, String mothersMobile, Optional<Angel> lastYearsAngel) {
        this.name = name;
        this.age = age != null ? age : "Not set";
        this.mothersMobile = mothersMobile;
        this.lastYearsAngel = lastYearsAngel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", mothersMobile='" + mothersMobile + '\'' +
                ", lastYearsAngel=" + lastYearsAngel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(name, child.name) &&
                Objects.equals(age, child.age) &&
                Objects.equals(mothersMobile, child.mothersMobile) &&
                Objects.equals(lastYearsAngel, child.lastYearsAngel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, mothersMobile, lastYearsAngel);
    }

    public String getAge() {
        return age;
    }

    public String getMothersMobile() {
        return mothersMobile;
    }

    public boolean isSiblingOf(Child child) {
        return child.mothersMobile.equals(this.mothersMobile);
    }

    public boolean wasLastYearsAngelFor(Child child) {
        if (child.lastYearsAngel.isPresent()) {
            Angel angel = child.lastYearsAngel.get();
            return Objects.equals(angel.name, this.name) &&
                    Objects.equals(angel.mobile, this.mothersMobile);
        }
        return false;
    }
}
