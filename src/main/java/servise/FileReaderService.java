package servise;

import exeption.ReadFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class FileReaderService {
    private static final Logger LOGGER = LogManager.getLogger(FileReaderService.class);
    public  List<String> readFile(String filePath) throws ReadFileException {
        List<String> lines = new ArrayList<String>();
        Path path = Paths.get(filePath);
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            LOGGER.info("file has been read");
        }
        catch (IOException e){
            LOGGER.error("unsuccessful read of file");
            throw new ReadFileException("unsuccessful read of file",e);
        }
        return lines;
    }
}
