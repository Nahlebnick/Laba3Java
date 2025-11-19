package main.java.repository;

import main.java.model.AbstractItem;
import java.util.*;

public class MapCollecton implements AbstractCollection
{
	private Map<UUID, AbstractItem> map = new TreeMap<>();

	@Override
	public void add(AbstractItem elem) {
		map.put(elem.getId(), elem);	
	}

	@Override
	public void delete(AbstractItem elem) {
		if (elem != null) map.remove(elem.getId());
		
	}

	@Override
	public AbstractItem get(UUID id) {
		return map.get(id);
	}

	@Override
	public List<AbstractItem> getALL() {
		return new ArrayList<>(map.values());
	}

	@Override
	public Map<UUID, AbstractItem> getMap() {
		return Collections.unmodifiableMap(map);
	}	
}
