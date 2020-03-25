package br.com.roberto.javaee.ejb.business;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Session;
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
	
	@Resource(lookup = "java:jboss/mail/AgendamentoMailSession")
	private Session sessaoEmail;
	
	private static String EMAIL_FROM = "carlosmedeiroslima@gmail.com";
	private static String EMAIL_USER = "carlosmedeiroslima";
	private static String EMAIL_PASSWORD = "CodeGear20136$";
	
	public List<AgendamentoEmail> listarAgendamentosEmail(){
		return agendamentoEmailDao.listarAgendamentosEmail();
	}
	
	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados(){
		return agendamentoEmailDao.listarAgendamentosNaoEnviados();
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
	
	public void enviarEmail(AgendamentoEmail agendamentoEmail) {
		try {
			/*MimeMessage mensagem = new MimeMessage(sessaoEmail);
			mensagem.setFrom(sessaoEmail.getProperty(EMAIL_FROM));
			mensagem.setRecipients(Message.RecipientType.TO, agendamentoEmail.getEmail());
			mensagem.setSubject(agendamentoEmail.getAssunto());
			
			mensagem.setText(Optional.ofNullable(agendamentoEmail.getMensagem()).orElse(""));
			
			Transport.send(mensagem,
					       sessaoEmail.getProperty(EMAIL_USER),
					       sessaoEmail.getProperty(EMAIL_PASSWORD));*/
			System.out.println("Mensagem Enviada");
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	

}
