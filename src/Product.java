public class Product {

    protected int price;
    protected String name;
    protected String manufacturer;

    public Product(String name, Integer price, String manufacturer) {

        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;

    }

    protected static int binarySearch(String name, Product products[]) {
        int left = 0;
        int right = products.length - 1;

        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].name.compareTo(name) > 0) {
                left = mid + 1;
            } else if (products[mid].name.compareTo(name) < 0) {
                right = mid - 1;
            } else if (products[mid].name.compareTo(name) == 0) {
                index = mid;
                break;
            }
        }
        return index;
    }
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {

        StringBuilder group = new StringBuilder();
        group

                .append(price)
                .append("\t")
                .append(name)
                .append("\t")
                .append(manufacturer);

        return group.toString();
    }


}

