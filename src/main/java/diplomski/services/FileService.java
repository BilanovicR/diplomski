package diplomski.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import diplomski.models.Student;

@Service
public class FileService {
	
public String defaultStudentImageURL = "images/student_images/default.png";
private String imagesFolderPath = "images/student_images/";
private String folderFullPath = "src/main/resources/images/student_images/";	

	public String saveProfileImage(MultipartFile file, String fileName, Student student) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
	    
	    String fileURL = "";
	    String extension = "";
	    
		if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg"))) {
			extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			fileURL = String.join("", imagesFolderPath,fileName, extension);
			File convertFile = new File(folderFullPath + fileName + extension);
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();			
		}

		return fileURL;
	}

}
