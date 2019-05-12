package dataUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Utility class that compress user data.
 */
public final class Compressor {

    private static final Logger logger = Logger.getLogger(Compressor.class.getName());

    public static void compress(File source, File destination) {

        try {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");

            logger.info("Compressing into: " + destination.getAbsolutePath());
            Path path = Paths.get(destination.getPath());

            URI uri = URI.create("jar:" + path.toUri());

            try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {

                Path externalDataFile = Paths.get(source.getPath());
                logger.info(externalDataFile + " is compressing");

                Path pathInZipfile = zipfs.getPath("/" + source.getName());

                Files.copy(externalDataFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);

                logger.info(pathInZipfile + " is compressed!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
