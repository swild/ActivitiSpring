package de.exxeta.vortraege.bpm.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class RetweetTask {

	private static final Logger LOG = LoggerFactory.getLogger(RetweetTask.class);

	@Autowired
	private TwitterTemplate twitterTemplate;

	public void execute(long tweetId) {
		LOG.info("Retweet tweet id {}.", tweetId);

		twitterTemplate.timelineOperations().retweet(tweetId);
	}

}
