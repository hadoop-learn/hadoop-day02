package hdfs;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * 使用FileSystem
 * @author bling
 * 创建方法快捷键 Shit+Alt+M 
 *
 * 创建局部变量名称快捷键 Shit+Alt+L 
 */
public class App2 {
	public static final String HDFS_PATH="hdfs://hadoop:9000/hello";
	public static final String DIR_PATH = "/d100";
	public static final String FILE_PATH = "/d100/f100";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final FileSystem fileSystem =  FileSystem.get(new URI(HDFS_PATH), new Configuration());
		//创建文件夹
		makeDirectory(fileSystem);
		//上传文件
		uploadData(fileSystem);
		//下载文件
		downloadData(fileSystem);
		//删除文件（夹）
		//deleteFile(fileSystem);
	}
	private static void deleteFile(final FileSystem fileSystem)
			throws IOException {
		fileSystem.delete(new Path(FILE_PATH), true);
	}
	private static void uploadData(final FileSystem fileSystem) throws Exception{
		final FSDataOutputStream out = fileSystem.create(new Path(FILE_PATH));
		final FileInputStream in = new FileInputStream("D:/readme.txt");
		IOUtils.copyBytes(in, out, 1024, true);
		
	};
	private static void makeDirectory(final FileSystem fileSystem)throws Exception{
		fileSystem.mkdirs(new Path(DIR_PATH));
	}
	private static void downloadData(final FileSystem fileSystem)throws Exception{
		final FSDataInputStream in = fileSystem.open(new Path(FILE_PATH));
		IOUtils.copyBytes(in, System.out, 1024, true);
	}
}