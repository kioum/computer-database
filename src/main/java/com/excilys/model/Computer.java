package com.excilys.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "computer")
public class Computer {
	private Long id;
	private String name;
	private Timestamp introduced;
	private Timestamp discontinued;
	private Company manufacturer;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id")
	public Company getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Company manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="introduced")
	public Timestamp getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}

	@Column(name="discontinued")
	public Timestamp getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Computer other = (Computer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced=" + introduced + ", discontinued=" + discontinued
				+ ", manufacturer=" + manufacturer + "]";
	}

	public static class ComputerBuilder{
		private Long id;
		private String name;
		private Timestamp introduced;
		private Timestamp discontinued;
		private Company manufacturer;

		public ComputerBuilder() {
			this.id = null;
			this.name = null;
			this.introduced = null;
			this.discontinued = null;
			this.manufacturer = null;
		}

		public ComputerBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public ComputerBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ComputerBuilder introduced(Timestamp introduced) {
			this.introduced = introduced;
			return this;
		}

		public ComputerBuilder discontinued(Timestamp discontinued) {
			this.discontinued = discontinued;
			return this;
		}

		public ComputerBuilder manufacturer(Company company) {
			this.manufacturer = company;
			return this;
		}

		public Computer build() {
			Computer comp = new Computer();
			comp.id = id;
			comp.name = name;
			comp.introduced = introduced;
			comp.discontinued = discontinued;
			comp.manufacturer = manufacturer;

			return comp;
		}
	}
}
