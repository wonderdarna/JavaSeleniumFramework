package planit.web.auto.entities;

public class PurchaseDetail {
    private String itemName;
    private Integer quantity;
    private Double itemPrice;

    public PurchaseDetail(String itemName, Integer quantity, Double itemPrice) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getPriceSubtotal() {
        return itemPrice * quantity;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", itemPrice=" + itemPrice +
                ", priceSubtotal=" + getPriceSubtotal() +
                '}';
    }
}
