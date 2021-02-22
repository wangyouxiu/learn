package test.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName LinkedListTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/18 16:28
 */

public class LinkedListTest {

    @Test
    public void test() {
        ArrayList arrayList = new ArrayList<String>(){{
            add("aaa");
            add("bbb");
            add("ccc");
        }};
        LinkedList<String> strings = new LinkedList<>(arrayList);
        strings.addAll(1, arrayList);
    }

}