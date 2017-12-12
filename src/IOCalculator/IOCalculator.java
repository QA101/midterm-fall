package IOCalculator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOCalculator {
	Scanner input;
	File f;
	FileWriter writer;
	PrintWriter pw;
	
	public static void main(String[] args) throws IOException  {
		IOCalculator ui = new IOCalculator(args[0], args[1]);
		ui.ProcessFile();
		ui.pw.close();
		ui.writer.close();	
	}

	public IOCalculator(String inputfilename, String outputfilename) throws IOException{
		f = new File(inputfilename);
	    input = new Scanner(f);
		writer = new FileWriter(outputfilename, true);
		pw = new PrintWriter(writer);
	}
	
	public void ProcessFile() {
		while(input.hasNextLine()) {
			double curr = 0;
			String[] line = ReadLine();
			Boolean found_error = false;
			for(int i = 0; i< line.length-1; i+=3) {
				try {
					if(i == 0 ) {
						curr = Calculate(Double.parseDouble(line[i]), Double.parseDouble(line[i+2]), line[i+1].trim());
					}
					else {
						curr = Calculate(curr, Double.parseDouble(line[i+1]), line[i].trim());
					}
					if(i>=3) {
						i-=1;
					}
				}
				catch(Exception e) {
					pw.println("error");
					found_error = true;
					break;
				}
			}
			if(!found_error) {
				pw.println(curr);
			}

		}
	}
	
	//Do not modify
	public String[] ReadLine() {
		String line = input.nextLine();
		return line.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
	}
	
	public double Calculate(double first, double second, String operator) throws Exception{
		switch(operator) {
			case "+":
				return first + second;
			case "/":
				return first / second;
			case "-":
				return first - second;
			case "*":
				return first * second;
			case "^":
				return Math.pow(first, second);
			default:
				throw new Exception();
		}
		
	}

}
