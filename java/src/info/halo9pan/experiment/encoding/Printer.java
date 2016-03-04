package info.halo9pan.experiment.encoding;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Properties;

public class Printer {

	public static void main(String[] args) throws IOException {
//		System.getProperties().list(System.out);
//		printConsoles();
		printProperties();
	}
	
	private static void printConsoles(){
		System.out.println(Arrays.toString(UTF8.names));
		System.out.println(Arrays.toString(GBK.names));
		System.out.println(Arrays.toString(Big5.names));
	}

	private static void printProperties() throws IOException{
//		printInputStreamProperty("UTF8.properties");
//		printInputStreamProperty("GBK.properties");
//		printInputStreamProperty("Big5.properties");
//		printReaderProperty("UTF8.properties");
//		printReaderProperty("GBK.properties");
//		printReaderProperty("Big5.properties");
		printEncodingReaderProperty("UTF8.properties", "UTF-8");
		printEncodingReaderProperty("GBK.properties", "GBK");
		printEncodingReaderProperty("Big5.properties", "Big5");
	}

	private static void printInputStreamProperty(String file) throws IOException{
		Properties p = new Properties();
		InputStream is = Printer.class.getResourceAsStream(file);
		p.load(is);
		p.list(System.out);
	}

	private static void printReaderProperty(String file) throws IOException{
		Properties p = new Properties();
		InputStream is = Printer.class.getResourceAsStream(file);
		Reader r = new InputStreamReader(is);
		p.load(r);
		p.list(System.out);
	}

	private static void printEncodingReaderProperty(String file, String encoding) throws IOException{
		Properties p = new Properties();
		InputStream is = Printer.class.getResourceAsStream(file);
		Reader r = new InputStreamReader(is, encoding);
		p.load(r);
		p.list(System.out);
	}

}
