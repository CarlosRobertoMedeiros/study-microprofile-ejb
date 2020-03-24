package br.com.roberto.javaee.ejb.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.roberto.javaee.dao.AgendamentoEmailDao;
import br.com.roberto.javaee.entity.AgendamentoEmail;
import br.com.roberto.javaee.excecoes.BusinessException;
import br.com.roberto.javaee.interceptor.Logger;

@Stateless
@Logger
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao; 
	
	public List<AgendamentoEmail> listarAgendamentosEmail(){
		return agendamentoEmailDao.listarAgendamentosEmail();
		
	}
	
	public void salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessException {
		
		if (!agendamentoEmailDao
				.listarAgendamentosPorEmail(agendamentoEmail.getEmail())
				.isEmpty()) {
			
			throw new BusinessException("Email já está agendado"); 
			
		}
		
		agendamentoEmail.setEnviado(false);
		agendamentoEmailDao.salvarAgendamentoEmai(agendamentoEmail);
	}
	

}
