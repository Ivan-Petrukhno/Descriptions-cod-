package pages; // Объявление пакета, к которому принадлежит данный класс

import com.codeborne.selenide.SelenideElement; // Импорт класса SelenideElement из библиотеки Selenide
import pages.components.CalendarComponent; // Импорт класса CalendarComponent из пакета pages.components
import pages.components.RegistrationResultsModal; // Импорт класса RegistrationResultsModal из пакета pages.components

import static com.codeborne.selenide.Condition.text; // Импорт статического метода text из класса Condition
import static com.codeborne.selenide.Selectors.byText; // Импорт статического метода byText из класса Selectors
import static com.codeborne.selenide.Selenide.*; // Импорт статических методов для работы с браузером из Selenide

public class RegistrationPage { // Объявление класса RegistrationPage

    private final String TITLE_TEXT = "Student Registration Form"; // Инициализация константы TITLE_TEXT с текстом "Student Registration Form"
    private CalendarComponent calendarComponent = new CalendarComponent(); // Создание экземпляра класса CalendarComponent
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal(); // Создание экземпляра класса RegistrationResultsModal
    private SelenideElement // Объявление элементов страницы с использованием CSS-селекторов
            firstNameInput = $("#firstName"), // Поле ввода имени
            lastNameInput = $("#lastName"), // Поле ввода фамилии
            dateOfBirthInput = $("#dateOfBirthInput"); // Поле ввода даты рождения

    public RegistrationPage openPage() { // Метод для открытия страницы
        open("/automation-practice-form"); // Открытие страницы по указанному URL
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT)); // Проверка, что на странице присутствует текст "Student Registration Form"
        executeJavaScript("$('#fixedban').remove()"); // Удаление элемента с id "fixedban" с помощью JavaScript
        executeJavaScript("$('footer').remove()"); // Удаление элемента "footer" с помощью JavaScript

        return this; // Возврат текущего экземпляра класса
    }

    public RegistrationPage setFirstName(String value) { // Метод для ввода имени
        firstNameInput.setValue(value); // Установка значения в поле ввода имени

        return this; // Возврат текущего экземпляра класса
    }

    // Другие методы для ввода различных данных в форму и проверки результатов, аналогичные вышеперечисленным

}
