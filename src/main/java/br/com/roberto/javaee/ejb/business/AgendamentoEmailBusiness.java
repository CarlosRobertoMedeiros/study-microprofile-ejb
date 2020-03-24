package br.com.roberto.javaee.ejb.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.roberto.javaee.dao.AgendamentoEmailDao;
import br.com.roberto.javaee.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao; 
	
	public List<AgendamentoEmail> listarAgendamentosEmail(){
		return agendamentoEmailDao.listarAgendamentosEmail();
		
	}
	
	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmai(agendamentoEmail);
		
	}
	

}
