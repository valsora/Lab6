import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        boolean isCaseImportant = false;
        Scanner scan;
        try {
            scan = new Scanner(new File("./ex1.txt"));
            HashMap<String, Integer> map = new HashMap<>();
            while (scan.hasNext()) {
                String word = scan.next();
                if (word.equals("-")) continue;
                char lastChar = word.charAt(word.length() - 1);
                if (lastChar == ',' || lastChar == '.' || lastChar == '!' || lastChar == '?' || lastChar == ':') word = word.substring(0, word.length() - 1);
                if (word.equals("")) continue;
                if (!isCaseImportant) word = word.toLowerCase();
                if (map.containsKey(word)) map.replace(word, map.get(word) + 1);
                else map.put(word, 1);
            }
            scan.close();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            for (int i = 0; i < Math.min(10, list.size()); i++) {
                System.out.println(list.get(i).getKey() + " (" + list.get(i).getValue() + ")");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
