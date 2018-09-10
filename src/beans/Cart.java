package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Cart implements Serializable {
	
	@Id
	@GeneratedValue
    @Column(name="pk_id")
	private int id;
	
	private List<Game> games;
	
	public Cart() {
		this.games = new ArrayList<Game>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Game> getGames(){
		return games;
	}
	public void addGame(Game game){
		games.add(game);
	}
	public void removeGame(Game game){
		int index = -1;
		for(int i=0; i<this.games.size(); i++) 
		{
			if (this.games.get(i).getTitle().equals(game.getTitle()) && this.games.get(i).getConsole().equals(game.getConsole()))
			{
				index = i;
			}
		}
		if(index != -1)
		{
			games.remove(index);
		}
	}
	 
}
