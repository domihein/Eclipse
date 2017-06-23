package de.tuberlin.snet.prog2.ue10.dataanalyst;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import de.tuberlin.snet.prog2.ue10.dataanalyst.CSVDataEntry;


/**
 * class containing the main method that runs CSVManager
 *
 */
public class CSVMain {

	/**
	 * main method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		CSVManager csvManager = new CSVManager("resources/EWR_Ortsteile_Berlin_2015.csv");
		ArrayList<CSVDataEntry> csvData = new ArrayList<CSVDataEntry>();
		try {
			csvData = csvManager.readCSV();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stream<CSVDataEntry> streamDataset = csvManager.getDatasetStream();

		Predicate<CSVDataEntry> alleKinder = s -> s.getStaatsangeh().matches("A|D") && s.getAltersgruppe().matches("05_10|10_15|15_20");
		
		Predicate<CSVDataEntry> auslaender = s -> s.getStaatsangeh().equals("A") && s.getAltersgruppe().matches("05_10|10_15|15_20");
		
		Predicate<CSVDataEntry> alle = s -> s.getStaatsangeh().matches("A|D");
		
		sprachSchule(csvManager, streamDataset, alleKinder);
//		sprachSchule(csvManager, stream, auslaender);
//		sprachSchule(csvManager, streamDataset, alle);
		
	}
	
	public static void sprachSchule(CSVManager csvManager, Stream<CSVDataEntry> oldStream, Predicate<CSVDataEntry> predi) throws IOException {
		
		String stream = oldStream
				.filter(predi)
				.collect(Collectors.groupingBy(CSVDataEntry::getOrtsname, Collectors.summingDouble(CSVDataEntry::getHauefigkeit)))
				.entrySet()
				.stream()	
				.reduce((s1,s2) -> (s1.getValue() > s2.getValue()) ? s1:s2).get().getKey();
		
		System.out.println(stream);
	}
}
