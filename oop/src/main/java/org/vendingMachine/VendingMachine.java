package org.vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private final double availableChange;
    private final Map<Item, ItemValues> items = new HashMap();

    private Item selected = null;

    public VendingMachine(double avilableChange, Map<Item, ItemValues> items) {
        this.availableChange = avilableChange;
        items.forEach(((item, value) -> this.items.put(item, value)));
    }

    public double getAvailableChange() {
        return availableChange;
    }

    public Map<Item, ItemValues> getItems() {
        return items;
    }

    public Item getSelected() {
        return selected;
    }

    public void select(Item toSelect, Integer quantity) throws Exception {

        if (selected != null) {
            throw new Exception("ItemAlreadySelected");
        }

        if (!items.containsKey(toSelect)) {
            throw new Exception("InvalidItem");
        } else {
            var toProcess = items.get(toSelect);

            if (toProcess.quantity < quantity) {
                throw new Exception("NotEnoughItems");
            } else {
                this.selected = toSelect;
            }
        }

    }

    public OperationResult payAndComplete(double amount) throws Exception {
        OperationResult result = null;

        if (selected == null) {
            throw new Exception("AnItemMustBeSelected");
        } else {

            var toUpdateQuantity = this.items.get(selected);

            if (amount > availableChange || amount < toUpdateQuantity.price) {
                this.selected = null;
                throw new Exception("InvalidTransaction");
            }

            this.items.put(selected, new ItemValues(toUpdateQuantity.quantity - 1, toUpdateQuantity.price));

            result = new OperationResult(selected, amount - toUpdateQuantity.price);
            selected = null;
        }

        return result;

    }

    public enum Item {
        COKE("COKE"),
        COOKIES("COOKIES");
        private final String name;

        Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public record ItemValues(
            Integer quantity,
            Double price) {
    }

    public record OperationResult(
            Item item,
            Double change) {
    }
}
