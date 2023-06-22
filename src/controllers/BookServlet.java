package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Bookshell;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/new")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {  //新規登録サーブレット
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CSRF対策
        request.setAttribute("_token", request.getSession().getId());

        // おまじないとしてのインスタンスを生成
        Bookshell book = new Bookshell();
        book.setReadStatus("wantToRead"); // デフォルト値を設定

        request.setAttribute("book", book);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/new.jsp");
        rd.forward(request, response);
     }
}
