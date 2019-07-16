package org.plaintech.coding;
import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);

            List<String> xs = map.get(str);
            if (null == xs) {
                xs = new ArrayList<String>();
                map.put(str, xs);
            }
            xs.add(strs[i]);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
