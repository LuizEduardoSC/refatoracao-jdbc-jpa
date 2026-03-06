package br.com.eduardo.dao.jpa;

import br.com.eduardo.dao.generic.jpa.GenericJpaDAO;
import br.com.eduardo.domain.jpa.ClienteJpa;

/**
 * @author luizeduardo
 *
 */
public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}


