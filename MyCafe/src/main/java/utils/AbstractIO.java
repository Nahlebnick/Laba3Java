package main.java.utils;
import main.java.model.*;
import java.util.*;

public interface AbstractIO<T extends AbstractItem> {
	List<T> readAll(String path);
	void writeAll(String path, List<T> list);
}
