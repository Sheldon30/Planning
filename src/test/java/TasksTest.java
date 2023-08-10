import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindTaskInMeeting() {
        Meeting meeting = new Meeting(56, "Анализ выкладки", "Мерчендайзинг", "Пятница утро");
        boolean expected = true;
        boolean actual = meeting.matches("Анализ");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTaskInMeeting() {
        Meeting meeting = new Meeting(56, "Анализ выкладки", "Мерчендайзинг", "Пятница утро");
        boolean expected = false;
        boolean actual = meeting.matches("aнализ");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindTaskInMeetingProject() {
        Meeting meeting = new Meeting(56, "Анализ выкладки", "Мерчендайзинг", "Пятница утро");
        boolean expected = true;
        boolean actual = meeting.matches("Мерч");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTaskInMeetingProject() {
        Meeting meeting = new Meeting(56, "Анализ выкладки", "Мерчендайзинг", "Пятница утро");
        boolean expected = false;
        boolean actual = meeting.matches("мерчендайзинг");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindTaskInMeetingStart() {
        Meeting meeting = new Meeting(56, "Анализ выкладки", "Мерчендайзинг", "Пятница утро");
        boolean expected = true;
        boolean actual = meeting.matches("Пятница");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTaskInMeetingStart() {
        Meeting meeting = new Meeting(56, "Анализ выкладки", "Мерчендайзинг", "Пятница утро");
        boolean expected = false;
        boolean actual = meeting.matches("пятница");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindTaskInEpic() {
        String[] subtasks = {"Убрать постель", "забрать костюм", "купить лекарство", "тренировка"};
        Epic epic = new Epic(75, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("костюм");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTaskInEpic() {
        String[] subtasks = {"Убрать постель", "забрать костюм", "купить лекарство", "тренировка"};
        Epic epic = new Epic(75, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Тренировка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInSimple() {
        SimpleTask simpleTask = new SimpleTask(45, "Секция волейбола");
        boolean expected = true;
        boolean actual = simpleTask.matches("Секция");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTaskInSimple() {
        SimpleTask simpleTask = new SimpleTask(45, "Секция волейбола");
        boolean expected = false;
        boolean actual = simpleTask.matches("секция");
        Assertions.assertEquals(expected, actual);
    }
}
