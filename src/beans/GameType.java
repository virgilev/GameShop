package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="GAME_TYPE")
public class GameType implements Serializable {
	
	@Id
	@Column(name="pk_name")
	private String game;
	
	@Id
	@Column(name="fk_type")
	private String type;
	
	public GameType() {
		
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
