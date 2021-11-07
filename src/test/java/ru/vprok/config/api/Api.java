package ru.vprok.config.api;

import org.aeonbits.owner.ConfigFactory;

public class Api {
	public static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
}