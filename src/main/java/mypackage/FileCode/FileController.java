package mypackage.FileCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.mail.handlers.message_rfc822;

import mypackage.FileCode.payload.FileResponse;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController 
{
	@Autowired
	private FileService fservice;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse>fileUpload(@RequestParam("image") MultipartFile image)
	{
		String fileName=null;
		try
		{
			fileName=this.fservice.uploadImage(path, image);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(fileName,"image is not added"),HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<FileResponse>(new FileResponse(fileName,"image is successfully added"),HttpStatus.OK);
	}

}
