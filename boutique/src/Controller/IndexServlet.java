package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Categorie;
import Model.Produit;
import Repository.BoutiqueManagment;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoutiqueManagment boutique = new BoutiqueManagment();
		if (request.getParameter("value") != null) {
			int id = Integer.parseInt(request.getParameter("value"));
			List<Produit> AllProduitByCategorie = boutique.getProduitByCategorie(id);
			request.setAttribute("produits", AllProduitByCategorie);
		} else {
			List<Produit> AllProduit = boutique.getAllProduit();// 7ot fi variable resulta mete3 requet
			request.setAttribute("produits", AllProduit);// stoke fi request bech teb3ath lil jsp
		}
		List<Categorie> Allcategorie = boutique.getAllCategorie();// 7ot fi variable resulta mete3 requet
		request.setAttribute("categories", Allcategorie);// stoke fi request bech teb3ath lil jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);// teb3th fi jsp

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
