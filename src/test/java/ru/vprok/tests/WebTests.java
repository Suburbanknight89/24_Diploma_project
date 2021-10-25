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
import ru.vprok.allure.Layer;
import ru.vprok.allure.Microservice;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WebTests extends TestBase{

	@Test
	@DisplayName("Vprok.ru tests 1")
	@Layer("web")
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
	@Layer("web")
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
	@Layer("web")
	@Story("Проверка ссылки 'Упаковкой дешевле'")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertCatalogueLink() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("check that 'expensive if pack' lead to correct link", () -> {
			$(".xfnew-header__catalog-button").click();
					$(By.linkText("Упаковкой дешевле")).shouldHave(href("catalog/4924/upakovkoy-deshevle"));
		});
	}


	@Test
	@DisplayName("Vprok.ru tests 4")
	@Layer("web")
	@Story("Проверка что в заголовках блока зоотовары есть корма для животных")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertCatalogueLinkZoo() {
		step("open https://zoo.vprok.ru/", () -> {
			open("https://zoo.vprok.ru/");
		});

		step("check the zoo corner contains feed in the headers", () -> {
			$("#tns1-item1").shouldHave(text("корм"));
		});
	}

	@Test
	@DisplayName("Vprok.ru tests 5")
	@Layer("web")
	@Story("Проверка заголовка 'Зоотовары'")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertZooHeader() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("search best for cats in zoo corner", () -> {
			$(".xfnew-header__catalog-button").click();
			$(By.linkText("Зоотовары")).click();
		});

			step("check that 'лучшее для кошек' contains in search results", () -> {
				$(".xfnew-semiblocks__item-header-title").shouldHave(text("Лучшее для кошек"));
		});
	}

		@Test
		@DisplayName("Vprok.ru tests 6")
		@Layer("web")
		@Story("Проверка поиска по продукту 'молоко'")
		@Microservice("Search")
		@Tags({@Tag("web")})
		@Owner("ZaytsevE")
		@JiraIssues({@JiraIssue("HOMEWORK-250")})
		void searchMilktest() {
			step("open https://www.vprok.ru/", () -> {
				open("https://www.vprok.ru/");
			});

			step("search 'milk'", () -> {
				$(byXpath("(//input[@name='search'])[2]")).val("молоко").pressEnter();
			});

			step("check that 'молоко' contains in search results", () -> {
					$("#ui-id-31 .xf-product-title__link").
							shouldHave(text("Молоко"));
			});

		}

	@Test
	@DisplayName("Vprok.ru tests 7")
	@Layer("web")
	@Story("Проверка отправки смс кода при регистрации нового клиетна")
	@Microservice("Registration")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void searchMilktest1() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("fill in fields", () -> {
			$(".xfnew-nav__dropdown-button").click();
			$(byText("Регистрация Интернет-Магазин")).click();
			$(byName("phone")).val("+9999999999");
			$(byName("name")).val("9999");
			$(byName("email")).val("9999@9999.ru");
			$(".xf-registration__btn").click();
			$(".xf-registration-pin__timer").shouldHave(text("Отправить"));
			});

		step("check that countdown begins", () -> {
				$(".xf-registration-pin__timer").shouldHave(text("Отправить"));
			});

	}
}
