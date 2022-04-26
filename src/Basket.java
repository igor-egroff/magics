public class Basket {

    protected String productName;
    protected int amounOfGoods;


    public Basket(String productName, int amounOfGoods) {

        this.productName = productName;
        this.amounOfGoods = amounOfGoods;

    }

    public String getProductName() {
        return productName;
    }

    public int getAmounOfGoods() {
        return amounOfGoods;
    }


    @Override
    public String toString() {

        StringBuilder group = new StringBuilder();
        group

                .append(productName)
                .append("\t")
                .append(amounOfGoods);

        return group.toString();
    }

}

