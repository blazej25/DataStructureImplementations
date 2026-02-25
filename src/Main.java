import Lists.DynamicListArray;
import Lists.List;

public class Main {

    static void main() {
        List<Integer> list = new DynamicListArray<>();

        list.add(0, 4);
        list.add(0, 5);
        list.add(1, 6);
        list.set(1, 8);
        System.out.println(list);
    }
}
