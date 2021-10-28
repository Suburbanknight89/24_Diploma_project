package ru.vprok.tests;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.vprok.allure.JiraIssue;
import ru.vprok.allure.JiraIssues;
import ru.vprok.allure.Layer;
import ru.vprok.allure.Microservice;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class WebTests extends TestBase{

	@Test
	@DisplayName("Отображение 'Товар недели' на главной страниц")
	@Layer("web")
	@Story("vprok.ru tests")
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
	@DisplayName("Отображение 'Суперцены недели' на главной странице")
	@Layer("web")
	@Story("vprok.ru tests")
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
	@DisplayName("Проверка ссылки 'Упаковкой дешевле'")
	@Layer("web")
	@Story("vprok.ru tests")
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
					$(linkText("Упаковкой дешевле")).shouldHave(href("catalog/4924/upakovkoy-deshevle"));
		});
	}


	@Test
	@DisplayName("Проверка что в заголовках блока зоотовары есть подзаголовок 'лакомства для кошек'")
	@Layer("web")
	@Story("vprok.ru tests")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void assertCatalogueLinkZoo() {
		step("open https://zoo.vprok.ru/", () -> {
			open("https://zoo.vprok.ru/");
		});

		step("check the zoo corner contains feed in the headers", () -> {
			$(".xfnew-user-category__link").shouldHave(text("Лакомства для кошек"));
		});
	}

	@Test
	@DisplayName("Проверка подзаголовка в категории 'Зоотовары'")
	@Layer("web")
	@Story("vprok.ru tests")
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
			$(linkText("Зоотовары")).click();
		});

			step("check that 'Хиты продаж' contains in search results", () -> {
				$(".xf-main-page__header-wrapper").shouldHave(text("Хиты продаж"));
		});
	}

		@Test
		@DisplayName("Проверка поиска по продукту 'молоко'")
		@Layer("web")
		@Story("vprok.ru tests")
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
	@DisplayName("Проверка отправки смс кода при регистрации нового клиента")
	@Layer("web")
	@Story("vprok.ru tests")
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
	@Test
	@DisplayName("Проверка фильтрации в категории  'Чай, кофе, сахар'")
	@Layer("web")
	@Story("vprok.ru tests")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void filterTeaTest() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("search category tea,coffee,sugar in catalogue", () -> {
			$(".xfnew-header__catalog-button").click();
			$(linkText("Чай, кофе, сахар")).click();
		});

		step("select 'tea' category", () -> {
			$(".selectboxit-arrow-container").click();
		});

		step("check that search result excludes coffee", () -> {
			$(".selectboxit-option:nth-child(3)").shouldNotHave(text("кофе")).
					shouldNotHave(text("какао")).shouldNotHave(text("сахар"));
		});

	}

	@Test
	@DisplayName("Положить товар в козину")
	@Layer("web")
	@Story("vprok.ru tests")
	@Microservice("Search")
	@Tags({@Tag("web")})
	@Owner("ZaytsevE")
	@JiraIssues({@JiraIssue("HOMEWORK-250")})
	void basketTest() {
		step("open https://www.vprok.ru/", () -> {
			open("https://www.vprok.ru/");
		});

		step("search best for cats in zoo corner", () -> {
			$(".xfnew-header__catalog-button").click();
			$(linkText("Чай, кофе, сахар")).click();
		});

		step("buy the product", () -> {
			$(".xf-add-to-cart-btn__text").click();
		});

		step("choose delievery address", () -> {
			Selenide.sleep(3000);
			$(byName("address")).val("Московская область, городской округ Балашиха, деревня " +
					"Русавкино-Романово, Гостиничная улица, 61");
			$(".ui-menu-item-wrapper").click();
			$(".ui-menu-item-wrapper").should(disappear);
			Selenide.sleep(3000);
			$(".xfnew-button-filled").click();
		});

		step("go to the basket", () -> {
			$(".xfnew-header__cart-wrap",1).click();
		});

		step("check that selected prodict is in the basket", () -> {
			$(".fo-product-card__wrap").shouldHave(text("Lavazza"));
		});
	}
}

