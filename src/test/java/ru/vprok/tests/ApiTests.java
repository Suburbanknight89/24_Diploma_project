package ru.vprok.tests;

		import ru.vprok.allure.Layer;
		import ru.vprok.allure.Lead;
		import ru.vprok.allure.Microservice;
		import io.qameta.allure.Feature;
		import io.qameta.allure.Owner;
		import io.qameta.allure.Story;
		import io.restassured.path.json.JsonPath;
		import io.restassured.response.Response;
		import org.junit.jupiter.api.DisplayName;
		import org.junit.jupiter.api.Tag;
		import org.junit.jupiter.api.Tags;
		import org.junit.jupiter.api.Test;

		import java.util.ArrayList;
		import java.util.Map;

		import static io.qameta.allure.Allure.step;
		import static io.restassured.RestAssured.given;
		import static org.hamcrest.Matchers.hasItems;
		import static org.hamcrest.core.Is.is;

@Layer("rest")
@Lead("qa")
@Owner("ZaytsevE")
@Feature("User")
public class ApiTests {
}



