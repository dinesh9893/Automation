package ty01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfToText {
	public static void main(String[] args) throws Exception {
		PDDocument doc = PDDocument.load(new File("sample.pdf"));
		PrintWriter writer = new PrintWriter("data.txt", "UTF-8");
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		if(!doc.isEncrypted()) {
			PDFTextStripper stp = new PDFTextStripper();
		    String lines[] = stp.getText(doc).split("\\r?\\n");
               for (String line : lines) {
               	writer.write(line+"\n");
                }
               writer.close();
               String st;
               while((st=br.readLine()) != null) {
            	   System.out.println(st);
               } 
			}
		}
	}


