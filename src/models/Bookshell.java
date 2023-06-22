package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

	@Entity
	@NamedQueries({
	    @NamedQuery(
	        name = "getAllBooks",
	        query = "SELECT m FROM Bookshell AS m ORDER BY m.id DESC"
	    )
	})
	@Table(name = "books")

public class Bookshell {
	    @Id // 主キー属性を示すアノテーション
		@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー値の生成方法を指定
	    @Column(name = "id")
		private Long id;

	    @Column(name = "title", length = 255, nullable = false)
	    private String title;

	    @Column(name = "review", length = 255)
	    private String review;

	    @Column(name = "author", nullable = false)
	    private String author;

	    @Column(name = "company", nullable = false)
	    private String company;

	    @Column(name = "readStatus")
	    private String readStatus;

		@Column(name = "star")
	    private Long star;


	    public String getReadStatus() {
			return readStatus;
		}

		public void setReadStatus(String readStatus) {
			this.readStatus = readStatus;
		}

		public Long getStar() {
		    return star;
		}

		public void setStar(Long star) {
			this.star = star;
		}

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

