import java.util.Objects;

public class Buyer {
    protected String buyersName;
    protected String buyersAddress;


    public Buyer(String buyersName, String buyersAddress) {

        this.buyersName = buyersName;
        this.buyersAddress = buyersAddress;
    }

    public String getBuyersNamee() {
        return buyersName;
    }

    public String getBuyersAddress() {
        return buyersAddress;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(Buyer.class)) {
            return false;
        }

        Buyer altBuyer = (Buyer) obj;

        return this.buyersName.equals(altBuyer.buyersName) && this.buyersAddress.equals(altBuyer.buyersAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyersName, buyersAddress);
    }


}

