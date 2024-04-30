package LAP.LAP5_1;
import java.util.*;

public class LyricSet {
    private static final String[] lyric = {"you", "say", "it", "best",
            "when", "you", "say", "nothing", "at", "all"};

    public static void main(String[] args) {

        // Tạo một tập hợp từ HashSet đã triển khai Set
        Set words = new HashSet();


        // Thêm tất cả các từ cần đặt
        for (String w : lyric)
            words.add(w);

        // Traverse the list
        // NOTICE: set doesn't allow duplicate items
        for (Object o : words)
            System.out.println(o + "");
        System.out.println("\n------------------");

        System.out.println("Contains [you]?:" + words.contains("you"));
        System.out.println("Contains [me]?:" + words.contains("me"));
              }

    }
