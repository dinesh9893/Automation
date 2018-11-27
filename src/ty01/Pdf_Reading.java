package ty01;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;

public class Pdf_Reading {
	@Test
	public static void main(String[] args) {
	
		try {
			PDDocument doc = PDDocument.load(new File("sample.pdf"));
			if(!doc.isEncrypted()) {
				PDFTextStripper stp = new PDFTextStripper();
			    String AllText = stp.getText(doc);
			    String lines[] = AllText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }
			}
		}
		 catch(Exception e){
		 }
		}
	}


