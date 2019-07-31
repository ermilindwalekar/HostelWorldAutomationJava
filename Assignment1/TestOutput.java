import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

class OutputValidator{

    public void testFile(String fileName) throws IOException {
    	BufferedReader br = null;
    	try {
	    	br = new BufferedReader(new FileReader(fileName));
	    	int lineCounter = 1;
	    	
	        String line = br.readLine();
	        
	        while (line != null) {
	        	System.out.println("Line Number" + lineCounter);
	        	validateExcessTab(line, lineCounter);
	        	validateSerialNumberOutofRange(line, lineCounter);
	        	validateRandomNumberOutofRange(line, lineCounter);
	            line = br.readLine();
	            lineCounter++;
	            System.out.println();
	        }
	    }
	    finally {
    		br.close();
    	}
    }
    
    private static void validateExcessTab(String line, int lineCounter){
        String[] parts = line.split("\\t");
        if (parts.length != 2) {
            System.out.println("TestCase 1: Fail\n" + "Line " + lineCounter + ": Excess/No tabs found");
        }
        else {
        	System.out.println("TestCase 1: Pass");
        }
    }
    
   private static void validateSerialNumberOutofRange(String line, int lineCounter){
	   String[] parts = line.split("\\t");
	   try {
            Integer serial = Integer.valueOf(parts[0]);
            if (serial < 0 || serial > 50) {
            	System.out.println("TestCase 2: Fail\n" + "Line " + lineCounter + ": Serial number " + parts[0] + " is not in range 1 to 50");
            }
            else {
            	System.out.println("TestCase 2: Pass");
            }
        } catch (NumberFormatException e) {
        	System.out.println("TestCase 2: Fail\n" + "Line " + lineCounter + ": Serial number " + parts[0] + " is not a valid number");
        }
	   	catch (ArrayIndexOutOfBoundsException e) {
	   		System.out.println("TestCase 2: Fail\n" + "Line " + lineCounter + ": Serial number missing");
       }
    }
        
   private static void validateRandomNumberOutofRange(String line, int lineCounter){
	   String[] parts = line.split("\\t");
        try {
            Integer randomNumber = Integer.valueOf(parts[1]);
            if (randomNumber < 0 || randomNumber > 500) {
            	System.out.println("TestCase 3: Fail\n" + "Line " + lineCounter + ": Random number " + parts[1] + " is not in range 1 to 500");
            }
            else {
            	System.out.println("TestCase 3: Pass");
            }
        } catch (NumberFormatException e) {
        	System.out.println("TestCase 3: Fail\n" + "Line " + lineCounter + ": Random number " + parts[1] + " is not a valid number");
        }
        catch (ArrayIndexOutOfBoundsException e) {
	   		System.out.println("TestCase 3: Fail\n" + "Line " + lineCounter + ": Random number missing");
       }
    }
    
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } 
        finally {
            is.close();
        }
    } 
}

public class TestOutput{
	public static void main(String[] args) {
		int numLines;
		if(args.length == 1 ) {
			try {
				numLines = OutputValidator.countLines(args[0]);
				if(numLines > 50) {
					System.out.println("More than 50 lines present in file");
					return;
				}
				OutputValidator ovdtr = new OutputValidator();
				ovdtr.testFile(args[0]);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		else {
			System.out.println("USAGE:\n TestOutput <filename>.<file fomrat>");
			return;
		}
	}
}
