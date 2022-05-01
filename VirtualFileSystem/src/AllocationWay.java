
public interface AllocationWay {
	boolean checkSpace(int free);
	File allocateFile(String filePath,int fileSize);
	void deAllocateFile(File file);
	void deAllocateFolder(Directory folder);
	public int getBlocksNumbers();
	public void displayDiskStatus();
	public void writeDirectoryStructureToFile(String jsonString);
	public Directory readDirectoryStructureFromFile();
}
