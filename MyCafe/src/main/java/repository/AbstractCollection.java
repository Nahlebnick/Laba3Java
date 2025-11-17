package main.java.repository;
import java.util.*;

import main.java.model.AbstractItem;

public interface AbstractCollection
{
	void add(AbstractItem elem);
	void delete(AbstractItem elem);
	AbstractItem get(UUID id);
	List<AbstractItem> getALL();
	Map<UUID, AbstractItem> getMap();
}