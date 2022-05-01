import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.Vector;

public class IndexedAllocation implements AllocationWay {
	private int blocksNumbers;
	public IndexedStr[] blocks;
	public Vector<Integer> success;
	public IndexedAllocation (int n)
	{
		blocksNumbers=n;
		blocks=new IndexedStr [blocksNumbers];
		for(int i=0;i<blocksNumbers;i++)
			blocks[i]=new IndexedStr();
	}
	
	@Override
	public int getBlocksNumbers()
	{
		int counter=0;
		for(int i=0;i<blocksNumbers;i++)
			if(blocks[i].occupied==false)
				counter++;
		return counter;
	}
	
	@Override
	public boolean checkSpace(int free) {
		success=new Vector<Integer>();
		int count=free+1;
		for(int i=0;i<blocksNumbers;i++)
		{
			if(count>0 && blocks[i].occupied==false)
			{
				count--;
			}
			if(count==0)
				break;
		}
		if(success.size()>=free+1)
			return true;

		return false;
	}

	@Override
	public File allocateFile(String filePath, int fileSize) {
		File obj=new File();
		obj.setFilePath(filePath);
		int[] allBlocks=new int [fileSize+1];
		int j;
		for(int i=0;i<fileSize+1;i++)
		{
			j=success.elementAt(i);
			blocks[j].occupied=true;
			if(i==0)
				blocks[j].otherBlocks=new Vector<Integer>();
			else
				blocks[success.elementAt(0)].otherBlocks.addElement(j);
			allBlocks[i]=j;
		}
		obj.setAllocatedBlocks(allBlocks);
		return obj;
	}

	@Override
	public void deAllocateFile(File file) {
		int[] delBlocks = file.getAllocatedBlocks();
		for(int i=0;i<delBlocks.length;i++)
		{
			int j=delBlocks[i];
			blocks[j].occupied=false;
			blocks[j].otherBlocks=null;
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
			if(blocks[i].occupied==false)
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
        	String filePath="C:\\Users\\Suleiman Hesham\\VirtualFileSystem\\IndexedDirectoryStructure.txt";	
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
		String filePath="C:\\Users\\Suleiman Hesham\\VirtualFileSystem\\IndexedDirectoryStructure.txt";
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            Directory tree = (Directory) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return tree;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
