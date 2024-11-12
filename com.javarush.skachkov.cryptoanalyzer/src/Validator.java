import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Validator {

    static Scanner console = new Scanner(System.in);

    //Path validator
    static String getPathFrom(String file) {

        while (!(Files.isRegularFile(Path.of(file)) && FileManager.notEmptyFile(file))) {

            System.out.println("Некорректное имя файла или файл пуст. Введите корректный файл!");

            file = console.nextLine();

        }

        return file;
    }

    static String getPathTo(String file) {

        boolean app = true;

        while (app) {

            try {

                if (!(Files.isDirectory(Paths.get(file).getParent()) && file.endsWith(".txt"))) {


                    System.out.println("Некорректный путь или имя файла. Введите заново");

                    file = console.nextLine();

                }else{

                    app = false;
                }

            } catch (NullPointerException | InvalidPathException ex) {

                System.out.println("Проверьте правильность пути!");

                file = console.nextLine();
            }

        }

        return file;

    }


    //Key validator
    static int getKey(String str) {

        boolean app = true;

        int key = 0;

        while (app) {

            try {

                key = Integer.parseInt(str);

                app = false;

            } catch (InputMismatchException | NumberFormatException ex) {

                System.out.println("Введено некорректное значение ключа! Попробуйте еще раз");

                str = console.nextLine();

                app = true;

            }

        }

        return key;
    }

}
