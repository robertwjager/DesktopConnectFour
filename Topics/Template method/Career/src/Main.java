import java.util.Scanner;

abstract class Career {

    public void execute() {
        dream();
        plan();
        study();
        work();
    }

    public abstract void work();

    // Common methods
    public void dream() {
        System.out.println("Dream big!");
    }

    public void plan() {
        System.out.println("Draw a plan!");
    }

    public void study() {
        System.out.println("Study!");
    }
}

class Engineer extends Career {

    @Override
    public void work() {
        System.out.println("Work as a Full Stack Engineer");
    }
}

class DataScientist extends Career {

    @Override
    public void work() {
        System.out.println("Work as a Data Scientist");
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine().toLowerCase();
        scanner.close();
        Career career = null;

        if ("engineer".equals(type)) {
            career = new Engineer();
        } else if ("scientist".equals(type)) {
            career = new DataScientist();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }

        // Execute the career plan
        career.execute();
    }
}
