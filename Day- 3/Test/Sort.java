public class Sort {
    public static void sort(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            int min = i;
            for (int j = i; j < group.length; j++) {
                if (group[min].height - (group[j].height) > 0) {
                    min = j;
                }
            }
            swap(group, i, min);
        }
    }

    public static void  swap(Person[] group, int index, int min) {
        System.out.println(index + " " + min);
        Person temp = group[index];
        group[index] = group[min];
        group[min] = temp;
    }
}