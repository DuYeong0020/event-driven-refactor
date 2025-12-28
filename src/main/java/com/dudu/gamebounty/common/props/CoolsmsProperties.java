package com.dudu.gamebounty.common.props;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@RequiredArgsConstructor
@ConfigurationProperties("coolsms")
public class CoolsmsProperties {

	private final String key;
	private final String secret;
	private final String from;
	private final String pfId;

}
