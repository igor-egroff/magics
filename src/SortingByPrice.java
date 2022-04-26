public class SortingByPrice implements SortingOfGoods {
    // сортировка по стоимости товара
    // L-принцип замены Барбары Лисков(Liskov Substitution Principle)Наследуй только тогда, когда можешь играть роль за предка.
    protected static void quickSort(Product[] products, int low, int high) {
        if (products.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Product opora = products[middle];

        int i = low, j = high;
        while (i <= j) {


            while (products[i].price < opora.price) {
                i++;

            }


            while (products[j].price > opora.price) {
                j--;
            }


            if (i <= j) {
                Product temp = products[i];
                products[i] = products[j];
                products[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(products, low, j);

        if (high > i)
            quickSort(products, i, high);
    }

}

