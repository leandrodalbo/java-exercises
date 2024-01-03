package org.vendingMachine;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.vendingMachine.VendingMachine.ItemValues;
import static org.vendingMachine.VendingMachine.Item;

public class VendingMachineTest {

    @Test
    public void shouldCreateAMachineWithItemsAndChange() {
        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0), Item.COOKIES, new ItemValues(15, 0.5));

        var machine = new VendingMachine(100, items);

        assertThat(machine.getItems()).isEqualTo(items);
        assertThat(machine.getAvailableChange()).isEqualTo(100);
    }

    @Test
    public void shouldSelectAnAvailableItem() throws Exception {
        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0), Item.COOKIES, new ItemValues(15, 0.5));

        var machine = new VendingMachine(100, items);

        machine.select(Item.COOKIES, 1);

        assertThat(machine.getSelected()).isNotNull();
    }

    @Test
    public void shouldThrowExceptionIfSelectedIsNotNull() throws Exception {
        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0), Item.COOKIES, new ItemValues(15, 0.5));

        var machine = new VendingMachine(100, items);

        machine.select(Item.COOKIES, 1);

        assertThatException().isThrownBy(() -> machine.select(Item.COKE, 1));
    }

    @Test
    public void shouldThrowExceptionIfTheItemDoesNotExists() throws Exception {

        var machine = new VendingMachine(100, Map.of());

        assertThatException().isThrownBy(() -> machine.select(Item.COKE, 1));
    }

    @Test
    public void shouldThrowExceptionIfThereIsNotEnoughQuantity() throws Exception {

        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0));

        var machine = new VendingMachine(100, items);

        assertThatException().isThrownBy(() -> machine.select(Item.COKE, 11));
    }

    @Test
    public void shouldBeAbleToPayAndComplete() throws Exception {

        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0));

        var machine = new VendingMachine(100, items);
        machine.select(Item.COKE, 1);

        var result = machine.payAndComplete(1.0);

        assertThat(result).isEqualTo(new VendingMachine.OperationResult(Item.COKE, 0.0));
    }

    @Test
    public void shouldFailWithoutASelectedItem() throws Exception {

        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0));

        var machine = new VendingMachine(100, items);

        assertThatException().isThrownBy(() -> machine.payAndComplete(1.0));


    }

    @Test
    public void shouldFailIfTheMachineHasNoMoney() throws Exception {

        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0));

        var machine = new VendingMachine(0, items);
        machine.select(Item.COKE, 1);

        assertThatException().isThrownBy(() -> machine.payAndComplete(1.0));

    }

    @Test
    public void shouldFailWithoutEnoughMoney() throws Exception {

        final Map items = Map.of(Item.COKE, new ItemValues(10, 1.0));

        var machine = new VendingMachine(100, items);
        machine.select(Item.COKE, 1);

        assertThatException().isThrownBy(() -> machine.payAndComplete(0.5));

    }
}
