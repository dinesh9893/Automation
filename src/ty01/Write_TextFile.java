package ty01;

import java.io.PrintWriter;

public class Write_TextFile {

	public static void main(String[] args) throws Exception{
		PrintWriter writer = new PrintWriter("sample.txt", "UTF-8");
		writer.println("Writing in Text file");
		writer.println("Thank you.");
		writer.close();

	}

}
