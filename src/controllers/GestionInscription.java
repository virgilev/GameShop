package controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import beans.Client;

public class GestionInscription extends AbstractGestion {

	public Client getClient(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String birthDate = getValeurChamp(request, CHAMP_DATE_NAISSANCE);
		String checkmotDePasse = getValeurChamp(request, CHAMP_PASS_CHECK);

		Client client = new Client();

		/* Validation du champ email. */
		try {
			validationEmail(email);
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		client.setEmail(email);

		/* existing client */
		try {
			checkExistingClient(email);
		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}

		/* Validation du champ mot de passe. */
		try {
			validationPassword(motDePasse);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}
		client.setPassword(motDePasse);

		try {
			checkReTypePassword(motDePasse, checkmotDePasse);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASS_CHECK, e.getMessage());
		}

		try {
			checkNames(nom);
		} catch (Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		client.setLastName(nom);
		try {
			checkNames(prenom);
		} catch (Exception e) {
			erreurs.put(CHAMP_PRENOM, e.getMessage());
		}
		client.setFirstName(prenom);

		try {
			Date birth = getStringToDate(birthDate);
			checkBirthDate(birth);
		} catch (Exception e) {
			erreurs.put(CHAMP_DATE_NAISSANCE, e.getMessage());

		}
		client.setBirthDate(birthDate);

		if (erreurs.isEmpty()) {
			resultat = "Succès de l'inscription.";
		} else {
			resultat = "Echec de l'inscription";
		}
		return client;
	}

	// private boolean checkDate(Date date) {
	// Date currentDate = Calendar.getInstance().getTime();
	// if(date.after(currentDate)) {
	// return true;
	// } else {
	// return false;
	// }
	// }

	// private static Date getValeurDate(HttpServletRequest request, String
	// nomChamp) throws ParseException {
	// String valeur = request.getParameter(nomChamp);
	// if (valeur == null || valeur.trim().length() == 0) {
	// return null;
	// } else {
	// Date valeur_date = new SimpleDateFormat("yyyy-MM-dd").parse(valeur);
	// return valeur_date;
	// }
	// }

}
