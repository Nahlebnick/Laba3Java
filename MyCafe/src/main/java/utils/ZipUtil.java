package main.java.utils;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class ZipUtil {
  public static void zipFile(String src, String zip) throws IOException
  {
	  try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip)); FileInputStream fis = new FileInputStream(src);)
	  {
	      ZipEntry entry1 = new ZipEntry(src);
	      zout.putNextEntry(entry1);
	      byte[] buffer = new byte[fis.available()];
          fis.read(buffer);
          zout.write(buffer);
          zout.closeEntry();
	  }
	  catch(Exception ex)
	  {
          System.err.print(ex.getMessage());
      } 

  }
  public static void unzip(Path zip, Path dstDir) throws IOException
  {
	  try (ZipInputStream is = new ZipInputStream(Files.newInputStream(zip)))
	  {
	      ZipEntry e;
	      while((e=is.getNextEntry())!=null)
	      {
	    	  Path f=dstDir.resolve(e.getName());
	    	  Files.copy(is,f,StandardCopyOption.REPLACE_EXISTING);
	    	  is.closeEntry();
	      }
	  }
  }
}
