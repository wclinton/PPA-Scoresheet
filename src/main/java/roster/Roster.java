package roster;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class Roster {
	
	public static String ScoreSheetUrl = "http://www.ppa8ball.com/Scoresheet.pdf";

//	/** The original PDF. */
//	public static final String PDF = "src/main/resources/pdfs/Scoresheet.pdf";
	/** The resulting PDF. */
	public static final String RESULT1 = "scoresheet.pdf";

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			  ScoresheetGenerator.generateScoreSheet("Dec 10-2014",9, GetTestScoresheet(), RESULT1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	static void getFields() throws IOException, DocumentException {
//		
//		URL url = new URL(ScoreSheetUrl);
//		
//		PdfReader reader = new PdfReader(url);
//		PdfStamper stamper;
//		// preserve the reader enabling by creating a PDF in append mode (or
//		// not)
//
//		FileOutputStream outputstream = new FileOutputStream(RESULT1);
//
//		stamper = new PdfStamper(reader, outputstream);
//		AcroFields form = stamper.getAcroFields();
//
//		// fill out the fields
//
//		form.setField(DateField, "Dec 1st 2014");
//		form.setField(WeekField, "Week#");
//
//		// Home fields
//		form.setField(HomeTeamNameField, "Home Team Name");
//		form.setField(HomeTableField, "H Tbl");
//		form.setField(HomeTeamNumberField, "H#");
//
//		int i = 0;
//
//		for (String s : HomeTeamAverageFields) {
//			form.setField(s, "Home Av" + Integer.toString(i++));
//		}
//
//		i = 0;
//		for (String s : HomeTeamPlayerFields) {
//			form.setField(s, "Home Player" + Integer.toString(i++));
//		}
//
//		// Away fields
//
//		form.setField(AwayTeamNameField, "Home Team Name");
//		form.setField(AwayTableField, "H Tbl");
//		form.setField(AwayTeamNumberField, "H#");
//
//		i = 0;
//		for (String s : AwayTeamPlayerFields) {
//			form.setField(s, "Away Player" + Integer.toString(i++));
//		}
//
//		i = 0;
//		for (String s : AwayTeamAverageFields) {
//			form.setField(s, "Away Av" + Integer.toString(i++));
//		}
//
//		// form.setField("movie[0].#subform[0].title[0]", "The Misfortunates");
//		// form.setField("movie[0].#subform[0].original[0]",
//		// "De helaasheid der dingen");
//		// form.setField("movie[0].#subform[0].duration[0]", "108");
//		// form.setField("movie[0].#subform[0].year[0]", "2009");
//		// close the stamper
//		stamper.close();
//		reader.close();
//	}
//	
	
	
	static private Scoresheet GetTestScoresheet()
	{
		
		
		TeamRoster home = GetTestTeamRoster("Home Team", new String[]{"Wade", "Troy","Gerald","Sharon","Brad"},  new double[]{1.1,2.2,3.3,4.4,5.0});
		TeamRoster away = GetTestTeamRoster("Away Team", new String[]{"Neil", "John","Allen","Michelle","Frank"},  new double[]{6,7,8,9,10});
		
		Scoresheet scoresheet = new Scoresheet(home, away);
		
		return scoresheet;
	}
	
	static private TeamRoster GetTestTeamRoster(String name, String [] players, double [] averages)
	{
		TeamRoster roster = new TeamRoster();
		roster.name = name;
		
		for(int i=0;i<5;i++)
		{
			roster.players[i] = new Player(players[i],averages[i]);
		}
		
		return roster;
		
	}
	

}
