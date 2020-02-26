import javax.xml.bind.annotation.XmlType;

public enum Product {
    SOUP("soup"),
    BREAD("bread"),
    APPLE("apple"),
    DEFAULT("default");

    private String product;

    Product(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product;
    }
}
