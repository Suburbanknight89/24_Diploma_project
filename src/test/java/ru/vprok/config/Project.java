package ru.vprok.config;

import org.aeonbits.owner.ConfigFactory;
import ru.vprok.config.api.ApiConfig;

public class Project {
	public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());


	public static boolean isWebMobile() {
		return config.browserMobileView() != null && !config.browserMobileView().isEmpty();
	}

	public static boolean isRemoteWebDriver() {
		return config.remoteDriverUrl() != null && !config.remoteDriverUrl().isEmpty();
	}

	public static boolean isVideoOn() {
		return config.videoStorage() != null && !config.videoStorage().isEmpty();
	}
}