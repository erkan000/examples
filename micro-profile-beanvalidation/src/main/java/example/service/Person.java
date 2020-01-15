package example.service;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
 
public class Person {
 
    @NotNull(message = "Name cannot be null")
    private String name;
 
    @Positive
    @Min(value = -10, message = "Min age is -10")
    @Max(value = 100, message = "Max age is 100")
    private int age;
    
    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 3, max = 320, message = "Cv must be between 10 and 200 characters long")
    private String cv;
    
    @NotNull
    @Pattern(regexp = "[0-9]_[0-9][a-z]")
    private String licenceNumber;		// 	"licenceNumber":"1_2a"
    
    @NotBlank
    @Digits(fraction = 0, integer = 2)
    private String serialNumber;	// 	"serialNumber":"99"
    
    @PastOrPresent
    private Date birthDate;		// 	"birthDate":"2019-12-23T15:01:19.622Z"
    
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
    private BigDecimal weight;	// "weight":375.12

    @AssertTrue
    private boolean valid;	// 	"valid":true

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
