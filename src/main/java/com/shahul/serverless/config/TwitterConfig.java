package com.shahul.serverless.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterConfig {
	@Autowired
	private Environment env;

	public Twitter getTwitterInstance() {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(env.getProperty("twitter.api.key"))
		  .setOAuthConsumerSecret(env.getProperty("twitter.api.secret"))
		  .setOAuthAccessToken(env.getProperty("twitter.api.accessToken"))
		  .setOAuthAccessTokenSecret(env.getProperty("twitter.api.accessSecret"));
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();

	}
}
