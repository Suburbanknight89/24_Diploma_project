package ru.vprok.tests;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.vprok.allure.JiraIssue;
import ru.vprok.allure.JiraIssues;
import ru.vprok.allure.Microservice;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WebTests extends TestBase{

	@Test
	@DisplayName("Vprok.ru tests 1")
	@Story("Отображение 'Товар недели' на главной странице")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertProductOFTheWeekTest() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check text Товар недели", () -> {
			$(".xfnew-semiblocks__item-header-title").shouldHave(text("Товар недели"));
		});
	}

	@Test
	@DisplayName("Vprok.ru tests 2")
	@Story("Отображение 'Суперцены недели' на главной странице")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertSuperPricesTest() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check text Суперцены недели ", () -> {
			$(byText("Суперцены недели")).shouldBe(visible);
		});
	}

	@Test
	@DisplayName("Vprok.ru tests 3")
	@Story("Проверка ссылки 'Упаковкой дешевле'")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertCatalogueLink() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check Catalogue", () -> {
			$(".xfnew-header__catalog-button").click();
					$(By.linkText("Упаковкой дешевле")).shouldHave(href("catalog/4924/upakovkoy-deshevle"));
		});
	}


	@Test
	@DisplayName("Vprok.ru tests 4")
	@Story("Проверка ссылки 'Зоотовары'")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertCatalogueLinkZoo() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check Catalogue", () -> {
			$(".xfnew-header__catalog-button").click();
			$(By.linkText("Зоотовары")).shouldHave(href("https://zoo.vprok.ru/"));
			$(".xf-svg xfnew-header__logo-image--zoo-corner").shouldHave(text("Зоотовары"));
		});
	}

	@Test
	@DisplayName("Vprok.ru tests 5")
	@Story("Проверка заголовка 'Зоотовары'")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertZooHeader() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check Catalogue", () -> {
			$(".xfnew-header__catalog-button").click();
			$(By.linkText("Зоотовары")).click();
			$(".xfnew-semiblocks__item-header").shouldHave(text("Лучшее для кошек"));
		});
	}

		@Test
		@DisplayName("Vprok.ru tests 6")
		@Story("Проверка поиска по продукту 'молоко'")
		@Microservice("Search")
		@Tags({@Tag("web")})
		@Owner("ZaytsevE")
		@JiraIssues({@JiraIssue("HOMEWORK-250")})
		void searchMilktest() {
			step("open https://www.vprok.ru/", () -> {
				open("https://www.vprok.ru/");
			});

			step("check Catalogue", () -> {
				$(byXpath("(//input[@name='search'])[2]")).val("молоко").pressEnter();
				$("#ui-id-31 .xf-product-title__link").
						shouldHave(text("Молоко"));
			});
		}

	@Test
	@DisplayName("Vprok.ru tests 7")
	@Story("Проверка отправки смс кода при регистрации нового клиетна")
	@Microservice("Registration")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void searchMilktest1() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check Catalogue", () -> {
			$(".xfnew-nav__dropdown-button").click();
			$(byText("Регистрация Интернет-Магазин")).click();
			$(byName("phone")).val("+9999999999");
			$(byName("name")).val("9999");
			$(byName("email")).val("9999@9999.ru");
			$(".xf-registration__btn").click();
			$(".xf-registration-pin__timer").shouldHave(text("Отправить"));


		});
	}
}
