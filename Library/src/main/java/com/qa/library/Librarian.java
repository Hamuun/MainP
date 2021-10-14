package com.qa.library;

	import java.util.List;
	import java.util.Objects;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;

	@Entity
	public class Librarian {
		@Id//PK
		@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremented
		private Integer id;
		private String name;
		private int pagenum;
		private String author;
		private int shelfnum;
		
		
		public Librarian(Integer id, String name, int pagenum, String author, int shelfnum) {
			super();
			this.id = id;
			this.name = name;
			this.pagenum = pagenum;
			this.author = author;
			this.shelfnum = shelfnum;
		}
	
		public Librarian() {//requires this for entity to make sql page
			super();
		}		
	
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPagenum() {
			return pagenum;
		}

		public void setPagenum(int pagenum) {
			this.pagenum = pagenum;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getShelfnum() {
			return shelfnum;
		}

		public void setShelfnum(int shelfnum) {
			this.shelfnum = shelfnum;
		}

		
		@Override
		public String toString() {
			return "Librarian [id=" + id + ", name=" + name + ", pagenum=" + pagenum + ", author=" + author
					+ ", shelfnum=" + shelfnum + "]";
		}


		@Override
		public int hashCode() {
			return Objects.hash(author, id, name, pagenum, shelfnum);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Librarian other = (Librarian) obj;
			return Objects.equals(author, other.author) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && pagenum == other.pagenum && shelfnum == other.shelfnum;
		}
	
		

	}

