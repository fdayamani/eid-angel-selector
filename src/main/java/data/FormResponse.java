package data;

import java.util.Objects;

public class FormResponse {
    private final String name;
    private final String age;
    private final String mothersMobile;
    private final String tookPartLastYear;

    public FormResponse(String name, String age, String mothersMobile, String tookPartLastYear) {
        this.name = name;
        this.age = age != null ? age : "Not set";
        this.mothersMobile = mothersMobile;
        this.tookPartLastYear = tookPartLastYear;
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
                ", tookPartLastYear=" + tookPartLastYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormResponse formResponse = (FormResponse) o;
        return Objects.equals(name, formResponse.name) &&
                Objects.equals(age, formResponse.age) &&
                Objects.equals(mothersMobile, formResponse.mothersMobile) &&
                Objects.equals(tookPartLastYear, formResponse.tookPartLastYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, mothersMobile, tookPartLastYear);
    }

    public String getAge() {
        return this.age;
    }

    public String getMothersMobile() {
        return this.mothersMobile;
    }
}
