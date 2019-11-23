package example.hibernate.repository;

import example.hibernate.dto.IslemDTO;

public interface IslemRepository {
	
    IslemDTO getIslemDTOById(Long id);
 
    IslemDTO saveIslemDTO(IslemDTO islem);
     
    void deleteIslemDTO(IslemDTO islem);

}
