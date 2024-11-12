import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StaticalAnalyze {

    String fileNameOut;

    String fileNameIn;

    Path[] files = new Path[Alphabet.alphabyte.length()];

    public StaticalAnalyze(String fileNameIn, String fileNameOut) {

        this.fileNameIn = fileNameIn;

        this.fileNameOut = fileNameOut;

    }

    public void decode() {

        char c;

        List<Character> chars = new ArrayList<>();

        HashMap<Character, Double> freqOfchar = new HashMap<>();

        try (
                BufferedReader inputStream = Files.newBufferedReader(Paths.get(fileNameIn));

                BufferedWriter bfw = Files.newBufferedWriter(Paths.get(fileNameOut))

        ) {


            //int[] arrBytes = new int[65600];

            long startTime = System.currentTimeMillis();


            while (inputStream.ready()) {

                int a = inputStream.read();

                //arrBytes[a]++;

                c = (char) a;

                chars.add(Character.toLowerCase(c));

            }

            inputStream.close();

            int sumOfchar = 0;

            for (Character aChar : chars) {

                if (Character.isLetter(aChar)) {

                    if (!freqOfchar.containsKey(aChar))

                        sumOfchar += Integer.valueOf(Collections.frequency(chars, aChar));

                    freqOfchar.put(aChar, Double.valueOf(Collections.frequency(chars, aChar)));

                }

            }

            TreeMap<Character, Double> sortedMap = new TreeMap<>(freqOfchar);

            for (
                    Map.Entry entry : sortedMap.entrySet()) {

                System.out.println("Symbol " + "\' " + entry.getKey() + " \'" + " frequency = " + ((double) entry.getValue() / sumOfchar) * 100 + " %");

                char c_cast = (char) entry.getKey();

                freqOfchar.put(c_cast, (((double) entry.getValue() / sumOfchar) * 100));

            }


            System.out.println("Freq:  " + freqOfchar.size() + "  " + Alphabet.charFrequency.size());


            //double min = 0.0;


            for (
                    Map.Entry entry : freqOfchar.entrySet()) {

                System.out.println("Symbol " + "\' " + entry.getKey() + " \'" +
                        " frequency_text = " + entry.getValue() +
                        "  freq_voc " + Alphabet.charFrequency.get(entry.getKey()) + "  diff: " + (Double.valueOf((double) entry.getValue()) - Alphabet.charFrequency.get(entry.getKey())));


                if (Math.floor((double)entry.getValue()) == 18) {

                    System.out.println("Symbol: " + entry.getKey());

                    new CesarEncryption(fileNameIn, -(Alphabet.alphabyte.indexOf((char) entry.getKey()) - 32), fileNameOut).encrypt();

                    break;
                }

            }

            /*List<Double> maxOffreqCharOfText = (new ArrayList<>(freqOfchar.values()));

            List<Double> maxOffreqCharOfVocab = (new ArrayList<>(Alphabet.charFrequency.values()));


            System.out.println(Collections.max(maxOffreqCharOfText) + "  " + "   " + Collections.max(maxOffreqCharOfVocab) + "  " + Collections.min(maxOffreqCharOfText) + "   " + Collections.min(maxOffreqCharOfVocab));
*/

            long finishTime = System.currentTimeMillis();

            System.out.println("\nОперация завершена! Время работы = " + (finishTime - startTime) + "ms.");

            System.out.println("\nДля продолжения работы выберите пункт меню или нажмите 'ы' для выхода");

        } catch (IOException ex) {

        }


    }
}
