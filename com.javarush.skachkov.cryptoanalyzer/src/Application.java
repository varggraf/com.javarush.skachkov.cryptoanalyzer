import java.util.*;

import static java.lang.System.exit;

public class Application {

    static Scanner console = new Scanner(System.in);

    static boolean app = true;

    public static void main(String[] args) {


        drawMenu();

        while (app) {

            switch (console.nextLine()) {

                case "ш":
                    doEncrypt();
                    break;

                case "д":
                    doDecoding();
                    break;

                case "в":

                    doBrutForce();
                    break;

                case "а":
                    doStatisticalAnalyze();
                    break;

                case "ы":
                    console.close();
                    exit(0);

                default:
                    System.out.println("Выберите корректный пункт меню!");

            }
        }

    }

    private static void doDecoding() {

        System.out.println("Введите путь расположения и имя файла для расшифровки: ");

        String fileNmeIn = Validator.getPathFrom(console.nextLine());

        System.out.println("Введите ключ для расшифровки(целое положительное не болбшее" + (Alphabet.alphabyte.length() - 1) + ") : ");

        int key = Validator.getKey(console.nextLine());

        System.out.println("Введите путь и имя для сохранения расшифрованного файла: ");

        String fileNmeOut = Validator.getPathTo(console.nextLine());

        CesarEncryption cesarEncryption = new CesarEncryption(fileNmeIn, -key, fileNmeOut);

        cesarEncryption.encrypt();
    }


    private static void doEncrypt() {

        System.out.println("Введите путь и имя файла для шифрования: ");

        String fileNmeIn = Validator.getPathFrom(console.nextLine());

        System.out.println("Введите ключ шифрования (от 1 до " +  (Alphabet.alphabyte.length() - 1) + "): ");

        int key = Validator.getKey(console.nextLine());

        System.out.println("Введите путь и имя для зашифрованного файла: ");

        String fileNameOut = Validator.getPathTo(console.nextLine());

        CesarEncryption cesarEncryption = new CesarEncryption(fileNmeIn, key, fileNameOut);

        cesarEncryption.encrypt();

    }

    private static void doStatisticalAnalyze() {

        System.out.println("Введите путь расположения и имя файла для SA: ");

        String fileNameIn = Validator.getPathFrom(console.nextLine());

        System.out.println("Введите путь расположения и имя для расшифрованного файла: ");

        String fileNameOut = Validator.getPathTo(console.nextLine());

        StaticalAnalyze staticalAnalyze = new StaticalAnalyze(fileNameIn, fileNameOut);

        staticalAnalyze.decode();

    }

    private static void doBrutForce() {

        System.out.println("Введите путь расположения и имя файла для BF: ");

        String fileNameIn = Validator.getPathFrom(console.nextLine());

        System.out.println("Введите путь расположения и маску имени варианта расшифровки файла: ");

        String fileNameOut = console.nextLine();

        BrutForce bf = new BrutForce(fileNameIn, fileNameOut);

        bf.decode();

    }

    private static void drawMenu() {

        System.out.println("*".repeat(40));

        System.out.println("Шифрование с помощью алгоритма Цезаря");

        System.out.println("*".repeat(40));

        System.out.println("-------------МЕНЮ-------------");

        System.out.println("ш - шифрование");

        System.out.println("д - Расшифровка с ключом");

        System.out.println("в - Brut force");

        System.out.println("а - Статистический анализ");

        System.out.println("ы - выход");
    }
}
