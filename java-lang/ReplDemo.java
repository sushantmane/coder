import java.util.Scanner;

public class ReplDemo {

    public static String getUsageStr() {
            //String str = "\n***********************************************************************\n"
            //    + "Replicated hashtable service client is starting in interactive mode\n"
            //    + "Usage: get key | inc key value | del key | quit\n"
             //   + "***********************************************************************\n";
             String str = "\n+-------------------------------------------------+\n"
                + "| Interactive Replicated Hashtable Service Client |\n"
                + "| Usage: get key | inc key value | del key | quit |\n"
                + "+-------------------------------------------------+\n";
              str = "+-------------------------------------------------+\n"
                + "|       Replicated Hashtable Service Client       |\n"
                + "| Usage: get key | inc key value | del key | quit |\n"
                + "+-------------------------------------------------+\n";
        return str;
    }

    private static void checkNumArgs(int length, int argc) {
        if (length < argc) {
            System.err.println("Missing arguments");
        }
    }

    private static void repl() {
        System.out.println(getUsageStr());
        Scanner scanner = new Scanner(System.in);
        String line;

        do {
            System.out.print("cli>>> ");
            line = scanner.nextLine();
            if (line.trim().length() == 0) {
                continue;
            }

            String input[] = line.split(" ");
            String op = input[0];
            switch (op) {
                case "get":
                    checkNumArgs(input.length, 2);
                    ;
                    break;
                case "inc":
                    checkNumArgs(input.length, 3);
                    //op
                    break;
                case "del":
                    checkNumArgs(input.length, 2);
                    //op
                    break;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("Operation not supported");
            }
        } while (true);
    }

    public static void main(String[] args) {
        repl();
    }
}

