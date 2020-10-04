package com.shahul.serverless.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahul.serverless.config.TwitterConfig;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

@Service
public class TwitterService {

	@Autowired
	TwitterConfig twitterConfig;

	public String updateUsername() {
		Twitter twitter = twitterConfig.getTwitterInstance();
		User user;
		try {
			user = twitter.showUser(twitter.getId());
			User updatedProfile = twitter.updateProfile(user.getName() + " | " + user.getFollowersCount(), null, null,null);
			return updatedProfile.getName();
		} catch (TwitterException e) {}
		return null;
	}
}
