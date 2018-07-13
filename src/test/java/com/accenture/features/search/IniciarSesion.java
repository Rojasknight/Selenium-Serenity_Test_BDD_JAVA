package com.accenture.features.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.accenture.tasks.Pasos;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class IniciarSesion {
	String eme ="hola";
	@Managed(driver = "chrome")
	public WebDriver driver;

	@Steps
	Pasos steps;

	@Test
	@Title("Iniciar Sesion")
	public void InicioDeSesion() throws InterruptedException {
		steps.paso1(driver);
		steps.paso2();
		steps.paso3();
	}
}