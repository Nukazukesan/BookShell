package controllers;

import java.io.IOException;

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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        // 該当のIDのメッセージ1件のみをデータベースから取得
        Bookshell m = em.find(Bookshell.class, Long.parseLong(request.getParameter("id")));

        em.close();

        // メッセージ情報とセッションIDをリクエストスコープに登録
        request.setAttribute("book", m);
        request.setAttribute("_token", request.getSession().getId());

        // メッセージIDをセッションスコープに登録
        if(m != null){
        request.getSession().setAttribute("book_id", m.getId());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/edit.jsp");
        rd.forward(request, response);
    }

}
