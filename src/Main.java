import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        Product product = new Product(null, 0, null);
        Buyer buyer = new Buyer(null, null);
        Product selectedProduct = new Product(null, 0, null);
        //1. Правило Magic: не используй числа напрямую в коде
        Product[] products = {new Product("помидор", 10, "Крым"),
                new Product("апельсин", 8, "Турция"),
                new Product("молоко", 3, "Вологда"),
                new Product("масло", 11, "Краснодар")};

        Map<Buyer, List<Basket>> buyersOrder = new HashMap<>();//заказ покупателя

        int low = 0;
        //1. Правило Magic: не используй числа напрямую в коде
        int high = products.length - 1;

       // I- принцип сегрегации (разделения) интерфейса(Interface Segregation Principle).
// сортировка по цене
        System.out.println("-----Сортировка по цене-----");
        SortingByPrice.quickSort(products, low, high);
        //2. Правило DRY (Don’t Repeat Yourself): не повторяй свой код
        printProduct(products);

        System.out.println("-----Сортировка по производителю-----");
        SortingByManufacturersName.quickSort(products, low, high);
        //2. Правило DRY (Don’t Repeat Yourself): не повторяй свой код
        printProduct(products);

        System.out.println("-----Сортировка по товару-----");
        SortingByProductName.quickSort(products, low, high);
        //2. Правило DRY (Don’t Repeat Yourself): не повторяй свой код
        printProduct(products);
        System.out.println("---------------------------------");

        // Наполнение корзины покупателя
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                List<Basket> basket = new ArrayList<>();
                System.out.println("Выберите имя, адрес покупателя через пробел или введите \"end\": ");
                String inputBuyer = scanner.nextLine();
                if (inputBuyer.equals("end")) {
                    printBasket(buyersOrder, products);
                    break;
                }
                String[] buyerParameters = inputBuyer.split(" ");
                buyer = new Buyer(buyerParameters[0], buyerParameters[1]);

                while (true) {

                    System.out.println("Выберите наименование товара  и количество  через пробел или введите \"end\": ");
                    String inputOrder = scanner.nextLine();
                    int productNumber = 0;
                    if (inputOrder.equals("end")) {
                        buyersOrder.put(buyer, basket);
                        break;
                    }
                    String[] orderParameters = inputOrder.split(" ");
                    productNumber = checkingTheAvailabilityOfGoods(orderParameters[0], products);
                    basket.add(new Basket(products[productNumber].name, Integer.parseInt(orderParameters[1])));
                }
            }
        } catch (RuntimeException exception) {
            System.out.println("Не верно ведена информация (необходимо строго вводить разделитель - пробел");
        }

    }
    //2. Правило DRY (Don’t Repeat Yourself): не повторяй свой код
    // печать перечня товаров
    private static void printProduct(Product products[]) {
        int i = 0;
        StringBuilder tableHeader = new StringBuilder();

        tableHeader
                .append("Список товаров:")
                .append("\n")
                .append("цена")
                .append("\t")
                .append("Наим")
                .append("\t")
                .append("производитель");
        System.out.println(tableHeader);
        for (Product entry : products) {
            i++;
            System.out.println(entry.toString());
        }
    }

    // печать корзины покупателя
    private static void printBasket(Map<Buyer, List<Basket>> buyersOrder, Product[] products) {
        int i = 0;
        StringBuilder tableHeader = new StringBuilder();

        tableHeader
                .append("Заказ:")
                .append("\n")
                .append("Покупатель")
                .append("\t")
                .append("Адрес")
                .append("\t")
                .append("Товар")
                .append("\t")
                .append("кол-во")
                .append("\t")
                .append("Цена")
                .append("\t")
                .append("Стоимость");

        for (Map.Entry<Buyer, List<Basket>> entry : buyersOrder.entrySet()) {
            StringBuilder orderParameters = new StringBuilder();
            List<Basket> basket1 = entry.getValue();
            for (Basket entry1 : basket1) {
                int productNumber = checkingTheAvailabilityOfGoods(entry1.productName, products);
                orderParameters
                        .append(entry.getKey().buyersName)
                        .append("\t")
                        .append(entry.getKey().buyersAddress)
                        .append("\t")
                        .append(entry1.productName)
                        .append("\t")
                        .append(entry1.amounOfGoods)
                        .append("\t")
                        .append(products[productNumber].price)
                        .append("\t")
                        .append(products[productNumber].price * entry1.amounOfGoods)
                        .append("\n");
            }
            System.out.println("покупатель: " + entry.getKey().buyersName);
            System.out.println(tableHeader);
            System.out.println(orderParameters);
        }

    }

    // метод поиска товара в списке
    private static int checkingTheAvailabilityOfGoods(String name, Product products[]) {
        int productNumber = 0;
        productNumber = Product.binarySearch(name, products);
        return productNumber;
    }

}
