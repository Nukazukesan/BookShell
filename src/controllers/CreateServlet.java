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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();

            Bookshell m = new Bookshell();

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

            String starParam = request.getParameter("star");
            Long star = Long.parseLong(starParam);
            m.setStar(star);

            // バリデーションを実行してエラーがあったら新規登録のフォームに戻る
            List<String> errors = BookValidator.validate(m);
            if(errors.size() > 0) {
                em.close();

                // フォームに初期値を設定、さらにエラーメッセージを送る
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("book", m);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/new.jsp");
                rd.forward(request, response);
            } else {
                // データベースに保存
                em.persist(m);
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "登録が完了しました。");
                em.close();

                response.sendRedirect(request.getContextPath() + "/ReadBookServlet");
            }
        }
    }

}

