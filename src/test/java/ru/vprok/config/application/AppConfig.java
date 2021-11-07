package ru.vprok.config.application;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/app.properties"
})
public interface AppConfig extends Config {
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