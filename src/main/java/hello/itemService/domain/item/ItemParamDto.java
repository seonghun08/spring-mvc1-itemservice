package hello.itemService.domain.item;

import lombok.Data;

@Data
public class ItemParamDto {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemParamDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
