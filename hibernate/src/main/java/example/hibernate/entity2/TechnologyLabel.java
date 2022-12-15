package example.hibernate.entity2;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TechnologyLabel {
	
	@Id
    @GeneratedValue
    @Column(updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;
	
	private String userName;
	
	@ManyToOne
    @JoinColumn(name = "technology_id")
    private Technology technology;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
