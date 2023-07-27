package com.eliteprofessional.cmpc.runners;


import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import com.eliteprofesional.cmpc.utils.BeforeSuite;
import com.eliteprofesional.cmpc.utils.DataToFeature;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@MEXFDHC7",
        glue = "com.eliteprofessional.cmpc.stepDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class pedidoExcelMEXFDHC7Runner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
