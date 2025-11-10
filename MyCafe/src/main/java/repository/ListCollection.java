package main.java.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import main.java.model.*;

public class ListCollection<T extends AbstractItem> implements AbstractCollection<T>
{
	private List<T> list = new ArrayList<>();
	@Override
	public void add(T elem) {
		list.add(elem);		
	}

	@Override
	public void delete(T elem) {
		list.remove(elem);		
	}

	@Override
	public T get(UUID id) {
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
	public List<T> getALL() {
		return list;
	}

}
