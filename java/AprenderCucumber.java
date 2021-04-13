import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AprenderCucumber {

	@Given("^Criei o arquivo corretamente$")
	public void crieiOArquivoCorretamente() throws Throwable {
	 
	}

	@When("^executá-lo$")
	public void executáLo() throws Throwable {
	 
	}

	@Then("^a especificação deve ser verificada com sucesso$")
	public void aEspecificaçãoDeveSerVerificadaComSucesso() throws Throwable {
	 
	}
	
	private int contador = 0;
	@Given("^que o valor do contador eh (\\d+)$")
	public void queOValorDoContadorEh(int arg1) throws Throwable {
		contador = arg1;
	}

	@When("^quando eu incrementar (\\d+)$")
	public void quandoEuIncrementar(int arg1) throws Throwable {
		contador += arg1;
	}

	@Then("^o valor do contador serah (\\d+)$")
	public void oValorDoContadorSerah(int arg1) throws Throwable {
	    int resultado = arg1;
	    Assert.assertEquals(contador,resultado);
	}
	
	
	Date entrega = new Date();
	
	@Given("^que an data de entrega é (\\d+/\\d+/\\d+)$")
	public void queAnDataDeEntregaEh(@Transform( DateConverter.class )Date data) throws Throwable {
		entrega = data;
	}

	@When("^quando atrasar (\\d+) (dia|dias|mes|meses)$")
	public void quandoAtrasarDias(int arg1, String periodo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		
		if ( periodo.equals("dias") ) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
		}
		
		if ( periodo.equals("meses") ) {
			cal.add(Calendar.MONTH, arg1);
		}

		entrega = cal.getTime();
	}

	@Then("^a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeraEfetuadaEm(@Transform(DateConverter.class) Date data) throws Throwable {
		assertEquals(data, entrega);
	}	

	
	@Given("que o ticket( especial)? é A.(\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
	}

	@Given("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double valor) throws Throwable {
		System.out.println(valor);
	}

	@Given("^que o nome do passageiro é \"(\\D{10,20})\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
	}

	@Given("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {
	}

	@When("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Then("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}	
	
	
	
	
}
