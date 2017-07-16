package main;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class DungeonquestMain {

	public static void main(String[] args) throws ParseException {
		for (String s : args){
			//System.out.println(s);
		}
		
		Options options = new Options();

		options.addOption(new Option("n", "name", true, "The name to display in the hello message"));
		options.addOption(new Option("t", "title", true, "The title of the person"));

		CommandLineParser clp = new DefaultParser();

		CommandLine cmd = clp.parse(options, args);
		
		System.out.println("Hello world!!!! " + cmd.getOptionValue('t') + " " + cmd.getOptionValue('n'));
		
		//Board b1 = new Board();
		Board b2 = new Board();
		
	}

}
