package main.java.repository;
import java.util.*;

import main.java.model.AbstractItem;

public interface AbstractCollection<T extends AbstractItem>
{
	void add(T elem);
	void delete(T elem);
	T get(UUID id);
	List<T> getALL();
	Map<UUID, T> getMap();
}
