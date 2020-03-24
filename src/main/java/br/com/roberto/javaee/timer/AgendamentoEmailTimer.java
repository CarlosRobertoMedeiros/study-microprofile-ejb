package br.com.roberto.javaee.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

import java.util.logging.Logger;
import br.com.roberto.javaee.resource.AgendamentoEmailResource;

@Singleton
public class AgendamentoEmailTimer {
	
	private static Logger logger = Logger.getLogger(AgendamentoEmailResource.class.getName());
	
	@Schedule(hour = "*", minute = "*")
	public void enviarEmailsAgendados() {
		logger.info("Testando EJB Timer !");
	}

}
