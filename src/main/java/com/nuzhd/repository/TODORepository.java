package com.nuzhd.repository;

import com.nuzhd.model.TODO;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TODORepository implements CommonRepository<TODO> {

    private Map<String, TODO> toDos = new HashMap<>();

    @Override
    public TODO save(TODO domain) {
        TODO result = toDos.get(domain.getId());
        if (result != null) {
            result.setModified(LocalDateTime.now());
            result.setDescription(domain.getDescription());
            result.setCompleted(domain.isCompleted());
            domain = result;
        }
        toDos.put(domain.getId(), domain);
        return toDos.get(domain.getId());
    }

    @Override
    public void delete(TODO domain) {
        toDos.remove(domain.getId());
    }

    @Override
    public Iterable<TODO> saveAll(Collection<TODO> domains) {
        domains.forEach(this::save);
        return findAll();
    }

    @Override
    public TODO findById(String id) {
        return toDos.get(id);
    }

    @Override
    public Iterable<TODO> findAll() {
        return toDos.entrySet().stream()
                .sorted(entryComparator)
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private Comparator<Map.Entry<String, TODO>> entryComparator =
            (Map.Entry<String, TODO> o1, Map.Entry<String, TODO> o2) -> o1.getValue().getCreated().compareTo(o2.getValue().getCreated());
}
