package de.exxeta.vortraege.service;

import de.exxeta.vortraege.model.TwitterMessage;

public interface ProcessService {

    void start(TwitterMessage twitterMessage);

}
