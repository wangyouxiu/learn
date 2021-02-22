package test.CollectionTest;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName HashMapTest
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/1/18 22:03
 */

public class HashMapTest {

    @Test
    public void hashMapTest() {
        HashMap<String, String> hashMap = new HashMap<>();
        int i = 17;
        while (i >= 0) {
            hashMap.put("" + i, "value" + i);
            i--;
        }
    }

    @Test
    public void hashMapTest1() {
        HashMap<String, String> hashMap = new HashMap<>();
        int i = 17;
        while (i >= 0) {
            hashMap.put("aaaa" + i, "value" + i);
            i--;
        }
    }

    @Test
    public void hashMapTest2() {
        HashMap<String, String> hashMap = new HashMap<>();
        int i = 17;
        while (i >= 0) {
            hashMap.put("aaaa" + i, "value" + i);
            i--;
        }

        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.putAll(hashMap);

    }


}