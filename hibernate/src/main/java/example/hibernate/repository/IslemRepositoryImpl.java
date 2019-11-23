package example.hibernate.repository;

import javax.persistence.EntityManager;

import example.hibernate.dto.IslemDTO;

public class IslemRepositoryImpl implements IslemRepository{

	private EntityManager em;
    
    public IslemRepositoryImpl(EntityManager em) {
        this.em = em;
    }
     
    @Override
    public IslemDTO getIslemDTOById(Long id) {
        return em.find(IslemDTO.class, id);
    }
 
    @Override
    public IslemDTO saveIslemDTO(IslemDTO b) {
        if (b.getIslemSiraNo() == 0) {
            em.persist(b);
        } else {
            b = em.merge(b);
        }
        return b;
    }
 
    @Override
    public void deleteIslemDTO(IslemDTO b) {
        if (em.contains(b)) {
            em.remove(b);
        } else {
            em.merge(b);
        }
    }

}