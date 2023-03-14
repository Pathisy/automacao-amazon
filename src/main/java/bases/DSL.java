package bases;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public DSL() {
		// TODO Auto-generated constructor stub
	}

	public void escreve(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
	
	public void escreve(String id_campo, String texto) {
		escreve(By.id(id_campo), texto);
	}

	public Object obterValorCampo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clicarRadio(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean isRadioMarcado(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clicarCheck(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean isCheckMarcado(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void selecionarCombo(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public Object obterValorCombo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object obterQuantidadeOpcoesCombo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean verificarOpcaoCombo(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> obterValoresCombo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clicarBotao(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object[] obterValueElemento(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clicarLink(String string) {
		// TODO Auto-generated method stub
		
	}

	public String obterTexto(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object obterTexto() {
		// TODO Auto-generated method stub
		return null;
	}

	public void escrever(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
		
	}

	public String alertaObterTextoEAceita() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object alertaObterTextoENega() {
		// TODO Auto-generated method stub
		return null;
	}

	public void alertaEscrever(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object alertaObterTexto() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object obterTexto(By tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void entraFrame(String string) {
		// TODO Auto-generated method stub
		
	}

	public void sairFrame(Object sendKeys) {
		// TODO Auto-generated method stub
		
	}


	public void sairFrame() {
		// TODO Auto-generated method stub
		
	}

	public void trocarJanela(String string) {
		// TODO Auto-generated method stub
		
	}
}
