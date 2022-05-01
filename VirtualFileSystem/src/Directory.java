
import java.util.Vector;

import flexjson.JSONSerializer;
public class Directory { 

	private String directoryPath;
	private Vector<File> files;
	private Vector<Directory> subDirectories;
	private boolean deleted;
	public Directory()
	{
		files=null;
		subDirectories=null;
		deleted = false;
	}
	
	public void printDirectoryStructure(int level) 
	{
		int backSlashs=0;
		int lastBackSlash=-1;
		String space=new String (new char[level]).replace("\0", "   ");
		for(int i=0;i<this.directoryPath.length();i++)
		{
			if(this.directoryPath.charAt(i)=='/')
			{
				backSlashs++;
				lastBackSlash=i;
			}
		}
		if(level==1)
			System.out.println(this.directoryPath.substring(lastBackSlash+1));
		if(backSlashs==level-1)
		{
			if(this.files!=null)
			{
				for(int i=0;i<this.files.size();i++)
				{
					String filePath=this.files.elementAt(i).getFilePath();
					System.out.println(space+filePath.substring(directoryPath.length()+1));
				}
			}
			if(this.subDirectories!=null)
			{
				int newLevel=level+1;
				for(int i=0;i<this.subDirectories.size();i++)
				{
					if(!this.subDirectories.elementAt(i).isDeleted())
					{
						String directoryPath=this.subDirectories.elementAt(i).getDirectoryPath();
						System.out.println(space+"<"+directoryPath.substring(this.directoryPath.length()+1)+">");
						subDirectories.elementAt(i).printDirectoryStructure(newLevel);
					}
				}
			}
		}
	}
	public String getDirectoryPath() {
		return directoryPath;
	}
	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Vector<Directory> getSubDirectories() {
		return subDirectories;
	}
	public void setSubDirectories(Vector<Directory> subDirectories) {
		this.subDirectories = subDirectories;
	}
	public Vector<File> getFiles() {
		return files;
	}
	public void setFiles(Vector<File> files) {
		this.files = files;
	}
	public void addFile(File file )
	{
		if(this.files==null)
			this.files=new Vector<File>();
		this.files.addElement(file);
	}
	public void addSubDirectory(Directory subDirectory )
	{
		if(this.subDirectories==null)
			this.subDirectories=new Vector<Directory>();
		this.subDirectories.addElement(subDirectory);
	}
	public void deleteFile(String filePath)
	{
		for(int i=0;i<files.size();i++)
		{
			if(files.elementAt(i).getFilePath()==filePath)
			{
				files.elementAt(i).setDeleted(true);
			}
		}
	}
	public void deletSubDirectory(String dirPath )
	{
		for(int i=0;i<subDirectories.size();i++)
		{
			if(subDirectories.elementAt(i).getDirectoryPath()==dirPath)
			{
				subDirectories.elementAt(i).setDeleted(true);
			}
		}
	}
	public String toJson()
	{
		JSONSerializer serializer = new JSONSerializer();
		String json = serializer.deepSerialize(this);
		return json;
	}
}
