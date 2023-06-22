package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Bookshell;
import utils.DBUtil;

/**
 * Servlet implementation class ReadBookServlet
 */
@WebServlet("/ReadBookServlet")
public class ReadBookServlet extends HttpServlet {  //本の一覧を表示するサーブレット = ホーム画面

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadBookServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Bookshell> books = em.createNamedQuery("getAllBooks", Bookshell.class).getResultList();
        response.getWriter().append(Integer.valueOf(books.size()).toString());
        int bookCount = books.size();
        String bookCountString;

        if (bookCount < 0) {
            bookCountString = "Invalid count";
        } else {
            bookCountString = String.valueOf(bookCount);
        }

        response.getWriter().append(bookCountString);


        em.close();

        request.setAttribute("books", books);

        // フラッシュメッセージがセッションスコープにセットされていたら
        // リクエストスコープに保存する（セッションスコープからは削除）
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/index.jsp");
        rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
