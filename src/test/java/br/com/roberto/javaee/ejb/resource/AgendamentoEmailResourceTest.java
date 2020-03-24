package br.com.roberto.javaee.ejb.resource;

import javax.ejb.BeforeCompletion;

import org.mockito.MockitoAnnotations;

import br.com.roberto.javaee.ejb.business.AgendamentoEmailBusiness;

public class AgendamentoEmailResourceTest {
	
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@BeforeCompletion
	public void init(){
	    MockitoAnnotations.initMocks(this);
	    agendamentoEmailBusiness = new AgendamentoEmailBusiness(); 
	  }
	
	  
	  public boolean quandoExistiremAgendamentos(){
	    return agendamentoEmailBusiness.listarAgendamentosEmail().size()>0;  
	  }
    
	
	
	
	

}
