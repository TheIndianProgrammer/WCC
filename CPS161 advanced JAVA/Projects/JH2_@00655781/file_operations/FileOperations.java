package file_operations;
import java.io.*;
import java.util.*;

public class FileOperations {
	StringTokenizer parseCommand;
	
	public void delete(){
		//		code for handling the delete command
		//		Make sure you check the return code from the
		//		File delete method to print out success/failure status
		File deleteFile = null;
		String fileName = getNextToken();
		if(fileName == null)
			System.out.println("[No input given for Filename!]");
		else {
			deleteFile = new File(fileName);
			if(deleteFile.exists()) {
				deleteFile.delete();
			}
			else {
				System.out.println("[ " + fileName + " does not exist!]");
			}
		}
	}
	
	public void rename(){
		//		code for handling the rename command
		//		Make sure you check the return code from the
		//		File rename method to print out success/failure statusw
	}

	public void list(){
		// code for handling the list command
	}
	
	public void size(){
		// code for handling the size command
	}
	
	public void lastModified(){
		// code for handling the lastModified command
	}
	
	public void mkdir(){
		//		code for handling the mkdir command
		//		Make sure you check the return code from the
		//File mkdir method to print out success/failure status
	}
	
	public void createFile(){
		// code for handling the createFile command
	}

	public void printFile(){
		// code for handling the printFile command
	}

	void printUsage(){
		// process the "?" command
	}

	//		useful private routine for getting next string on the command line
	private String getNextToken(){
		if (parseCommand.hasMoreTokens()) 
			return parseCommand.nextToken();
		else
			return null;
	}

	//useful private routine for getting a File class from the next string on the command line
	private File getFile(){
		File f = null;
		String fileName = getNextToken(); 
		if (fileName == null)
			System.out.println("Missing a File name");
		else
			f = new File(fileName);
		return f;
	}

	private void printhelpcmd() {
		System.out.print("?\ndelete filename\nrename oldFilename newFilename\nsize filename\nlastModified filename\nlist dir\nprintFile filename\ncreateFile filename\nmkdir dir\nquit");
	}
	
	public boolean processCommandLine(String line){
		//		if line is not null, then setup the parseCommand StringTokenizer. Pull off the first string
		//		using getNextToken() and treat it as the "command" to be processed.
		//		It would be good to print out the command you are processing to make your output more readable.
		//		If you are using at least java 1.7, you can use a switch statement on command.
		//		Otherwise, resort to if-then-else logic. Call the appropriate routine to process the requested command:
		//		i.e. delete, rename, mkdir list, etc.
		//		return false if command is quit or the line is null, otherwise return true.
		if(line != null) {
			String cmd = getNextToken();
			switch(cmd) {
			case("?"):{
				System.out.println("Processing: ?");
			}
						
			case("createFile"):{
				System.out.println("Processing: createFile");
			}
			
			case("printFile"):{
				System.out.println("Processing: printFile");
			}
			
			case("lastModified"):{
				System.out.println("Processing: lastModified");
			}
			
			case("size"):{
				System.out.println("Processing: size");
			}
			
			case("rename"):{
				System.out.println("Processing: rename");
			}
			
			case("mkdir"):{
				System.out.println("Processing: mkdir");
			}
			
			case("delete"):{
				System.out.println("Processing: delete");
			}
			
			case("list"):{
				System.out.println("Processing: list");
			}
			
			case("quit"):{
				System.out.println("Processing: quit");
			}
			
			default:{
				System.out.println("[Invalid Command! Try again!]");
			}
			}
			return true;
		}
		else
			return false;
	}

	void processCommandFile(String commandFile) throws FileNotFoundException{
		//		Open up a scanner based on the commandFile file name. Read the commands from this file
		//		using the Scanner line by line. For each line read, call processCommandLine. Continue reading
		//		from this file as long as processCommandLine returns true and there are more lines in the file.
		//		At the end, close the Scanner.
		File cmds = new File(commandFile);
		Scanner scan = new Scanner(commandFile);
		String lineIn = null;
		while(scan.hasNextLine()) {
			lineIn = scan.nextLine();
			processCommandLine(lineIn);
		}
		if(scan != null) {
			scan.close();
		}
	}

	/*public static void main(String[] args){
		FileOperations fo= new FileOperations(); 
		for (int i=0; i < args.length; i++) {
			System.out.println("\n\n============ Processing " + args[i] +" =======================\n");
			fo.processCommandFile(args[i]);
		}
		System.out.println("Done with FileOperations");
	}*/
}