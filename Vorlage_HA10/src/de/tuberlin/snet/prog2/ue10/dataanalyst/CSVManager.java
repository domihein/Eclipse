package de.tuberlin.snet.prog2.ue10.dataanalyst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import de.tuberlin.snet.prog2.ue10.dataanalyst.CSVDataEntry;

/**
 * CSVManager manages reading and writing to a csv gile
 *
 */
public class CSVManager {

	/** csvFile */
	File csvFile;
	/** ArrayList of CSVDataEntry */
	ArrayList<CSVDataEntry> dataset;

	/**
	 * constructor
	 * 
	 * @param path
	 *            - path to csvFile
	 */
	public CSVManager(String path) {
		csvFile = new File(path);
		dataset = new ArrayList<CSVDataEntry>();
	}

	/**
	 * readCSV reads a csvFile and stores data in ArrayList
	 * 
	 * @return ArrayList of CSVDataEntry after reading all lines
	 * @throws IOException
	 */
	public ArrayList<CSVDataEntry> readCSV() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(csvFile));
		String line;
		reader.readLine(); // remove the headerline
		while ((line = reader.readLine()) != null) {
			dataset.add(new CSVDataEntry(line));
		}
		reader.close();
		return dataset;
	}

	/**
	 * writeDatatoCSV file writes Data from ArrayLIst csvData to a csv File with
	 * path path
	 * 
	 * @param csvData
	 *            - csvData as ArrayList
	 * @param path
	 *            - path to csv file where data are stored
	 * @throws IOException
	 */
	public void writeDataToCSV(ArrayList<CSVDataEntry> csvData, String path) throws IOException {
		File writeFile = new File(path);
		FileWriter writer = new FileWriter(writeFile);

		for (CSVDataEntry data : csvData) {

			writer.append(data.toCSVFormat(";"));
			writer.append('\n');

		}

		writer.flush();
		writer.close();
	}

	/**
	 * returns the CSVDataEntry of an CSVManager instance
	 * 
	 * @return ArrayList with CSVDataEntry
	 */
	public ArrayList<CSVDataEntry> getDatasetArrayList() {
		return !dataset.isEmpty() ? dataset : null;
	}

	/**
	 * 
	 * @return Stream with CSVDataEntry
	 */
	public Stream<CSVDataEntry> getDatasetStream() {
		return dataset.stream();
	}

	

}
