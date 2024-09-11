package mypackage.FileCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import mypackage.FileCode.*;

@Service
public class FileServiceImplementation implements FileService
{

	
	public String uploadImage(String path, MultipartFile file) 
	{
		//file name
		String name=file.getOriginalFilename();
		
		
		// to give random name to your uploaded file
		
		String randomidString=UUID.randomUUID().toString();
		String fileName1=randomidString.concat(name.substring(name.lastIndexOf(".")));
		
		
		
		
		
		//Full path
		String filePath=path+ File.separator+fileName1;
		
		//create folder if not
		File f=new File(path);
		if(f.exists())
		{
			f.mkdir();
		}
		
		//file copy
		
		
			try {
				Files.copy(file.getInputStream(), Paths.get(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		return name;
	}
	
	
}
