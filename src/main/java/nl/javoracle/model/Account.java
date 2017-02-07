package nl.javoracle.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import nl.javoracle.model.Person;

@Entity
@Table(name="account", 
	uniqueConstraints=@UniqueConstraint(columnNames={"person_id"})
)

public class Account {
	
	@Id
	@GeneratedValue
	@Column(name = "account_id", unique = true, nullable = false)
	private long accountId;
	
	@OneToOne()
	@JoinColumn(name="person_id")
	private Person person;

	// Not used yet //
	//private int role;
	//private long userSetting;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
