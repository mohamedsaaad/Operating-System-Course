
import java.util.Scanner;

//import flexjson.JSONDeserializer;
public class FileSystem {
	static Directory rootDirectory=new Directory(); //Root
	static AllocationWay allocator;
	static Directory tempDirectory;
	static Directory tempSubDirectory;
	static String filePath="";
	static String fileName="";
	static String fSize="0";
	static int fileSize;
	private static Scanner input , commandLine;
//	--------------------------Functions---------------------------
	
	
	
	
	public static void parseCommand(String command)
	{
		int lastBackSlash=0;
		for(int i=0;i<command.length();i++)
		{
			if(command.charAt(i)!=' ')
			{
				filePath+=command.charAt(i);
			}
			else
			{
				fSize=command.substring(i+1);
				break;
			}
		}
		fileSize=Integer.parseInt(fSize);
		for(int i=0;i<filePath.length();i++)
			if(filePath.charAt(i)=='/')
				lastBackSlash=i;
		fileName=filePath.substring(lastBackSlash+1);
		filePath=filePath.substring(0,lastBackSlash+1);
	}
// 							 ----------------------------
	
	
	
	public static boolean checkPath(String path,Directory root,int level)
	{
		int levelCount=0;
		Directory obj=root;
		String srhPath="";
		for(int i=0;i<path.length();i++)
		{
			if(path.charAt(i)!='/')
			{
				srhPath+=path.charAt(i);
			}
			else
			{
				levelCount++;
				if(levelCount==level)
					break;
				else
					srhPath+='/';
			}
		}
		if(obj.getDirectoryPath().equals(srhPath))
		{
			if(path.equals(srhPath+'/'))
			{
				tempDirectory=root;
				return true;
			}
			if (obj.getSubDirectories()!=null)
			{
				int newLevel=level+1;
				for(int i=0;i<obj.getSubDirectories().size();i++)
				{
					if(!obj.getSubDirectories().elementAt(i).isDeleted())
					{
						if( checkPath(path,obj.getSubDirectories().elementAt(i),newLevel))
							return true;
					}
				}
			}
			else
			return false;
		}
		return false;
	
	}
//  					   ----------------------------
	
	
	
	public static boolean checkFileExist(Directory dir, String filePath)
	{
		if(dir.getFiles()!=null)
		{
			for(int i=0;i<dir.getFiles().size();i++)
			{
				if(!dir.getFiles().elementAt(i).isDeleted())
					if(dir.getFiles().elementAt(i).getFilePath().equals(filePath))
					{
						return true;
					}
			}
		}
		return false;
	}
	
	
	
//                         ---------------------------- 
	
	
	public static void createFile(String command)
	{
		parseCommand(command);
		if(checkPath(filePath,rootDirectory,1))
		{
			if(!checkFileExist(tempDirectory,filePath+fileName))
			{
				if(allocator.checkSpace(fileSize))
				{
					File obj=allocator.allocateFile(filePath+fileName,fileSize);
					tempDirectory.addFile(obj);
					System.out.println("File is created successffully!");
				}
				else
					System.out.println("No Enough Space!");
			}
			else
				System.out.println("there is already a file with this name in the target path!!");
		}
		else
			System.out.println("Wrong File Path!");
		filePath="";
		fileName="";
		fSize="0";
	}
// 						    ---------------------------- 
		
	
	
	public static boolean checkFolderExist(Directory dir, String folderPath)
	{
		if(dir.getSubDirectories()!=null)
		{
			for(int i=0;i<dir.getSubDirectories().size();i++)
			{
				if(!dir.getSubDirectories().elementAt(i).isDeleted())
					if(dir.getSubDirectories().elementAt(i).getDirectoryPath().equals(folderPath))
					{
						tempSubDirectory=dir.getSubDirectories().elementAt(i);
						return true;
					}
			}
		}
		return false;
	}



//							  ---------------------------- 
	
	public static void createFolder(String command)
	{
		parseCommand(command);
		if(checkPath(filePath,rootDirectory,1))
		{
			if(!checkFolderExist(tempDirectory,filePath+fileName))
			{
				Directory obj=new Directory();
				obj.setDirectoryPath(filePath+fileName);
				tempDirectory.addSubDirectory(obj);
				System.out.println("Folder is created successffully!");
			}
			else
				System.out.println("there is already a folder with this name in the target path!!");
		}
		else
			System.out.println("Wrong Folder Path!");
		filePath="";
		fileName="";
		fSize="0";
	}
	
	
	
// 						    ---------------------------- 

	
	
