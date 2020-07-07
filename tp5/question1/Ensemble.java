package question1;

import java.util.*;
import java.util.function.Predicate;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        boolean contains = table.contains(t);
        
        if(contains) return false;
        table.add(t);
        return true;
        
       
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        Ensemble<T> res = new Ensemble<T>();
        res.table.addAll(this.table);

        res.table.addAll(e.table);
        
        for(T t :  this.table)
        {
            if(e.table.contains(t))
            {
                res.table.removeElement(t);
            }
        }
        return res;

    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble<T> res = new Ensemble<T>();
        res.table.addAll(this.table);
        res.table.retainAll(e.table);
        return res;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble <T> res = new Ensemble<T>();
        res.table.addAll(this.table);
        res.table.removeAll(e.table);
        return res;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble<T> union = this.union(e);
        Ensemble<T> intersection = this.inter(e);

        Ensemble<T> res = union.diff(intersection);
        return res;

    }
    
    
    
}
