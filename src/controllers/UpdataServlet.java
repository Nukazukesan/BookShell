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
import models.validators.BookValidator;
import utils.DBUtil;

/**
 * Servlet implementation class UpdataServlet
 */
@WebServlet("/update")
public class UpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();


            // 該当のIDのメッセージ1件のみをデータベースから取得
            Bookshell m = em.find(Bookshell.class, (Long) request.getSession().getAttribute("book_id"));

            // フォームの内容を各フィールドに上書き
            String title = request.getParameter("title");
            m.setTitle(title);

            String review = request.getParameter("review");
            m.setReview(review);

            String author = request.getParameter("author");
            m.setAuthor(author);

            String company = request.getParameter("company");
            m.setCompany(company);

            String readStatus = request.getParameter("readStatus");
            m.setReadStatus(readStatus);

            String starString = request.getParameter("star");
            Long star = Long.parseLong(starString);
            m.setStar(star);

            // バリデーションを実行してエラーがあったら編集画面のフォームに戻る
            List<String> errors = BookValidator.validate(m);
            if(errors.size() > 0) {
                em.close();

                // フォームに初期値を設定、さらにエラーメッセージを送る
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("book", m);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/edit.jsp");
                rd.forward(request, response);
            } else {
            	  // データベースを更新
                em.getTransaction().begin();
                // エンティティのデータを更新
                em.merge(m);
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "更新が完了しました。");
                em.close();

                // セッションスコープ上の不要になったデータを削除
                request.getSession().removeAttribute("book_id");

                // indexページへリダイレクト
                response.sendRedirect(request.getContextPath() + "/ReadBookServlet");
            }
        }
    }
}


