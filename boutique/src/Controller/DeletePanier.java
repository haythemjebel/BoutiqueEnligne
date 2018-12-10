package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.LignePanier;
import Model.Panier;
import Repository.BoutiqueManagment;

/**
 * Servlet implementation class DeletePanier
 */
@WebServlet("/DeletePanier")
public class DeletePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		int id = Integer.parseInt(request.getParameter("id"));
		/*for (LignePanier LP : panier.getLignesPanier()) {
			if (LP.getProduit().getId() == id) {
				if (LP.getQuantite() > 1) {
					LP.setQuantite(LP.getQuantite()-1);
				}else {
					panier.getLignesPanier().remove(LP);
				}
			}
		}*/
		for(int i =0; i<panier.getLignesPanier().size();i++) {
			if (panier.getLignesPanier().get(i).getProduit().getId() == id) {
				if (panier.getLignesPanier().get(i).getQuantite() > 1) {
					panier.getLignesPanier().get(i).setQuantite(panier.getLignesPanier().get(i).getQuantite()-1);
				}else {
					panier.getLignesPanier().remove(panier.getLignesPanier().get(i));
				}
			}
		}
		response.sendRedirect("panier.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
