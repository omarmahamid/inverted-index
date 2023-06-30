package org.searchengine.invertedindex;

import java.util.List;

public interface Index{

    List<String> searchQuery(Query query);
}
