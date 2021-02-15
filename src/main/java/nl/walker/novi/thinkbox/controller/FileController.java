package nl.walker.novi.thinkbox.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FileController {

    @PostMapping("/uploading")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File("C:\\Users\\moira\\Downloads\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }
}