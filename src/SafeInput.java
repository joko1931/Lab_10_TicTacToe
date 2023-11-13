import java.util.Scanner;
public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner scanner2,String prompt)
    {
        int value = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt + ": ");
            if (scanner2.hasNextInt()) {
                value = scanner2.nextInt();
                validInput = true;
            }
            else
            {
                System.out.println("Invalid input. Please make sure to enter an integer");
                scanner2.nextLine();
            }
        }
        while (!validInput) ;
        scanner2.nextLine();
        return value;
    }
    public static double getDouble(Scanner scanner,String prompt)
    {
        double value2 = 0.0;
        boolean validInput2 = false;
        do {
            System.out.print(prompt + ": ");
            if (scanner.hasNextDouble())
            {
                value2 = scanner.nextDouble();
                validInput2 = true;
            }
            else
            {
                System.out.println("Invalid input. Please make sure to enter a Double");
                scanner.nextLine();
            }
        }
        while (!validInput2) ;
        scanner.nextLine();
        return value2;
    }

    public static int getRangedInt(Scanner scanner, String prompt, int low, int high)
    {
        int value3 = 0;
        boolean validInput3 = false;

        do {
            System.out.print(prompt + ": ");

            if (scanner.hasNextInt())
            {
                value3 = scanner.nextInt();
                if (value3 >= low && value3 <= high)
                {
                    validInput3= true;
                }
                else
                {
                    System.out.println("Invalid input. Please make sure tp enter an integer within the specified range " + low + " to " + high + ".");
                }
            }
            else
            {
                System.out.println("Invalid input. Please make sure to enter an integer.");
                scanner.nextLine();
            }
        } while (!validInput3);

        scanner.nextLine();
        return value3;
    }
    public static double getRangedDouble(Scanner scanner, String prompt, double low, double high)
    {
        double value = 0.0;
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (scanner.hasNextDouble())
            {
                value = scanner.nextDouble();
                if (value >= low && value <= high)
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("Invalid input. Please make sure to enter a double within the range " + low + " - " + high + ".");
                }
            }
            else
            {
                System.out.println("Invalid input. Please make sure to enter a double.");
                scanner.nextLine();
            }
        } while (!validInput);

        scanner.nextLine();

        return value;
    }
    public static boolean getYesNoInput(Scanner scanner, String prompt)
    {
        boolean validInput = false;
        boolean result = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Y") || input.equals("N"))
            {
                result = input.equals("Y");
                validInput = true;
            }
            else
            {
                System.out.println("Invalid input. Please make sure to enter either 'Y' or 'N'.");
            }
        } while (!validInput);

        return result;
    }
    public static String getRegExString(Scanner scanner, String prompt, String regexPattern)
    {
        String input = "";

        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt + ": ");

            if (scanner.hasNextLine())
            {
                input = scanner.nextLine();
                if (input.matches(regexPattern))
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("Invalid input. Please make sure to enter a string that matches the specified pattern.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please make sure to enter a valid string.");
                scanner.next();
            }
        }

        return input;
    }
    public static void prettyHeader(String msg)
    {
        int totalWidth = 60;
        int messageWidth = msg.length();
        int paddingWidth = (totalWidth - messageWidth - 6) / 2;


        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();


        System.out.print("***");
        for (int i = 0; i < paddingWidth; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < paddingWidth; i++)
        {
            System.out.print(" ");
        }
        System.out.println("***");


        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}