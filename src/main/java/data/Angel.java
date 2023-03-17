package data;

import java.util.Objects;

public class Angel {
    public final String name;
    public final String mobile;

    public Angel(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angel angel = (Angel) o;
        return Objects.equals(name, angel.name) &&
                Objects.equals(mobile, angel.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobile);
    }
}
