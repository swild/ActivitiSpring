package de.exxeta.vortraege.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.exxeta.vortraege.bpm.engine.ProcessKeys;
import de.exxeta.vortraege.bpm.engine.VariableKeys;
import de.exxeta.vortraege.model.TwitterMessage;
import de.exxeta.vortraege.service.ProcessService;

@Service
public class DefaultProcessService implements ProcessService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultProcessService.class);

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void start(TwitterMessage twitterMessage) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put(VariableKeys.TWITTER_MESSAGE.getKey(), twitterMessage);

        LOG.info("Start process instance {} with variable {}={}.", new Object[] { 
                ProcessKeys.TWITTER_PROCESS.getKey(), VariableKeys.TWITTER_MESSAGE.getKey(), twitterMessage });

        runtimeService.startProcessInstanceByKey(ProcessKeys.TWITTER_PROCESS.getKey(), variables);
    }

}
