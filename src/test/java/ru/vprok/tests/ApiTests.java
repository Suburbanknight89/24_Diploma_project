package ru.vprok.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import ru.vprok.allure.JiraIssue;
import ru.vprok.allure.JiraIssues;
import ru.vprok.allure.Layer;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ApiTests {

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@Test
	@DisplayName("reqres.in tests create user")
	@Layer("api")
	@Story("Создание нового пользователя")
	@Tags({ @Tag("api") })
	@Owner("ZaytsevE")
	@JiraIssues({ @JiraIssue("HOMEWORK-250") })
	void usersCreateNew() {
		given()
				.contentType(JSON)
				.body("{\"name\": \"suburban\"," +
						"\"job\": \"qa\"}")
				.when()
				.post("https://reqres.in/api/users")
				.then()
				.statusCode(201)
				.body("name", is("suburban"), "job", is("qa"))
				.extract().response().asString();
	}

	@Test
	@DisplayName("reqres.in tests get info")
	@Layer("api")
	@Story("Запрос пользовательских данных")
	@Tags({ @Tag("api") })
	@Owner("ZaytsevE")
	@JiraIssues({ @JiraIssue("HOMEWORK-250") })
	void usersGetInfo() {
		given()
				.contentType(JSON)
				.when()
				.get("https://reqres.in/api/users/6")
				.then()
				.statusCode(200)
				.body("data.email", is("tracey.ramos@reqres.in"))
				.body("data.last_name", is("Ramos"));
	}

	@Test
	@DisplayName("reqres.in tests support.url")
	@Layer("api")
	@Story("Проверка ответа в блоке support.Url")
	@Tags({ @Tag("api") })
	@Owner("ZaytsevE")
	@JiraIssues({ @JiraIssue("HOMEWORK-250") })
	void usersListGetFindUrl() {
		given()
				.contentType(JSON)
				.when()
				.get("https://reqres.in/api/users?page=3")
				.then()
				.statusCode(200)
				.body("support.url", is("https://reqres.in/#support-heading"));
	}

	@Test
	@DisplayName("reqres.in ussuccesfull user creation")
	@Layer("api")
	@Story("Неуспешное создание нового пользователя(негативный)")
	@Tags({ @Tag("api") })
	@Owner("ZaytsevE")
	@JiraIssues({ @JiraIssue("HOMEWORK-250") })
	void unsuccesfullCreateUser() {
		given()
				.contentType(JSON)
				.body("{\n" +
						"    \"name\": \"morpheus\",\n" +
						"}")
				.when()
				.post("https://reqres.in/api/users")
				.then()
				.assertThat().statusCode(400);
	}

	@Test
	@DisplayName("reqres.in succesfull registration")
	@Layer("api")
	@Story("Успешное создание нового пользователя")
	@Tags({ @Tag("api") })
	@Owner("ZaytsevE")
	@JiraIssues({ @JiraIssue("HOMEWORK-250") })
	void registrationSuccessfulTest() {
		given()
				.contentType(JSON)
				.body("{ \"email\": \"eve.holt@reqres.in\", " +
						"\"password\": \"pistol\" }")
				.when()
				.post("/api/register")
				.then()
				.statusCode(200)
				.body("id", is(4))
				.body("token", is("QpwL5tke4Pnpja7X4"));
	}
}




