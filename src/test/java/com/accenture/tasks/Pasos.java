package com.accenture.tasks;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.matches;

import org.openqa.selenium.By;

public class Pasos {

	String usuario = "USUARIO_GMAIL";
	String contraseña = "PASSWORD_GMAIL";
	
	Excel xx = new Excel();

	public WebDriver driver;
	
	@Step("Ingresar al Login de gmail")
	public void paso1(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		this.driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		//WebElement iniciarSesion = driver.findElement(By.xpath("//*[@id='gb_70']"));
		//iniciarSesion.click();
		String resultado = driver.switchTo().activeElement().getAttribute("name");
		Thread.sleep(1000);
		assertThat(resultado, is("identifier"));

	}
	@Step("Ingresar usuario y contraseña")
	public void paso2() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("//*[@id='identifierId']"));
		user.sendKeys(usuario + "\n");
		
		WebElement pass = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
		pass.sendKeys(contraseña + "\n");
		
		Thread.sleep(1000);
		
	}
	
	@Step("Enviar Correos")
	public void paso3() throws InterruptedException {
		
		System.out.println("Metodo de lectura EXEL");
		
		for(Dato informacion: Excel.lectura()) {
			
			System.out.println(informacion.getCorreo());
			
			WebElement redactar = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
			redactar.click();
			
			
	         WebElement destino = driver.findElement(By.xpath("//textarea[@name='to']"));
	         destino.sendKeys(informacion.getCorreo());
	         
	         
	         WebElement asunto = driver.findElement(By.xpath("//input[@name='subjectbox']"));
	         asunto.sendKeys("example@gmail.com \n");
	       
	         WebElement enviar = driver.findElement(By.xpath("//*[text()='Enviar']"));
	         enviar.click();
	         
			
		
			System.out.println("------- correo enviado a :"+ informacion.getCorreo());
			
		}
		
	}
}







