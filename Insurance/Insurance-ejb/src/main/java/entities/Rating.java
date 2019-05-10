package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Rating")
public class Rating implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Rating_ID")
	private int rating_id;

	private Integer rating1;   
    private Integer rating2;   
    private Integer rating3;   
    private Integer rating4;
	
    
    public Rating(){}
    
	public Rating(Integer rating1, Integer rating2, Integer rating3, Integer rating4) {
		super();
		this.rating1 = rating1;
		this.rating2 = rating2;
		this.rating3 = rating3;
		this.rating4 = rating4;
	}




	public int getRating_id() {
		return rating_id;
	}

	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}

	public Integer getRating1() {
		return rating1;
	}

	public void setRating1(Integer rating1) {
		this.rating1 = rating1;
	}

	public Integer getRating2() {
		return rating2;
	}

	public void setRating2(Integer rating2) {
		this.rating2 = rating2;
	}

	public Integer getRating3() {
		return rating3;
	}

	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
	}

	public Integer getRating4() {
		return rating4;
	}

	public void setRating4(Integer rating4) {
		this.rating4 = rating4;
	}
    
    
    
}
