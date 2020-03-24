package br.com.roberto.javaee.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.roberto.javaee.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

	@PersistenceContext
	private EntityManager manager;

	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return manager.createQuery("select a from AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}

	public void salvarAgendamentoEmai(AgendamentoEmail agendamentoEmail) {
		manager.persist(agendamentoEmail);
	}

}
