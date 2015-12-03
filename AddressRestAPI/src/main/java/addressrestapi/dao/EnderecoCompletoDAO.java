package addressrestapi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import addressrestapi.model.EnderecoCompleto;

@Repository
public class EnderecoCompletoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(rollbackFor=Exception.class)
	public void save(EnderecoCompleto end) {
    	entityManager.persist(end);		
	}
	
	public EnderecoCompleto getByCep(String cep) {
        return (EnderecoCompleto) entityManager
        		.createQuery("FROM EnderecoCompleto e WHERE e.cep = :cep")
        		.setParameter("cep", cep).getSingleResult();
    }

}
