/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionbank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author mystic
 */
public class QuestionBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	String file = "./ja_ja_naturlich.csv";
	int langCode = 2;
	BufferedReader br = null;
	BufferedWriter bw = null;
	String line;
	String separator = ";";

	try {
	    int qid = 0;
	    br = new BufferedReader(new FileReader(file));
	    bw = new BufferedWriter(new FileWriter("./output.sql"));
	    while ((line = br.readLine()) != null) {
		if (!line.equalsIgnoreCase(";;;")) {
		    String[] values = line.split(separator);
		    //System.out.println(values.length+"|"+line);
		    if (values.length > 0) {
			String question, ansA, ansB, ansC, ansD;
			question = values[0];
			qid++;
			ansA = values[2];
			line = br.readLine();
			values = line.split(separator);
			ansB = values[2];

			line = br.readLine();
			values = line.split(separator);
			ansC = values[2];

			line = br.readLine();
			values = line.split(separator);
			ansD = values[2];
		
		    //System.out.println(qid + "|" + question + "|" + ansA + "|" + ansB + "|" +ansC + "|" + ansD);
		    
		    String s1 = "INSERT INTO Translations (question, answerA, answerB, answerC, answerD, language, qId) VALUES (";
		    String s2 = s1.concat("'"+question+"', '"+ansA+"', '"+ansB+"', '"+ansC+"', '"+ansD+"', '");
		    String s3 = s2.concat(langCode+"', '"+qid+"');");
		    //String s2 = "'"+question+"', '"+ansA+"', '"+ansB+"', '"ansC+"', '"ansD; 
		    bw.write(s3, 0, s3.length());
		    bw.newLine();
		    
		    System.out.println(qid + "|" + question + "|" + ansA + "|" + ansB + "|" +ansC + "|" + ansD);
			
		}
		}
	}
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (br != null) {
		try {
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	    if (bw != null) {
		try {
		    bw.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	System.out.println("Done");
    }
	
}
