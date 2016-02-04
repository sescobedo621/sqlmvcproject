package JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class StatesDAO {
	private ArrayList<String> abbrev;
	@Autowired
	private ApplicationContext ac;
	private static final String FILE_NAME = "/WEB-INF/states.csv";

	public void initStates()
	{
		
		abbrev = new ArrayList<>();
		try (InputStream is = ac.getResource(FILE_NAME).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				abbrev.add(tokens[1]);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAbbrev()
	{
		return abbrev;
	}

	public void setAbbrev(ArrayList<String> abbrev)
	{
		this.abbrev = abbrev;
	}
}
