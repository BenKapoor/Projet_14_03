package eu.ensup.projetetudianttdd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eu.ensup.projetetudianttdd.metier.Etudiant;


public class EtudiantDAO {
	
	public ArrayList<Etudiant> listUnEtudiant(int id, Statement stm) throws SQLException {
		ArrayList<Etudiant> ArrayListUnEtudiant = new ArrayList<>();
		try {

			ResultSet res = stm.executeQuery("SELECT * FROM etudiant WHERE id = "+ id );

			while (res.next()) {
				Etudiant etudiantList = new Etudiant();
				etudiantList.setNom(res.getString("nom"));
				etudiantList.setPrenom(res.getString("prenom"));
				etudiantList.setEmail(res.getString("email"));

				ArrayListUnEtudiant.add(etudiantList);
			}

		}

		catch (Exception e) {
			String message = "Erreur lors de la requête de recherche de l'étudiants : <br/>";
		}

		return ArrayListUnEtudiant;
	}
}
