package io.github.sruby.javaguide.basic.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * try with resources
 *
 * @author sruby on 2020-6-26 17:01
 */
public class TryWithResources {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
