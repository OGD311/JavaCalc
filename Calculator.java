import java.util.Scanner;

public class Calculator {

    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static double sqrt(double num) {
        return Math.sqrt(num);
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        String[] Options = { "+", "-", "*", "/", "^", "√", "="};

        double Total = 0;

        try {
            System.out.printf("Enter a number: ");
            double enteredNum = userInput.nextDouble();
            userInput.nextLine();

            Total = enteredNum;

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            userInput.nextLine(); 
        }

        System.out.print("\033[H\033[2J");   
        System.out.flush(); 
        
        while (true) {

            try {
                System.out.printf("Current total is: %.3f%n", Total);
                for (int i = 0; i < Options.length; i++) {
                    System.out.printf(Options[i] + ' ');
                }
                System.out.println("");

                System.out.printf("Choose an option: ");
                String selectedOption = userInput.nextLine();

                if (!selectedOption.equals("=")) {

                    System.out.printf("Enter a number: ");
                    double enteredNum = userInput.nextDouble();
                    userInput.nextLine();
                
                    switch (selectedOption) {
                        case "+":
                            Total += enteredNum;
                            break;

                        case "-":
                            Total -= enteredNum;
                            break;

                        case "*":
                            Total *= enteredNum;
                            break;

                        case "/":
                            Total /= enteredNum;
                            break;

                        case "!":
                            Total = Total + factorial((int)enteredNum);
                            break;
                        
                        case "^":
                            Total = Math.pow(Total, enteredNum);
                            break;

                        case "sqrt":
                            Total = Total + sqrt(enteredNum);

                        default:
                            System.out.println("That is not an option... \n");
                            break;
                    }
                
                }

                System.out.printf("New total is: %.3f%n", Total);
                
                System.out.println("Press enter to continue...");
                String hold = userInput.nextLine();

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                userInput.nextLine(); 

            }

            System.out.print("\033[H\033[2J");   
            System.out.flush();   

        }

        // userInput.close();

    }

}
