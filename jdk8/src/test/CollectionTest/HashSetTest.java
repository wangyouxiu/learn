package test.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName HashSetTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/18 20:49
 */

public class HashSetTest {

    @Test
    public void hashSetTest() {
        ArrayList arrayList = new ArrayList<String>(){{
            add("aaa");
            add("bbb");
            add("ccc");
        }};
        Set<String> set = new HashSet<>(arrayList);

    }


    public void linkedHashSetTest() {
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("ssss");


    }

}