	public static void deleteFile(String command)
	{
		parseCommand(command);
		if(checkPath(filePath,rootDirectory,1))
		{
			if(checkFileExist(tempDirectory,filePath+fileName))
			{
				for(int i=0;i<tempDirectory.getFiles().size();i++)
				{
					if(tempDirectory.getFiles().elementAt(i).getFilePath().equals(filePath+fileName))
					{
						allocator.deAllocateFile(tempDirectory.getFiles().elementAt(i));
						tempDirectory.getFiles().elementAt(i).setDeleted(true);
					}
				}
				System.out.println("File is deleted successffully!");
			}
			else
				System.out.println("there is not a file with this name in the target path!!");
		}
		else
			System.out.println("Wrong File Path!");
		filePath="";
		fileName="";
		fSize="0";
	}

	
//						    ---------------------------- 

	
	public static void deleteFolder(String command)
	{
		parseCommand(command);
		if(checkPath(filePath,rootDirectory,1))
		{
			if(checkFolderExist(tempDirectory,filePath+fileName))
			{
				System.out.println(tempSubDirectory.getDirectoryPath());
				
				allocator.deAllocateFolder(tempSubDirectory);
				tempSubDirectory.setDeleted(true);
				System.out.println("Folder is deleted successffully!");
			}
			else
				System.out.println("there is not a folder with this name in the target path!!");
		}
		else
			System.out.println("Wrong Folder Path!");
		filePath="";
		fileName="";
		fSize="0";
	}
	
	
//						------------------------------
	
	public static void doCommand(String command)
	{
		String function="";
		for(int i=0;i<command.length();i++)
		{
			if(command.charAt(i)==' ')
			{
				command=command.substring(i+1);
				break;
			}
			else
				function+=command.charAt(i);
		}
		if(function.equals("CreateFile"))
			createFile(command);
		else if(function.equals("CreateFolder"))
			createFolder(command);
		else if(function.equals("DeleteFile"))
			deleteFile(command);
		else if(function.equals("DeleteFolder"))
			deleteFolder(command);
		else if(function.equals("DisplayDiskStatus"))
			allocator.displayDiskStatus();
		else if(function.equals("DisplayDiskStructure"))
			rootDirectory.printDirectoryStructure(1);
		else
			System.out.println("Invalid Command!!");
	}
	
	
	
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		System.out.print("Allocation Way: ");
		int op=input.nextInt();
		System.out.print("Enter Disk Size: ");
		int size=input.nextInt();
		char choice;
		while(true)
		{
			if(op==1)
			{
				allocator=new ContiguousAllocation(size);
				break;
			}
			else if(op==2)
			{
				allocator=new LinkedAllocation(size);
				break;
			}
			else if(op==3)
			{
				allocator=new IndexedAllocation(size);
				break;
			}
			else
			{
				System.out.print("again, Allocation Way(1,2,3): ");
				op=input.nextInt();
			}
		}
		System.out.println("do you want to load the last previous data?(y/n)");
		choice=input.next().toUpperCase().charAt(0);
		if(choice =='Y')
			rootDirectory=allocator.readDirectoryStructureFromFile();
		else
		{
			rootDirectory=new Directory();
			rootDirectory.setDirectoryPath("root");
		}
		if(rootDirectory==null)
		{
			rootDirectory=new Directory();
			rootDirectory.setDirectoryPath("root");
		}
		while(true)
		{
			commandLine = new Scanner(System.in);
			System.out.print("FileSystem (0 to Exit) :-> ");
			String command=commandLine.nextLine();
			if(command.charAt(0)=='0')
				break;
			doCommand(command);
		}
		String jsonString=rootDirectory.toJson();
		allocator.writeDirectoryStructureToFile(jsonString);
//		System.out.println(jsonString);
//		rootDirectory= new JSONDeserializer<Directory>().deserialize( jsonString );
//		rootDirectory.printDirectoryStructure(1);
	}
}
