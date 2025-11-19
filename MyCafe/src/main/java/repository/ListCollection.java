package main.java.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import main.java.model.*;

public class ListCollection implements AbstractCollection
{
	private List<AbstractItem> list = new ArrayList<>();
	@Override
	public void add(AbstractItem elem) {
		list.add(elem);		
	}

	@Override
	public void delete(AbstractItem elem)
	{
		if (elem != null) list.remove(elem);		
	}

	@Override
	public AbstractItem get(UUID id) {
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getId().equals(id))
			{
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public Map<UUID, AbstractItem> getMap() {
		Map<UUID, AbstractItem> map = new TreeMap<>();
		for (AbstractItem item : list) map.put(item.getId(), item);
		return map;
	}
	
	@Override
	public List<AbstractItem> getALL() {
		return list;
	}
	
	public void sort()
	{
		Collections.sort(list);
	}

}
