package mg.tmr.khr.bara.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="`users`")
public class User {
	
	/*===============START TABLE COLUMNS===================*/
	@Id
	@Column(name = "user_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer user_id;
	
	@Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

	@Size(max = 255)
    @Column(name = "middle_name")
    private String middleName;
	
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    
    @NotBlank @Size(max = 255)
    @Column(name = "user_name",  nullable = false)
    private String userName;

    @NotBlank @Email @Size(max = 255)
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank @Size(max = 255)
    @Column(name = "password")
    private String password;
    
    @Transient
    private String passwordConfirm;
    
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    @Column(name = "created_by",  nullable = true)
    private String createdBy;
    
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    @Column(name = "updated_by",  nullable = true)
    private String updatedBy;
    
    /*-----------start relations-----------*/

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_group_id")
    private UserGroup userGroup;
    
    /*-----------end relations-----------*/
    
    /*===============END TABLE COLUMNS===================*/
    
    /*===============mutators/accessors==================*/
    
    public Integer getUserId() {
		return user_id;
	}
	public void setId(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return firstName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}