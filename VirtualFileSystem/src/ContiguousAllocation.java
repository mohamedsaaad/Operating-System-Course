
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.Vector;

public class ContiguousAllocation implements AllocationWay {
	private int blocksNumbers;
	public boolean[] blocks;
	Vector<ContStr> freePlaces=new Vector<ContStr>();
	public ContStr success;
	public ContiguousAllocation (int n)
	{
		blocksNumbers=n;
		blocks=new boolean [blocksNumbers];
		for(int i=0;i<blocksNumbers;i++)
		{
			blocks[i]=false;
		}
	}
	
	@Override
	public int getBlocksNumbers()
	{
		int counter=0;
		for(int i=0;i<blocksNumbers;i++)
			if(blocks[i]==false)
				counter++;
		return counter;
	}
	
	@Override
	public boolean checkSpace(int free) {
		success=new ContStr();
		freePlaces=new Vector<ContStr>();
		int start=0;
		int count=0;
		for(int i=0;i<blocksNumbers;i++)
		{
			if(blocks[i]==false)
			{
				count++;
			}
			else
			{
				if(count>0)
				{
					ContStr obj=new ContStr();
					obj.start=start;
					obj.count=count;
					freePlaces.addElement(obj);
				}
				start=i+1;
				count=0;
			}
		}
		if(count>0)
		{
			ContStr obj=new ContStr();
			obj.start=start;
			obj.count=count;
			freePlaces.addElement(obj);
		}
		if(freePlaces.size()!=0)
		{
			success=freePlaces.elementAt(0);
			if(freePlaces.size()>1)
			{
				for(int i=1;i<freePlaces.size();i++)
				{
					
					if(freePlaces.elementAt(i).count>success.count)
					{
						success=freePlaces.elementAt(i);
					}
				}
			}
			if(success.count>=free)
				return true;
		}
		return false;
	}
	
	@Override
	public File allocateFile(String filePath,int fileSize)
	{
		File obj=new File();
		int[] allBlocks=new int [fileSize];
		for(int i=0;i<fileSize;i++)
		{
			blocks[success.start]=true;
			allBlocks[i]=success.start;
			success.start++;
		}
		obj.setFilePath(filePath);
		obj.setAllocatedBlocks(allBlocks);
		return obj;
	}
	
	@Override
	public void deAllocateFile(File file)
	{
		int[] delBlocks = file.getAllocatedBlocks();
		for(int i=0;i<delBlocks.length;i++)
		{
			int j=delBlocks[i];
			blocks[j]=false;
		}
	}
	@Override
	public void deAllocateFolder(Directory folder) {
		if(folder.getFiles()!=null)
		{
			for(int i=0;i<folder.getFiles().size();i++)
			{
				deAllocateFile(folder.getFiles().elementAt(i));
				folder.getFiles().elementAt(i).setDeleted(true);
			}
		}
		if(folder.getSubDirectories()!=null)
		{
			for(int i=0;i<folder.getSubDirectories().size();i++)
			{
				deAllocateFolder(folder.getSubDirectories().elementAt(i));
				folder.getSubDirectories().elementAt(i).setDeleted(true);
			}
		}
	}

	@Override
	public void displayDiskStatus() {
		int freeBlocks=0;
		int allocatedBlocks=0;
		Vector<Integer> free=new Vector<Integer>();
		Vector<Integer> allocated=new Vector<Integer>();
		for(int i=0;i<blocksNumbers;i++)
		{
			if(blocks[i]==false)
			{
				freeBlocks++;
				free.addElement(i);
			}
			else
			{
				allocatedBlocks++;
				allocated.addElement(i);
			}
		}
		System.out.println("empty space: "+freeBlocks);
		System.out.println("empty blocks: "+free);
		System.out.println("Allocated space: "+allocatedBlocks);
		System.out.println("Allocated blocks: "+allocated);
	}
	
	@Override
	public void writeDirectoryStructureToFile(String jsonString) 
	{
		 
        try {
        	String filePath="C:\\Users\\Suleiman Hesham\\VirtualFileSystem\\ContiguousDirectoryStructure.txt";	
        	FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jsonString);
            bufferedWriter.close();
            System.out.println("The Directory Structure was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	@Override
	public Directory readDirectoryStructureFromFile()
	{
		String filePath="C:\\Users\\Suleiman Hesham\\VirtualFileSystem\\ContiguousDirectoryStructure.txt";
        try {
        	Directory tree=null;
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn=null;
            if(fileIn.getChannel().size()!=0)
            {
            	objectIn = new ObjectInputStream(fileIn);
                tree = (Directory) objectIn.readObject();
                objectIn.close();
            }
            System.out.println("The Object has been read from the file");
            return tree;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
}

