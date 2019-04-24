package com.excilys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company{
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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

		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}

	public static class CompanyBuilder{
		private Long id;
		private String name;

		public CompanyBuilder() {
			id = null;
			name = null;
		}

		public CompanyBuilder id(long id) {
			this.id = id;
			return this;
		}

		public CompanyBuilder name(String name) {
			if(name != null)
				this.name = name;
			else this.name = "";
			return this;
		}

		public Company build() {
			Company comp = new Company();
			comp.id = id;
			comp.name = name;

			return comp;
		}
	}
}
