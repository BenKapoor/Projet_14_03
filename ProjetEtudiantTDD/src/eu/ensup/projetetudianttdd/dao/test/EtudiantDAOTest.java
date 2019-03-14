/**
 * 
 */
package eu.ensup.projetetudianttdd.dao.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import eu.ensup.projetetudianttdd.dao.Connexion;
import eu.ensup.projetetudianttdd.dao.EtudiantDAO;
import eu.ensup.projetetudianttdd.metier.Etudiant;

/**
 * @author benja
 *
 */
public class EtudiantDAOTest {

	private static Statement statement = null;
	private static Etudiant etudiant = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass setUpClass");
		Connexion conn = new Connexion();
		statement = conn.getConnection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRecuperationUnEtudiant() throws SQLException {
		ArrayList<Etudiant> ArrayListeUnEtudiant = new ArrayList<>();

		ResultSet res = statement.executeQuery("SELECT nom, prenom, email " + "FROM etudiant WHERE `id`= 1 ;");

		while (res.next()) {
			Etudiant EtudiantList = new Etudiant(null, null, null);
			EtudiantList.setNom(res.getString("nom"));
			EtudiantList.setPrenom(res.getString("prenom"));
			EtudiantList.setEmail(res.getString("email"));
			ArrayListeUnEtudiant.add(EtudiantList);
		}

		assertNotNull(ArrayListeUnEtudiant); // On test qu'il y'a bien un étudiant de trouvé
	}

	@Test
	public void testRecuperationAttributsEtudiant() throws SQLException {
		ArrayList<Etudiant> ArrayListeUnEtudiant = new ArrayList<>();

		ResultSet res = statement.executeQuery("SELECT nom, prenom, email " + "FROM etudiant WHERE `id`= 1 ;");

		while (res.next()) {
			Etudiant EtudiantList = new Etudiant();
			// EtudiantList.setId(Integer.parseInt(res.getInt("id")));
			EtudiantList.setNom(res.getString("nom"));
			EtudiantList.setPrenom(res.getString("prenom"));
			EtudiantList.setEmail(res.getString("email"));
			ArrayListeUnEtudiant.add(EtudiantList);
		}

		// assertEquals(ArrayListeUnEtudiant.get(0).getId(), 1);
		assertEquals(ArrayListeUnEtudiant.get(0).getNom(), "Michel"); // On check que le nom est correcte
		assertEquals(ArrayListeUnEtudiant.get(0).getPrenom(), "Jean"); // On check que le prénom est correcte
		assertEquals(ArrayListeUnEtudiant.get(0).getEmail(), "jeanmichel@gmail.com"); // On check que l'email est
																						// correcte
	}

	@Test
	public void testInsertionEtudiant() throws SQLException {
		// On créé un étudiant
		Etudiant newEtudiant = new Etudiant("azert", "azerty", "azerty");
		statement.executeUpdate("INSERT INTO etudiant(nom, prenom, email) values" + "('" + newEtudiant.getNom() + "','"
				+ newEtudiant.getPrenom() + "','" + newEtudiant.getEmail() + "');");

		// On recherche l'étudiant créé, on utilise la méthode listUnEtudiant()
		ArrayList<Etudiant> ArrayListeUnEtudiant = new ArrayList<>();
		EtudiantDAO daoEtudiant = new EtudiantDAO();
		ArrayListeUnEtudiant = daoEtudiant.listUnEtudiant(2, statement);

		assertEquals(ArrayListeUnEtudiant.get(0).getNom(), "azert"); // On check que le nom est correcte
		assertEquals(ArrayListeUnEtudiant.get(0).getPrenom(), "azerty"); // On check que le prénom est correcte
		assertEquals(ArrayListeUnEtudiant.get(0).getEmail(), "azerty"); // On check que l'email est correcte
	}

	@Test
	public void testSuppressionEtudiant() throws SQLException {
		// On recherche l'étudiant qui sera supprimé , on utilise la méthode
		// listUnEtudiant()
		ArrayList<Etudiant> ArrayEtudiant = new ArrayList<>();
		EtudiantDAO daoEtudiant = new EtudiantDAO();
		ArrayEtudiant = daoEtudiant.listUnEtudiant(19, statement);

		assertNotNull(ArrayEtudiant);

		ArrayList<Etudiant> ArrayListeSupprimer = new ArrayList<>();
		// On supprime l'utilisateur
		statement.executeUpdate("DELETE FROM `etudiant` WHERE `id`= 19 ;");	
		
		// On vérifie que l'utilisateur n'est plus présent sur la base
		assertTrue(ArrayEtudiant.isEmpty());
		

	}

}
