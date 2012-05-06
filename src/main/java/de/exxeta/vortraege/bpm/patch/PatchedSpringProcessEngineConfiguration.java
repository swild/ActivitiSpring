package de.exxeta.vortraege.bpm.patch;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.bpmn.parser.BpmnParser;
import org.activiti.engine.impl.persistence.deploy.Deployer;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatchedSpringProcessEngineConfiguration extends SpringProcessEngineConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(PatchedSpringProcessEngineConfiguration.class);

    @Override
    public ProcessEngine buildProcessEngine() {
        LOG.info("Adding our own custom BPMDeployer");
        PatchedBpmnDeployer deployer = new PatchedBpmnDeployer();

        // Initialize everything upto the deployers
        initHistoryLevel();
        initExpressionManager();
        initVariableTypes();
        initBeans();
        initFormEngines();
        initFormTypes();
        initScriptingEngines();
        initBusinessCalendarManager();
        initCommandContextFactory();
        initTransactionContextFactory();
        initCommandExecutors();
        initServices();
        initIdGenerator();

        deployer.setExpressionManager(expressionManager);
        deployer.setIdGenerator(idGenerator);
        BpmnParser bpmnParser = new BpmnParser(expressionManager);

        if (preParseListeners != null) {
            bpmnParser.getParseListeners().addAll(preParseListeners);
        }
        bpmnParser.getParseListeners().addAll(getDefaultBPMNParseListeners());
        if (postParseListeners != null) {
            bpmnParser.getParseListeners().addAll(postParseListeners);
        }

        deployer.setBpmnParser(bpmnParser);

        List<Deployer> deployerList = new ArrayList<Deployer>();
        deployerList.add(deployer);
        setCustomPostDeployers(deployerList);
        return super.buildProcessEngine();
    }
}
