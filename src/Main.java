
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String initialCurrency;
        String targetCurrency;
        double mount;
        double convertedMount;
        Currency currency = new Currency("USD", "USD", 0, 0);

        Scanner reader = new Scanner(System.in);
        ApiConsultor consulta = new ApiConsultor();

        System.out.println("Bienvenido al conversor de divisas.\nEstas son las divisas disponibles:\n" +
                "1) Dólar           ==> Peso Argentino\n" +
                "2) Peso Argentino  ==> Dólar\n" +
                "3) Dólar           ==> Real Brasileño\n" +
                "4) Real Brasileño  ==> Dólar\n" +
                "5) Dólar           ==> Peso Colombiano\n" +
                "6) Peso Colombiano ==> Dólar\n" +
                "7) Salir\n\n" +
                "Elija una opción:");

        int option = Integer.parseInt(reader.nextLine());
        System.out.println("Ingrese la cantidad a convertir:");
        mount = Integer.parseInt(reader.nextLine());

        try{
            switch(option){
                case 1:
                    initialCurrency = "USD";
                    targetCurrency = "ARS";
                    currency = consulta.findCurrency(initialCurrency, targetCurrency, mount);
                    convertedMount = currency.conversion_result();
                    System.out.println("$"+mount+" Dólares, son "+convertedMount+" Pesos Argentinos.");
                    break;
                case 2:
                    initialCurrency = "ARS";
                    targetCurrency = "USD";
                    currency = consulta.findCurrency(initialCurrency, targetCurrency, mount);
                    convertedMount = currency.conversion_result();
                    System.out.println(mount+" Pesos Argentinos, son $"+ convertedMount +" Dólares.");
                    break;
                case 3:
                    initialCurrency = "USD";
                    targetCurrency = "BRL";
                    currency = consulta.findCurrency(initialCurrency, targetCurrency, mount);
                    convertedMount = currency.conversion_result();
                    System.out.println("$"+mount+" Dólares, son "+ convertedMount +" Reales Brasileños.");
                    break;
                case 4:
                    initialCurrency = "BRL";
                    targetCurrency = "USD";
                    currency = consulta.findCurrency(initialCurrency, targetCurrency, mount);
                    convertedMount = currency.conversion_result();
                    System.out.println("$"+mount+" Reales Brasileños, son "+ convertedMount +" Dólares.");
                    break;
                case 5:
                    initialCurrency = "USD";
                    targetCurrency = "COP";
                    currency = consulta.findCurrency(initialCurrency, targetCurrency, mount);
                    convertedMount = mount* currency.conversion_result();
                    System.out.println("$"+mount+" Dólares, son "+ convertedMount +" Pesos Colombianos.");
                    break;
                case 6:
                    initialCurrency = "COP";
                    targetCurrency = "USD";
                    currency = consulta.findCurrency(initialCurrency, targetCurrency, mount);
                    convertedMount = mount*currency.conversion_result();
                    System.out.println("$"+mount+" Pesos Colombianos, son "+ convertedMount +" Dólares.");
                    break;
                case 7:
                    break;
            }

        } catch (NumberFormatException e){
            System.out.println("CURRENCY NOT FOUND "+e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
