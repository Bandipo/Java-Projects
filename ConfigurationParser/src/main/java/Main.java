import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {




        String key;
        ConfigParser config;





        if (args.length == 0) {

            System.out.println();
            System.out.print("Enter a key : ");
            key = scanner.nextLine().trim();
            config = new ConfigParser("/Users/decagon/Documents/ConfigurationParser/src/main/resources/config.txt");
            System.out.println();
            System.out.println(config.configKey(key));
            System.out.println();
            System.out.println(config.getConfigMap());


            System.out.println();


        } else if (args.length > 0) {

            if (args[0].equalsIgnoreCase("development")) {

                System.out.println();
                System.out.print("Enter a key : ");
                key = scanner.nextLine().trim();
                config = new ConfigParser("/Users/decagon/Documents/ConfigurationParser/src/main/resources/config.txt.dev");
                System.out.println();
                System.out.println(config.configKey(key));
                System.out.println();
                System.out.println(config.getConfigMap());


                System.out.println();

            } else if (args[0].equalsIgnoreCase("staging")) {

                System.out.println();
                System.out.print("Enter a key : ");
                config = new ConfigParser("/Users/decagon/Documents/ConfigurationParser/src/main/resources/config.txt.staging");
                System.out.println();
                System.out.println(config.configKey("application.name"));
                System.out.println();


                System.out.println();
            }


        } else {
            System.out.println("wrong entry");
        }

    }
}








