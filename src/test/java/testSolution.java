import java.util.*;
import java.util.stream.Collectors;

/**
 * ************************************************************************************
 * *
 * <p>
 * Project:PACKAGE_NAME
 * ClassName: testSolution
 * Description: test Method
 * Author: Zhao Wenqing
 * Date: 2024/1/31 10:26
 *************************************************************************************/
public class testSolution {

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        StringBuilder sd = new StringBuilder();

        for (Character c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        for (Character c : order.toCharArray()) {
            if (mp.containsKey(c)) {
                int count = mp.get(c);
                while (count > 0) {
                    sd.append(c);
                    count--;
                }
                mp.remove(c);
            }
        }

        for (Character c : mp.keySet()) {
            int count = mp.get(c);
            while (count > 0) {
                sd.append(c);
                count--;
            }
        }
        System.out.printf("left : ====> %s\n", sd);
        return sd.toString();
    }

    public String mySubstring(Integer[] arr, String s) {
        if (arr.length == 0 || arr[0] == null)
            return "";
        int max = 0, min = arr[0];
        for (Integer integer : arr) {
            if ((integer != null) && integer > max)
                max = integer;
            if ((integer != null) && integer < min)
                min = integer;

        }
        return s.substring(min, max + 1);
    }

}
