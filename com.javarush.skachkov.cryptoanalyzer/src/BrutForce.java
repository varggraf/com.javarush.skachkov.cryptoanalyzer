import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrutForce {

    String fileNameOut;

    String fileNameIn;

    Path[] files = new Path[Alphabet.alphabyte.length()];

    public BrutForce(String fileNameIn, String fileNameOut) {

        this.fileNameIn = fileNameIn;

        this.fileNameOut = fileNameOut;
    }

    public void decode() {

        Set<String> words = new HashSet<>();

        for (int i = 0; i < Alphabet.alphabyte.length(); i++) {

            files[i] = Paths.get(fileNameOut + "_" + i);

            (new CesarEncryption(fileNameIn, -i + 1, fileNameOut + "_" + i)).encrypt();

        }

        for (int i = 0; i < files.length; i++) {

            try (Scanner input = new Scanner(files[i])) {

                input.useDelimiter(" +"); //delimitor is one or more spaces

                while (input.hasNext()) {

                    String word = input.next();

                    words.add(word);

                }

                Alphabet.getVocabulary();

                if (!Collections.disjoint(words, Alphabet.vocabulary)) {

                    System.out.println("Найдены совпадения в файле: " + files[i]);

                    break;
                }

            } catch (IOException ex) {

            }

        }

        System.out.println("BF закончен!");
    }
}
