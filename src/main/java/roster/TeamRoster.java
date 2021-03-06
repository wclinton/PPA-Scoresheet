package roster;

import java.util.ArrayList;
import java.util.List;

public class TeamRoster {

	public Player[] players = new Player[5];
	public String name;
	public int number;
	
	public TeamRoster()
	{
		
	}
	
	public TeamRoster(TeamStat teamStat)
	{
		this(teamStat, new ArrayList<PlayerStat>());
	}
	
	public TeamRoster(TeamStat teamStat, List<PlayerStat> playerStats)
	{
		this.name = teamStat.name;
		this.number = teamStat.number;
		
		int i=0;
		for (PlayerStat playerStat : playerStats) {
			players[i++] = new Player(playerStat);
		}
	}
}
