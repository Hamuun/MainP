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
		private int pageNum;
		private String author;
		private int shelfNum;
		
		
		public Librarian(Integer id, String name, int pageNum, String author, int shelfNum) {
			super();
			this.id = id;
			this.name = name;
			this.pageNum = pageNum;
			this.author = author;
			this.shelfNum = shelfNum;
		}
	
		public Librarian() {//requires this for entity to make sql page
			super();
		}
		
		
		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getShelfNum() {
			return shelfNum;
		}

		public void setShelfNum(int shelfNum) {
			this.shelfNum = shelfNum;
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
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		
		@Override
		public String toString() {
			return "Librarian [id=" + id + ", name=" + name + ", pageNum=" + pageNum + ", author=" + author
					+ ", shelfNum=" + shelfNum + "]";
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(author, id, name, pageNum, shelfNum);
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
					&& Objects.equals(name, other.name) && pageNum == other.pageNum && shelfNum == other.shelfNum;
		}
		
		

	}

