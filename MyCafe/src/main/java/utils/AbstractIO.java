package main.java.utils;
import main.java.model.*;

import java.io.File;
import java.util.*;

public interface AbstractIO
{
	List<AbstractItem> readAll(File inFile);
	void writeAll(File outFile, List<AbstractItem> list);
}
