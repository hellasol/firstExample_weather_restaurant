package ch.zhaw.gpi.csbtemplate.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named("PublishLightDelegate")
public class PublishLightMenuDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution e) throws Exception {
        Path src = Paths.get("src/main/resources/lightMenu.html");
        Path dst = Paths.get("target/classes/static/menu.html");
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);        
    }

}