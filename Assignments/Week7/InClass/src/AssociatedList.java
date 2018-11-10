import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.security.Key;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

final public class AssociatedList implements Map {

    private ArrayList list = new ArrayList();


    public class KeyValuePair implements Map.Entry {

        private String key;
        private int value;

        public KeyValuePair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            if(!(value instanceof Integer)) {
                throw new IllegalArgumentException("Not an Integer");
            }
            Integer old = this.value;
            this.value = (Integer) value;
            return old;
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public Object get(Object key) {
        if(!(key instanceof String)) {
            throw new ClassCastException();
        }
        if(key == null) {
            throw new NullPointerException();
        }
        for(Object kvp : list) {
            if(((KeyValuePair) kvp).getKey().equals(key)) {
                return (((KeyValuePair) kvp).getValue());
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if((!(key instanceof String)) || (!(value instanceof Integer))) {
            throw new ClassCastException();
        }
        if(key == null || value == null) {
            throw new IllegalArgumentException();
        }
        Integer oldValue = (Integer) get(key);
        KeyValuePair target = null;
        for(Object kvp : list) {
            if(((KeyValuePair) kvp).getKey().equals(key)) {
                target = (KeyValuePair) kvp;
                break;
            }
        }
        if(target != null) {
            oldValue = (Integer) target.getValue();
            target.setValue(value);
        } else {
            list.add(new KeyValuePair((String) key, (int) value));
        }

        return oldValue;
    }

    @Override
    public Object remove(Object key) {
        Integer oldValue = null;
        KeyValuePair target = null;
        for(Object kvp : list) {
            if(((KeyValuePair) kvp).getKey().equals(key)) {
                target = (KeyValuePair) kvp;
                break;
            }
        }
        if(target != null) {
            oldValue=(Integer)target.getValue();
            list.remove(target);
        }
        return oldValue;
    }

    @Override
    public void putAll(Map m) {
        for(Object entry:m.entrySet()) {
            String key = (String)((Map.Entry) entry).getKey();
            Integer value = (Integer)((Map.Entry) entry).getValue();
            list.add(new KeyValuePair(key,value));
        }
    }

    @Override
    public void clear() {
        list = new ArrayList();
    }

    @Override
    public Set keySet() {
        ArrayList keys = new ArrayList();
        for(Object kvp : list) {
            keys.add(((KeyValuePair) kvp).getKey());
        }
        return (Set) keys;
    }

    @Override
    public Collection values() {
        ArrayList values = new ArrayList();
        for(Object kvp : list) {
            values.add(((KeyValuePair) kvp).getValue());
        }
        return values;
    }

    @Override
    public Set<Entry> entrySet() {
        return (Set) list;
    }
}
