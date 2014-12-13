package roster;

import java.io.IOException;
import java.util.List;
import com.itextpdf.text.DocumentException;

public class Roster
{
	public static String ScoreSheetUrl = "http://www.ppa8ball.com/Scoresheet.pdf";

	/** The resulting PDF. */
	public static final String RESULT1 = "scoresheet.pdf";

	public static void main(String[] args)
	{

		try
		{
			Stats s = new Stats();

			s.load();

			TeamStat homeTeamStat = s.getTeam(4);
			List<PlayerStat> homePlayersStat = s.getPlayerStat(4);

			TeamStat awayTeamStat = s.getTeam(5);

			TeamRoster teamRoster = new TeamRoster(homeTeamStat, homePlayersStat);

			TeamRoster awayRoster = new TeamRoster(awayTeamStat);

			Scoresheet scoresheet = new Scoresheet(teamRoster, awayRoster);

			ScoresheetGenerator.generateScoreSheet("Dec 10-2014", 9, scoresheet, RESULT1);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	static private Scoresheet GetTestScoresheet()
//	{
//
//		TeamRoster home = GetTestTeamRoster("Home Team", new String[]
//		{ "Wade", "Troy", "Gerald", "Sharon", "Brad" }, new double[]
//		{ 1.1, 2.2, 3.3, 4.4, 5.0 });
//		TeamRoster away = GetTestTeamRoster("Away Team", new String[]
//		{ "Neil", "John", "Allen", "Michelle", "Frank" }, new double[]
//		{ 6, 7, 8, 9, 10 });
//
//		Scoresheet scoresheet = new Scoresheet(home, away);
//
//		return scoresheet;
//	}

//	static private TeamRoster GetTestTeamRoster(String name, String[] players, double[] averages)
//	{
//		TeamRoster roster = new TeamRoster();
//		roster.name = name;
//
//		for (int i = 0; i < 5; i++)
//		{
//			roster.players[i] = new Player(players[i], averages[i]);
//		}
//
//		return roster;
//	}
}
