public class Group {
    static Person[] group = new Person[10];

    public static void main(String[] args) {
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(i);
        //     group[i] = new Person("person" + i, i);
        // }
        group[0] = new Person("person0", 5);
        group[1] = new Person("person1", 4);
        group[2] = new Person("person2", 1);
        group[3] = new Person("person3", 9);
        group[4] = new Person("person4", 6);
        group[5] = new Person("person5", 4);
        group[6] = new Person("person6", 7);
        group[7] = new Person("person7", 5);
        group[8] = new Person("person8", 0);
        group[9] = new Person("person9", 3);
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(group[i].name + group[i].height);
        // }

        Sort.sort(group);

        for (int i = 0; i < 10; i++) {
            System.out.println(group[i].name + " " + group[i].height);
        }
    }
}