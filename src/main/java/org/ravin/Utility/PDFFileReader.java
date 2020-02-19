package org.ravin.Utility;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PDFFileReader {

    String filePath;

    public PDFFileReader(String filePath){
        this.filePath = filePath;
    }

    private boolean isFileExists(){
        File csvFile = new File(filePath);
        return csvFile.isFile();
    }

    public void pdfFileReader() throws IOException {
        if(isFileExists()){
            PDDocument document = PDDocument.load(new File("./Files/082-400714.pdf"));
            System.out.println(document.getCurrentAccessPermission().toString());
            System.out.println(document.getDocumentInformation());
            System.out.println(document.isEncrypted());
            System.out.println(document.isAllSecurityToBeRemoved());
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(document);
            System.out.println(text);
            document.close();
        } else {
            throw new RuntimeException("File is not exists in path: "+filePath);
        }
    }

    public void parse() throws IOException {
        PdfReader reader = new PdfReader(filePath);
        PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(reader);
        TextExtractionStrategy strategy = null;
        for (int i=1; i<= reader.getNumberOfPages(); i++) {
            String text = PdfTextExtractor.getTextFromPage(reader, i, new LocationTextExtractionStrategy());
            System.out.println(text);

        }
    }
}
