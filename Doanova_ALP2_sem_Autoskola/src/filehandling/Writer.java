package filehandling;

import app.Result;
import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author helen
 */
public abstract class Writer {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract void saveResults(String resultFilepath, List<Result> results) throws IOException;
}
