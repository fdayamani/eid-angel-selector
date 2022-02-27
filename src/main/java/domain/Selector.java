package domain;

import java.util.*;

public class Selector {
    private final List<Child> childrenToAssign;
    private final List<Child> unassignedChildren;

    public Selector(List<Child> children) {
        this.childrenToAssign = children;
        this.unassignedChildren = new ArrayList<>(children);
    }


    public Map<Child, Child> assignAngels() {
        Map<Child, Child> allocations = new HashMap<>();
        childrenToAssign.forEach(child -> allocations.put(child, allocateAngel(child)));

        return allocations;
    }

    private Child allocateAngel(Child child) {
        Collections.shuffle(unassignedChildren);
        Child match = unassignedChildren.stream()
                .filter(potentialAngel -> !potentialAngel.isSiblingOf(child))
                .findFirst()
                .orElseThrow(() -> new InvalidMatchAttempt("Attempting to match siblings"));
        unassignedChildren.remove(match);
        return match;
    }
}
