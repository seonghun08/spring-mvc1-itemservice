package hello.itemService.item;

import hello.itemService.domain.item.Item;
import hello.itemService.domain.item.ItemParamDto;
import hello.itemService.domain.item.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = Item.builder()
                .itemName("spring")
                .price(15000)
                .quantity(100)
                .build();
        Item saveItem = itemRepository.save(item);

        assertThat(item).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        Item a = new Item("A", 100, 100);
        Item b = new Item("B", 200, 100);
        Item c = new Item("C", 300, 100);
        Item d = new Item("D", 400, 100);

        itemRepository.save(a);
        itemRepository.save(b);
        itemRepository.save(c);
        itemRepository.save(d);

        List<Item> list = itemRepository.findAll();

        assertThat(list.size()).isEqualTo(4);
        assertThat(list).contains(a, b, c, d);
    }

    @Test
    void updateItem() {
        Item item = Item.builder()
                .itemName("spring")
                .price(15000)
                .quantity(100)
                .build();
        Item saveItem = itemRepository.save(item);
        Long itemId = saveItem.getId();

        ItemParamDto IPD = new ItemParamDto("JPA", 20000, 100);
        itemRepository.update(itemId, IPD);

        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo("JPA");
    }
}
