import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Map.entry;

public class Alphabet {


    public static final Path vocabulary_file = Paths.get("words.txt");


    public static final Set<String> vocabulary = new HashSet<>();

    public static final String s = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static final String a = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static final String n = "0123456789";

    public static final String p = "!№;%:?*()_+-=,.\" ";

    public static final String alphabyte = s + a + n + p;

    public static final Map<Character, Double> charFrequency =  Map.ofEntries(

            entry('а', 8.01),
            entry('б', 1.59),
            entry('в', 4.54),
            entry('г', 1.70),
            entry('д', 2.98),
            entry('е', 8.45),
            entry('ё', 0.04),
            entry('ж', 0.94),
            entry('з', 1.65),
            entry('и', 7.35),
            entry('й', 1.21),
            entry('к', 3.49),
            entry('л', 4.40),
            entry('м', 3.21),
            entry('н', 6.70),
            entry('о', 10.97),
            entry('п', 2.81),
            entry('р', 4.73),
            entry('с', 5.47),
            entry('т', 6.26),
            entry('у', 2.62),
            entry('ф', 0.26),
            entry('х', 0.97),
            entry('ц', 0.48),
            entry('ч', 1.44),
            entry('ш', 0.73),
            entry('щ', 0.36),
            entry('ъ', 0.04),
            entry('ы', 1.90),
            entry('ь', 1.74),
            entry('э', 0.32),
            entry('ю', 0.64),
            entry('я', 2.01)
    );


    public static void getVocabulary()  {

        //System.out.println("IN Alphabet");

        try (Scanner input_word = new Scanner(vocabulary_file)) {

            //System.out.println("IN Alphabet_1");

            input_word.useDelimiter("\n+"); //delimiter is one or more spaces

            while (input_word.hasNext()) {

                //System.out.println("IN Alphabet_2");

                String word = input_word.next();

                //System.out.println("IN Alphabet_3");

                //System.out.println("Add word in vocabulary:  " + word);

                vocabulary.add(word);

                //System.out.println(vocabulary.size());
            }

        }catch (IOException ex) {

            System.out.println("ERROR" + ex);

        }

    }

    public static int countWords(String word){

        int cnt = 0;

        getVocabulary();

        if(vocabulary.contains(word)){

            cnt++;

        }

        return cnt;
    }



}
