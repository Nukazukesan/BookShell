package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Bookshell;

public class BookValidator {
    // バリデーションを実行する
	public static List<String> validate(Bookshell m) {
	    List<String> errors = new ArrayList<String>();

	    String title_error = validateTitle(m.getTitle());
	    if (!title_error.equals("")) {
	        errors.add(title_error);
	    }

	    String review_error = validateReview(m.getReview());
	    if (!review_error.equals("")) {
	        errors.add(review_error);
	    }

	    String author_error = validateAuthor(m.getAuthor());
	    if (!author_error.equals("")) {
	        errors.add(author_error);
	    }

	    String company_error = validateCompany(m.getCompany());
	    if (!company_error.equals("")) {
	        errors.add(company_error);
	    }

	    String readStatus_error = validateReadStatus(m.getReadStatus());
	    if (!readStatus_error.equals("")) {
	        errors.add(readStatus_error);
	    }

	    return errors;
	}

    private static String validateTitle(String title) {
        if(title == null || title.equals("")) {
            return "タイトルを入力してください。";
        }

        return "";
    }


    private static String validateReview(String review) {
        if(review == null || review.equals("")) {
            return "レビューを入力してください。";
        }

        return "";
    }

    private static String validateAuthor(String author) {
        if(author == null || author.equals("")) {
            return "著者名を入力してください。";
        }

        return "";
    }

    private static String validateCompany(String company) {
        if(company == null || company.equals("")) {
            return "出版社を入力してください。";
        }

        return "";
    }

    private static String validateReadStatus(String readStatus) {
        if(readStatus== null || readStatus.equals("")) {
            return "読書状況を入力してください。";
        }

        return "";
      }


}