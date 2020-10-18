package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        Output output = new StubOutput();
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction(output);
        action.execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find Item by id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Item{id = 1, name = 'Find item'}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find Item by id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find item"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Find Item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Item{id = 1, name = 'Find item'}" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find Item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ListAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                                        + "0. All Items List" + System.lineSeparator()
                                        + "1. Exit" + System.lineSeparator()
                                        + "Item{id = 1, name = 'Item'}" + System.lineSeparator()
                                        + "Menu." + System.lineSeparator()
                                        + "0. All Items List" + System.lineSeparator()
                                        + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "1", "0" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), Matchers.is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}
