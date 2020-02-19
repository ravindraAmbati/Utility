package org.ravin.Utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class UtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilityApplication.class, args);
		PDFFileReader reader = new PDFFileReader("./Files/082-400714.pdf");
		try {
			reader.pdfFileReader();
			reader.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void create(String[] args){

	}

}
