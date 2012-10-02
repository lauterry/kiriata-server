package fr.lau.kiriata.model;

import com.google.common.base.Objects;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // marchera pas dans Oracle
	private Long id;
	
	private String code;

	private String status;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date lastWatched;

    private int rate;

    private String comment;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastWatched() {
        return lastWatched;
    }

    public void setLastWatched(Date lastWatched) {
        this.lastWatched = lastWatched;
    }

    @Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("status", status)
				.toString();
	}
	
}
