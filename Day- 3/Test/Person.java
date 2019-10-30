public class Person implements Comparable<Person>{
    String name;
    int height;

    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int compareTo(Person that) {
        if (this.height > that.height) {
            return 1;
        } else if (this.height < that.height) {
            return -1;
        }
        return 0;
    }
}
