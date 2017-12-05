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
	
	public static void main(String[] args)  {
		IOCalculator ui = new IOCalculator(args[0], args[1]);
		ui.ProcessFile();
		ui.pw.close();
		ui.writer.close();	
	}

	public IOCalculator(String inputfilename, String outputfilename) throws IOException{
		f = new File(inputfilename);
				input = new Scanner(inputfilename);
			writer = new FileWriter(outputfilename, true);
						pw = new PrintWriter(writer);
	}
	
	public void ProcessFile() {
		while(input.hasNext()) {
			int curr = 0;
			String[] line = ReadLine();
			for(int i = 0; i< line.length-1; i++) {
				try {
					if(i ==0 ) {
						curr = Calculate(Integer.parseInt(line[i]), Integer.parseInt(line[i+2]), line[i+1].trim());
					}
					else {
						curr = Calculate(curr, Integer.parseInt(line[i+1]), line[i].trim());
					}
				}
				catch(Exception e) {
					System.out.println("error");
				}
			}
			pw.println(curr);
		}
	}
	
	//Do not modify
	public String[] ReadLine() {
		String line = input.nextLine();
		return line.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
	}
	
	public int Calculate(int first, int second, String operator){
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
				return first * second;
		}
		return 0;
	}

}
