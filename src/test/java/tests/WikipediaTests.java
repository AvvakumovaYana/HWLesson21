package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase {

    @Test
    @DisplayName("Проверка стартовой страницы википедии")
    void wikipediaOnboardingTest() {

        step("Проверяем стартовую страницу", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia"));
        });
        step("Переходим на вторую страницу", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверяем вторую страницу", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        });
        step("Переходим на третью страницу", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверяем третью страницу", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        });
        step("Переходим на четвертую страницу", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверяем четвертую страницу", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Data & Privacy"));
        });
        $(By.("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
    }
}


