package de.exxeta.vortraege.bpm.tests;

import static org.junit.Assert.assertEquals;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.test.Deployment;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/process/activiti-context.xml")
public class HelloWorldUnitTest {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(HelloWorldUnitTest.class);
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Before
	public void printSomeDebugInformation(){
		LOG.info("About to print some debug information");
		for(ProcessDefinition processDefinition: repositoryService.createProcessDefinitionQuery().list()){
			LOG.info("Found the process with the id: "+processDefinition.getId());
		}
	}
	
	
	@Test
	@Deployment
	public void test(){
		
		runtimeService.startProcessInstanceByKey("helloWorld");
		assertEquals(0, runtimeService.createProcessInstanceQuery().count());
	}

}
