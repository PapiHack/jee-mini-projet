package meissa.metier;

import java.util.HashMap;

import meissa.beans.Client;

/**
 * 
 * @author papihack
 * @since 08/02/19
 * @version 0.1.0
 *
 *          Classe permettant de valider les données d'une instance de la classe
 *          client.
 */
public class ClientValidator
{
	private Client client;
	private HashMap<String, String> result = new HashMap<String, String>();
	private final String STRING_PATTERN = "[A-Za-zéèöôîï]{2,}";
	private final String ADRESSE_PATTERN = "[A-Za-zéèöôîï\\.\\-,]{2,}";
	private final String EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
	private final String TELEPHONE_PATTERN = "[0-9]+";
	
	public ClientValidator(Client client)
	{
		this.client = client;
	}
	
	public Client getClient()
	{
		return client;
	}
	
	public HashMap<String, String> validate()
	{
		this.validateOtherTextInput();
		if (!this.isValidEmail())
		{
			this.result.put("email", "Veuillez saisir une adresse email valide svp.");
		}
		if (!this.isValidTelephone())
		{
			this.result.put("telephone", "Le numéro de téléphone doit comporter que des chiffres.");
		}
		if (this.isClientEmpty())
		{
			this.result.put("vide", "Veuillez remplir tous les champs svp.");
		}
		return this.result;
	}
	
	public void setClient(Client client)
	{
		this.client = client;
	}
	
	private boolean isValidTelephone()
	{
		return this.removeSpaces(client.getTelephone().trim()).matches(TELEPHONE_PATTERN);
	}
	
	private boolean isValidEmail()
	{
		return client.getEmail().matches(EMAIL_PATTERN);
	}
	
	private void validateOtherTextInput()
	{
		if (!this.removeSpaces(this.client.getNom().trim()).matches(STRING_PATTERN))
		{
			this.result.put("nom", "Le nom doit comporter au minimum deux (2) caractères.");
		}
		if (!this.removeSpaces(this.client.getPrenom().trim()).matches(STRING_PATTERN))
		{
			this.result.put("prenom", "Le prénom doit comporter au minimum deux (2) caractères.");
		}
		if (!this.removeSpaces(this.client.getAdresse().trim()).matches(ADRESSE_PATTERN))
		{
			this.result.put("adresse", "L'adresse doit comporter au minimum deux (2) caractères.");
		}
		
	}
	
	private boolean isClientEmpty()
	{
		if (this.client.getNom().isEmpty() || this.client.getPrenom().isEmpty())
		{
			if (this.client.getEmail().isEmpty() || this.client.getAdresse().isEmpty())
			{
				if (this.client.getTelephone().isEmpty())
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private String removeSpaces(String in)
	{
		return in.replaceAll(" ", "");
	}
}
