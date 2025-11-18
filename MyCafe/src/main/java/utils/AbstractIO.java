package main.java.utils;
import main.java.model.*;
import java.util.*;

public interface AbstractIO
{
	List<AbstractItem> readAll(String path);
	void writeAll(String path, List<AbstractItem> list);
}
