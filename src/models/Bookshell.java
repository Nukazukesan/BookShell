package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "books")

public class Bookshell {
	    @Id // 主キー属性を示すアノテーション
		@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー値の生成方法を指定
	    @Column(name = "id")
		private Long id;

	    @Column(name = "title", length = 255, nullable = false)
	    private String title;

	    @Column(name = "review", length = 255, nullable = false)
	    private String review;

	    @Column(name = "author", nullable = false)
	    private String author;

	    @Column(name = "company", nullable = false)
	    private String company;


	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getReview() {
	        return review;
	    }

		public void setReview(String review) {
			this.review = review;
		}

	    public void setContent(String review) {
	        this.review = review;
	    }

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		 public Long getId() {
		    return id;
		    }

		 public void setId(Long id) {
		    this.id = id;
		    }
	}

