package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Проверка поиска статьи по запросу")
    void searchTest() {

        step("Вводим текст в строку поиска", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверяем отображение результатов поиска", () -> {
                $$(id("page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @Tag("android")
    @DisplayName("Проверка открытия найденной статьи")
    void openPageTest() {
        step("Вводим текст в строку поиска", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Выбираем первый результат поиска", () -> {
            $(id("page_list_item_title")).click();
        });
        step("Проверяем страницу статьи", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("An error occurred"));
        });
    }
}


