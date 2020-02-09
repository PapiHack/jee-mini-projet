package meissa.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import meissa.beans.Client;

/**
 * 
 * @author papihack
 * @since 07/02/19
 * @version 0.1.0
 * 
 *          Classe représentant le DAO de l'entité client.
 */
public class ClientManager
{
	private Connection connexion = DbManager.getInstance().getConnexion();
	private PreparedStatement statement = null;
	private ResultSet result = null;
	private String INSERT_REQUEST = "INSERT INTO client VALUES (0, ?, ?, ?, ?, ?)";
	private String UPDATE_REQUEST = "UPDATE client SET nom = ?, prenom = ?, email = ?, adresse = ?, telephone = ? WHERE id = ?";
	private String SELECT_REQUEST = "SELECT * FROM client";
	private String SELECT_CLIENT_REQUEST = "SELECT * FROM client WHERE id = ?";
	private String REMOVE_REQUEST = "DELETE FROM client WHERE id = ?";
	
	public void add(Client client)
	{
		try
		{
			this.statement = this.connexion.prepareStatement(INSERT_REQUEST);
			this.statement.setString(1, client.getNom());
			this.statement.setString(2, client.getPrenom());
			this.statement.setString(3, client.getEmail());
			this.statement.setString(4, client.getAdresse());
			this.statement.setString(5, client.getTelephone());
			this.statement.executeUpdate();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			this.free(statement, result);
		}
	}
	
	public List<Client> getAll()
	{
		List<Client> clients = new ArrayList<Client>();
		try
		{
			this.statement = this.connexion.prepareStatement(SELECT_REQUEST);
			this.result = this.statement.executeQuery();
			Client client = null;
			while (this.result.next())
			{
				client = new Client(this.result.getInt("id"), this.result.getString("nom"),
						this.result.getString("prenom"), this.result.getString("email"),
						this.result.getString("adresse"), this.result.getString("telephone"));
				clients.add(client);
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			this.free(statement, result);
		}
		return clients;
	}
	
	public Client get(int id)
	{
		Client client = null;
		try
		{
			this.statement = this.connexion.prepareStatement(SELECT_CLIENT_REQUEST);
			this.statement.setInt(1, id);
			this.result = this.statement.executeQuery();
			
			if (this.result.next())
			{
				client = new Client(this.result.getInt("id"), this.result.getString("nom"),
						this.result.getString("prenom"), this.result.getString("email"),
						this.result.getString("adresse"), this.result.getString("telephone"));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			this.free(statement, result);
		}
		return client;
	}
	
	public void update(Client client)
	{
		try
		{
			this.statement = this.connexion.prepareStatement(UPDATE_REQUEST);
			this.statement.setString(1, client.getNom());
			this.statement.setString(2, client.getPrenom());
			this.statement.setString(3, client.getEmail());
			this.statement.setString(4, client.getAdresse());
			this.statement.setString(5, client.getTelephone());
			this.statement.setInt(6, client.getId());
			this.statement.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			this.free(statement, result);
		}
		
	}
	
	public void delete(int id)
	{
		try
		{
			this.statement = this.connexion.prepareStatement(REMOVE_REQUEST);
			this.statement.setInt(1, id);
			this.statement.executeUpdate();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			this.free(statement, result);
		}
		
	}
	
	private void free(PreparedStatement st, ResultSet rs)
	{
		try
		{
			rs.close();
			st.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
