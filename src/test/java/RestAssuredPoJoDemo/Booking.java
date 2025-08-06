package RestAssuredPoJoDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true) for not defined variables
@JsonIgnoreProperties({"lastname","totalprice"})
public class Booking{
	@JsonProperty("firstname")
	private String firstName;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;

	//@JsonIgnore
	private String lastname;

	public String getFirstname(){
		return firstName;
	}

	public String getAdditionalneeds(){
		return additionalneeds;
	}

	public Bookingdates getBookingdates(){
		return bookingdates;
	}

	public int getTotalprice(){
		return totalprice;
	}

	public boolean isDepositpaid(){
		return depositpaid;
	}

	public String getLastname(){
		return lastname;
	}
}
