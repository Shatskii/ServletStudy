import java.util.Objects;

public class User {
    private String name;
    private int age;
    private int id;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id == user.id && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return "Name : " + name + "\n" +
                "Age : " + age + "\n";

    }
}
