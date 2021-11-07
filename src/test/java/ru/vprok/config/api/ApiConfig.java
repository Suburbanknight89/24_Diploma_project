package ru.vprok.config.api;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"classpath:config/api.properties",
		"classpath:config/remote.properties"
})
public interface ApiConfig extends Config {

	@Key("remote.web.user")
	String getRemoteWebUser();

	@Key("remote.web.password")
	String getRemoteWebPassword();

	@Key("remote.web.email")
	String getRemoteWebEmail();

	@Key("remote.web.token")
	String getRemoteWebToken();

	@Key("remote.web.name")
	String getRemoteWebName();

	@Key("remote.web.namet2")
	String getRemoteWebNameForTest2();

	@Key("remote.web.job")
	String getRemoteWebJob();
}