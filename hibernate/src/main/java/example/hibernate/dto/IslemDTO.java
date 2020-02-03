package example.hibernate.dto;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity(name = "ENT_ISLEM")
@Table(name = "ISLEM", schema = "GSS")
public class IslemDTO {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long islemSiraNo;
	
	@Column(name = "islem_id")
	private int butId;
	
	@Column(name = "aciklama")
	private String aciklama;
	
	@Column(name = "degistirme_zamani")
	private Timestamp degistirmeZamani;	
	
//	*** Use Temporal for date and time values. Above example is JDBC driver specific! ***
//	@Temporal(TemporalType.TIMESTAMP)
//	private java.util.Date degistirmeZamani2;
	
//	*** Embeddable use for Class variables ***
//	@Embedded
//	private MyClass evAdresi;
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name="postaKodu", column=@Column(name="EV_POSTA_KODU")),
//		@AttributeOverride(name="sokakNo", column=@Column(name="EV_SOKAK_NO"))
//	})
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(islemSiraNo);
		s.append("\t");
		s.append(aciklama);
		s.append("\t");
		s.append(butId);
		s.append("\t");
		s.append(degistirmeZamani);
		return s.toString();
	}
	public long getIslemSiraNo() {
		return islemSiraNo;
	}
	public void setIslemSiraNo(long islemSiraNo) {
		this.islemSiraNo = islemSiraNo;
	}	
	public int getButId() {
		return butId;
	}
	public void setButId(int butId) {
		this.butId = butId;
	}	
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}	
	public Timestamp getDegistirmeZamani() {
		return degistirmeZamani;
	}
	public void setDegistirmeZamani(Timestamp degistirmeZamani) {
		this.degistirmeZamani = degistirmeZamani;
	}
}
