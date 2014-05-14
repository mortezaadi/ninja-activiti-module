package ir.cafebabe.ninja;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import ir.caebabe.ninja.ActivitiConstants;
import ir.caebabe.ninja.providers.ProcessEngineProvider;

import java.io.File;
import java.io.FileNotFoundException;

import ninja.utils.NinjaProperties;

import org.activiti.engine.ProcessEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.util.ResourceUtils;

@RunWith(MockitoJUnitRunner.class)
public class NoConfigurationTest {

	@Mock
	NinjaProperties ninjaProperties;
	
	@Mock
	Logger logger;

	/**
	 * Remove/Rename default config(conf/activiti.cfg.xml) manually before running the test
	 */
	@Test
	public void testNoConfigTest() {
		//wrong path ignore any xml configs
		when(ninjaProperties.get("activiti.cfg.path")).thenReturn("asdhakjhdskjahskdaksjhd");
		ProcessEngineProvider peP = new ProcessEngineProvider(logger, ninjaProperties);
		ProcessEngine processEngine = peP.get();
		assertNotNull(processEngine);
	}

}
