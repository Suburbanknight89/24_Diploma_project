package ru.vprok.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import ru.vprok.allure.JiraIssue;
import ru.vprok.allure.JiraIssues;
import ru.vprok.allure.Layer;
import ru.vprok.config.application.App;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ApiTests {

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}

	public final static String USER = App.config.getRemoteWebUser();
	public final static String TOKEN = App.config.getRemoteWebToken();
	public final static String NAME = App.config.getRemoteWebName();
	public final static String EMAIL = App.config.getRemoteWebEmail();
	public final static String PASSWORD = App.config.getRemoteWebPassword();
	public final static String NAMEFOTTEST2 = App.config.getRemoteWebNameForTest2();
	public final static String JOB = App.config.getRemoteWebJob();

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
				.body("{\"name\": \"" + USER + "\"," +
						"\"job\": \"" + JOB + "\" }")
				.when()
				.post(baseURI + "/api/users")
				.then()
				.statusCode(201)
				.body("name", is(USER), "job", is(JOB))
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
				.get(baseURI + "/api/users/6")
				.then()
				.statusCode(200)
				.body("data.email", is(EMAIL))
				.body("data.last_name", is(NAMEFOTTEST2));
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
				.get(baseURI + "/api/users?page=3")
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
				.body(NAME)
				.when()
				.post(baseURI + "/api/users")
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
				.body("{\"email\": \"" + EMAIL + "\"," +
						"\"password\": \"" + PASSWORD + "\" }")
				.when()
				.post("/api/register")
				.then()
				.statusCode(200)
				.body("id", is(6))
				.body("token", is(TOKEN));
	}
}




