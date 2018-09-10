package controllers;

import javax.servlet.http.HttpServletRequest;

import beans.Client;
import dao.ClientDao;

public class GestionConnexion extends AbstractGestion{


	public Client connectClient( HttpServletRequest request ) {
		/* Récupération des champs du formulaire */
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);

		Client client = new Client();

		/* Validation email correct */
		try {
			validationEmail(email);
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);

		/* Check existing client */
		try {
			checkNonExistingClient(email);
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		
		/* Validation mot de passe. */
		try {
			validationPassword(motDePasse);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		client.setPassword(motDePasse);
		
		try {
			checkGoodPassword(motDePasse, email);
		}
		catch (Exception e){
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		
		/* Initialisation du résultat. */
		Client clientCompletion = ClientDao.findSQL(email);
		if ( erreurs.isEmpty() ) {
			client.setFirstName(clientCompletion.getFirstName());
			client.setLastName(clientCompletion.getLastName());
			client.setBirthDate(clientCompletion.getBirthDate());
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}

		
		
		
		return client;
	}


}



