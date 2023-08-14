package hello.itemService.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, ItemParamDto IPD) {
        Item findItem = findById(itemId);
        findItem.setItemName(IPD.getItemName());
        findItem.setPrice(IPD.getPrice());
        findItem.setQuantity(IPD.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
