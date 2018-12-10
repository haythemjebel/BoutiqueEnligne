package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.LignePanier;
import Model.Panier;
import Model.Produit;
import Repository.BoutiqueManagment;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet("/Panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanierServlet() {
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
		int id = Integer.parseInt(request.getParameter("x"));
		Produit p = boutique.getProduitById(id);
		HttpSession session  = request.getSession();
		if((Panier)session.getAttribute("panier")== null) {
			LignePanier lp = new LignePanier(p, 1);// nisno3o ligne panier
			List<LignePanier> ListP = new ArrayList<LignePanier>();// nesni3o list de ligne paniier 
			ListP.add(lp);// nezido ligne panier fi list panier
			Panier panier = new Panier(ListP);// nesna3 panier de list panier
			session.setAttribute("panier", panier);// nisna3 session de panier
		}else {
			Panier panier =(Panier) session.getAttribute("panier");
			Boolean test = false ;
			for(LignePanier  LP : panier.getLignesPanier()) {
				if(LP.getProduit().getId()==id) {
					LP.setQuantite(LP.getQuantite()+1);
					test= true ;
				}
			}
			if(!test) {
				LignePanier lp = new LignePanier(p, 1);// nisno3o ligne panier
				List<LignePanier> ListP = new ArrayList<LignePanier>();// nesni3o list de ligne paniier 
				panier.getLignesPanier().add(lp);// nezido ligne panier fi list panier
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
