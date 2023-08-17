import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindArraySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Написать письмо");
        Todos todos = new Todos();
        todos.add(simpleTask);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Написать");
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldFindArrayTaskMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldFindArrayTaskEpic() {
        String[] subtasks = {"Анальгин", "Клевер", "Ромашка", "Липа"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Ромашка");
        Assertions.assertArrayEquals(actual, expected);

    }
// Находится 0 задач
    @Test
    public void shouldNotFindArrayTaskEpic() {
        String[] subtasks = {"Анальгин", "Клевер", "Ромашка", "Липа"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("Задачи не найдены");
        Assertions.assertArrayEquals(actual, expected);

    }
    // Находится несколько задач.
    @Test
    public void shouldNotFindArraySomeTasks() {
        String[] subtasks = {"Анальгин", "Клевер", "Ромашка", "Липа"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Купить Анальгин",
                "Покупки",
                "Сегодня вечером"
        );

        Todos todos = new Todos();
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Анальгин");
        Assertions.assertArrayEquals(actual, expected);

    }

}
