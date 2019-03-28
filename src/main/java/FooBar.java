import java.util.ArrayList;
import java.util.List;

public class FooBar {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        System.out.println(list.stream().mapToInt(i -> i).sum());
        foo(null);
    }

    static void  foo(int[] nums) {}
}
