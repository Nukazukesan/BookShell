package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Bookshell;
import utils.DBUtil;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/new")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        // インスタンスを生成
        Bookshell m = new Bookshell();

        // mの各フィールドにデータを代入
        String title = "騎士団長殺し";
        m.setTitle(title);

        String content = "妻に離婚を切り出された画家の「私」は家を出て放浪の末、友人の父親宅を借りることになった。そこで、「騎士団長殺し」という日本画を見て以来、不思議な出来事に巻き込まれていく。";
        m.setContent(content);

        String author = "東野圭吾";
        m.setAuthor(author);

        String company = "新潮社";
        m.setCompany(company);

        // データベースに保存
        em.persist(m);
        em.getTransaction().commit();

        // 自動採番されたIDの値を表示
        response.getWriter().append(String.valueOf(m.getId()));

        em.close();
     }
}
