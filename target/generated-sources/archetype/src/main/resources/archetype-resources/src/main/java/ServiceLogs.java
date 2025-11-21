#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceLogs {
    private final Map<TypeLog, List<Log>> logs;

    public ServiceLogs() {
        this.logs = new HashMap<>();
    }

    public void addLog(Log log) {
        if (!this.logs.containsKey(log.getType())) {
            this.logs.put(log.getType(), new ArrayList<>());
        }
        this.logs.get(log.getType()).add(log);
    }

    public void deleteLog(Log log) {
        this.logs.get(log.getType()).remove(log);
    }

    public void clear() {
        this.logs.clear();
    }
}
