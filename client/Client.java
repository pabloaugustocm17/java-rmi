import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static Scanner SCANNER = new Scanner(System.in);

    public static Calculator getConnection() {

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);

            Remote stub = registry.lookup("Calculator");

            Calculator calculator = (Calculator) stub;

            return calculator;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao retornar servidor: " + e.getMessage());
        }

    }

    public static int[] returnTwoNumbers() {

        int[] numbers = new int[2];

        System.out.println("Digite o primeiro numero: ");
        numbers[0] = SCANNER.nextInt();
        System.out.println("Digite o segundo numero: ");
        numbers[1] = SCANNER.nextInt();

        return numbers;
    }

    public static void main(String[] args) throws RemoteException {

        Calculator calculator = getConnection();

        int i = 0;

        while (true) {

            System.out.println("Qual operacao deseja realizar: ");
            System.err.println("0 - Sair");
            System.out.println("1 - Soma");
            System.out.println("2 - Diminuir");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");

            i = SCANNER.nextInt();

            if (i == 0) {
                break;
            }

            int[] numbers = returnTwoNumbers();
            double result = 0;

            switch (i) {
                case 1:
                    result = calculator.plus(numbers[0], numbers[1]);
                    break;
                case 2:
                    result = calculator.minus(numbers[0], numbers[1]);
                    break;
                case 3:
                    result = calculator.multiply(numbers[0], numbers[1]);
                    break;
                case 4:
                    result = calculator.divide(numbers[0], numbers[1]);
                    break;
            }

            System.out.println("Resultado: " + result);

        }

    }
}
