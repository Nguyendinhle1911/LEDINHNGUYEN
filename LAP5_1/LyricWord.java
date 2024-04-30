package LAP.LAP5_1;
import java.util.*;
public class LyricWord {
    private static final String[] lyric = {"you", "say", "it", "best",
            "when", "you", "say", "nothing", "at", "all"};


    public static void main(String[] args){
        // tạo một danh sách được ArrayList triển khai


        List words = new ArrayList();
        // Thêm tất cả Chuỗi trong mảng chuỗi vào danh sách


        for (String w : lyric)
            words.add(w);
        // Duyệt qua danh sách

        for (Object o : words)
            System.out.println(o + "");
        System.out.println("\n------------");
        System.out.println("Contains [you]?:" + words.contains("you"));
        System.out.println("Contains [me]?:"+ words.contains("me"));
        System.out.println("where`s [say]?:"+words.indexOf("say"));
        System.out.println("where`s the last [say]?:" + words.lastIndexOf("say"));
        // sort words
        Collections.sort(words);

        // show all elements of words
        for (Object o :words) {
            System.out.println(o + "");
        }


    }

}
