package ir.cafebabe.ninja;

import static org.junit.Assert.*;
import ir.caebabe.ninja.providers.ProcessEngineProvider;

import java.util.Properties;

import ninja.utils.NinjaProperties;

import org.activiti.engine.ProcessEngine;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;

@RunWith(MockitoJUnitRunner.class)
public class ConfigurationTest {

	@Mock
	NinjaProperties ninjaProperties;
	
	@Mock
	Logger logger;
	
	@Ignore
	@Test
	public void testDefaultConfigInitialization() {
		ProcessEngineProvider peP = new ProcessEngineProvider(logger, ninjaProperties);
		ProcessEngine processEngine = peP.get();
		assertEquals("default", processEngine.getName());
	}
	
	@Ignore
	@Test
	public void testCustomConfigInitialization() {
		//when(ninjaProperties.get("activiti.processEngineName")).thenReturn("Morteza");
		when(ninjaProperties.get("activiti.cfg.path")).thenReturn("conf/my.activiti.cfg.xml");
		ProcessEngineProvider peP = new ProcessEngineProvider(logger, ninjaProperties);
		ProcessEngine processEngine = peP.get();
		assertEquals("Morteza", processEngine.getName());
	}
	
	@Test
	public void testPropertyConfigInitialization() {
		//wrong path cause module to ignore any xml configurations
		when(ninjaProperties.get("activiti.cfg.path")).thenReturn("conf/my2.activiti.cfg.xml");
		when(ninjaProperties.get("activiti.databaseSchemaUpdate")).thenReturn("create-drop");
		when(ninjaProperties.get("activiti.jdbcUrl")).thenReturn("jdbc:h2:mem:activitiprop");
		ProcessEngineProvider peP = new ProcessEngineProvider(logger, ninjaProperties);
		ProcessEngine processEngine = peP.get();
		assertNotNull(processEngine.getName());
	}

}
