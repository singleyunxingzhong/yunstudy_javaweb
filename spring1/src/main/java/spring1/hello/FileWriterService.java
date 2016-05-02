package spring1.hello;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("FileWriterService")
public class FileWriterService {
	@Value(value = "${filepath}")
	private String filepath;

	private FileOutputStream fs = null;

	@PostConstruct
	public void init() throws FileNotFoundException {
		this.fs = new FileOutputStream(this.filepath);
		System.out.println("文件创建：");
	}

	public void writeContent(String content) throws IOException {
		DataOutputStream ds = new DataOutputStream(this.fs);
		ds.writeUTF(content);
		ds.close();
	}

	@PreDestroy
	public void destroy() throws IOException {
		fs.close();
	}
}
