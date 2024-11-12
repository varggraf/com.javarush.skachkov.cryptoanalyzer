import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CesarEncryption {

    String fileNameOut;

    String fileNameIn;

    int keyEncryption;


    public CesarEncryption(String fileNameIn, int keyEncryption, String fileNameOut) {

        this.fileNameIn = fileNameIn;

        this.keyEncryption = keyEncryption;

        this.fileNameOut = fileNameOut;

    }

    public void encrypt() {

        try (
                BufferedReader inputStream = Files.newBufferedReader(Paths.get(fileNameIn));

                BufferedWriter bfw = Files.newBufferedWriter(Paths.get(fileNameOut))

        ) {


            int[] arrBytes = new int[65600];

            long startTime = System.currentTimeMillis();


            while (inputStream.ready()) {

                int a = inputStream.read();


                arrBytes[a]++;

                if (Alphabet.alphabyte.indexOf((char) a) == -1) {

                    bfw.write(a);

                    continue;
                }


                bfw.write(Alphabet.alphabyte.charAt((Alphabet.alphabyte.indexOf((char) a) + keyEncryption + Alphabet.alphabyte.length()) % Alphabet.alphabyte.length()));


            }

            inputStream.close();


            long finishTime = System.currentTimeMillis();

            System.out.println("\nОперация завершена! Время работы = " + (finishTime - startTime) + "ms.");

            System.out.println("\nДля продолжения работы выберите пункт меню или нажмите 'ы' для выхода");

        } catch (IOException ex) {

        }

    }


}
